package javaGameTemplate.System;

/**
 * BaseManagerをゲーム制作に特化したものとして拡張した基底クラス
 * @author フェル
 *
 */
abstract public class BaseObject extends BaseManager {

	/**
	 * オブジェクト生成開始からの経過時間（初回updateのタイミングで1になる）
	 */
	protected int time = 0;

	/**
	 * コンストラクタ
	 */
	public BaseObject() {
		initialize();
	}

	/**
	 * 初期化
	 */
	public void initialize() {
	}

	/**
	 * 更新
	 */
	public void update() {
		time++;
	}

	/**
	 * 描画
	 */
	public void draw() {

	}

}
