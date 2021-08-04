package in.gurujana.standalone.main;

import in.gurujana.standalone.model.UserEmail;
 

public class ReadEmailThread extends Thread{

	UserEmail userEmail;
	 public ReadEmailThread(UserEmail userEmail) {
		 this.userEmail=userEmail;
	}

	public void run(){
		ReadEmailOutlook readEmailOutlook = new ReadEmailOutlook();
		readEmailOutlook.readEmailWithAttachments(userEmail);
	    }
}
