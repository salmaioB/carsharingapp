package cs.appandroid;

import java.util.List;

import cs.dao.dao.OfferDAO;
import cs.model.Offer;
import android.app.Activity;
import android.os.Bundle;

public class DisplayOffers extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.displayoffers);
	    
	    //Bundle bun = getIntent().getExtras();
	    //String test = bun.getString("az");
	    
	    OfferDAO offerDAO = new OfferDAO();
	    //List<Offer> offers = offerDAO.loadSearchOffers("toto", "orleans", "tata", "paris");
	    
	    offerDAO.loadSearchOffers("toto", "orleans", "tata", "paris");
	}
}
