package cn.edu.shou.staff.service.impl;

import java.util.List;

import cn.edu.shou.staff.dao.EmpDao;
/*jdbc version*/
/*import cn.edu.shou.staff.dao.impl.EmpDaoImpl;*/
/*hibernate version*/
import cn.edu.shou.staff.dao.hbmimpl.EmpDaoImpl;
import cn.edu.shou.staff.model.Emp;
import cn.edu.shou.staff.service.EmpService;

public class EmpServiceImpl implements EmpService{
	/*×¢²áDAO×é¼þ*/
	/*private EmpDao empDao = new EmpDaoImpl();*/
	private EmpDao empDao;
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	
	@Override
	public boolean addEmp(Emp emp) {
		// TODO Auto-generated method stub
		return empDao.addEmp(emp);
	}
	@Override
	public List<Emp> listEmp() {
		// TODO Auto-generated method stub
		return empDao.listEmp();
	}
	@Override
	public boolean deleteEmp(Emp emp) {
		// TODO Auto-generated method stub
		return empDao.deleteEmp(emp);
	}
	@Override
	public Emp findEmp(int id) {
		// TODO Auto-generated method stub
		return empDao.findEmp(id);
	}
	@Override
	public boolean editEmp(Emp emp) {
		// TODO Auto-generated method stub
		return empDao.editEmp(emp);
	}
}
