package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Account;
import model.Login;

public class AccountDAO {
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;

	private void connect() throws NamingException, SQLException {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/matchingApp");
		this.db = ds.getConnection();
	}

	private void disconnect()  {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (db != null) {
				db.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void ConnectCheck() {
		try {
			this.connect();
			System.out.println("OK");
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			System.out.println("noOK");
		}finally {
			this.disconnect();
		}
	}
	
	public Account findByLogin(Login login) {
		Account account = null;
		
		// dbへ接続
		try {
			this.connect();
			// SELECT文を準備
			String sql = "SELECT user_id, name, password FROM account "
					+ "WHERE user_id = ? AND password = ?";
			ps = db.prepareStatement(sql);
			ps.setString(1, login.getUserId());
			ps.setString(2, login.getPassword());
			
			// SELECT文実行
			rs = ps.executeQuery();
			
			// 一致したユーザーがいた場合
			// そのユーザーを表すAccount追加
			if(rs.next()) {
				String userId = rs.getString("user_id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				account = new Account(userId, password, name);
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			System.out.println("失敗");
			return null;
		} finally {
			this.disconnect();
		}
		
		// 見つかったアカウントまたはnullを返す
		return account;
	}
}
