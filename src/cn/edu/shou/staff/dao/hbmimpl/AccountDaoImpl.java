package cn.edu.shou.staff.dao.hbmimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.edu.shou.staff.dao.AccountDao;
import cn.edu.shou.staff.model.Account;

public class AccountDaoImpl implements AccountDao{
	private SessionFactory sf;
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}


	@Override
	public boolean mayILogin(Account account) {
		// TODO Auto-generated method stub
		/*Session session = HibernateSessionFactory.getSession();*/
		Session session = sf.openSession();
		Query query = session.createQuery("from cn.edu.shou.staff.model.Account acc" +
				" where acc.uname=:u and acc.passwd=:v");
		query.setString("u", account.getUname());
		query.setString("v", account.getPasswd());
		List list = query.list();
		return list.size()>0;
	}		
}
