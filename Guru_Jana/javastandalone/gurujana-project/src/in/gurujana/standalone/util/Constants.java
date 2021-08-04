package in.gurujana.standalone.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Constants {

	public static final String UNDETERMINED_CLIENT = "undertmined";
	public static final String SEPERATOR = ",";
	// public static String HOST = "pop.gmail.com";
//	  public static String PORT = "995";
	public static String BASE_DIRECTORY = "/home/user/Projects";
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String getTodaysDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy");
		String strDate = formatter.format(date);
		return strDate;
	};

	public static String getNowDateTimeStr() {
		return formatter.format(new Date());
	}
	
	//Create directory
	public static File makeDirectory(String path) {
		System.out.println("path :: "+ path);
		File directoryForAttachment = new File(path);
		if (!directoryForAttachment.exists()) {
			directoryForAttachment.mkdirs();
			System.out.println("In side directoryForAttachment :: "+ directoryForAttachment);
		}
		System.out.println("Out side directoryForAttachment :: "+ directoryForAttachment);
		return directoryForAttachment;
	}

	// This method to fix the prefix issue coming for From address.
	public static String getEmailAddressFromStringForFrom(String fromAddress) {
		if (fromAddress != null && fromAddress != "") {
			List<String> emails = Arrays.asList(fromAddress.split(","));
			Pattern p = Pattern.compile("(.*?)<([^>]+)>\\s*,?", Pattern.DOTALL);
			if (emails != null && emails.size() > 0) {
				StringBuffer email = new StringBuffer();
				for (String temp : emails) {
					Matcher m = p.matcher(temp);
					if (m.find()) {
						String parseEmail = m.group(2).replaceAll("[\\n\\r]+", "");
						if ((emails.indexOf(temp) + 1) != emails.size()) {
							// do nothings
						} else {
							email.append(parseEmail);
						}
					} else {
						if ((emails.indexOf(temp) + 1) != emails.size()) {
							// do nothings
						} else {
							email.append(temp);
						}
					}
				}
				return email.toString();
			}
		}
		return fromAddress;
	}
}
