package in.gurujana.standalone.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.gurujana.standalone.model.UserEmail;
import in.gurujana.standalone.util.DatabaseUtils;

public class UserEmailDaoImpl implements UserEmailDao {

	@Override
	public List<UserEmail> getListUserDetails() {
		List<UserEmail> listUserEmails = new ArrayList<UserEmail>();
		Connection conn = DatabaseUtils.getDbConnection();
		StringBuilder queBuilder = new StringBuilder(" select * from userEmail ");
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(queBuilder.toString());
			while (resultSet.next()) {
				UserEmail userEmailDetail = new UserEmail();
				userEmailDetail.setUserEmailId(resultSet.getString("userEmailId"));
				userEmailDetail.setEmail(resultSet.getString("email"));
				userEmailDetail.setPassword(resultSet.getString("password"));
				userEmailDetail.setStatus(resultSet.getString("status"));
				userEmailDetail.setCreatedDate(resultSet.getString("createdDate"));
				userEmailDetail.setCreatedBy(resultSet.getString("createdBy"));
				listUserEmails.add(userEmailDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listUserEmails;
	}
}
