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

import bean.MachineBean;
import service.MachineService;

public class EmployeeController extends HttpServlet { //HttpServletの継承するときはdoXXXXを必ず使うこと
	// フォームのmethod="post"からdoPostが呼び出し
    public void doPost(HttpServletRequest request, HttpServletResponse response) //doPostメソッドをオーバーライド
            throws ServletException, IOException {
        try {// try:例外が発生するかもしれない処理を記述
            // 問① index.htmlから送信されたIDとPassWordの値を取得できるように修正しましょう。
            String price = request.getParameter("price"); //name属性のprice:投入金額を持ってくる


            MachineService mc = new MachineService();

            MachineBean MachineBean = mc.search(price);
            request.setAttribute("MachineBean", MachineBean);// setAttribute(属性名, 属性の値)EmployeeBeanにEmployeeBeanを下記のフォワードで渡す
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ServletContext context = this.getServletContext(); //getServletContext:サーブレットで設定したファイルをcontextに保管
            RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");// getRequestDispatcher():ServletからJSPを表示するためのファイル
            dispatcher.forward(request, response); //フォワードを行う
            System.out.println(request);
            // RequestDispatcher: doXXXXから抜けた後のページ遷移で使うことが多い
        }
    }
}