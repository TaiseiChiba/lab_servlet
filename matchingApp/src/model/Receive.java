package model;

public class Receive {
	private String subject;
	private String textbookName;
	
	public Receive(String subject, String textbookName) {
		this.subject = subject;
		this.textbookName = textbookName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTextbookName() {
		return textbookName;
	}

	public void setTextbookName(String textbookName) {
		this.textbookName = textbookName;
	}
}
