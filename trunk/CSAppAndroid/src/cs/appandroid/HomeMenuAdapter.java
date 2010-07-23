package cs.appandroid;

import android.R.color;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class HomeMenuAdapter extends BaseAdapter
{
	private Context mContext;
	
	public HomeMenuAdapter(Context c) {
		mContext = c;
	}
	
	@Override
	public int getCount() {
		return mThumbIds.length;
	}
	
	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ImageView imageView;
		TextView textView;
		
		// If it's not recycled, initialize some attributes
		if (convertView == null)
		{
//            imageView = new ImageView(mContext);
//            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setPadding(8, 8, 8, 8);
			
			textView = new TextView(mContext);
			textView.setLayoutParams(new GridView.LayoutParams(85, 85));
			textView.setGravity(Gravity.CENTER);
			textView.setText(menuItemIds[position]);
			textView.setTextColor(Color.BLACK);
			
			//textView.setOnClickListener(this);
			
//			textView.setOnClickListener(new View.OnClickListener()
//			{
//	         @Override
//	         public void onClick(View view)
//	         {
//	          Log.d("onClick","position ["+position+"]");
//	          
//	          switch(position)
//	          {
//	           case 1: 
//	        	       break;
//	           default: break;
//	          }
//	         }
//	        });

        }
		else
		{
			//imageView = (ImageView) convertView;
			textView = (TextView)convertView;
		}
		
		//imageView.setImageResource(mThumbIds[position]);		
		
		/**
		 * To change background ressource alpha
		 */
		/*
		AlphaAnimation anim = new AlphaAnimation(1, 0.2f);
		anim.setFillAfter(true);
		textView.setAnimation(anim);
		*/
		textView.setBackgroundResource(mThumbIds[position]);
		
		//return imageView;
        return textView;
	}
	
	
	
    // References to menu images
    private Integer[] mThumbIds = {
    	R.drawable.icon_search_offer, R.drawable.icon_add_offer,
        R.drawable.icon_list_my_offers, R.drawable.icon_my_messages
    };
    
    // Reference to menu items text
    private Integer[] menuItemIds = {
    	R.string.offer_search, R.string.add_offer,
    	R.string.my_offers, R.string.my_messages
    };
}
