package cn.edu.shou.staff.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.shou.staff.model.Account;
import cn.edu.shou.staff.service.AccountService;
import cn.edu.shou.staff.service.impl.AccountServiceImpl;

public class LoginServlet extends HttpServlet {
	private AccountService accountService = new AccountServiceImpl();
	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Account account = new Account();
		account.setUname(request.getParameter("uname"));
		account.setPasswd(request.getParameter("passwd"));
		boolean res = accountService.mayILogin(account);
		if(res){
			/*允许登录，把用户名写进session，去列表页*/
			HttpSession session = request.getSession();
			session.setAttribute("uname", account.getUname());
			request.getRequestDispatcher("ListEmpServlet")
				.forward(request,response);
		}else{
			/*用户名密码错，返回登录页*/
			request.setAttribute("msg", "Invalid username or password");
			request.getRequestDispatcher("Login.jsp")
				.forward(request,response);
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
