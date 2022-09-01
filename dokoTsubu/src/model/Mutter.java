package model;

import java.io.Serializable;

public class Mutter implements Serializable{
	// ユーザー名
	private String userName;
	// 内容
	private String contents;
	
	Mutter(){}
	Mutter(String userName, String contents) {
		this.userName = userName;
		this.contents = contents;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
}
