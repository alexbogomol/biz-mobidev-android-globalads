package biz.mobidev.android.globalads.activities;

import biz.mobidev.android.globalads.GlobalAdsApp;
import biz.mobidev.android.globalads.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends Activity {
	
	private EditText mTxtLogin;
	private EditText mTxtPassword;
	private CheckBox mCkbShowPassword;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    	
    	initializeViews();
    }

	private void initializeViews() {
		mTxtLogin = (EditText)findViewById(R.id.activity_login_edit_login);
    	mTxtPassword = (EditText)findViewById(R.id.activity_login_edit_password);
    	mCkbShowPassword = (CheckBox)findViewById(R.id.activity_login_check_showpassword);
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_login, menu);
        return true;
    }
    
	@Override
	protected void onActivityResult(int requestCode, 
									int resultCode, 
									Intent data) {
		
		switch (resultCode) {
			case Activity.RESULT_OK: {
		    	Intent intent = new Intent(this, ActionsListActivity.class);
		    	startActivity(intent);
		    	finish();
				break;
			}
			case Activity.RESULT_CANCELED: {
				break;
			}
			default:
				break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
    
    public void onButtonLoginClick(View view) {
    	
    	if (isLoginSucceed()) {
	    	Intent intent = new Intent(this, ActionsListActivity.class);
	    	startActivity(intent);
	    	finish();
    	} else {
    		showUserDialog("Login error", "Please, check if you entered correct login and password");
    	}
	}
    
    private void showUserDialog(String title, String message) {
		
		AlertDialog.Builder db = new AlertDialog.Builder(this);
		db.setTitle(title);
		db.setMessage(message);
		AlertDialog ad = db.create();
		ad.show();
	}

	private boolean isLoginSucceed() {
    	
    	String login = mTxtLogin.getText().toString();
    	String pass = mTxtPassword.getText().toString();
    	
    	return GlobalAdsApp.getInstance()
    					   .getAccountHandler()
    					   .loginUser(login, pass);
	}

	public void onButtonSignUpClick(View view) {
    	Intent intent = new Intent(this, SignUpActivity.class);
    	startActivityForResult(intent, 1);
	}
    
    public void onShowPassCheckBoxClick(View view) {
    	
    	if (mCkbShowPassword.isChecked())
    		mTxtPassword.setTransformationMethod(null);
    	else
    		mTxtPassword.setTransformationMethod(new PasswordTransformationMethod());
    }
}