package javaGameTemplate.System;

import java.util.ArrayList;
import java.util.List;

import javaGameTemplate.Common.SceneInfo;
import javaGameTemplate.Utility.Switch;

/**
 * シーン管理クラス
 * @author フェル
 *
 */
public class SceneManager extends BaseObject {

	/**
	 * ゲーム終了フラグ
	 */
	public Switch endGameFlg = new Switch();

	/**
	 * シーンオブジェクト
	 */
	private List<BaseScene> scenes = new ArrayList<BaseScene>();

	/**
	 * 新規追加予定のシーン
	 */
	private List<BaseScene> newSceneList = new ArrayList<BaseScene>();

	/**
	 * コンストラクタ
	 */
	public SceneManager() {
		// デフォルトシーンを追加
		scenes.add(SceneInfo.getDefaultScene().createNewObject());
	}

	/**
	 * 進行中のシーンを全更新
	 */
	@Override
	public void update() {
		super.update();

		// 新規シーンを追加
		for (BaseScene scene : newSceneList) {
			scenes.add(scene);
		}
		newSceneList.clear();

		// 進行中のシーンを全更新
		for (BaseScene scene : scenes) {
			scene.update();
		}

		// 終了フラグ、シーン追加フラグを取得し、シーン追加リストに追加
		for (BaseScene scene : scenes) {
			if (scene.endGameFlg.getThenOff()) {
				endGameFlg.set(true);
			}
			if (scene.changeSceneFlg.getThenOff()) {
				List<BaseScene> addSceneList = scene.extractNewScenes();
				for (BaseScene addScene : addSceneList) {
					newSceneList.add(addScene);
				}
			}
		}

		// 終了シーンがあったものはシーン削除
		BaseManager.allRefresh(scenes);
	}

	/**
	 * 進行中のシーンを全描画
	 */
	@Override
	public void draw() {
		super.draw();
		for (BaseScene scene : scenes) {
			scene.draw();
		}
	}
}
