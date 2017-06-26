package cn.edu.shou.staff.dao.hbmimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cn.edu.shou.staff.dao.EmpDao;
import cn.edu.shou.staff.model.Emp;

public class EmpDaoImpl implements EmpDao {
	private SessionFactory sf; 
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public boolean addEmp(Emp emp) {
		// TODO Auto-generated method stub
		/*Session session = HibernateSessionFactory.getSession();*/
		Session session = sf.openSession();
		/*开启事务*/
		Transaction tx = session.beginTransaction();
		session.save(emp);
		/*事务提交*/
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public List<Emp> listEmp() {
		// TODO Auto-generated method stub
		/*Session session = HibernateSessionFactory.getSession();*/
		Session session = sf.openSession();
		/*HQL:Hibernate Query Language*/
		List<Emp> emps = session.createQuery("from cn.edu.shou.staff.model.Emp")
			.list();
		return emps;
	}

	@Override
	public boolean deleteEmp(Emp emp) {
		// TODO Auto-generated method stub
		/*Session session = HibernateSessionFactory.getSession();*/
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(emp);
		tx.commit();
		return true;
	}

	@Override
	public Emp findEmp(int id) {
		// TODO Auto-generated method stub
		/*Session session = HibernateSessionFactory.getSession();*/
		Session session = sf.openSession();
		/*方案1，get()方法*/
		Emp emp = (Emp)session.get(Emp.class, id);
		/*方案2，load()方法*/
		/*Emp emp = (Emp)session.load(Emp.class, id);*/
		return emp;
	}

	@Override
	public boolean editEmp(Emp emp) {
		// TODO Auto-generated method stub
		/*Session session = HibernateSessionFactory.getSession();*/
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(emp);
		tx.commit();
		return true;
	}
}
