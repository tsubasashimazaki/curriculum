package check;
import constants.Constants;

public class Check {

	// [課題①]フィールド変数の宣言と初期化
	private static String firstName = "島﨑"; //private:そのクラスでのみアクセス可能 Checkクラスのみ
	private static String lastName = "翼";

	public static void main(String[] args) {
		System.out.println("printNameメソッド" + " " + "→" + " " + printName(firstName, lastName));

//		Pet pet = new Pet(CHECK_CLASS_JAVA, CHECK_CLASS_HOGE);
		Pet pet = new Pet(Constants.CHECK_CLASS_JAVA, Constants.CHECK_CLASS_HOGE);
		pet.introduce();

		RobotPet rp = new RobotPet(Constants.CHECK_CLASS_R2D2, Constants.CHECK_CLASS_LUKE);
		rp.introduce();

	}

	private static String printName(String firstName, String lastName) {
		return firstName + lastName;
	}
}