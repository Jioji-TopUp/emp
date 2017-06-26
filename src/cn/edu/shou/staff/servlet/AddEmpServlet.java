package cn.edu.shou.staff.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.shou.staff.model.Emp;
import cn.edu.shou.staff.service.EmpService;
import cn.edu.shou.staff.service.impl.EmpServiceImpl;

public class AddEmpServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmpService empService = new EmpServiceImpl();
	/**
	 * Constructor of the object.
	 */
	public AddEmpServlet() {
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
		Emp emp = new Emp();
		String ename = request.getParameter("name");
		emp.setName(ename);
		emp.setSex(request.getParameter("sex"));
		emp.setDept(request.getParameter("dept"));
		empService.addEmp(emp);	
		/*÷ÿ∂®œÚ*/
		response.sendRedirect("ListEmpServlet");
		/*request.getRequestDispatcher("ListEmpServlet")
			.forward(request,response);*/
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
