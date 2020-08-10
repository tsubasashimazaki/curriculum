/**
 *
 */
package abstracts;

/**
 * @author bankun
 *
 */
public class TraineeMain {

	public static void main(String[] args) { //これstaticついてるとdoJavaCurriculum持ってこれないんじゃない?
		Trainee traniee = new Trainee("七海");
		Trainee.doJavaCurriculum();
	}
}
