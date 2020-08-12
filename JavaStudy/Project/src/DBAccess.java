import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 */

/**
 * @author bankun
 *
 */
public class DBAccess { //データベースへの接続と切断の処理を行うプログラム(現場によってクラス名は変わる)
	// ドライバのクラス名
	private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
	// JDMC接続先情報
	private static final String JDBC_CONNECTION =
			"jdbc:postgresql://localhost:5432/lesson_db";
	// ユーザー名
	private static final String USER = "postgres";
	// パスワード
	private static final String PASS = "postgres";

	public static void main(String[] args) {

		Connection connection = null; // Connectionクラスのconnectionオブジェクトかな？nullを入れる

		try {
			// データベースに接続する準備(Class.forName()でロードしている)
			Class.forName(POSTGRES_DRIVER);
			// 接続先の情報(getConnection()3つの引数を与える。(データベース名, ユーザー, パスワード))
			connection = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);

			//forName()で例外発生
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

			// getConnection()で例外発生
		} catch (SQLException e) {
			e.printStackTrace();

		} finally { // finally: 例外処理があっても実行する処理(DBに接続したら、必ず切断するようにする)
			try {
				if (connection != null) {
					// データベースを切断
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
