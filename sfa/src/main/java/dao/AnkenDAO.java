package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Anken;

public class AnkenDAO {
	private final String JDBC_URL = "jdbc:h2:C:/work/kensyu/data/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public List<Anken> findAll() {
		List<Anken> AnkenList = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			String sql = "SELECT * FROM ANKEN";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				int anken_id = rs.getInt("ANKEN_ID");
				String anken_name = rs.getString("ANKEN_NAME");
				String anken_startday = rs.getString("ANKEN_STARTDAY");
				String anken_endday = rs.getString("ANKEN_ENDDAY");
				String client_name = rs.getString("CLIENT_NAME");
				int sales_place = rs.getInt("SALES_PLACE");
				String sales_name = rs.getString("SALES_NAME");
				int display_position = rs.getInt("DISPLAY_POSITION");

				Anken anken = new Anken(anken_id, anken_name, anken_startday, anken_endday,
						client_name, sales_place, sales_name,display_position);
				AnkenList.add(anken);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return AnkenList;

	}

	public boolean create (Anken anken) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			String sql = "INSERT INTO ANKEN(ANKEN_NAME,ANKEN_STARTDAY,ANKEN_ENDDAY,CLIENT_NAME, SALES_PLACE, SALES_NAME, DISPLAY_POSITION) "
					+ "VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, anken.getAnken_name());
			pStmt.setString(2, anken.getAnken_startday());
			pStmt.setString(3, anken.getAnken_endday());
			pStmt.setString(4, anken.getClient_name());
			pStmt.setInt(5, anken.getSales_place());
			pStmt.setString(6, anken.getSales_name());
			pStmt.setInt(7, 1);

			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}



//表示位置変更、display_positionをUPDATE
	public boolean changePosition (int id,String position_id) {
		System.out.println("位置変更しにきた"+id+position_id);
		//DB接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
		//UPDATE文を準備
			String sql ="UPDATE ANKEN SET DISPLAY_POSITION=? WHERE ANKEN_ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
		//?の値をセット
			pStmt.setString(1, position_id);
			pStmt.setInt(2, id );
		//UPDATE実行
			int result = pStmt.executeUpdate();
			System.out.println(result);
			if(result != 1) {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public int findID() {
		int anken_id = 0;

		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql = "SELECT ANKEN_ID FROM ANKEN ORDER BY ANKEN_ID DESC LIMIT 1";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				anken_id = rs.getInt("ANKEN_ID");
			}
		} catch (SQLException e){
			e.printStackTrace();
			return 0;
		}
		return anken_id;
	}
	//引数と同じ案件IDのレコードを取得
	public List<Anken> findRecord(int id) {
		List<Anken> AnkenList = new ArrayList<>();
		int receiveId = id;

		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql = "SELECT * FROM ANKEN WHERE ANKEN_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, receiveId);

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				int anken_id = rs.getInt("ANKEN_ID");
				String anken_name = rs.getString("ANKEN_NAME");
				String anken_startday = rs.getString("ANKEN_STARTDAY");
				String anken_endday = rs.getString("ANKEN_ENDDAY");
				String client_name = rs.getString("CLIENT_NAME");
				int sales_place = rs.getInt("SALES_PLACE");
				String sales_name = rs.getString("SALES_NAME");
				int display_position = rs.getInt("DISPLAY_POSITION");

				Anken anken = new Anken(anken_id, anken_name, anken_startday, anken_endday,
						client_name, sales_place, sales_name,display_position);
				System.out.println(anken);
				AnkenList.add(anken);

			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
			return AnkenList;
	}
	//編集内容をupdate
	public boolean updateAnken(int anken_id,String anken_name,String anken_startday, String anken_endday,String client_name,int sales_place,String sales_name ) {
		
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			
			String sql ="UPDATE ANKEN SET ANKEN_NAME=?,ANKEN_STARTDAY=?,ANKEN_ENDDAY=?,CLIENT_NAME=?,SALES_PLACE=?,SALES_NAME=? \r\n"
					+ "WHERE ANKEN_ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1,anken_name );
			pStmt.setString(2,anken_startday );
			pStmt.setString(3,anken_endday );
			pStmt.setString(4,client_name );
			pStmt.setInt(5,sales_place );
			pStmt.setString(6,sales_name);
			pStmt.setInt(7,anken_id );
			
			int result = pStmt.executeUpdate();
			
			if(result != 1) {
				return false;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
