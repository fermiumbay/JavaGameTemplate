package javaGameTemplate.Utility;

/**
 * ON/OFFを持つスイッチクラス
 * @author フェル
 *
 */
public class Switch {

	/**
	 * フラグ
	 */
	private boolean flg;

	/**
	 * コンストラクタ（初期値はOFF）
	 */
	public Switch() {
		this.set(false);
	}

	/**
	 * フラグを取得
	 * @return フラグ
	 */
	public boolean get() {
		return this.flg;
	}

	/**
	 * フラグを取得後、フラグをOFFにする
	 * @return フラグ
	 */
	public boolean getThenOff() {
		boolean ret = this.flg;
		this.flg = false;
		return ret;
	}

	/**
	 * フラグをセットする
	 * @param flg フラグ
	 */
	public void set(boolean flg) {
		this.flg = flg;
	}

}
