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

//l’interface Bureau
interface Bureau {
    public Guichet ouvrirNouveauGuichet (int capacité) ;
    public void ajouterUsager (int numéro) ;
    public int premierUsager (Guichet g) ;
}