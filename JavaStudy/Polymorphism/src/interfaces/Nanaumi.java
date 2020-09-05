package interfaces;

public class Nanaumi implements OrderFromMotoki, OrderFromShihandai {

	private static String name;
	private static String date;

	public Nanaumi(String n, String yyyyMM) {
		name = n;
		date = yyyyMM;
	}

//	司令(インターフェース)が増えたときにフラグによって実行されるメソッドをまとめておく

	private static void submitOrder(final int shoriFlg) {
		String nameAnd = name + "、";

		if (shoriFlg == 0) {
			//勤務表インターフェース
			System.out.println(nameAnd + date + "の勤務表を提出しました！");
		} else if(shoriFlg == 1) {
			// 交通費
			System.out.println(nameAnd + date + "の交通費も出しました！");
		}else {
			System.out.println(nameAnd + "本当はまだ何も出していません");
		}
	}

	// 何もしていません
	public void doNothing() {
		submitOrder(-1);
	}

	@Override
	public void daseyaKinmuhyo() {
		submitOrder(0);
	}

	@Override
	public void daseyaKotsuhi() {
		submitOrder(1);
	}

	@Override
	public void goToSevenEleven() {
		System.out.println("先にセブンイレブン行ってきます");
	}

	@Override
	public String doCreateJavaCurriculum() {
		// TODO 自動生成されたメソッド・スタブ
		return "Javaカリキュラム完成しました。";
	}

}
