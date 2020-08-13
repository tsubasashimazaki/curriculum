package controller;
/**
 * 社員情報管理コントローラー Controller:ブラウザからの応答・要求を受け付けるサーブレット
 * サーブレットとは→サーバーサイドで動くJavaプログラム(サーバーで動く)
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeBean;
import service.EmployeeService;

public class EmployeeController extends HttpServlet { //HttpServletの継承するときはdoXXXXを必ず使うこと
	// フォームのmethod="post"からdoPostが呼び出し
    public void doPost(HttpServletRequest request, HttpServletResponse response) //doPostメソッドをオーバーライド
            throws ServletException, IOException {
        try {// try:例外が発生するかもしれない処理を記述
            // 問① index.htmlから送信されたIDとPassWordの値を取得できるように修正しましょう。
            String id = request.getParameter("id"); //name属性がid情報を持ってくる
            String password = request.getParameter("pass"); //name属性がpassを持ってくる

            /*
             *  IDとPassWordと元に、社員情報を検索する関数の呼び出し、結果をJSPに渡す処理
             *  ※ EmployeeBeanとEmployeeServiceをimportするのを忘れないでください。
             */
            // 問② EmployeeServiceクラスをインスタンス化する。
            EmployeeService empService = new EmployeeService();
            // 問③ EmployeeBeanに、EmployeeServiceよりsearch関数を呼び出し、返り値を格納する。
             EmployeeBean EmployeeBean = empService.search(id, password);
            // 問④ nullの部分に適切な引数をセットする。
             // setAttribute("属性の名前", "属性値");
            request.setAttribute("EmployeeBean", EmployeeBean);// setAttribute(属性名, 属性の値)
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ServletContext context = this.getServletContext(); //値を保管するServletContextオブジェクト
            RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");// getRequestDispatcher():ServletからJSPを表示するためのファイル
            dispatcher.forward(request, response); //フォワードを行う
            // RequestDispatcher: doXXXXから抜けた後のページ遷移で使うことが多い
        }
    }
}