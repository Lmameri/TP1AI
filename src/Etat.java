/* INF4230 - Intelligence artificielle
 * UQAM / D�partement d'informatique
 * Hiver 2017
 */

import java.util.Collection;
import java.util.LinkedList;


/**
 * Repr�sente un �tat dans le monde.
 */
public class Etat implements Comparable<Etat> 
{


    // R�f�rence sur le planete (pour acc�der aux objets du planete).
    protected   Planete           planete;

    
    // Noyau de la repr�sentation d'un �tat. Ici, on met tout ce qui rend l'�tat unique.
    /** Emplacement du Htepien. */
    protected Emplacement     emplacementHtepien;
    /** Array indicant l'emplacement de chaque bombes (il y'en a qu'une seule dans ce TP). */
    protected Emplacement     emplacementsBombes[];
    /** Array indicant l'�tat de chargement de chaque bombes pat le Htepien. */
    protected boolean         bombesCharges[];
    /** Nombre de bombes que porte le Htepien. */
    protected int             nbbombesCharges = 0;

    
    // Variables pour l'algorithme A*.
    /** �tat pr�c�dent permettant d'atteindre cet �tat. */
    protected Etat            parent;
    /** Action � partir de parent permettant d'atteindre cet �tat. */
    protected String          actionFromParent;
    /** f=g+h. */
    protected double          f;
    /** Meilleur co�t trouv� pour atteindre cet �t� � partir de l'�tat initial. */    
    protected double          g;
    /** Estimation du co�t restant pour atteindre le but. */
    protected double          h;

    
    public Etat(Planete planete){
        this.planete = planete;
    }

    /** Fonction retournant les �tats successeurs � partir de cet �t�.
     *  Aussi appel� fonction de transition.
     *  Cela permet d'explorer l'espace d'�tat (le graphe de recherche).
     */
    public Collection<Successeur> genererSuccesseurs()
    {
        LinkedList<Successeur> successeurs = new LinkedList<Successeur>();
        
        int xH= (int) this.emplacementHtepien.positionGeographique.getX();
        int yH= (int) this.emplacementHtepien.positionGeographique.getY();
        
        
        if((this.planete.navigationTable[(xH-1)][yH])!=null){
        	Successeur successeurHaut = new Successeur();
        	successeurHaut.etat = this.clone();
        	successeurHaut.action = "NORD";
        	String type = this.planete.navigationTable[(xH-1)][yH].type;
        	successeurHaut.cout =returnCost(type) ;
            successeurHaut.etat.actionFromParent = "NORD";
            successeurHaut.etat.emplacementHtepien = this.planete.navigationTable[(xH-1)][yH];
            successeurs.add(successeurHaut);
           
        }

        if((this.planete.navigationTable[(xH+1)][yH])!=null){
        	Successeur successeurBas = new Successeur();
        	successeurBas.etat = this.clone();
        	successeurBas.action = "SUD";
        	String type = this.planete.navigationTable[(xH+1)][yH].type;
        	successeurBas.cout =returnCost(type) ;
            successeurBas.etat.actionFromParent = "SUD";
            successeurBas.etat.emplacementHtepien = this.planete.navigationTable[(xH+1)][yH];
            successeurs.add(successeurBas);
           
        }
        
        if((this.planete.navigationTable[(xH)][yH=1])!=null){
        	Successeur successeurDroite = new Successeur();
        	successeurDroite.etat = this.clone();
        	successeurDroite.action = "EST";
        	String type = this.planete.navigationTable[(xH)][yH-1].type;
        	successeurDroite.cout =returnCost(type) ;
        	successeurDroite.etat.actionFromParent = "EST";
        	successeurDroite.etat.emplacementHtepien = this.planete.navigationTable[(xH)][yH=1];
            successeurs.add(successeurDroite);
           
        }
        
        if((this.planete.navigationTable[(xH)][yH-1])!=null){
        	Successeur successeurGauche = new Successeur();
        	successeurGauche.etat = this.clone();
        	successeurGauche.action = "OUEST";
        	String type = this.planete.navigationTable[(xH)][yH-1].type;
        	successeurGauche.cout =returnCost(type) ;
        	successeurGauche.etat.actionFromParent = "OUEST";
        	successeurGauche.etat.emplacementHtepien = this.planete.navigationTable[(xH)][yH-1];
            successeurs.add(successeurGauche);
           
        }
     

        return successeurs;
    }


    /** Cr�e un nouvel �tat en copiant l'�tat pr�sent.
     *  Effectue une copie en surface.
     *  En principe, vous n'aurez pas � modifier la m�thode clone().
     */
    @Override
    public Etat  clone()
    {
        Etat etat2 = new Etat(planete);
        etat2.nbbombesCharges = nbbombesCharges;
        etat2.emplacementHtepien = emplacementHtepien;
        etat2.emplacementsBombes = new Emplacement[emplacementsBombes.length];
        for(int i=0;i<emplacementsBombes.length;i++)
            etat2.emplacementsBombes[i] = emplacementsBombes[i];

        etat2.bombesCharges = new boolean[bombesCharges.length];
        for(int i=0;i<bombesCharges.length;i++)
            etat2.bombesCharges[i] = bombesCharges[i];
        return etat2;
    }

    /** Relation d'ordre n�cessaire pour TreeSet. */
    @Override
    public int compareTo(Etat o) {
        int c;
        c = emplacementHtepien.compareTo(o.emplacementHtepien);
        if(c!=0) return c;

        c = nbbombesCharges - o.nbbombesCharges;
        if(c!=0) return c;

        for(int i=0;i<emplacementsBombes.length;i++){
            c = (bombesCharges[i]?1:0) - (o.bombesCharges[i]?1:0);
            if(c!=0) return c;
            if(!bombesCharges[i]){
                c = emplacementsBombes[i].compareTo(o.emplacementsBombes[i]);
                if(c!=0) return c;
            }
        }
        return 0;
    }

    @Override
    public String toString(){
        String s = "ETAT: f=" + f + "  g=" + g + "\n";
        s += "  Pos=" + emplacementHtepien.nom + "";
        for(int i=0;i<emplacementsBombes.length;i++){
            s += "\n  PosBombes[i]=";
            s += emplacementsBombes[i]==null ? "--" : emplacementsBombes[i].nom;
        }
        s += "\n";
        return s;
    }
    
    public int returnCost(String type){
    	int coutCase=0;
    	switch (type){
    	case "P":
    	case "-":
    		coutCase+=2;
    		break;
    	case "#":
    	case "S":
    		coutCase += 1;
    		break;
    	default: break;
    	
    		} 
    	
    	return coutCase+1;
    	
    }
    

}
