/**
 *
 */
package helloPackage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author bankun
 *
 */
public class HelloServlet extends HttpServlet { //importで呼び出しているHttpServletスパークラス
	// オーバーライド。doGetメソッド: クライアントからデータ要求がある場合に呼び出される
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		setContentType:拡張子だけでは転送先のブラウザで判別が難しい情報を伝えるための設定
		response.setContentType("text/html; charset=Windows-31j");//responseにはheml型で,文字コードの指定
		//responseより呼び出したgetWriterメソッドで、PeintWriterクラスのoutインスタンスを生成。
	    PrintWriter out = response.getWriter();
//	    PrintWriterクラスではSystem.out.plintln→plintlnで実行できる
	    out.println("<body>HelloServlet</body>");
	}

}
