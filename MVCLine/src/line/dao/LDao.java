package line.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import line.dto.LDto;



public class LDao {
	DataSource dataSource;
	
	public LDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc"); 
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	// ------------------------------------------------------
	public ArrayList<LDto> list() {	
		ArrayList<LDto> dtos = new ArrayList<LDto>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		/////////////////////// COUNT를 초기화
		try {
			connection = dataSource.getConnection();
			String query = "SET @COUNT = 0;";
			ps = connection.prepareStatement(query);
			ps.executeUpdate(); // 예전에 했던 sql 커맨드 이걸로 끝!
	
		}catch (Exception e) { 
			e.printStackTrace();	
		}finally { // 걸리거나 안걸리거나 무조건 이쪽으로 들어옴
			try { // 전부 연결 해제
				if(ps != null) ps.close();
				if(connection != null) connection.close();
				
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
/////////////////// COUNT로 seqno를 재 정리
		try {
			connection = dataSource.getConnection();
			String query = "UPDATE mvc_line SET mvc_line.bId = @COUNT := @COUNT + 1";
			ps = connection.prepareStatement(query);
			ps.executeUpdate();

		}catch (Exception e) { 
			e.printStackTrace();	
		}finally {
			try { 
				if(ps != null) ps.close();
				if(connection != null) connection.close();
				
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
//////////////////////////////////////////		
		try {
			connection = dataSource.getConnection();
			String query = "select bId, bName, bTitle, bDate from mvc_line";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery(); // 예전에 했던 sql 커맨드 이걸로 끝!
			
			while(rs.next()) {
				
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTItle");
				Timestamp bDate = rs.getTimestamp("bDate");
				
				LDto dto = new LDto(bId, bName, bTitle, bDate);
				dtos.add(dto); // arrayList로 입력	
			}
		}catch (Exception e) { 
			e.printStackTrace();	
		}finally { // 걸리거나 안걸리거나 무조건 이쪽으로 들어옴
			try { // 전부 연결 해제
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(connection != null) connection.close();
				
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dtos;
	}
	// ------------------------------------------------------
	
	public void write (String bName,String bTitle) { // 데이터베이스에 항목추가
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = dataSource.getConnection();
			String query = "insert into mvc_line(bName, bTitle,bDate) values (?,?,now()) "; // now(): mysql 쓸 때만 사용할 수 있는 함수
			ps = connection.prepareStatement(query);
			
			ps.setString(1, bName);
			ps.setString(2, bTitle);
			
			ps.executeUpdate(); 
		}catch(Exception e){
			e.printStackTrace();
		}finally { 
			try { 
				if(ps != null) ps.close();
				if(connection != null) connection.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	// ------------------------------------------------------
	
	public void delete(String bId) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			
			connection = dataSource.getConnection();
			String query = "delete from mvc_line where bId = ? ";
			ps = connection.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(bId));
			ps.executeUpdate(); 
			
		}catch(Exception e){
			e.printStackTrace();
		}finally { 
			try { 
				if(ps != null) ps.close();
				if(connection != null) connection.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}	
		
	}
	
	
	
}
