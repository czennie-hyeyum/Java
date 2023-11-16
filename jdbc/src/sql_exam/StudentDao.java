package sql_exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class StudentDao extends BasicAbstractDao {
	private static StudentDao instance = new StudentDao();
	public StudentDao() {	}	
	
	public static StudentDao getInstance() {
		return instance;
	}
	
	// 입력
	public boolean addStudent(StudentVo studentVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO TBL_STUDENT (SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE) VALUES (?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, studentVo.getSno());
			pstmt.setString(2, studentVo.getSname());
			pstmt.setInt(3, studentVo.getSyear());
			pstmt.setString(4, studentVo.getGender());
			pstmt.setInt(5, studentVo.getMajor());
			pstmt.setInt(6, studentVo.getScore());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
		return false;
		
	}
	
	// 수정
	public boolean modify(StudentVo studentVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = this.getConnection();
			String sql = "UPDATE TBL_STUDENT SET SNAME=?, SYEAR=?, GENDER=?, MAJOR=?, SCORE=? WHERE SNO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, studentVo.getSno());
			pstmt.setString(2, studentVo.getSname());
			pstmt.setInt(3, studentVo.getSyear());
			pstmt.setString(4, studentVo.getGender());
			pstmt.setInt(5, studentVo.getMajor());
			pstmt.setInt(6, studentVo.getScore());
			pstmt.setString(7, studentVo.getSno());
			int count = pstmt.executeUpdate();
			return count > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
		return false;
		
	}
	
	// 삭제
	public boolean delete(StudentVo studentVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
		return false;
	}
	
	// 조회
	public Vector<StudentVo> getInfo() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = this.getConnection();
			String sql = "SELECT SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE FROM TBL_STUDENT";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Vector<StudentVo> vec = new Vector<>();
			while (rs.next()) {
				String sno = rs.getString("SNO");
				String sname = rs.getString("SNAME");
				Integer syear = rs.getInt("SYEAR");
				String gender = rs.getString("GENDER");
				Integer major = rs.getInt("MAJOR");
				Integer score = rs.getInt("SCORE");
				StudentVo studentvo = null;
				studentvo = new StudentVo(sno, sname, syear, gender, major, score);
				vec.add(studentvo);
			} 
			return vec;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return null;
		
	}

}
