package model;

import java.io.Serializable;

public class User implements Serializable {
	// ユーザー名
	private String name;
	// パスワード
	private String password;
	
	User(){}
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
