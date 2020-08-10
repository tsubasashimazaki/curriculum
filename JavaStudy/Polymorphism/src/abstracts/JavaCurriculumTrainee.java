/**
 *
 */
package abstracts;

/**
 * @author bankun
 *
 */
// 抽象クラス: Javaのカリキュラムだけしかこなせないクラス
public abstract class JavaCurriculumTrainee {

	private String name;


	public JavaCurriculumTrainee(String name) {
		this.name = name; //引数のnameはフィールド変数のnameだよ
	}
	// abstract(アブストラクタ): public abstract void メソッド(抽象メソッド=処理無しのメソッド)
	public abstract void doJavaCurriculum();

	protected String getName() {
		return name;
	}
}
