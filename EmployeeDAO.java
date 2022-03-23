package JDBCDAO;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.Employee;

public interface EmployeeDAO {
	
	public int save(Employee e);

	public ArrayList<Employee> getemployeelist();

	public Employee geteditdata(int selectedid);

	public int deletedata(int selectedid) throws SQLException;

	public int updatedata(Employee e) throws SQLException;

	public boolean checkmailexist(String name);

	


	

	

}
