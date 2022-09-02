package model;

import java.util.List;

public class PostMutterLogic {
	/**
	 * 対象のつぶやきをつぶやきリストの先頭に付け足す
	 * @param mutter つぶやき
	 * @param mutterList つぶやきリスト
	 */
	public void addText(Mutter mutter, List<Mutter> mutterList) {
		mutterList.add(0, mutter);
	}
}
