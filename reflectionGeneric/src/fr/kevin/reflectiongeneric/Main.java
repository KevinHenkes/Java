package fr.kevin.reflectiongeneric;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.kevin.reflectiongeneric.database.reflectionner.ToolsBox;
import fr.kevin.reflectiongeneric.entities.Account;
import fr.kevin.reflectiongeneric.entities.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*MySqlConnect db = MySqlConnect.getDbCon();
		
		ResultSet result = null;
		DbPreparedStatementReflectionnerGeneric<User> dbReflectionnerGeneric = new DbPreparedStatementReflectionnerGeneric<User>();
		try {
			result = db.query("select * from user;");
			
			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				Date birthday = result.getDate("birthday");
				
				User user = new User(name, birthday);
				user.setId(id);
				
				dbReflectionnerGeneric.readObject(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		String name = "Toto";
		Date date = new Date();
		User user = new User(name, date);
		user.setId(1);
		
		//System.out.println(user.getClass().getName());
	
		Account account = new Account(5000, user);
		account.setId(1);
		
		ToolsBox toolsBox = new ToolsBox();
		List<User> listUser = new ArrayList<User>();
		List<Account> listAccount = new ArrayList<Account>();
		
		listAccount.add(account);
		
		toolsBox.readObject(listAccount);
	}

}
