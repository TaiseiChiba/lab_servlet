package test;

import model.Login;
import model.LoginLogic;

public class LoginLogicTest {
	public static void main(String[] args) {
		test1();
		test2();
	}
	
	public static void test1() {
		Login login = new Login("taisei", "1234");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		if(result) {
			System.out.println("1: 成功");
		} else {
			System.out.println("1: 失敗");
		}
	}
	
	public static void test2() {
		Login login = new Login("taisei", "12345");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		if(!result) {
			System.out.println("1: 成功");
		} else {
			System.out.println("1: 失敗");
		}
	}
}
