package biz.mobidev.android.globalads.activities;

import java.util.ArrayList;
import java.util.List;

import biz.mobidev.android.globalads.GlobalAdsApp;
import biz.mobidev.android.globalads.R;
import biz.mobidev.android.globalads.adapters.ActionsListAdapter;
import biz.mobidev.android.globalads.model.AdsAction;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

public class ActionsListActivity extends Activity {
	
	private ListView listView;
	private List<AdsAction> actionsList;
	private ActionsListAdapter actListAdapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        initGUI();
    }

	private void initGUI() {
		
		// Inflate our view
    	setContentView(R.layout.activity_actions_list);
    	
    	// Get references to UI widgets
    	listView = (ListView)findViewById(R.id.activity_actions_list_actions_list);
    	
    	// Create instances to show
    	actionsList = GlobalAdsApp.getInstance().getActionsList();
    	
    	// Perform binding
    	actListAdapter = new ActionsListAdapter(this,  actionsList);
    	listView.setAdapter(actListAdapter);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_actions_list, menu);
        return true;
    }
	
	public void onButtonAccountClick(View view) {
		
		// logout current user
		GlobalAdsApp.getInstance().getAccountHandler().logoutUser();
		
		// open Login Screen
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
		finish();
	}
}