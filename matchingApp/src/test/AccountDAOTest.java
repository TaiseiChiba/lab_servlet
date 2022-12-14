package test;

import dao.AccountDAO;
import model.Account;
import model.Login;

public class AccountDAOTest {
	public static void main(String[] args) {
		testFindByLogin1();
		testFindByLogin2();
	}
	
	public static void testFindByLogin1() {
		Login login = new Login("taisei", "1234");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);
		
		if(result != null &&
			result.getUserId().equals("taisei") &&
			result.getPassword().equals("1234") &&
			result.getName().equals("千葉泰誠")) {
			System.out.println("testFindByLogin1:成功しました");
		} else {
			System.out.println("testFindByLogin1:失敗しました");
		}
	}
	
	public static void testFindByLogin2() {
		Login login = new Login("minato", "1234");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);
		if(result == null ) {
			System.out.println("testFindByLogin2:成功しました");
		} else {
			System.out.println("testFindByLogin2:失敗しました");
		}
	}
}
