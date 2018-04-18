/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javafx.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.io.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hélène
 */
public class RechercherDocteur extends JFrame implements ActionListener {
    
     private JFrame fenetre;
    private JLabel malades;
    private JLabel numero;
    private JTextField entree1;
    private JTextField entree2;
    private GridBagLayout gbl = new GridBagLayout();
    private JButton bouton;
    private String text1;
    private String text2;
    
    // cette classe nous permet d'afficher une fenêtre avec un champ de saisie du nb malades + numéro
    
    public RechercherDocteur()
    {
        malades = new JLabel ("Nombre de malades : ");
        numero = new JLabel ("Numéro : ");
        entree1 = new JTextField();
        entree2 = new JTextField();
        bouton = new JButton("Valider");
        
                this.setLayout(gbl);
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.fill = GridBagConstraints.BOTH;
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.weightx = 1;
                gbc.weighty = 1;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                
                gbc.insets = new Insets(5,10,2,0);
                
                gbl.setConstraints(this.numero, gbc);
                this.add(this.numero);
                gbc.insets = new Insets(5,0,2,10);
                gbc.gridx = 1;
                gbc.weightx = 5;
                gbl.setConstraints(this.entree1, gbc);
                this.add(this.entree1);

                gbc.insets = new Insets(0,10,2,0);
                gbc.gridx =0;
                gbc.gridy = 1;
                gbc.weightx = 1;
                gbl.setConstraints(this.malades, gbc);
                this.add(this.malades);

                gbc.insets = new Insets(0,0,2,10);
                gbc.gridx =1;
                gbc.weightx = 5;
                gbl.setConstraints(this.entree2, gbc);
                this.add(this.entree2);
                               
                
                gbc.gridx =0;
                gbc.gridy = 2;
                gbc.gridwidth =2;
                gbc.weightx = 1;
                gbc.insets = new Insets(10,50,5,50);
                gbl.setConstraints(this.bouton, gbc);
                this.add(this.bouton);
                this.bouton.addActionListener(this);

       this.setResizable(false);
       this.setSize(300, 110);
       this.setVisible(true);
    }
    
    // faire un sous-programme qui push l'entrée clavier dans le jtextfield dans une requête
    
    public String getText1(){
        return text1;
    }
    
    public String getText2(){
        return text2;
    }
    
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        // si le bouton a été cliqué
        if (e.getSource() == bouton)
        {
            System.out.println("ok");
            
            if(!entree1.getText().equals(""))
                text1=entree1.getText();
            else
                text1="";
            
            if(!entree2.getText().equals(""))
                text2=entree2.getText();
            else
                text2="";
            
            ResultDocteur result;
            try {
                result = new ResultDocteur(text1,text2);
                
                try {
                    result.Afficher();
                } catch (SQLException ex) {
                    Logger.getLogger(RechercherDocteur.class.getName()).log(Level.SEVERE, null, ex);
                } 
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(RechercherDocteur.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}
