package fr.kevin.reflectiongeneric;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.kevin.reflectiongeneric.database.MySqlConnect;
import fr.kevin.reflectiongeneric.database.reflectionner.ToolsBox;
import fr.kevin.reflectiongeneric.entities.Account;
import fr.kevin.reflectiongeneric.entities.Users;

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
		
		MySqlConnect db = MySqlConnect.getDbCon();
		
		
/*		char[] name = "".toCharArray();
		char[] birthday = "".toCharArray();
		int user_id = 0;
		
		try {
			result = db.query("SELECT * FROM users WHERE id=1");
			while (result.next()) {
				name = result.getString("name").toCharArray();
				birthday = result.getDate("birthday").toString().toCharArray();
				user_id = result.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		Users user = new Users(name,birthday,user_id);*/
		
		double solde = 0;
		int account_id = 0;
		
		String name = "";
		String birthday = "";
		int user_id = 0;
		
		ResultSet result_account = null;
		ResultSet result_user = null;
		
		SimpleDateFormat formatter;

		formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			result_account = db.query("SELECT * FROM account WHERE id=3");
			while (result_account.next()) {
				solde = result_account.getDouble("solde");
				account_id = result_account.getInt("id");
				result_user = db.query("SELECT * FROM users WHERE id=" + result_account.getInt("user_id"));
				while (result_user.next()) {
					name = result_user.getString("name");
					birthday = formatter.format(result_user.getDate("birthday"));
					user_id = result_user.getInt("id");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		Users user = new Users(name,birthday,user_id);
		Account account = new Account(solde, account_id, user);
		//System.out.println(String.valueOf(user.getName()));
		ToolsBox toolsBox = new ToolsBox();
		//List<User> listUser = new ArrayList<User>();
		List<Account> listAccount = new ArrayList<Account>();
		
		listAccount.add(account);
		/*String test = "";
		System.out.println(toolsBox.isPrimitive(test));*/
		toolsBox.readObject(listAccount);
	}
}
