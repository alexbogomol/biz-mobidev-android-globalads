package biz.mobidev.android.globalads.model;

public class Account {

	private String mLogin;
	private String mPassword;
	private String mEmail;
	private String mCountry;
	private String mSex;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public Account(String login, 
				   String password, 
				   String email, 
				   String country, 
				   String sex) {
		
		super();
		mLogin = login;
		mPassword = password;
		mEmail = email;
		mCountry = country;
		mSex = sex;
	}

	public String getLogin() {
		return mLogin;
	}
	public void setLogin(String login) {
		mLogin = login;
	}
	public String getPassword() {
		return mPassword;
	}
	public void setPassword(String password) {
		mPassword = password;
	}
	public String getEmail() {
		return mEmail;
	}
	public void setEmail(String email) {
		mEmail = email;
	}
	public String getCountry() {
		return mCountry;
	}
	public void setCountry(String country) {
		mCountry = country;
	}
	public String getSex() {
		return mSex;
	}
	public void setSex(String sex) {
		mSex = sex;
	}
	
}