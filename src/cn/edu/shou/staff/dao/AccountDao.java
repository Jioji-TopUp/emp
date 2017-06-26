package cn.edu.shou.staff.dao;

import cn.edu.shou.staff.model.Account;

public interface AccountDao {
	public boolean mayILogin(Account account);
}
