package cs.appandroid.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;


public class MyCustomGridView extends GridView implements OnItemClickListener{

  private Listener mListener;



  public MyCustomGridView(Context context, AttributeSet attrs) {

    super(context, attrs);

    setOnItemClickListener(this);

  }



  public void onItemClick(AdapterView parent, View v, int position, long id) {

    if (mListener != null) {

      mListener.onClick(position);

    }

  }



  public void setListener(Listener l){

    mListener = l;

  }



  public interface Listener{

    void onClick(int position); 

  }   

}