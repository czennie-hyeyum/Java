package guessnum2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class ScoreDao {
	private static ScoreDao instance = new ScoreDao();
	private ScoreDao() { }
	public static ScoreDao getInstance() {
		return instance;
	}
	
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "USER01";
	private static final String PW = "1234";
	private static final int MIN_SCORE = 30000;
	
	private Connection getConnection() {
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, ID, PW);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) try { rs.close(); } catch (Exception e) { }
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
		if (conn != null) try { conn.close(); } catch (Exception e) { }
	}
	
	public boolean addScore(ScoreVo scoreVo) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    try {
	        conn = getConnection();
	        StringBuffer sb = new StringBuffer();
	        sb.append("INSERT INTO TBL_SCORE "
	                + "    (SCORE_ID, USER_ID, SCORE, REGDATE)");
	        sb.append(" VALUES "
	                + "    (SEQ_SCORE_ID.NEXTVAL, ?, ?, SYSDATE)");
	        pstmt = conn.prepareStatement(sb.toString());
	        pstmt.setString(1, scoreVo.getUserId());
	        pstmt.setInt(2, scoreVo.getScore());
	        int count = pstmt.executeUpdate();
	        if (count > 0) {
	            return true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // 예외 출력을 추가
	    } finally {
	        closeAll(null, pstmt, conn);
	    }
	    return false;
	}
	
	public int getMinScore() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "SELECT COALESCE(MIN(SCORE), ?) AS MIN_SCORE FROM TBL_SCORE";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, MIN_SCORE);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int minScore = rs.getInt("MIN_SCORE");
				return minScore;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return MIN_SCORE;
	}
	
	// 읽기
	public Vector<ScoreUserVo> getAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "SELECT U.USER_ID, U.USER_NAME, S.SCORE, S.REGDATE, G.GRADE"
					+ "   FROM TBL_USER U, TBL_SCORE S, TBL_SCORE_GRADE G"
					+ "   WHERE U.USER_ID = S.USER_ID"
					+ "   AND S.SCORE BETWEEN G.LO_SCORE AND G.HI_SCORE"
					+ "   ORDER BY S.SCORE ASC, U.USER_ID ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Vector<ScoreUserVo> vec = new Vector<>();
			while (rs.next()) {
				String userId = rs.getString("USER_ID");
				String userName = rs.getString("USER_NAME");
				int score = rs.getInt("SCORE");
				Date regdate = rs.getDate("REGDATE");
				String grade = rs.getString("GRADE");
				ScoreUserVo scoreUserVo = new ScoreUserVo(userId, userName, score, regdate, grade);		
				vec.add(scoreUserVo);
			}
			return vec;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return null;
	}

} // class	