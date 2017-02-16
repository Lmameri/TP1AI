/* INF4230 - Intelligence artificielle
 * UQAM / D�partement d'informatique
 * Hiver 2017
 */

import java.awt.geom.Point2D;
import java.util.ArrayList;

/** Un emplacement repr�sente un point (noeud) sur la carte. */
public class Emplacement implements Comparable<Emplacement> {
  
    public Emplacement(String nom, double x, double y, String type){
        this.nom = nom;
        this.type = type; // correspond au type de l'emplacement. Valeurs possibles= +, -, P, B, S, E, #
        this.positionGeographique = new Point2D.Double(x, y);
    }

    protected  Point2D           positionGeographique;
    protected  String            nom;
    protected  String type;
    
    /** Routes attach�es � cet emplacement. */
    protected  ArrayList<Route>  routes = new ArrayList<Route>();

    
    /** Pour num�rotation interne. */
    protected int                id = nextId++;
    protected static int         nextId = 0;
    
    @Override
    public int compareTo(Emplacement o) {
        return id - o.id;
    }

    @Override
    public String toString(){
        return nom;
    }

}

