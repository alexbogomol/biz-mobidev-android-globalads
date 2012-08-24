package biz.mobidev.android.globalads.adapters.holders;

import biz.mobidev.android.globalads.R;
import biz.mobidev.android.globalads.model.AdsAction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ActionDetailsHolder {

	ImageView mPicture;
	TextView mOfferView;
	TextView mCompanyView;
	TextView mStartsView;
	TextView mEndsView;
	TextView mRatingView;
	TextView mTypeView;
	View mAdsView;
	
	public void createHolder(View adsView){
		mAdsView = adsView;
		mPicture = (ImageView)adsView.findViewById(R.id.item_actions_list_image);
		mOfferView = (TextView)adsView.findViewById(R.id.item_actions_list_text_offer);
		mCompanyView = (TextView)adsView.findViewById(R.id.item_actions_list_text_company);  
		mStartsView = (TextView)adsView.findViewById(R.id.item_actions_list_text_datestarts);
		mEndsView = (TextView) adsView.findViewById(R.id.item_actions_list_text_dateends);
		mRatingView = (TextView)adsView.findViewById(R.id.item_actions_list_text_rating);
		mTypeView = (TextView)adsView.findViewById(R.id.item_actions_list_text_type);
	}
	public void setData(AdsAction item) {
		
		mPicture.setImageResource(item.getPicture());
		mOfferView.setText(item.getOffer());
		mCompanyView.setText(item.getCompany());
		mStartsView.setText(item.getStarts());
		mEndsView.setText(item.getEnds());
		mRatingView.setText(String.format("%.1f", item.getRating()));
		mTypeView.setText(item.getType());

	}
}