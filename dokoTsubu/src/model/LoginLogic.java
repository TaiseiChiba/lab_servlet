package model;

public class LoginLogic {

	/**
	 * ログインに成功するかしないか
	 * @param user ログイン画面で入力されたユーザー
	 * @return 成功か失敗か
	 */
	public boolean isSuccess(User user) {
		if(user.getPassword().equals("1234")) {
			return true;
		}
		return false;
	}
}

