package cs.appandroid;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

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
	public Object getItem(int arg0) {
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
        
		// If it's not recycled, initialize some attributes
		if (convertView == null)
		{
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
		else imageView = (ImageView) convertView;
		
		imageView.setImageResource(mThumbIds[position]);
        return imageView;
	}
	
    // References to menu images
    private Integer[] mThumbIds = {
            R.drawable.icon_rechercher
    };
}
