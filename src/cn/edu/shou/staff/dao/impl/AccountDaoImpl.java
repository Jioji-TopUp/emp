package cn.edu.shou.staff.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.shou.staff.dao.AccountDao;
import cn.edu.shou.staff.model.Account;
import cn.edu.shou.staff.model.Emp;

public class AccountDaoImpl implements AccountDao {

	@Override
	public boolean mayILogin(Account account) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean res = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/shoudb" +
					"?user=root&password=root";
			conn = DriverManager.getConnection(url);
			String sql = "select name,password from account" +
					" where name=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getUname());
			pstmt.setString(2, account.getPasswd());
			rs = pstmt.executeQuery();
			if(rs.next())
				res = true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();			
		} finally {
			try{
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		return res;
	}

}
