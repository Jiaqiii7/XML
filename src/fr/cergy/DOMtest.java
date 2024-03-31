package fr.cergy;

import javax.xml.parsers.*; 
import org.w3c.dom.*; 
import org.xml.sax.*; 
import java.io.*; 

public class DOMtest {

	public static void main(String[] args) {
		System.out.print("Ficher XML: ");
		// String fichier = lireString();
		String fichier1 ="F:\\Eclipse\\Workplace\\XML\\src\\fr\\cergy\\musee.xml";
		Document dom = parseDom(fichier1);
		if(dom != null){
			Node racine = dom.getDocumentElement();
			
			// Calcul r¨¦sultat
			// !ADAPTER au type de r¨¦sultat et ¨¤ la liste de param¨¨tres
			int resultat = explorer(racine);

			// Affichage r¨¦sultat
			// !ADAPTER ¨¤ l'affichage souhait¨¦
			System.out.println("Le r¨¦sultat est " + resultat);
		}
	}
	
	private static String lireString(){
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
   	    try {
	    	return in.readLine();
	    } catch (IOException e){
	    	return null;
	    }
	}
	
	/**
	 * @param fichier
	 * @return
	 */
	private static Document parseDom(String fichier){
		try{
			  // cr¨¦ation d'une fabrique de parseurs
			  DocumentBuilderFactory fabrique = 
					DocumentBuilderFactory.newInstance();
			  //fabrique.setValidating(true); //si l¡¯on veut v¨¦rifier une DTD

			  // cr¨¦ation d'un parseur
			  DocumentBuilder parseur = fabrique.newDocumentBuilder();
			            
			  // transformation d'un fichier XML en DOM
			  File xml = new File(fichier);
			  Document document = parseur.parse(xml);
			  return document;
			  
			} catch(ParserConfigurationException pce){
			     System.out.println("Erreur de configuration du parseur DOM");
			} catch(SAXException se){
			     System.out.println("Erreur lors du parsing du document");
			} catch(IOException ioe){
			     System.out.println("Erreur d'entr¨¦e/sortie");
			}
        return null;
	}
	
	//!ADAPTER au type de r¨¦sultat et ¨¤ la liste de param¨¨tres
	private static int explorer(Node noeud){
		// initialisation
		// !ADAPTER
		int resultat = 0;

		// traitement noeud courant
		// !ADAPTER
		if (noeud.getNodeType() == Node.ELEMENT_NODE && noeud.getNodeName().equals("visiteur")){
			Element element = (Element) noeud;
			String date = element.getAttribute("date");
			if(date.equals("2021-10-03")) {
				int num=1;
				resultat = resultat + num;
			}
			//action pour les noeuds ¨¦l¨¦ment
		}
		
		// parcours r¨¦cursif
		if (noeud.hasChildNodes()){
			NodeList enfants = noeud.getChildNodes();
			for(int i=0; i<enfants.getLength(); i++){
				// appel r¨¦cursif
				// !ADAPTER
				int resenf = explorer(enfants.item(i));
			   
				// combiner resenf avec resultat
				// !ADAPTER
				resultat = resultat + resenf;
			}
		}
		return resultat;
	}
}