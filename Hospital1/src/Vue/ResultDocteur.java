/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modèle.Connexion;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Vivien
 */
public class ResultDocteur extends JFrame{
    private final String num;
    private final String nbmalade;
    JPanel container;
    JFrame fen;
    ArrayList<String> result;
    Connexion conn;
    
    public ResultDocteur(String textnum, String textnb) throws SQLException, ClassNotFoundException{
        num = textnum;
        nbmalade=textnb;
        container= new JPanel();
        fen = new JFrame();
        result = new ArrayList<String>();
        conn = new Connexion("hopital","root","");
    }
    
    public void Afficher() throws SQLException{
        fen.setTitle ("Résultats de la recherche");
        fen.setSize (600, 600);
        //this.setAlwaysOnTop(true);
        fen.setLocationRelativeTo(null);
        container.setLayout(new BorderLayout());
        
        if(!nbmalade.equals("") || !num.equals("")){
            if(num.equals("")){
                JLabel entete = new JLabel();
                entete.setText("Nombre de Malade entré: "+ nbmalade);
                container.add(entete, BorderLayout.NORTH);
                /*result=conn.remplirChampsTable2("SELECT no_docteur, COUNT(no_malade) FROM soigne GROUP BY no_docteur HAVING COUNT(no_malade) = " + nbmalade);
                int nbColonne = Integer.parseInt(result.get(0));
                String[] title= new String[nbColonne];
                result.remove(0);

                for(int i=0; i<nbColonne; i++){
                    title[i]=result.get(0);
                    result.remove(0);
                }

                String[][] tab= new String[(result.size()/nbColonne)][nbColonne];
                int k=0;
                for(int i=0; i<result.size(); i+=nbColonne)
                {
                    int l=0;
                    for(int j=i; j<(i+nbColonne);j++)
                    {
                        tab[k][l]=result.get(j);
                        l++;
                    }
                    k++;
                }*/

                JTable tablo;
                tablo = conn.remplirChampsTable2("SELECT nom, prenom, COUNT(no_malade) FROM soigne INNER JOIN employe ON soigne.no_docteur = employe.numero GROUP BY no_docteur HAVING COUNT(no_malade) = " + nbmalade);
                if(tablo.getRowCount()!=0)
                    container.add(new JScrollPane(tablo), BorderLayout.CENTER);
                else
                {
                    container.add(new JLabel(""), BorderLayout.CENTER);
                }
            }
            if(nbmalade.equals("")){
                JLabel entete = new JLabel();
                ArrayList<String> iddoc = conn.remplirChampsRequete("SELECT nom,prenom,adresse,tel FROM employe WHERE numero = " + num);
                JLabel pied = new JLabel();
                ArrayList<String> spedoc = conn.remplirChampsRequete("SELECT specialite FROM docteur WHERE numero = " + num);
                
                if(!iddoc.isEmpty()){
                    if(!spedoc.isEmpty()){
                        entete.setText("Identité du médecin: " + iddoc.get(0));
                        container.add(entete, BorderLayout.NORTH);

                        JTable tablo = conn.remplirChampsTable2("SELECT * FROM soigne WHERE no_docteur = " + num);
                        container.add(new JScrollPane(tablo), BorderLayout.CENTER);

                        pied.setText("Le docteur "+num+" possède \""+spedoc.get(0)+"\" comme spécialité.");
                        container.add(pied, BorderLayout.SOUTH);
                    }
                    else{
                        entete.setText("Aucun docteur ne correspond à ce numéro.");
                        //ArrayList<String> idinf = conn.remplirChampsRequete("SELECT nom,prenom,adresse,tel FROM employe WHERE numero = " + num);
                        pied.setText("Mais un infirmier correspond: " + iddoc.get(0));
                    }
                }
                else{
                    entete.setText("Aucun employé ne correspond à ce numéro.");
                    ArrayList<String> idmal = conn.remplirChampsRequete("SELECT nom,prenom,adresse,tel FROM employe WHERE numero = " + num);
                }
            }
            if(!nbmalade.equals("") && !num.equals(""))
            {
                JLabel entete = new JLabel();
                ArrayList<String> iddoc = conn.remplirChampsRequete("SELECT nom,prenom,adresse,tel FROM employe WHERE numero = " + num);
                entete.setText("Identité du médecin: " + iddoc.get(0));
                container.add(entete, BorderLayout.NORTH);
                
                JPanel pan = new JPanel();
                pan.setLayout(new GridLayout(2,1));
                JTable tabloS = conn.remplirChampsTable2("SELECT * FROM soigne WHERE no_docteur = " + num);
                pan.add(tabloS);
                JTable tabloI = conn.remplirChampsTable2("SELECT nom, prenom, COUNT(no_malade) FROM soigne INNER JOIN employe ON soigne.no_docteur = employe.numero GROUP BY no_docteur HAVING COUNT(no_malade) = " + nbmalade);
                pan.add(tabloI);
                container.add(pan,BorderLayout.CENTER);
                
                JLabel pied = new JLabel();
                ArrayList<String> spedoc = conn.remplirChampsRequete("SELECT specialite FROM docteur WHERE numero = " + num);
                pied.setText("Le docteur numéro "+num+" possède \""+spedoc.get(0)+"\" comme spécialité.");
                container.add(pied, BorderLayout.SOUTH);
            }
        }
        else{
            JLabel entete = new JLabel();
            entete.setText("Aucune information n'a été entré donc tous les médecins seront affichés:");
            container.add(entete, BorderLayout.NORTH);
            /*result=conn.remplirChampsTable2("SELECT * FROM docteur");
            int nbColonne = Integer.parseInt(result.get(0));
            String[] title= new String[nbColonne];
            result.remove(0);
            
            for(int i=0; i<nbColonne; i++){
                title[i]=result.get(0);
                result.remove(0);
            }
            
            String champ="";
            for(int i=0; i<result.size(); i+=nbColonne){
                for(int j=i; j<(i+nbColonne);j++)
                    champ= champ +" "+ result.get(j);
                champ=champ + "\n";
            }
            
            String[][] tab= new String[(result.size()/nbColonne)][nbColonne];
            int k=0;
            for(int i=0; i<result.size(); i+=nbColonne)
            {
                int l=0;
                for(int j=i; j<(i+nbColonne);j++)
                {
                    tab[k][l]=result.get(j);
                    l++;
                }
                k++;
            }*/
            
            JTable tablo;
            tablo =conn.remplirChampsTable2("SELECT * FROM docteur") ;
            container.add(new JScrollPane(tablo), BorderLayout.CENTER);
        }
        
        fen.setContentPane(container);
        fen.setVisible(true);
    }
}