package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.MachineBean;
/**
 * ・社員情報検索サービス
 */
public class MachineService {
    // 問① 接続情報を記述してください
    /** ドライバーのクラス名 */
    private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
    /** ・JDMC接続先情報 */
    private static final String JDBC_CONNECTION = "jdbc:postgresql://localhost:5432/Employee";
    /** ・ユーザー名 */
    private static final String USER = "postgres";
    /** ・パスワード */
    private static final String PASS = "password123";
    // 問② 入力された値で、UPDATEする文
    /** ・SQL 入力金額から商品を求めるSQL */
//    private static final String SQL_UPDATE = "update Employee_table SET login_time = ? WHERE id = ?"; //コンプリメント
    // 問③ 入力されたIDとPassWordをキーにして、検索するSELECT文
    /** ・SQL 入力金額から商品を求めるSQL */
    private static final String SQL_SELECT = "SELECT price,name FROM Machine where price <= ?";
    MachineBean drink = null;
    // 送信されたIDとPassWordを元に社員情報を検索するためのメソッド
    public MachineBean search(String price) {

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



            preparedStatement = connection.prepareStatement(SQL_SELECT);
            preparedStatement.setString(1, price); //投入金額をセット
            // SQLを実行。実行した結果をresultSetに格納。
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // 問⑦ tmpName,tmpComment,tmpLoginTimeに適当な値を入れてください。

            	//ここ！！！
                String tmpPrice = resultSet.getString("price"); //getString:文字列の値。SQLが格納されたresultSetだからカラム名で値が抽出できる？？
                String tmpName = resultSet.getString("name");
                // 問⑧ EmployeeBeanに取得したデータを入れてください。
                drink = new MachineBean();
                drink.setPrice(tmpPrice); //金額入力
                drink.setName(tmpName);//飲みmのの名前を入れる
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
        return drink;
    }

}