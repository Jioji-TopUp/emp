package cn.edu.shou.staff.action;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.shou.staff.model.Account;
import cn.edu.shou.staff.service.AccountService;
import cn.edu.shou.staff.service.impl.AccountServiceImpl;

public class LoginAction {
	private Account acc;
/*	private AccountService accountService = 
			new AccountServiceImpl();*/
	private AccountService accountService;
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
	public Account getAcc() {
		return acc;
	}
	public void setAcc(Account acc) {
		this.acc = acc;
	}
	
	public String login(){
		String res = "success";
		String msg = "";
		boolean flag = accountService.mayILogin(acc);
		if(!flag){
			msg = "Invalid username or password";
			res = "login";
			ActionContext.getContext().put("msg", msg);
		}else{
			ActionContext.getContext()
				.getSession().put("uname", acc.getUname());
		}
		return res;
	}
}
