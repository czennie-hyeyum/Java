package sql_exam;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDao extends BasicAbstractDao {
	private static StudentDao instance = new StudentDao();
	private StudentDao() {
		/* singleton */
	}
	
	public static StudentDao getInstance() {
		return instance;
	}
	// -------------------------------------------------------
	
	public boolean addStudent(StudentVo studentVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "INSERT INTO TBL_STUDENT (SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE) VALUES (?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studentVo.getSno());
            pstmt.setString(2, studentVo.getSname());
            pstmt.setInt(3, studentVo.getSyear());
            pstmt.setString(4, studentVo.getGender());
            pstmt.setInt(5, studentVo.getMajor());
            pstmt.setInt(6, studentVo.getScore());
            int count = pstmt.executeUpdate();
            if (count > 0) {
            	return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(null, pstmt, conn);
        }
        return false;
	}
	
}
