package in.gurujana.standalone.main;

import java.util.List;

import in.gurujana.standalone.dao.UserEmailDao;
import in.gurujana.standalone.dao.UserEmailDaoImpl;
import in.gurujana.standalone.model.UserEmail;

 

public class ReadEmailInitializer {

	
	public static void main(String[] args)
	{
		ReadEmailInitializer emailInitializer=new ReadEmailInitializer();
		emailInitializer.start();
	}
	

	public void start()
	{
		UserEmailDao userEmailDao = new UserEmailDaoImpl();
		List<UserEmail> userEmails=userEmailDao.getListUserDetails();
		for(UserEmail userEmail:userEmails) {
			
			ReadEmailThread readEmail=new ReadEmailThread(userEmail);
			readEmail.run();
		}
	}
	
	
}
