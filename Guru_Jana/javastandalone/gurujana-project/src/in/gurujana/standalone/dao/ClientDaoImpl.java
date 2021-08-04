package in.gurujana.standalone.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.gurujana.standalone.dao.ClientDao;
import in.gurujana.standalone.dao.ClientDaoImpl;
import in.gurujana.standalone.model.Client;
import in.gurujana.standalone.model.Email;
import in.gurujana.standalone.util.Constants;
import in.gurujana.standalone.util.DatabaseUtils;

public class ClientDaoImpl implements ClientDao {

	@Override
	public List<Client> getClients(Email email) {

		List<Client> clients = new ArrayList<Client>();
		Connection conn = DatabaseUtils.getDbConnection();
		StringBuilder queBuilder = new StringBuilder(" select * from client ");
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(queBuilder.toString());
			if (resultSet.next()) {
				Client clientDetail = new Client();
				clientDetail.setClientId(resultSet.getString("clientId"));
				clientDetail.setClientName(resultSet.getString("clientName"));
				clientDetail.setClientTags(resultSet.getString("clientTags"));
				clientDetail.setFolderName(resultSet.getString("folderName"));
				clientDetail.setStatus(resultSet.getString("status"));
				clientDetail.setClientEmails(resultSet.getString("clientEmails"));
				clientDetail.setCreatedDate(resultSet.getString("createdDate"));
				clientDetail.setCreatedBy(resultSet.getString("createdBy"));
				clients.add(clientDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

	public Client setClientForEmail(Email email) {
		Client client = null;

		List<Client> registeredClients = getClients(email);
		// logic to determine client
		if (registeredClients != null && registeredClients.size() > 0) {
			
			client = getClientByCheckingFromEmail(email,registeredClients);
			if(client==null)
			{
				client =getClientByCheckingSubject(email,registeredClients);
			}
			if(client==null)
			{
				client =getClientByCheckingBody(email,registeredClients);
			}
			if(client==null)
			{
				client =getClientByCheckingAttachmentNames(email,registeredClients);
			}
		} 
		
		if(client==null)
		{
			client = new Client();
			client.setClientName(Constants.UNDETERMINED_CLIENT);
			client.setClientId(Constants.UNDETERMINED_CLIENT);
		}
		return client;
	}

	private Client getClientByCheckingFromEmail(Email email, List<Client> registeredClients) {
		for(Client client:registeredClients)
		{
			if(client.getClientEmails().contains(email.getFromEmail()))
			{
				return client;
			}
		}
		return null;
	}
	
	private Client getClientByCheckingSubject(Email email, List<Client> registeredClients) {
		return checkTagsInText(  email,  registeredClients,email.getSubject()) ;
	}
	
	private Client getClientByCheckingBody(Email email, List<Client> registeredClients) {
		return checkTagsInText(  email,  registeredClients,email.getMailBody()) ;
	}
	
	private Client getClientByCheckingAttachmentNames(Email email, List<Client> registeredClients) {
		return checkTagsInText(  email,  registeredClients,email.getAttchedFiles()) ;
	}
	
	
	private Client checkTagsInText(Email email, List<Client> registeredClients,String text) {
		for(Client client:registeredClients)
		{
			String subjectTags=client.getClientTags();
			String tags[]=subjectTags.split(Constants.SEPERATOR);
			for(String tag:tags)
			if(text.contains(tag))
			{
				return client;
			}
		}
		return null;
	}
}
