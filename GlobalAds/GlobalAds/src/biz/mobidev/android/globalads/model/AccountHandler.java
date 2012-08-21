package biz.mobidev.android.globalads.model;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import biz.mobidev.android.globalads.GlobalAdsApp;

public class AccountHandler {

	private List<Account> mAccounts;

	public AccountHandler(List<Account> accounts) {
		mAccounts = accounts;
	}
	
	public boolean loginUser(String login,
							 String pass) {
		
		boolean result = false;
		
		for (Account user : mAccounts) {
			if (user.getLogin().equals(login)) {
				if (user.getPassword().equals(pass)) {
					result = true;
					GlobalAdsApp.getInstance().setCurrentUser(user);
				}
			}
		}
		
		return result;
	}
	
	public boolean registerUser(AccountRegisterCandidate candidate) {
		
		boolean result = false;
		
		if (isRegisterRulesSucceed(candidate)) {
			Account newby = new Account(candidate.getLogin(), 
										candidate.getPassword(), 
										candidate.getEmail(), 
										candidate.getCountry(), 
										candidate.getSex());
			mAccounts.add(newby);
			result = true;
		}
		
		return result;
	}
	
	private boolean isRegisterRulesSucceed(AccountRegisterCandidate candidate) {
		
		return  isEqualConfirmAndPass(candidate.getConfirmPassword(), candidate.getPassword())
				&& isCorrectLoginAndPassLength(candidate.getLogin(), candidate.getPassword())
				&& isCorrectSymbolPattern(candidate.getLogin())
				&& isCorrectSymbolPattern(candidate.getPassword())
				&& isCorrectEmailPattern(candidate.getEmail());
	}

	private boolean isCorrectEmailPattern(String email) {
		
		return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
	}

	private boolean isCorrectSymbolPattern(String stringToCheck) {
		
	    Pattern pattern;
	    Matcher matcher;
	    String SYMBOL_PATTERN = "[A-Za-z0-9]+";
	    pattern = Pattern.compile(SYMBOL_PATTERN);
	    matcher = pattern.matcher(stringToCheck);
	    return matcher.matches();
	}

	private boolean isCorrectLoginAndPassLength(String login, String password) {
		
		int loginLength = login.length();
		int passLength = password.length();
		
		return  (loginLength >= 3 && loginLength <= 10)
				&& (passLength >= 3 && passLength <= 10);
	}

	private boolean isEqualConfirmAndPass(String confirm, String password) {
		return confirm.equals(password);
	}

	public boolean getLoginStatus(Account account) {
		return true;
	}
	
	public void logoutUser() {
		
		GlobalAdsApp.getInstance().setCurrentUser(null);
	}
}