package biz.mobidev.android.globalads;

import java.util.ArrayList;
import java.util.List;

import biz.mobidev.android.globalads.model.Account;
import biz.mobidev.android.globalads.model.AccountHandler;
import biz.mobidev.android.globalads.model.AdsAction;
import android.app.Application;

public class GlobalAdsApp extends Application {
	
	private static GlobalAdsApp instance;
	private List<Account> mAccounts;
	private List<AdsAction> mActionsList;
	private Account mCurrentUser;
	private AccountHandler mAccountHandler;
	
	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		
		createUsersCollection();
		createActionsCollection();
		
		mAccountHandler = new AccountHandler(mAccounts);
		mCurrentUser = null;
	}

	private void createActionsCollection() {
		
		mActionsList = new ArrayList<AdsAction>();
		
		int itemsNumber = 99;
		
		for (int i = 0; i < itemsNumber; i++) {
			AdsAction newItem = new AdsAction();
			newItem.setPicture(attachPictureToListPosition(i));
			newItem.setOffer("<Offer text>");
			newItem.setCompany("<Company name>");
			newItem.setStarts("From: <Start date>");
			newItem.setEnds("To: <End date>");
			newItem.setRating(itemsNumber - i);
			newItem.setType("<Type>");
			newItem.setTypeView(i % 2);
			mActionsList.add(newItem);
		}
	}

	private int attachPictureToListPosition(int position) {
		
		int picPes = R.drawable.adspic1;
		switch (position % 3) {
			case 1: picPes = R.drawable.adspic2; break;
			case 2: picPes = R.drawable.adspic3; break;
			default: break;
		}
		return picPes;
	}

	private void createUsersCollection() {
		
		mAccounts = new ArrayList<Account>();
		
		Account account1 = new Account("sash", "sash", "sash@mail.com", "Ukraine", "male");
		mAccounts.add(account1);
		Account account2 = new Account("den", "den", "den@mail.com", "Ukraine", "male");
		mAccounts.add(account2);
		Account account3 = new Account("kell", "kell", "kell@mail.com", "Ukraine", "female");
		mAccounts.add(account3);
	}
	
	public static GlobalAdsApp getInstance() {
		return instance;
	}

	public List<AdsAction> getActionsList() {
		return mActionsList;
	}
	
	public AccountHandler getAccountHandler() {
		return mAccountHandler;
	}

	public void setCurrentUser(Account user) {
		mCurrentUser = user;
	}
}