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

import Modèle.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import Controleur.*;
//import Vue.*;

/**
 *
 * @author Vivien
 */
public class Acceuil extends JFrame{
    JPanel pan;
    JPanel panbut;
    JPanel rechpan;
    JPanel majpan;
    JPanel reppan;
    JPanel container;
    JButton rechbut;
    JButton majbut;
    JButton repbut;
    CardLayout cl;
    String[] listContent = {"Rep", "Maj", "Rech"};
    JLabel majtitre;
    JLabel reptitre;
    JLabel rechtitre;
    Connexion conn;
    
    public Acceuil(){
        this.setTitle ("Menu");
        this.setSize (500, 300);
        this.setAlwaysOnTop(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        pan = new JPanel();
        panbut = new JPanel();
        panbut.setPreferredSize(new Dimension(1500,300));
        Font police= new Font("Tahoma", Font.BOLD, 30);
        container = new JPanel();
        reptitre = new JLabel();
        rechtitre = new JLabel();
        majtitre = new JLabel();
        
        /*try {
            conn = new Connexion("hopital","root","");
        } catch (SQLException ex) {
            Logger.getLogger(Acceuil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Acceuil.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        Recherche rech= new Recherche();
        rechpan = new JPanel();
        //rechpan.setBackground(Color.yellow);
        rechpan.add(rech.getPane());
        majpan = new JPanel();
        majpan.setBackground(Color.red);
        reppan = new JPanel();
        reppan.setBackground(Color.blue);
        
        rechbut = new JButton();
        majbut = new JButton();
        repbut = new JButton();
        rechtitre.setFont(police);
        rechtitre.setText("Recherche");
        rechbut.add(rechtitre);
        majtitre.setFont(police);
        majtitre.setText("Mise à jour");
        majbut.add(majtitre);
        reptitre.setFont(police);
        reptitre.setText("Reporting");
        repbut.add(reptitre);
        
        
        cl = new CardLayout();
        pan.setLayout(cl);
        panbut.setLayout(new GridLayout(1,3));
        panbut.add(rechbut);
        panbut.add(majbut);
        panbut.add(repbut);
        
        pan.add(reppan, listContent[0]);
        pan.add(majpan, listContent[1]);
        pan.add(rechpan, listContent[2]);
        
        rechbut.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                cl.show(pan, listContent[2]);
            }
        });
        majbut.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 cl.show(pan, listContent[1]);
            }
        });
        repbut.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                cl.show(pan, listContent[0]);
            }
        });
        container.setLayout(new BorderLayout());
        container.add(panbut,BorderLayout.NORTH);
        container.add(pan,BorderLayout.CENTER); // ajouter le panneau dans la fenêtre
        this.setLocationRelativeTo(null);
        this.setContentPane(container);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
