package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Receive;

public class ReceiveDAO {
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;

	private void connect() throws NamingException, SQLException {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/matchingApp");
		this.db = ds.getConnection();
	}

	private void disconnect() {
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
	
	public void insertOne(Receive receive) {
		try {
			this.connect();
//			System.out.println("コネクトできてる");
			// SELECT文を準備
			String sql = "insert into receive(subject, textbook_name) values(?,?)";
			ps = db.prepareStatement(sql);
			ps.setString(1, receive.getSubject());
			ps.setString(2, receive.getTextbookName());
			
			// SELECT文実行
			ps.execute();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		} finally {
			this.disconnect();
		}
	}
	
	public List<Receive> findAll() {
		List<Receive> list = new ArrayList<>();
		try {
			this.connect();
			String sql = "select * from receive";
			ps = db.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String subject = rs.getString("subject");
				String textbookName = rs.getString("textbook_name");
				list.add(new Receive(subject, textbookName));
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		} finally {
			this.disconnect();
		}
		
		return list;
	}
}
