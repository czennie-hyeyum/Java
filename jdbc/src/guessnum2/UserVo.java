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
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		if (userId != null && userId.length() <= 20) {
			this.userId = userId;
		}
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
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

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	 public String toString() {
        return "UserVo [userId=" + userId + ", userPw=" + userPw + 
                ", userName=" + userName + ", userEmail=" + userEmail + "]";
    }
	
	public UserVo(String userId, String userPw, String userName, String userEmail) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userEmail = userEmail;
	}
	
	
}