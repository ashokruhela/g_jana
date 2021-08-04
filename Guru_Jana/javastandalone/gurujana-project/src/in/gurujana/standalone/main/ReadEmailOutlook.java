package in.gurujana.standalone.main;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.util.MimeMessageParser;

import in.gurujana.standalone.dao.ClientDao;
import in.gurujana.standalone.dao.ClientDaoImpl;
import in.gurujana.standalone.dao.EmailDao;
import in.gurujana.standalone.dao.EmailDaoImpl;
import in.gurujana.standalone.model.Client;
import in.gurujana.standalone.model.Email;
import in.gurujana.standalone.model.UserEmail;
import in.gurujana.standalone.util.Constants;

public class ReadEmailOutlook {

	public Email readEmailWithAttachments(UserEmail userEmail) {

		Session session = getSession();
		Email email = null;

		try {
			// connects to the message store
			Store store = session.getStore("imaps");
			store.connect("outlook.office365.com", userEmail.getUserEmailId(), userEmail.getPassword());

			// opens the inbox folder
			Folder folderInbox = store.getFolder("INBOX");
			folderInbox.open(Folder.READ_WRITE);
			FlagTerm unreadMessages = new FlagTerm(new Flags(Flags.Flag.SEEN), false);

			// fetches new messages from server
			Message[] arrayMessages = folderInbox.search(unreadMessages);
			System.out.println("Total Message" + arrayMessages.length);
			for (int i = 0; i < arrayMessages.length; i++) {
				Message message = arrayMessages[i];
				email = getEmail(message);
				ClientDao clientDao = new ClientDaoImpl();
				Client client = clientDao.setClientForEmail(email);
				String path = getFolderPath(userEmail, client, email);
				//client will never be null
				email.setClientId(client.getClientId());
				
				saveEmailFiles(email, message, path);
				
				EmailDao emailDao = new EmailDaoImpl();
				String emailMailBodyPath = saveEmailContentToFile(userEmail,client,email,null);
				email.setContentFilePath(emailMailBodyPath);
				int result = emailDao.saveEmail(email);
				if(result > 0) {
					if(client.getClientId()!=null && !client.getFolderName().isEmpty())
					{
						moveMessageToFolder(store,message,client);
					}
				}
					//Move to folder
				
			}
			folderInbox.close(false);
			store.close();
		} catch (javax.mail.NoSuchProviderException ex) {
			System.out.println("No provider for pop3.");
			ex.printStackTrace();
		} catch (MessagingException ex) {
			System.out.println("Could not connect to the message store");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return email;
	}

	private void moveMessageToFolder(Store store,Message m, Client client)throws MessagingException {
		Folder outputFolder = store.getFolder(client.getFolderName());
		    m.getFolder().copyMessages(new Message[] {m}, outputFolder);
		    m.setFlag(Flag.DELETED, true);
		    m.getFolder().expunge();
	}

	private void saveEmailFiles(Email email, Message message, String path) throws IOException, MessagingException {
		if (email.getContentType().contains("multipart")) {
			// content may contain attachments
			Multipart multiPart = (Multipart) message.getContent();
			int numberOfParts = multiPart.getCount();
			for (int partCount = 0; partCount < numberOfParts; partCount++) {
				MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
				if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
					// this part is attachment
					String fileName = part.getFileName();
					
		            File directoryForAttachment = Constants.makeDirectory(path);
					File att = new File(directoryForAttachment+File.separator+fileName);
					part.saveFile(att);
				}
			}
		}
	}

	private String getFolderPath(UserEmail userEmail, Client client, Email email) {
		String path = Constants.BASE_DIRECTORY + File.separator + userEmail.getEmail() + File.separator
				+ Constants.getTodaysDate() + File.separator + email.getEmailId() + File.separator
				+ client.getClientName() + File.separator;
		return path;
	}

	private Email getEmail(Message message) throws MessagingException {
		Email email = new Email();
		email.setEmailId(UUID.randomUUID().toString());

		String from = InternetAddress.toString(message.getFrom());
		email.setFromEmail(Constants.getEmailAddressFromStringForFrom(from));
		String to = InternetAddress.toString(message.getRecipients(RecipientType.TO));
		email.setToEmail(to);
		String cc = InternetAddress.toString(message.getRecipients(RecipientType.CC));
		email.setCcEmail(cc);
		String bcc = InternetAddress.toString(message.getRecipients(RecipientType.BCC));
		email.setBccEmail(bcc);
		String subject = message.getSubject();
		email.setSubject(subject);
		String sentDate = message.getSentDate().toString();
		email.setSendDate(sentDate);
		String contentType = message.getContentType();
		email.setContentType(contentType);
		String messageContent = "";

		// store attachment file name, separated by comma
		String attachFiles = "";
		try {
			if (email.getContentType().contains("multipart")) {
				// content may contain attachments
				Multipart multiPart = (Multipart) message.getContent();
				MimeMessage msg = (MimeMessage) multiPart.getParent();
				MimeMessageParser parser = new MimeMessageParser(msg);
				try {
					messageContent = parser.parse().getHtmlContent();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				int numberOfParts = multiPart.getCount();
				for (int partCount = 0; partCount < numberOfParts; partCount++) {
					MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
					if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
						String fileName = part.getFileName();
						attachFiles += fileName + ", ";
					} 
				}
				if (attachFiles.length() > 1) {
					attachFiles = attachFiles.substring(0, attachFiles.length() - 2);
					email.setEmailAttachment(true);
				} else {
					email.setEmailAttachment(false);
				}
			} else if (email.getContentType().contains("text/plain") || email.getContentType().contains("text/html")) {
				Object content = message.getContent();
				if (content != null) {
					messageContent = content.toString();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		email.setMailBody(messageContent);
		email.setAttchedFiles(attachFiles);
		return email;
	}
		
	@SuppressWarnings("deprecation")
	private String saveEmailContentToFile(UserEmail userEmail, Client client, Email email,String fileName) throws IOException {
		String path = getFolderPath(userEmail,client,email)+File.separator+email.getEmailId()+"_"+"emailContent.txt";
		FileUtils.writeStringToFile(new File(path), email.getMailBody());
		return path;
	}

	private Session getSession() {
		Properties props = new Properties();

		props.setProperty("mail.store.protocol", "imap");
		props.setProperty("mail.imap.ssl.enable", "true");
		props.setProperty("mail.imaps.partialfetch", "false");
		props.put("mail.mime.base64.ignoreerrors", "true");

		Session session = Session.getInstance(props);
		return session;
	}
}
