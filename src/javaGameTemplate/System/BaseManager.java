package javaGameTemplate.System;

import java.util.ArrayList;
import java.util.List;

import javaGameTemplate.Utility.Switch;

/**
 * 要素を管理し、要素として管理されるクラス
 * @author フェル
 *
 */
abstract public class BaseManager {

	/**
	 * 消去フラグ
	 */
	private Switch clearFlg = new Switch();

	/**
	 * 要素を消去する
	 */
	public void clear() {
		this.clearFlg.set(true);
	}

	/**
	 * 全要素を走査し、削除済みであれば実際に配列から削除する
	 * @param e 要素リスト
	 */
	public static <T extends BaseManager> void allRefresh(List<T> e) {
		List<T> removeList = new ArrayList<T>();
		for (T a : e) {
			if (((BaseManager) a).clearFlg.getThenOff()) {
				removeList.add(a);
			}
		}
		for (T a : removeList) {
			e.remove(a);
		}
	}

	/**
	* 全要素の削除
	* @param e 要素リスト
	*/
	public static <T extends BaseManager> void allClear(List<T> e) {
		e.clear();
	}

}
