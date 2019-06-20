package javaGameTemplate.Common;

import javaGameTemplate.Scene.MainScene;
import javaGameTemplate.System.BaseScene;;

/**
 * シーン情報
 * @author フェル
 *
 */
public enum SceneInfo {

	/**
	 * メインシーン
	 */
	Main,
	;

	/**
	 * デフォルトシーンを返却
	 * @return
	 */
	public static SceneInfo getDefaultScene() {
		return Main;
	}

	/**
	 * 新規オブジェクトを生成して返却
	 * @return
	 */
	public BaseScene createNewObject() {
		BaseScene ret = null;

		// 新しいシーンができたら、ここに追加する
		switch (this) {
		case Main:
			ret = new MainScene();
		}
		return ret;
	}

}
