package cn.edu.shou.staff.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.shou.staff.model.Emp;
import cn.edu.shou.staff.service.EmpService;
import cn.edu.shou.staff.service.impl.EmpServiceImpl;

public class DeleteEmpServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmpService empService = new EmpServiceImpl();
	/**
	 * Constructor of the object.
	 */
	public DeleteEmpServlet() {
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
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*1.获取id*/
		int id = Integer.parseInt(request.getParameter("id"));
		Emp emp = new Emp();
		emp.setId(id);
		/*2.调用service*/
		empService.deleteEmp(emp);
		/*3.页面跳转:重定向*/
		response.sendRedirect("ListEmpServlet");
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
