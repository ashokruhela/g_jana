package in.gurujana.standalone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.gurujana.standalone.model.Email;
import in.gurujana.standalone.util.Constants;
import in.gurujana.standalone.util.DatabaseUtils;

public class EmailDaoImpl implements EmailDao {

	@Override
	public int saveEmail(Email email) {
		Connection conn = DatabaseUtils.getDbConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		StringBuilder queBuilder = new StringBuilder(" insert into email(fromEmail,toEmail,ccEmail,bccEmail,subject,contentFilePath,isEmailAttachment,emailAttachments,emailCreatedDate,emailStatus,clientId,emailId) values(?,?,?,?,?,?,?,?,?,?,?,?) ");
		try {
			preparedStatement = conn.prepareStatement(queBuilder.toString());
			preparedStatement.setString(1, email.getFromEmail());
			preparedStatement.setString(2, email.getToEmail());
			preparedStatement.setString(3, email.getCcEmail());
			preparedStatement.setString(4, email.getBccEmail());
			preparedStatement.setString(5, email.getSubject());
			preparedStatement.setString(6, email.getContentFilePath());
			preparedStatement.setBoolean(7, email.isEmailAttachment());
			preparedStatement.setString(8 ,email.getAttchedFiles());
			preparedStatement.setString(9, Constants.getNowDateTimeStr());
			preparedStatement.setString(10, email.getEmailStatus());
			preparedStatement.setString(11, email.getClientId());
			preparedStatement.setString(12,email.getEmailId());
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
