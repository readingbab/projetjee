package sdzee.com.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import sdzee.com.bdd.Database;
import sdzee.com.beans.Client;

public class loginForm {
	    private static final String CHAMP_EMAIL  = "email";
	    private static final String CHAMP_PASS   = "motdepasse";
	    private Map<String, String> erreurs      = new HashMap<String, String>();
	    public Map<String, String> getErreurs() {
	        return erreurs;
	    }
	    public int loginClient( HttpServletRequest request ) {
	    	int statut=0;
	        String mdp = getValeurChamp( request,"mdp");
	        String mdpc = getValeurChamp( request,"mdpc");
	        if(!mdp.isEmpty() && !mdpc.isEmpty() && !request.getParameter("cin").isEmpty() && !request.getParameter("nom").isEmpty() && !request.getParameter("add").isEmpty() && !request.getParameter("prenom").isEmpty() && !request.getParameter("phone").isEmpty() ) {
	        
	        if(mdp.equals(mdpc)) {
	        	Database d=new Database();
	        	 statut=d.Inscription(request);
	        	
	        }
	        else {
	        	setErreur("mdp","les mots de passe ne sont pas identiques");
	        }
	        }
	        else {
	        	setErreur("vide","il faut completer tous les champs");
	        }
	        return statut;
	    }

	    private void setErreur( String champ, String message ) {
	        erreurs.put( champ, message );
	    }
	    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
	        String valeur = request.getParameter( nomChamp );
	        if ( valeur == null || valeur.trim().length() == 0 ) {
	            return null;
	        } else {
	            return valeur.trim();
	        }
	    }
	    
}
