package cs.define;

public class Define
{
	public static final String addressWeb = "localhost";
	public static final Integer portWeb   = 8080;
	public static final String webRootUrl    = "http://" + addressWeb + ":" + portWeb.toString() + "/";
	
	//public static final String addressWebService = "93.10.90.51";
	public static final String addressWebService = "10.0.2.2";
	//public static final String addressWebService = "192.168.1.29";	
	public static final Integer portWebService   = 8080;
    public static final String webServiceRootUrl = "http://" + addressWebService + ":" + portWebService.toString() + "/";
}
