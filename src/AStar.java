/* INF4230 - Intelligence artificielle
 * UQAM / Département d'informatique
 * Hiver 2017
 */

import java.util.*;

public class AStar {

    public static List<String> genererPlan(Etat etatInitial, But but, Heuristique heuristique)
    {
        // Implémentez l'algorithme A* ici.
        //
        // Étapes suggérées :
        //  - Restez simple. Commencez avec TreeSet<Etat> open, closed;.
        //  - Ajoutez etatInitial dans open.
        //  - Tracez les itérations dans la console avec System.out.println(..).
        //  - Pour chaque itération :
        //  --  Affichez le numéro d'itération.
        //  --  Faites une boucle qui itère tous les états e dans open pour trouver celui avec e.f minimal.
        //  --  Affichez l'état e sélectionné (les e.f affichés devraient croître);
        //  --  Vérifiez si l'état e satisfait le but. 
        //  ---   Si oui, sortez du while.
        //  ---   Une autre boucle remonte les pointeurs parents.
        //  --  Générez les successeurs de e.
    	
        //  --  Pour chaque état successeur s de e:
        //  ---   Vérifiez si s.etat est dans closed.
        //  ---   Calculez s.etat.g = e.g + s.cout.
        //  ---   Vérifiez si s.etat existe dans open.
        //  ----    Si s.etat est déjà dans open, vérifiez son .f.
        //  ---   Ajoutez s.etat dans open si nécessaire.
        //  - Exécutez le programme sur un problème TRÈS simple (ex: prob00.txt)
        //  --  Vérifiez le bon fonctionnement de la génération des états.
        //  --  Vérifiez que e.f soit croissant (>=).
        //  - Réfléchissez maintenant à une heuristique.
        //  - Une fois que l'algorithme et l'heuristique fonctionne :
        //  -- Ajoutez un TreeSet<Etat> open2 avec un comparateur basé sur f.
        //  -- Évaluez la pertinence d'un PriorityQueue.
        //  - Commentez les lignes de traçage (déboggage avec System.out.println).
        
        
        // Un plan est une séquence (liste) d'actions. Ici, une actions est tout simplement une String.
        LinkedList<String> plan = new LinkedList<String>();
        
        // A* ici.
        
        TreeSet<Etat> open, closed; //Creation de open et closed
        open=new TreeSet<Etat>();
        closed=new TreeSet<Etat>();
        open.add(etatInitial);
        int i=0;
        while(true){
        	System.out.println("Iteration numero : " + i);//Afficher le numero de literation
        	
        	if(open.isEmpty()){
        		
        		break;//If open is empty when quit the loop
        	}
        	
        	Iterator<Etat> itr=open.iterator();
        	while(itr.hasNext()){
        	    Etat e=itr.next();
        	    System.out.println("HEY"+e.toString());
        	}
        	
        	System.out.println("etat selectionne: " + open.first().toString());//Afficher lemplacement
        	
        	if(but.butEstStatisfait(open.first())){
        		break; //On sort de la boucle si le prochain est une sortie
        	}
        	
        	Collection<Successeur> successeurs = open.first().genererSuccesseurs();
        	
        	Iterator<Successeur> iterator = successeurs.iterator();
        	
        	while (iterator.hasNext()) {
                Successeur s = iterator.next();
                
                if (closed.contains(s.etat)){ }
                //  ---   Calculez s.etat.g = e.g + s.cout.
                //  ---   Vérifiez si s.etat existe dans open.
                //  ----    Si s.etat est déjà dans open, vérifiez son .f.
                //  ---   Ajoutez s.etat dans open si nécessaire.                
                
                
                
                }
        	
        	
        	i++;
        }
        
        return plan;
    }

}
