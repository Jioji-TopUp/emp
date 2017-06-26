package cn.edu.shou.staff.service.impl;

import cn.edu.shou.staff.dao.AccountDao;
/*jdbc version*/
/*import cn.edu.shou.staff.dao.impl.AccountDaoImpl;*/
/*hibernate version*/
import cn.edu.shou.staff.dao.hbmimpl.AccountDaoImpl;
import cn.edu.shou.staff.model.Account;
import cn.edu.shou.staff.service.AccountService;

public class AccountServiceImpl implements AccountService{
	/*private AccountDao accountDao = new AccountDaoImpl();*/
	private AccountDao accountDao;	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public boolean mayILogin(Account account) {
		// TODO Auto-generated method stub
		return accountDao.mayILogin(account);
	}

}
