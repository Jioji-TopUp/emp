package cn.edu.shou.staff.service;

import cn.edu.shou.staff.model.Account;

public interface AccountService {
	public boolean mayILogin(Account account);
}
