package model;

import dao.AccountDAO;

public class AccountLogic {
	public void excute(Account account) {
		AccountDAO dao = new AccountDAO();
		dao.insertUser(account);
	}
}
