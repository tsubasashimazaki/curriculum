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

public class EmployeeService {

	private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
	private static final String JDBC_CONNECTION = "jdbc:postgresql://localhost:5432/lesson_db";
	private static final String USER = "postgres";
	private static final String PASS = "password123";
    private static final String TIME_FORMAT = "yyyy/MM/dd hh:mm:ss";

    EmployeeBean employeeData = null;


public EmployeeBean search(String id, String password) { //ControllerからのdoPostで送られてきたid,passwordが格納されている
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;


    try {
    	// DB接続
    	Class.forName(POSTGRES_DRIVER);
    	connection = DriverManager.getConnection(JDBC_CONNECTION,USER,PASS);

    	statement = connection.createStatement();

    	// ログインタイムの生成
    	Calendar cal = Calendar.getInstance();//getInstance: このメソッドが実行された日時の情報を取得
    	SimpleDateFormat sdFormat = new SimpleDateFormat(TIME_FORMAT);// SimpleDateFormarの引数にはフォーマットパターン
    	String login_Time = sdFormat.format(cal.getTime());

    	//任意のユーザーのログインタイムをUPDATEする。
    	String SQL_UPDATE = "UPDATE employee_table SET login_time = ? where id = ?";

    	PreparedStatement psExecuteUpdate = connection.prepareStatement(SQL_UPDATE);

    	psExecuteUpdate.setString(1, login_Time);
    	psExecuteUpdate.setString(2, id); //doPostで受け取ったname="id"
    	psExecuteUpdate.executeUpdate();

    	while (resultSet.next()) { //next()1行ずつ実行

    		String colmun1 = resultSet.getString("name");
    		String colmun2 = resultSet.getString("comment");
    		String colmun3 = resultSet.getString("login_time");

    		employeeData = new EmployeeBean();
    		employeeData.setName(colmun1);
    		employeeData.setComment(colmun2);
    		employeeData.setLogin_Time(colmun3);
    	}

    } catch (ClassNotFoundException e) {
    	e.printStackTrace();

    } catch (SQLException e){ // SQLException:データベースアクセス中のエラー
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
    return employeeData;
    }

}

