package JDBCDAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.jdbc.ResultSet;

import entity.Employee;

public class EmployeeJDBC implements EmployeeDAO {
	
	Connection con = null;
	
	 public EmployeeJDBC(Connection con) {
		// TODO Auto-generated constructor stub
		
		this.con = con;
	}

	@Override
	public int save(Employee e) {
		Connection con = null;
		try {
			con = ConnectionProvider.getConnection();
		 
		String sql ="Insert into employee "
				+ "(name,salary,departmentid)"
				+ "values(?,?,?)";
		PreparedStatement pmt = con.prepareStatement(sql);
		pmt.setString(1, e.getEname());
		pmt.setString(2, e.getEsalary());
		pmt.setString(3, e.getEdepartment());
		int result = pmt.executeUpdate();
		System.out.println("Data inserted successfully");
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public ArrayList<Employee> getemployeelist() {
		Connection con = null;
		ArrayList<Employee>elist = new ArrayList<Employee>();
		try {
			con = ConnectionProvider.getConnection();
			String sql = "Select id,name,salary,departmentId from employee";
			PreparedStatement pmt = con.prepareStatement(sql);
			ResultSet rs = (ResultSet) pmt.executeQuery();
			while(rs.next()) {
				Employee e1 = new Employee();
				e1.setId(rs.getInt(1));
				e1.setEname(rs.getString(2));
				e1.setEsalary(rs.getString(3));
				e1.setEdepartment(rs.getString(4));
				elist.add(e1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return elist;
	}

	@Override
	public Employee geteditdata(int selectedid) {
		Connection con = null;
		Employee e1 = new Employee();
		try {
			con = ConnectionProvider.getConnection();
			String sql = "Update employee set name=?, salary=?,"
					    +"departmentId=? where id=? ";
			
			PreparedStatement pmt = con.prepareStatement(sql);
			pmt.setString(1, "Dik");
			pmt.setString(2, "15000");
			pmt.setString(3, "3");
			pmt.setInt(4, selectedid);
			
			int result = pmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}

	@Override
	public int deletedata(int selectedid) throws SQLException {
		Connection con = null;
		con = ConnectionProvider.getConnection();
		String sql = "Delete from employee where id=selectedid";
		PreparedStatement pmt = con.prepareStatement(sql);
		int result = pmt.executeUpdate();
		return 0;
		
		
		
	}

	@Override
	public int updatedata(Employee e) throws SQLException {
		Connection con = null;
		con = ConnectionProvider.getConnection();
		String sql ="Insert into employee(id,name,salary,departmentId)+"
				+ " values(?,?,?,?)";
		PreparedStatement pmt = con.prepareStatement(sql);
		pmt.setInt(1, e.getId());
		pmt.setString(2, e.getEname());
		pmt.setString(3, e.getEsalary());
		pmt.setString(4, e.getEdepartment());
		int result = pmt.executeUpdate();
		
		return 0;
	}

	@Override
	public boolean checkmailexist(String name) {
		
		return false;
	}
	

	
	
	
	
	}


