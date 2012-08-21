package biz.mobidev.android.globalads.activities;

import biz.mobidev.android.globalads.GlobalAdsApp;
import biz.mobidev.android.globalads.R;
import biz.mobidev.android.globalads.model.AccountRegisterCandidate;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class SignUpActivity extends Activity {
	
	private EditText mTxtLogin;
	private EditText mTxtEmail;
	private EditText mTxtPassword;
	private EditText mTxtConfirmPassword;
	private Spinner mSpnCountry;
	private Spinner mSpnSex;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        
        initializeViews();
    }

    private void initializeViews() {
    	
		mTxtLogin = (EditText)findViewById(R.id.activity_signup_edit_login);
		mTxtEmail = (EditText)findViewById(R.id.activity_signup_edit_email);
		mTxtPassword = (EditText)findViewById(R.id.activity_signup_edit_password);
		mTxtConfirmPassword = (EditText)findViewById(R.id.activity_signup_edit_confirmpass);
		mSpnCountry = (Spinner)findViewById(R.id.activity_signup_spin_country);
		mSpnSex = (Spinner)findViewById(R.id.activity_signup_spin_sex);
		
		// setup country spinner
		ArrayAdapter<CharSequence> adapterCountry = ArrayAdapter.createFromResource(this, R.array.enum_countries, 
																			 android.R.layout.simple_spinner_item);
		adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mSpnCountry.setAdapter(adapterCountry);
		
		// setup sex spinner
		ArrayAdapter<CharSequence> adapterSex = ArrayAdapter.createFromResource(this, R.array.enum_sex, 
																			 android.R.layout.simple_spinner_item);
		adapterSex.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mSpnSex.setAdapter(adapterSex);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_signup, menu);
        return true;
    }
    
    public void onButtonAcceptClick(View view) {
    	
    	if (isSignUpSucceed()) {
	    	setResult(Activity.RESULT_OK, getIntent());
	    	finish();
    	} else {
    		showUserDialog("Sign up error", "Please, check if you entered correct data");
    	}
    }

	private void showUserDialog(String title, String message) {
		
		AlertDialog.Builder db = new AlertDialog.Builder(this);
		db.setTitle(title);
		db.setMessage(message);
		AlertDialog ad = db.create();
		ad.show();
	}

	private boolean isSignUpSucceed() {
		
		String login = mTxtLogin.getText().toString();
		String email = mTxtEmail.getText().toString();
		String password = mTxtPassword.getText().toString();
		String confirm = mTxtConfirmPassword.getText().toString();
		String country = mSpnCountry.getSelectedItem().toString();
		String sex = mSpnSex.getSelectedItem().toString();
		
		AccountRegisterCandidate toRegister = new AccountRegisterCandidate(login, password, confirm, email, country, sex);		
		return GlobalAdsApp.getInstance()
						   .getAccountHandler()
						   .registerUser(toRegister);
		
		
	}
}