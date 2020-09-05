package controller;
/**
 * 社員情報管理コントローラー（メインサーブレット）
 *
 * @author s.nanaumi
 * @since 2019/03/15
 *
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

public class EmployeeController extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			// index.htmlから投げられたIDとPassWordの値を取得できるようにする
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			/*
             *  IDとPassWordと共に、社員情報を検索する関数の呼び出し、結果をJSPに渡す処理
             */
			EmployeeService employeeService = new EmployeeService();
			EmployeeBean employeeBean= new EmployeeBean();
			//インスタンス化したEmployeeBeanにEmployeeServiceのsearch関数の格納
			employeeBean = employeeService.search(id,password); // 戻り値employeeDataが格納
			// 取得したemployeeBeanの値をindex.jspに渡すためリクエストスコープにセット
			request.setAttribute("EmployeeBean", employeeBean);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ServletContext context = this.getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/index/jsp");
			dispatcher.forward(request, response);
			}
	}
}