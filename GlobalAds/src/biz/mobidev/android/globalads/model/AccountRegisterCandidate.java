/**
 * 
 */
package biz.mobidev.android.globalads.model;

/**
 * This class is used only for registrations purposes.
 * It has only one additional field for password confirmation.
 *
 */
public class AccountRegisterCandidate extends Account {
	
	private String mConfirmPassword;

	public AccountRegisterCandidate() {
		// TODO Auto-generated constructor stub
	}
	
	public AccountRegisterCandidate(String login, 
									String password,
									String confirm,
									String email,
									String country, 
									String sex) {
		super(login, password, email, country, sex);
		mConfirmPassword = confirm;
	}

	public String getConfirmPassword() {
		return mConfirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		mConfirmPassword = confirmPassword;
	}

}
