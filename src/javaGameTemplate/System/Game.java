package javaGameTemplate.System;

/**
 * ゲームオブジェクト
 * @author フェル
 *
 */
public class Game {

	/**
	 * シーンマネージャー
	 */
	private SceneManager sceneManager = null;

	/**
	 * ゲーム実行
	 */
	public void run() {
		// シーンマネージャーの初期化
		sceneManager = new SceneManager();

		// ゲーム本体のループ処理
		while(!sceneManager.endGameFlg.get()) {
			// 各シーンの更新
			sceneManager.update();

			// 各シーンの描画
			sceneManager.draw();
		}
	}

}
