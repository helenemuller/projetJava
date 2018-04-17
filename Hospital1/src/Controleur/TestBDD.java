/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modèle.Connexion;
import static java.nio.file.Files.size;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.UnaryOperator;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author Vivien
 */
public class TestBDD extends JFrame{
    private Connexion conn;
    ArrayList<ArrayList<String>> list;
    
    public TestBDD() throws SQLException, ClassNotFoundException{
    conn = new Connexion("hopital","root","");
    list.replaceAll((UnaryOperator<ArrayList<String>>) conn.ChampsRequete("SELECT * FROM docteur"));
    //Arrays.equals(list, conn.ChampsRequete("SELECT * FROM docteur"));
    
}
    
    public String [][] getData(){
    String [][] donnees = new String [list.size()][list.get(1).size()];
    for(int i = 0; i<list.size();i++){
        ArrayList<String> list2= list.get(i);
        for(int j=0; j<list.get(i).size();j++){
        donnees[i][j] = list2.get(j);
        System.out.println(list2.get(j));
        }
    }
  return donnees;
}
    
    public void Afficher(){
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tableau de Docteur");
        setSize(300, 120);
        
        String [] title = {"Numéro","Spécialité"};
        //String [][] donnees = getData();
        //JTable tablo = new JTable(title, conn.reponses);
        /*for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
        }*/
        //getContentPane().add(tablo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
