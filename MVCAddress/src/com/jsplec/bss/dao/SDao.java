package com.jsplec.bss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.bss.dto.SDto;
import com.jsplec.bss.util.SShare;



public class SDao {

	DataSource dataSource;
	
	public SDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc"); 
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	// ------------------------------------------------------
	public ArrayList<SDto> list() {	
		ArrayList<SDto> dtos = new ArrayList<SDto>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			String query = "select seqno, name, telno, address, email, relation from addressbook";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery(); // 예전에 했던 sql 커맨드 이걸로 끝!
			
			while(rs.next()) {
				
				int sSeqno = rs.getInt("seqno");
				String sName = rs.getString("name");
				String sTelno = rs.getString("telno");
				String sAddress = rs.getString("address");
				String sEmail = rs.getString("email");
				String sRelation = rs.getString("relation");
				SDto dto = new SDto(sSeqno, sName, sTelno, sAddress, sEmail, sRelation); // Dto 자바빈에 입력
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
	
	// ------------------------------------------------------ write ---------------------------------------------------------------------------	
		public void write (String name, String telno, String address, String email, String relation) { // 데이터베이스에 항목추가
			Connection connection = null;
			PreparedStatement ps = null;
			try {
				connection = dataSource.getConnection();
				String query = "insert into addressbook(name, telno, address, email, relation) values (?,?,?,?,?) ";
				ps = connection.prepareStatement(query);
				

				ps.setString(1, name);
				ps.setString(2, telno);
				ps.setString(3, address);
				ps.setString(4, email);
				ps.setString(5, relation);
				
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
		
	// ------------------------------------------------------ contentView ---------------------------------------------------------------------------	
	public SDto contentView(String aSeqno) {
		
		SDto dto = new SDto();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select seqno,name,telno,address,email,relation from addressbook where seqno=?";
			ps = connection.prepareStatement(query);
			
			ps.setInt(1, Integer.parseInt(aSeqno));
			
			rs = ps.executeQuery(); // 예전에 했던 sql 커맨드 이걸로 끝!
			
			while(rs.next()) {
				int seqno = rs.getInt("seqno");
				String name = rs.getString("name");
				String telno = rs.getString("telno");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String relation = rs.getString("relation");
				
				dto = new SDto(seqno,name,telno,address,email,relation); // Dto 자바빈에 입력
			}
		}catch (Exception e) { 
			e.printStackTrace();	
		}finally { // 걸리거나 안걸리거나 무조건 이쪽으로 들어옴 파이널리는 항상 똑같음 그냥 다 닫는 부분
			try { // 전부 연결 해제
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(connection != null) connection.close();
				
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dto;
	}
		
	
	// ------------------------------------------------------ modify ---------------------------------------------------------------------------
		public void modify(String seqno, String name, String telno, String address, String email, String relation) { 
		
			Connection connection = null;
			PreparedStatement ps = null;

			try {
				connection = dataSource.getConnection();
				String query = "update addressbook set name=?, telno=?, address=?, email=?, relation=? where seqno = ?";
				ps = connection.prepareStatement(query);
				
				ps.setString(1, name);
				ps.setString(2, telno);
				ps.setString(3, address);
				ps.setString(4, email);
				ps.setString(5, relation);
				ps.setInt(6, Integer.parseInt(seqno));
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
	
	// ------------------------------------------------------ delete ---------------------------------------------------------------------------
	public void delete(String seqno) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			
			connection = dataSource.getConnection();
			String query = "delete from addressbook where seqno = ? ";
			ps = connection.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(seqno));
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
	// ------------------------------------------------------ search view ---------------------------------------------------------------------------
	public ArrayList<SDto> searchView(String query, String search) {
			
	
		// validity test
		if(query == null) {
			query="name";
			search= "";
		}
		
		ArrayList<SDto> dtos = new ArrayList<SDto>();
		SDto dto = new SDto();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			String statement = "select seqno, name, telno, address, email, relation from addressbook where " + query + " like '%" + search + "%'"; 
			ps = connection.prepareStatement(statement);			
			rs = ps.executeQuery(); // 예전에 했던 sql 커맨드 이걸로 끝!
			
			while(rs.next()) {
				int seqno = rs.getInt("seqno");
				String name = rs.getString("name");
				String telno = rs.getString("telno");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String relation = rs.getString("relation");
				
				dto = new SDto(seqno,name,telno,address,email,relation); // Dto 자바빈에 입력
				dtos.add(dto);
			}
		}catch (Exception e) { 
			e.printStackTrace();	
		}finally { // 걸리거나 안걸리거나 무조건 이쪽으로 들어옴 파이널리는 항상 똑같음 그냥 다 닫는 부분
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
	//-------------------------------------------------페이지 설정 ------------------------------------------------------------------------------
	public ArrayList<SDto> listPage(String curPage) {
			ArrayList<SDto> dtos = new ArrayList<SDto>();
			Connection connection = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			// DB seqno을 정리하고 5개를 한페이지 한다 그럼 나눠서 계산하는 sql statement 필요
			// 한번 SQL STATEMENT 쓸 때 마다 TRY CATCH문을 사용함
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
				String query = "UPDATE addressbook SET addressbook.seqno = @COUNT := @COUNT + 1";
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
	/////////////////// 총 Record 수 구하기
			int totalRecord = 0;
			
			try {
				connection = dataSource.getConnection();
				String query = "select count(*) from addressbook";
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				rs.next();
				totalRecord = rs.getInt(1);
				
			}catch (Exception e) { 
				e.printStackTrace();	
			}finally {
				try { 
					if(rs !=null) rs.close();
					if(ps != null) ps.close();
					if(connection != null) connection.close();
					
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			}
			
	/////////////////// 1page당 보일 record 수를 결정하고 총 page 수를 구한다
			int numPerPage = 5; // 1page에 보일 record 수
			int totalPage = 0; // 총 page 수를 저장할 변수
			
			if(totalRecord != 0) {
				if ((totalRecord % numPerPage) == 0) {
					totalPage = (totalRecord / numPerPage);
					SShare.totalPage = totalPage;
				} else {
					totalPage = (totalRecord / numPerPage) + 1;
					SShare.totalPage = totalPage;
				}
			}
	//////////////////// 첫번째 Record번호와 마지막 Record번호를 구한다.
			int curpage = (curPage == null) ? 1: Integer.parseInt(curPage); // 없으면 1이고 아니면 curPage를 바꿈
			
    ///////////////////	시작 Record 계산 
			int start = (curpage - 1) * numPerPage + 1;
			
	/////////////////// 마지막 Record 계산
			int end = start + numPerPage - 1;
			
	/////////////////// 해당 Page의 Record Set을 구성한다.

			try {
				connection = dataSource.getConnection();
				String query = "select seqno, name, telno, address, email, relation from addressbook where seqno between ? and ?";
				ps = connection.prepareStatement(query);
				ps.setInt(1, start);
				ps.setInt(2, end);
				
				rs = ps.executeQuery(); // 예전에 했던 sql 커맨드 이걸로 끝!
				
				while(rs.next()) {
					int sSeqno = rs.getInt("seqno");
					String sName = rs.getString("name");
					String sTelno = rs.getString("telno");
					String sAddress = rs.getString("address");
					String sEmail = rs.getString("email");
					String sRelation = rs.getString("relation");
					SDto dto = new SDto(sSeqno, sName, sTelno, sAddress, sEmail, sRelation); // Dto 자바빈에 입력
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
	
	
	
	
		
}
