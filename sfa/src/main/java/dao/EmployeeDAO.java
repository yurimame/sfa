package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
//人員登録機能　社員一覧を取得
public class EmployeeDAO {
	private final String JDBC_URL = "jdbc:h2:C:/work/kensyu/data/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public List<Employee> findByName() {
		List<Employee> employeeList = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			String sql = "SELECT * FROM EMPLOYEE";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				String emp_no = rs.getString("EMP_NO");
				String name_kannji = rs.getString("NAME_KANJI");
				Employee employee = new Employee(emp_no,name_kannji);
				employeeList.add(employee);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return employeeList;
		}
	//メイン画面 待機中の社員一覧を取得
	public ArrayList<Employee> findByStandby(){
		ArrayList<Employee> standbyList = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql="SELECT EMP_NO,NAME_KANJI,STANDBY_FLG FROM EMPLOYEE\r\n"
					+ "WHERE STANDBY_FLG = 1";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				String emp_no = rs.getString("EMP_NO");
				String name_kannji = rs.getString("NAME_KANJI");
				Employee employee = new Employee(emp_no,name_kannji);
				standbyList.add(employee);
			}

		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return standbyList;
	}

}
