import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Example5_2 {

	// 定数 ドライバクラス名
	private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
	// JDMC接続先情報
	private static final String JDBC_CONNECTION =
			"jdbc:postgresql://localhost:5432/lesson_db";
	// ユーザー名
	private static final String USER = "postgres";
	private static final String PASS = "postgres";

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(POSTGRES_DRIVER);
			connection = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);


			statement = connection.createStatement();
			String SQL = "INSERT INTO TB_SHOHIN( SHOHIN_ID, SHOHIN_NAME, TANKA)" + "VALUES('021', 'SHOHIN021', 2100)";
			// SELECT文以外のSQLはUpdate()使用
			statement.executeUpdate(SQL);

			// forName()で例外発生
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		// getConnection(), createStatement(), executeQuery()で例外発生
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
 	}
}
