/**
 * 
 */
package biz.mobidev.android.globalads.model;

/**
 * @author alexander.bogomol
 *
 */
public class AdsAction {
	
	private int mPicture;
	private String mOffer;
	private String mCompany;
	private String mStarts;
	private String mEnds;
	private double mRating;
	private String mType;
	private int mTypeView;
	
	public int getTypeView() {
		return mTypeView;
	}

	public void setTypeView(int typeView) {
		mTypeView = typeView;
	}

	public AdsAction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getPicture() {
		return mPicture;
	}
	public void setPicture(int picture) {
		mPicture = picture;
	}
	public String getOffer() {
		return mOffer;
	}
	public void setOffer(String offer) {
		mOffer = offer;
	}
	public String getCompany() {
		return mCompany;
	}
	public void setCompany(String company) {
		mCompany = company;
	}
	public String getStarts() {
		return mStarts;
	}
	public void setStarts(String starts) {
		mStarts = starts;
	}
	public String getEnds() {
		return mEnds;
	}
	public void setEnds(String ends) {
		mEnds = ends;
	}
	public double getRating() {
		return mRating;
	}
	public void setRating(double d) {
		mRating = d;
	}
	public String getType() {
		return mType;
	}
	public void setType(String type) {
		mType = type;
	}
	
	@Override
	public String toString() {
		return getOffer();
	}
}