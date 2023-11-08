package ver15;

public class PhoneBookDao {
	// 싱글톤
	private static PhoneBookDao instance = new PhoneBookDao();
	private PhoneBookDao() { }
	public static PhoneBookDao getInstance() {
		return instance;
	}
	
	// 접속 정보
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver"; // 데이터 베이스마다 사용하는 드라이버가 다름
	private static final String URL = "jdbc:oracle:thin:@컴퓨터위치:포트번호:SID";
	private static final String ID = "";
	private static final String PW = "";
	
	// 접속 메서드
	// 닫기 메서드
	// 입력 기능
	// 수정 기능
	// 삭제 기능
	// 전체 조회 기능
	// 검색 기능
	


}
