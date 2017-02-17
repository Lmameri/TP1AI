/* INF4230 - Intelligence artificielle
 * UQAM / D�partement d'informatique
 * Hiver 2017
 */

import java.util.*;

public class AStar {

    public static List<String> genererPlan(Etat etatInitial, But but, Heuristique heuristique)
    {
        // Impl�mentez l'algorithme A* ici.
        //
        // �tapes sugg�r�es :
        //  - Restez simple. Commencez avec TreeSet<Etat> open, closed;.
        //  - Ajoutez etatInitial dans open.
        //  - Tracez les it�rations dans la console avec System.out.println(..).
        //  - Pour chaque it�ration :
        //  --  Affichez le num�ro d'it�ration.
        //  --  Faites une boucle qui it�re tous les �tats e dans open pour trouver celui avec e.f minimal.
        //  --  Affichez l'�tat e s�lectionn� (les e.f affich�s devraient cro�tre);
        //  --  V�rifiez si l'�tat e satisfait le but. 
        //  ---   Si oui, sortez du while.
        //  ---   Une autre boucle remonte les pointeurs parents.
        //  --  G�n�rez les successeurs de e.
    	
        //  --  Pour chaque �tat successeur s de e:
        //  ---   V�rifiez si s.etat est dans closed.
        //  ---   Calculez s.etat.g = e.g + s.cout.
        //  ---   V�rifiez si s.etat existe dans open.
        //  ----    Si s.etat est d�j� dans open, v�rifiez son .f.
        //  ---   Ajoutez s.etat dans open si n�cessaire.
        //  - Ex�cutez le programme sur un probl�me TR�S simple (ex: prob00.txt)
        //  --  V�rifiez le bon fonctionnement de la g�n�ration des �tats.
        //  --  V�rifiez que e.f soit croissant (>=).
        //  - R�fl�chissez maintenant � une heuristique.
        //  - Une fois que l'algorithme et l'heuristique fonctionne :
        //  -- Ajoutez un TreeSet<Etat> open2 avec un comparateur bas� sur f.
        //  -- �valuez la pertinence d'un PriorityQueue.
        //  - Commentez les lignes de tra�age (d�boggage avec System.out.println).
        
        
        // Un plan est une s�quence (liste) d'actions. Ici, une actions est tout simplement une String.
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
                //  ---   V�rifiez si s.etat existe dans open.
                //  ----    Si s.etat est d�j� dans open, v�rifiez son .f.
                //  ---   Ajoutez s.etat dans open si n�cessaire.                
                
                
                
                }
        	
        	
        	i++;
        }
        
        return plan;
    }

}
