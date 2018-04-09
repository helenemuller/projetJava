/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnote1;

import java.util.Scanner;

/**
 *
 * @author Vivien
 */
public class Poste {
    /*public int total_usagers;
    public int nb_guichets;
    public int prio;
    
    public void Poste(){
        prio=0;
        int nombreAleatoire = (int) (200+(Math.random()*(300-200))); //généré aléatoirement entre 200 et 300.
        int nombreAleatoireG = (int) (1+(Math.random()*(5-1))); //Initialiser le nombre de guichets généré aléatoirement entre 1 et 5.
        total_usagers = nombreAleatoire;
        System.out.println("Total usagers=" + total_usagers);
        nb_guichets = nombreAleatoireG;
        System.out.println("Nb de guichet=" + nb_guichets);
    }*/
    
    public static void main(String[] args){
        //Poste p= new Poste();
        int prio=0;
        int nombreAleatoire = (int) (200+(Math.random()*(300-200))); //généré aléatoirement entre 200 et 300.
        int nombreAleatoireG = (int) (1+(Math.random()*(5-1))); //Initialiser le nombre de guichets généré aléatoirement entre 1 et 5.
        int total_usagers = nombreAleatoire;
        System.out.println("Total usagers=" + total_usagers);
        int nb_guichets = nombreAleatoireG;
        System.out.println("Nb de guichet=" + nb_guichets);
        BureauImplemente bureau = new BureauImplemente(nb_guichets); //Instancier un objet de la classe BureauImplemente avec en paramètre le nombre de guichets généré ci-dessus.
        for(int i=0; i<nb_guichets; i++)
        {
            int AleaCapa= (int) (10+(Math.random()*(15-10)));
            bureau.ouvrirNouveauGuichet(AleaCapa);//ouvrir tous les guichets (de 1 au nombre de guichets généré ci-dessus) en
        //appelant sa méthode ouvrirNouveauGuichet, avec en paramètre la capacité générée aléatoirement entre 10 et 15.
        }
        for(int i=1; i<=total_usagers;i++)
        { //Ajouter ces numéros d’usagers en appelant la méthode ajouterUsager, 
            //avec en paramètre le numéro d’usager.
            bureau.ajouterUsager(i);
        }
        for(int i=1; i<=nb_guichets;i++)
        {
            System.out.println("Guichet "+i); //Afficher le numéro du guichet,
            while(bureau.guichets[i].nb_usagers !=0) //Si le numéro défilé est 0, afficher « le guichet est vide » sinon afficher le numéro de premier usager défilé.
            {
                System.out.println(bureau.premierUsager(bureau.guichets[i]));
            }
            if(bureau.premierUsager(bureau.guichets[i])==0)
                System.out.println("Le guichet est vide");
        }
        boolean test=false;
        Scanner sc=new Scanner(System.in);
        
        while (test==false){
            System.out.println("Entrer un numéro de guichet compris entre 1 et "+nb_guichets);
            prio = sc.nextInt();
            if(prio>=1 && prio<=nb_guichets)
                test=true;
            else
                System.out.println("Numéro incorrect, saisissez-en un autre.");
        }
        int AleaCapa= (int) (10+(Math.random()*(15-10)));
        Guichet guichetprio =new GichetPrioritaire(AleaCapa, prio);//Instancier un objet de la classe GuichetPrioritaire avec ses 2 paramètres : une capacité générée aléatoirement entre 10 et 15 et le numéro de guichet saisi ci-dessus.
        
        System.out.println(guichetprio.toString()); //Pour l’objet instancié ci-dessus, afficher la méthode toString() de cet objet.
    }
}
