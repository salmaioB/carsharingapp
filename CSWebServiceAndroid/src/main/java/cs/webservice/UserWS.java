//package cs.webservice;
//
//
//// Api android.jar
//import javax.microedition.midlet.MIDlet;
//import javax.microedition.lcdui.Display;
//import javax.microedition.lcdui.Form;
//import javax.microedition.midlet.MIDletStateChangeException;
//
//// Api ksoap2
//import org.ksoap2.serialization.SoapObject;
//import org.ksoap2.serialization.SoapSerializationEnvelope;
//import org.ksoap2.transport.HttpTransport;
///**
// * Classe de test de la connexion SOAP en J2ME
// * les methodes printStackTrace n'ont une utilité 
// * que lors de la phase de test avec KToolBar
// * et sont a eviter de meme que les System.out.println() 
// * pour une raison d'optimisation.
// * Dans une application plus consistante, il est judicieux 
// * d'utiliser un Thread pour la partie Connexion
// * L'utilisation du StringBuffer est plus longue
// * à écrire que de simples concaténations de String
// * mais vous évitera des erreurs d'execution du code sur certains telephones
// * @author Jean-Pierre Clair
// * @version 1.0
// */
//public class UserWs extends MIDlet 
//{
//	private Form monFormulaire;
//	private Display affichage;
//	private StringBuffer tamponEcriture;
//
//	public UtilisationKSOAP2() 
//	{
//		super();
//	}
//
//	protected void destroyApp(boolean arg0) throws MIDletStateChangeException 
//	{
//		this.notifyDestroyed();
//	}
//
//	protected void pauseApp() 
//	{
//		//
//	}
//
//	protected void startApp() throws MIDletStateChangeException 
//	{
//		// gestion de l'affichage
//		this.affichage		= Display.getDisplay(this);
//		this.monFormulaire	= new Form("KSOAP2 exemple");
//		
//		// StringBuffer pour debug
//		this.tamponEcriture	= new StringBuffer("Journal des évènements\n");	
//		this.executerRequeteSOAP();
//	}
//
//	public void afficherResultat() 
//	{
//		this.monFormulaire	.append ( this.tamponEcriture.toString() );
//		this.affichage		.setCurrent(this.monFormulaire);
//	}
//	
//	private void executerRequeteSOAP ()
//	{
//		// partie de la création des objets HTTPTransport et SOAPObject
//		Object resultatRequeteSOAP = null;
//		SoapObject objetSOAPHello;
//		HttpTransport connexionServeur;
//		SoapSerializationEnvelope envelope ;
//		
//		// nom du service
//		String nomService		= "urn:HelloYou";
//		
//		// url du service
//		String urlService= "http://www.minimonde.org/soap/HelloYou.Server.php5";
//		
//		// méthode du service
//		String methodeChoisie 		= "getHello";
//
//		try
//		{
//			this.tamponEcriture .append("création HTTPTransport\n");	
//			
//			// etape 1 création module de connexion HTTP
//			connexionServeur = new HttpTransport	( urlService ); 
//			
//			//TODO a modifier lors de la mise en production
//			connexionServeur.debug = true;
//			
//			//	 etape 1 ok 
//			this.tamponEcriture .append("creation HTTPTransport effective\n");	
//			
//			// création objet SOAP 
//			objetSOAPHello = new SoapObject	(nomService, methodeChoisie );
//			
//			// ajout des propriétés pour cette méthode
//			objetSOAPHello	.addProperty ("prenom","Paul");
//			objetSOAPHello	.addProperty ("nom", "Hochon");
//	
//			
//			// création d'un objet qui contiendra nos propriétés
//			envelope = new SoapSerializationEnvelope(SoapSerializationEnvelope.VER11);
//			envelope.bodyOut = objetSOAPHello;
//			
//			// argument utile dans le cas d'un service SOAP .net
//			//envelope.dotNet = true;
//			
//			//	 création de l'objet SOAP ok 
//			this.tamponEcriture .append(" SOAPobjet effective\n");	
//			
//		}
//		catch (Exception aE)
//		{
//			this.tamponEcriture .append("Exception levée dans SOAPObject\n");
//			this.afficherResultat(); 	
//			aE.printStackTrace ();
//			return;
//		}
//		
//		// connexion au serveur
//		try 
//		{
//			// invoquation de la méthode sur le serveur
//			connexionServeur.call(null, envelope);
//			
//			// recuperation de la réponse du serveur
//			resultatRequeteSOAP =  envelope.getResponse();
//
//			// affichage de la réponse
//			this.tamponEcriture .append("resultat de la requête\n");	
//			
//			this.tamponEcriture .append(resultatRequeteSOAP);	
//			this.afficherResultat(); 
//		} 
//		catch (Exception aE) 
//		{
//			this.tamponEcriture .append("exception déclenchée sur méthode call\n");	
//			this.afficherResultat(); 
//			aE.printStackTrace();
//		} 
//	}
//}