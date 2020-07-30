package study;

/**
 *
 * 本課題では、継承・オーバーロードメソッドの基本的な使い方を学んでいきましょう。
 * 課題は問①から問③まであります。
 * 指定された値と変数名を守って記述してください。
 *
 * @author s.nanaumi
 */
public class Main {
    public static void main(String[] args) {
        // ③ Taskクラスのインスタンスを生成し、「doTask()」メソッドを呼び出しなさい。
    	 Task task = new Task();
    	 System.out.println("plusメソッドの引数が一つの場合；" + task.plus(10));
    	 System.out.println("plusメソッドの引数が二つの場合；" + task.plus(10,20));
    	 System.out.println("plusメソッドの引数が三つの場合；" + task.plus(10,20,30));
    }
}
