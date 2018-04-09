/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnote1;

/**
 *
 * @author Vivien
 */
public class Guichet {
    private int usagers[]; // tableau (file d’attente du guichet) privé des numéros entiers d’usagers (*)
    protected int id ; // indice du premier usager (le plus ancien dans le tableau)
    public int nb_usagers ; // nombre d’usagers dans le tableau
    public int capacité ; // capacité maximale d’usagers du tableau

    public Guichet (int capa) 
    {
        capacité=capa;
        usagers=new int[capa];
        id=0;
        nb_usagers=0;
    } // constructeur
    
    public boolean guichetVide() {
        boolean test=false; 
        
        if(nb_usagers==0)
            test=true;
        
        return test;
    } // retourne true si nombre d’usagers=0, sinon false
    
    public boolean guichetPlein() {
        boolean test=false;
        
        if(nb_usagers==capacité)
            test=true;
        
        return test;
    } // retourne true si nombre d’usagers=capacité, sinon false
    
    public int premierUsager () {
      
      
        
        int nb=0;
        if(!guichetVide())
        {
            nb_usagers-=1;   //si le guichet n’est pas vide, décrémenter le nombre d’usagers,
            if(id < (id+nb_usagers)%capacité) // incrémenter « circulairement » cet id (*) 
            {
                nb=usagers[id];  //affecter le numéro d’usager d’indice id du tableau, 
            }
            else
            {
                id=0; //sinon (guichet vide) retourner 0.
                nb=usagers[id];
            }
        }
        return nb;   //et retourner le numéro d’usager; 
        
    } // défile et retourne le numéro du premier usager du tableau
    
    public void ajouterUsager (int numéro) { // enfile le numéro d’usagers en paramètre dans le tableau
        if(!guichetPlein()) //si le guichet n'est pas plein
        {
            // placer le numéro dans le tableau « circulaire » à l’indice (id+nb_usagers) modulo capacité (*) 
            //et incrémenter le nombre d’usagers ; 

            usagers[(id+nb_usagers)%capacité]=numéro;
            nb_usagers+=1;
        }
        else //sinon afficher le message « le guichet est plein ».
            System.out.println("Gichet pleins");
    } // ajoute (enfile) un usager dans le tableau
}
