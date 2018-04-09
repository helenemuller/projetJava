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
//Définir une classe BureauImplemente qui implémente l’interface Bureau,
public class BureauImplemente {
    //Attributs Publics
    public int total_guichet;
    public int nb_guichet;
    public Guichet guichets[];
    public int compt;
    
    //Méthodes
    public BureauImplemente(int total_G)
    {
        nb_guichet=0;
        compt=0;
        total_guichet=total_G;   //initialiser l’attribut associé au paramètre 
        guichets= new Guichet[total_G]; //et instancier le tableau des guichets avec ce paramètre.
    }//constructeur  avec en paramètre le nombre total de guichets 
  
    
    public Guichet ouvrirNouveauGuichet(int capacité) //la capacité en paramètre (de sa file d’attente) 
    {
        //implémente le guichet dans le tableau de guichet
        if(nb_guichet<total_guichet)
        {
            guichets[nb_guichet]= new Guichet(capacité);
            nb_guichet+=1;
        }
        
        return guichets[nb_guichet-1]; //et retourner le guichet instancié.
    }
    
    public void ajouterUsager(int numéro)
    {
        int i=0;
        if(guichets[i].guichetPlein())
        {
            System.out.println("Le bureau est saturé");   
        }
        else 
        {
            System.out.println("Personne "+(compt+1)+" entre");
            compt++;
            guichets[i].ajouterUsager(numéro);
        }
    }
    
    public int premierUsager(Guichet g)
    {
        return g.premierUsager(); //retourner le numéro du premier usager du guichet g en paramètre, 
        //en appelant la méthode premierUsager () de ce guichet g.
    }
}
