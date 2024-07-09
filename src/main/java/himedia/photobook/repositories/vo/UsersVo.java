package himedia.photobook.repositories.vo;

// 작성자: 유승원
public class UsersVo {
	private Long userId;
	private String email;
	private String password;
	private String userName;
	private String address;
	private String phoneNumber;
	private String role;  /*  -- 사용자 : U / 관리자 : A   */
	
	public UsersVo() {
		
	}

	public UsersVo(Long userId, String email, String password, String userName, String address, String phoneNumber,
			String role) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.role = role;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UsersVo [userId=" + userId + ", email=" + email + ", password=" + password + ", userName=" + userName
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", role=" + role + "]";
	}
	
	
	
	
}
