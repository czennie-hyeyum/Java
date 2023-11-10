package guessnum2;

public class UserVo {
	private String userId;
	private String userPw;
	private String userCheckPw;
	private String userName;
	private String userEmail;
	
	public UserVo() {
		super();
	}
	
	public UserVo(String userId, String userPw, String userCheckPw, String userName, String userEmail) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userCheckPw = userCheckPw;
		this.userPw = userPw;
		this.userName = userName;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String tfReaisterId) {
		this.userId = tfReaisterId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String tfReaisterPw) {
		this.userPw = tfReaisterPw;
	}

	public String getUserCheckPw() {
		return userCheckPw;
	}

	public void setUserCheckPw(String userCheckPw) {
		this.userCheckPw = userCheckPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String tfReaisterName) {
		this.userName = tfReaisterName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String tfReaisterEmail) {
		this.userEmail = tfReaisterEmail;
	}

	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", userPw=" + userPw + ", userCheckPw=" + userCheckPw + ", userName="
				+ userName + ", userEmail=" + userEmail + "]";
	}
	
}
