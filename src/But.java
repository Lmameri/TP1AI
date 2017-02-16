/*
 * INF4230 - Intelligence artificielle
 * UQAM / D�partement d'informatique
 * 
 * Hiver 2017 / TP1
 * 
 */

public class But {

    /** Array contenant la destination des colis. Dans le m�me ordre que dans Monde.java. */
    protected Emplacement[]    destinationsBombes;

    /** Retourne vrai si le but est satisfait dans l'�tat pass� en param�tre.
     * @param etat
     * @return  */
    public boolean butEstStatisfait(Etat etat)
    {
        // V�rification pr�alable : destinations.length et etat.positionsColis.length est le nombre de colis.
        assert destinationsBombes.length == etat.emplacementsBombes.length;
        
        // Pour tous les colis, v�rifier si sa position courante (�tat) est celle d�sir� (but).
        for(int i=0;i<destinationsBombes.length;i++)
            if(etat.emplacementsBombes[i] != destinationsBombes[i])
                return false;
        return true;
    }

}
