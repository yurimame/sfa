package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.RegistList;

public class Anken_dataDAO {
	private final String JDBC_URL = "jdbc:h2:C:/work/kensyu/data/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public boolean create (int anken_id, ArrayList<RegistList> registList2) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql1 = "INSERT INTO ANKEN_DATA(ANKEN_ID, EMP_NO) VALUES";
			String sql2 = "";

			for(int i=0; i<registList2.size(); i++){
				sql2 +="("+ anken_id +","+ registList2.get(i).getEmp_no() +")";
				if(registList2.size() !=1 && i != registList2.size() -1){
			    	sql2 += ",";
			    }
			}
			String sql = sql1 + sql2;
			PreparedStatement pStmt = conn.prepareStatement(sql);

			int result = pStmt.executeUpdate();
			if (result == 0) {
				return false;
			}

		} catch (SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
    }
	
	//データテーブルに登録されている社員の名前を取得
	public ArrayList<RegistList> findByEmpList(int anken_id){
		
		ArrayList<RegistList> empList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			
			String sql ="select anken_data.anken_id,anken_data.emp_no,employee.name_kanji \r\n"
					+ "from anken_data\r\n"
					+ "join employee\r\n"
					+ "on anken_data.emp_no = employee.emp_no\r\n"
					+ "where anken_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setInt(1,anken_id);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String emp_no = rs.getString("EMP_NO");
				String name_kanji = rs.getString("NAME_KANJI");
				RegistList emp = new RegistList(anken_id,emp_no,name_kanji);
				empList.add(emp);	
			}
			
					
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
		return empList;
	}
	//人員編集機能での初期値(社員名)を取得
	public ArrayList<RegistList> findByRegistList (int anken_id){
		
		ArrayList<RegistList> registList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			
			String sql ="select anken_data.anken_id,anken_data.emp_no,employee.name_kanji \r\n"
					+ "from anken_data\r\n"
					+ "join employee\r\n"
					+ "on anken_data.emp_no = employee.emp_no\r\n"
					+ "where anken_id = ?";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setInt(1,anken_id);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String emp_no = rs.getString("EMP_NO");
				String name_kanji = rs.getString("NAME_KANJI");
				RegistList emp = new RegistList(emp_no,name_kanji);
				registList.add(emp);	
			}
			
		}catch (SQLException e){
			e.printStackTrace();
			return null;
		}
		return registList;
	}
	//データテーブルレコード削除
	public boolean deleteRecord(int anken_id) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			
			String sql="delete from anken_data \r\n"
					+ "where anken_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,anken_id);
			
			int result = pStmt.executeUpdate();
			
			if(result != 1) {
				return false;
			}
			
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
