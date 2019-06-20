package javaGameTemplate.System;

import java.util.ArrayList;
import java.util.List;

import javaGameTemplate.Common.SceneInfo;
import javaGameTemplate.Utility.Switch;

/**
 * シーン基底クラス
 * @author フェル
 *
 */
public class BaseScene extends BaseObject {

	/**
	 * ゲーム終了フラグ
	 */
	public Switch endGameFlg = new Switch();

	/**
	 * シーン変更フラグ
	 */
	public Switch changeSceneFlg = new Switch();

	/**
	 * 変更シーン配列
	 */
	private List<BaseScene> newScenes = new ArrayList<BaseScene>();

	/**
	 * 変更シーン配列取得（取得すると配列は破棄される）
	 * @return
	 */
	public List<BaseScene> extractNewScenes() {
		List<BaseScene> ret = new ArrayList<BaseScene>();
		for (BaseScene scene : newScenes) {
			ret.add(scene);
		}
		newScenes.clear();
		return ret;
	}

	/**
	 * シーン変更
	 * @param scene 変更先シーン
	 * @return 変更後シーンオブジェクト
	 */
	protected BaseScene changeScene(SceneInfo scene) {
		clear();
		return addScene(scene);
	}

	/**
	 * シーン追加
	 * @param scene 追加シーン
	 * @return 追加シーンオブジェクト
	 */
	protected BaseScene addScene(SceneInfo scene) {
		changeSceneFlg.set(true);
		BaseScene newScene = scene.createNewObject();
		newScenes.add(newScene);
		return newScene;
	}

}
