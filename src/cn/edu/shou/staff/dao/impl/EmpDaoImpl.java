package cn.edu.shou.staff.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.shou.staff.dao.EmpDao;
import cn.edu.shou.staff.model.Emp;

public class EmpDaoImpl implements EmpDao {

	@Override
	public boolean addEmp(Emp emp) {
		// TODO Auto-generated method stub
		int row = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/shoudb" +
					"?user=root&password=root";
			conn = DriverManager.getConnection(url);
			String sql = "insert into emp(ename,esex,dept) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getName());
			pstmt.setString(2, emp.getSex());
			pstmt.setString(3, emp.getDept());
			row = pstmt.executeUpdate();
		}catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}catch(SQLException se){
			se.printStackTrace();
		}finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		}
		return row>0;
	}

	@Override
	public List<Emp> listEmp() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Emp> emps = new ArrayList<Emp>(); 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/shoudb" +
					"?user=root&password=root";
			conn = DriverManager.getConnection(url);
			String sql = "select id,ename,esex,dept from emp";
			pstmt = conn.prepareStatement(sql);
			/*insert,update,delete:executeUpdate()*/
			/*select:executeQuery()*/
			rs = pstmt.executeQuery();
			while(rs.next()){
				Emp emp = new Emp();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("ename"));
				emp.setSex(rs.getString("esex"));
				emp.setDept(rs.getString("dept"));
				emps.add(emp);
			}
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
		return emps;
	}

	@Override
	public boolean deleteEmp(Emp emp) {
		// TODO Auto-generated method stub
		int row = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/shoudb" +
					"?user=root&password=root";
			conn = DriverManager.getConnection(url);
			String sql = "delete from emp where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getId());
			row = pstmt.executeUpdate();
		}catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}catch(SQLException se){
			se.printStackTrace();
		}finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		}
		return row>0;
	}

	@Override
	public Emp findEmp(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Emp emp = null; 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/shoudb" +
					"?user=root&password=root";
			conn = DriverManager.getConnection(url);
			String sql = "select id,ename,esex,dept from emp" +
					" where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				emp = new Emp();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("ename"));
				emp.setSex(rs.getString("esex"));
				emp.setDept(rs.getString("dept"));
			}
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
		return emp;
	}

	@Override
	public boolean editEmp(Emp emp) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/shoudb" +
					"?user=root&password=root";
			conn = DriverManager.getConnection(url);
			String sql = "update emp set ename=?,esex=?,dept=?" +
					" where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getName());
			pstmt.setString(2, emp.getSex());
			pstmt.setString(3, emp.getDept());
			pstmt.setInt(4, emp.getId());
			row = pstmt.executeUpdate();
		}catch(ClassNotFoundException e){
			e.printStackTrace();			
		}catch(SQLException se){
			se.printStackTrace();
		}finally{
			try{
				if(pstmt!=null)
					pstmt.close();
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}		
		return row>0;
	}
}
