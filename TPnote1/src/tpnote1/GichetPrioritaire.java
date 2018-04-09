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
//Définir une classe GuichetPrioritaire qui hérite de la classe Guichet.
public class GichetPrioritaire extends Guichet{
    public int num; //Un attribut public : le numéro entier du guichet prioritaire.
    
    public GichetPrioritaire(int capa, int numéro) //Le constructeur GuichetPrioritaire (int capacité, int numéro) avec 2 paramètres : la capacité et le numéro du
//guichet prioritaire. 
    {
        super(capa); //. Ce constructeur appelle par héritage le constructeur de la classe mère 
        num=numéro; //initialise le numéro
//du guichet avec le paramètre associé.
    }
    
    //La méthode surchargée (par héritage) toString() dont l'objectif est de retourner une chaine sous la forme « Le
//guichet prioritaire numéro peut recevoir au maximum capacité usager(s) ».
    public String toString(){
        String reslt = ("Le guichet prioritaire est le "+ num +" avec une capactié de "+capacité);
        return reslt;
    }
}
