/**
 * 
 */
package biz.mobidev.android.globalads.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import biz.mobidev.android.globalads.R;
import biz.mobidev.android.globalads.adapters.holders.ActionDetailsHolder;
import biz.mobidev.android.globalads.model.AdsAction;

/**
 * @author master
 * 
 */
public class ActionsListAdapter extends BaseAdapter {

	private List<AdsAction> mItems;
	private LayoutInflater mInflater;

	public ActionsListAdapter(Context context, List<AdsAction> items) {

		mInflater = LayoutInflater.from(context);
		mItems = items;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		// Retrieve values to display from the instance
		AdsAction actionItem = mItems.get(position);
		ActionDetailsHolder holder = null;

		// Inflate a new view if this is not an update
		if (convertView == null) {
			if(getItemViewType(position)==1){
			convertView = mInflater.inflate(R.layout.item_actions_list, null);
			}else{
				convertView = mInflater.inflate(R.layout.item_actions_list2, null);
			}
			holder = getNewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ActionDetailsHolder) convertView.getTag();
		}

		// define background style
//		if (position % 2 == 1)
//			convertView.setBackgroundResource(R.drawable.item_actions_list_background_odd);
//		else
//			convertView.setBackgroundResource(R.drawable.item_actions_list_background_even);

		// set data and return a view
		holder.setData(actionItem);
		return convertView;
	}

	private ActionDetailsHolder getNewHolder(View view) {
		ActionDetailsHolder holder = new ActionDetailsHolder();
		holder.createHolder(view);
		return holder;
	}

	@Override
	public int getCount() {
		return mItems.size();
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 2;
	}
	
@Override
public int getItemViewType(int position) {
	// TODO Auto-generated method stub
	return position % 2;
}
	@Override
	public Object getItem(int position) {
		return mItems.get(position);
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}
}
