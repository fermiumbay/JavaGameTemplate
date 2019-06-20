package javaGameTemplate.System;

/**
 * エントリーポイント
 * @author フェル
 *
 */
public class Main {

	/**
	 * エントリーポイント
	 * @param args 標準入力
	 */
	public static void main(String args[]) {

		System.out.println("ゲーム開始");

		Game game = new Game();
		game.run();

		System.out.println("ゲーム終了");
	}
}
