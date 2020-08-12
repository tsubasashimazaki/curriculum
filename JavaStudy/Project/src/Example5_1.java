import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Example5_1 {

	// 定数, ドライバクラス名(現場によってクラス名は変わる)
	private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
	// JDMC接続先情報
	private static final String JDBC_CONNECTION =
			"jdbc:postgresql://localhost:5432/lesson_db";
	// ユーザー名
	private static final String USER = "postgres";
	// パスワード
	private static final String PASS = "postgres";

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(POSTGRES_DRIVER); //データベースの接続準備(forName()で読み込み)
			connection = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);

			// Statementインターフェース
			statement = connection.createStatement(); //ConnectionクラスのcreateStatement()メソッドで取得→SQLの実行！
			String SQL = "SELECT  * FROM Goods";
			// resultSetはSQLの実行結果を格納し、ぞの情報を取得できるメソッドも備えている
			resultSet = statement.executeQuery(SQL); //executeQuery()メソッドは引数で指定されたSQLをデータベースで実行するメソッド！

			while (resultSet.next()) { //next()メソッドは該当行があればtrueを返し、次の行へ移動
				String column1 = resultSet.getString("GoodsName");
				String column2 = resultSet.getString("UnitPrice");
				String column3 = resultSet.getString("UpdateDate");

				System.out.print(column1 + ",");
                System.out.print(column2 + ",");
                System.out.println(column3);
			}
			// forName()で例外発生
			} catch (ClassNotFoundException e) {
			e.printStackTrace();

			//get.Connection, createStatement, executeQueryで例外発生
		} catch (SQLException e) {
			e.printStackTrace();

		}finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					connection.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace(); //printStackTrace: Throwableクラスのメソッド。Throwableクラスは全ての例外クラスの親クラス
			}
		}
	}
}
