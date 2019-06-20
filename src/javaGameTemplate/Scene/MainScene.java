package javaGameTemplate.Scene;

import javaGameTemplate.System.BaseScene;

/**
 * メインシーン
 * @author フェル
 *
 */
public class MainScene extends BaseScene {

	/**
	 * 更新
	 */
	@Override
	public void update() {
		super.update();

		// 5回呼び出されたらゲーム終了
		if (time >= 5) {
			endGameFlg.set(true);
		}
	}

	/**
	 * 描画
	 */
	@Override
	public void draw() {
		// 現在時間を描画
		System.out.println("更新中... time = " + time);
	}

}
