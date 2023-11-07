package ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCTest2 {
	public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String ID = "USER01";
	public static final String PW = "1234";
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1. SQL Plus 띄운다 - 메모리에 오라클 드라이버를 로딩
			Class.forName(DRIVER_NAME);
			// 2. 접속 - conn system/1234
			conn = DriverManager.getConnection(URL, ID, PW);
			// 3. SQL 문장 작성
			String sql = "SELECT USERNAME, SCORE FROM TBL_SCORE";
			// 4. 엔터칠 객체 얻어옴
			pstmt = conn.prepareStatement(sql);
			System.out.println("conn:" + conn);
			// 5. 엔터를 치게 한다
			rs = pstmt.executeQuery();
			// -> 6. 결과 도출
			while (rs.next() == true) {
				String username = rs.getString("USERNAME");
				int score = rs.getInt("SCORE");
				System.out.println(username + " | " + score);
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception e) { }
			if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}

	}

}