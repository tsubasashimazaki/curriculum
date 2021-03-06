package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import bean.EmployeeBean;
/**
 * ・社員情報検索サービス
 */
public class EmployeeService {
    // 問① 接続情報を記述してください
    /** ドライバーのクラス名 */
    private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
    /** ・JDMC接続先情報 */
    private static final String JDBC_CONNECTION = "jdbc:postgresql://localhost:5432/Employee";
    /** ・ユーザー名 */
    private static final String USER = "postgres";
    /** ・パスワード */
    private static final String PASS = "password123";
    /** ・タイムフォーマット */
    private static final String TIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
    // 問② 入力された値で、UPDATEする文
    /** ・SQL UPDATE文 */
    private static final String SQL_UPDATE = "update Employee_table SET login_time = ? WHERE id = ?"; //コンプリメント
    // 問③ 入力されたIDとPassWordをキーにして、検索するSELECT文
    /** ・SQL SELECT文 */
    private static final String SQL_SELECT = "SELECT * FROM Employee_table WHERE id = ? AND password = ?";
    EmployeeBean employeeDate = null;
    // 送信されたIDとPassWordを元に社員情報を検索するためのメソッド
    public EmployeeBean search(String id, String password) {

    	/* ローカル変数: メソッド内の変数。そのメソッド内でしか使えない。
    	 * メンバ変数(フィールド変数): クラス内(メソッドの外)で宣言された変数。クラス内であれば自由に使える。
    	 *
    	 * --------つまずき箇所 ---------
    	 * インターフェース型のオブジェクト → オブジェクトをインターフェースとして使えるようにしたもの
    	 * クラス型のオブジェクト → クラスオブジェクトは変数に保存できる
    	 *
    	 */
        Connection connection = null; //Connectionインターフェース型の変数connectionをセット
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            // データベースに接続
            Class.forName(POSTGRES_DRIVER);
            connection = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);
            statement = connection.createStatement();//createStatement:Connectionインターフェースで定義されている。結果を取得するためのstatement
            // 処理が流れた時間をフォーマットに合わせて生成
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdFormat = new SimpleDateFormat(TIME_FORMAT);
            // PreparedStatementで使用するため、String型に変換
            String login_time = sdFormat.format(cal.getTime());
            /*
             *  任意のユーザーのログインタイムを更新できるように、プリペアドステートメントを記述。
             */
            // preparedStatementに実行したいSQLを格納
            //ConnectionインターフェースのprepareStatement:後からSQLを変更するかもしれない時とか ?とか
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            // 問④ preparedStatementを使って、一番目のindexに今の時間をセットしてください。2番目のindexにIDをセットしてください。
            preparedStatement.setString(1, login_time);// preparedStatement: プリコンパイラされたSQL文を表すオブジェクト
            preparedStatement.setString(2, id);


            // 問⑤ UPDATEを実行する文を記述
            preparedStatement.executeUpdate(); //実行時の引数には何も入れない
            /*
             *  UPDATEが成功したものを即座に表示
             *  任意のユーザーを検索できるように、プリペアドステートメントを記述。
             */
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            //問⑥ 一番目のindexにIDをセットしてください。2番目のindexにPASSWORDをセット
            preparedStatement.setString(1, id); //searchの引数
            preparedStatement.setString(2, password); //searchの引数
            // SQLを実行。実行した結果をresultSetに格納。
            resultSet = preparedStatement.executeQuery(); //SELECT限定のexecuteQuery()
            while (resultSet.next()) {
                // 問⑦ tmpName,tmpComment,tmpLoginTimeに適当な値を入れてください。

            	//ここ！！！
                String tmpName = resultSet.getString("name"); //getString:文字列の値。SQLが格納されたresultSetだからカラム名で値が抽出できる？？
                String tmpComment = resultSet.getString("comment");
                String tmpLoginTime = resultSet.getString("login_time");
                // 問⑧ EmployeeBeanに取得したデータを入れてください。
                employeeDate = new EmployeeBean();
                employeeDate.setName(tmpName);
                employeeDate.setComment(tmpComment);
                employeeDate.setLogin_Time(tmpLoginTime);
            }
            // forName()で例外発生
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // getConnection()、createStatement()、executeQuery()で例外発生
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employeeDate;
    }

}