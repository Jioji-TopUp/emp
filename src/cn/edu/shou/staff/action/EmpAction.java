package cn.edu.shou.staff.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.shou.staff.model.Emp;
import cn.edu.shou.staff.service.EmpService;

public class EmpAction {
	/*处理Emp的CRUD请求*/
	private Emp emp;
	/*private EmpService empService = new EmpServiceImpl();*/
	/*spring version begin*/
	private EmpService empService;
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	/*spring version end*/
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	
	public String add(){
		String res = "success";
		boolean flag = empService.addEmp(emp);
		if(!flag)
			res = "fail";	
		return res;
	}
	
	public String list(){
		List<Emp> emps = empService.listEmp();
		/*相当于HttpServletRequest*/		
		ActionContext.getContext().put("emps", emps);
		return "list";
	}
	
	public String delete(){
		String res = "success";
		boolean flag = empService.deleteEmp(emp);
		if(!flag)
			res = "fail";
		return res;
	}
	
	public String find(){
		String res = "edit";
		Emp emp = empService.findEmp(this.getEmp().getId());
		ActionContext.getContext().put("obj", emp);
		if(emp==null)
			res = "fail";
		return res;
	}
	
	public String edit(){
		String res = "success";
		boolean flag = empService.editEmp(emp);
		if(!flag)
			res = "fail";
		return res;
	}
}
