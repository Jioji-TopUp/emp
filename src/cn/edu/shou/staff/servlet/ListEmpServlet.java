package cn.edu.shou.staff.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.shou.staff.model.Emp;
import cn.edu.shou.staff.service.EmpService;
import cn.edu.shou.staff.service.impl.EmpServiceImpl;

public class ListEmpServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmpService empService = new EmpServiceImpl();
	/**
	 * Constructor of the object.
	 */
	public ListEmpServlet() {
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
	 * The service method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*1.调用service*/
		List<Emp> list = empService.listEmp();
		/*2.附带数据*/
		request.setAttribute("emps", list);
		/*3.页面跳转,请求转发*/
		request.getRequestDispatcher("ListEmp.jsp")
			.forward(request,response);
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
