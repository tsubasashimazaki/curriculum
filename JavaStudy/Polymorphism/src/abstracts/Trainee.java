/**
 *
 */
package abstracts;

/**
 * @author bankun
 *
 */
public class Trainee extends JavaCurriculumTrainee {

	public Trainee(String name) {
		super(name);
	}

	@Override
	public void doJavaCurriculum() { //doJavaCurriculum()はabstractつきメソッドのためオーバーライド必要
		System.out.println("私、" + super.getName() + "は、Javaカリキュラムをこなします！");
	}

}
