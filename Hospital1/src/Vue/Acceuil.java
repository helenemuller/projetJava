/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import Modèle.*;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import Controleur.*;
//import Vue.*;

/**
 *
 * @author Vivien
 */
public class Acceuil extends JFrame implements ActionListener {
private JMenuBar menuBar;
private JMenu menu, submenu,autre,resulting;
private JMenuItem menuItem,menuItem2,menuItem3,menuItem4,submenu2,graphes,quitter,services;
private JRadioButtonMenuItem rbMenuItem;
private JCheckBoxMenuItem cbMenuItem;
private JFrame frame;
private ImageIcon image;
private JLabel lab;

public Acceuil()
{
//Create the menu bar
menuBar = new JMenuBar();
image = new ImageIcon("hopital.jpg");
lab = new JLabel(image);

frame = new JFrame();
frame.add(lab);
frame.setSize(image.getIconWidth(),image.getIconHeight());

//Build the first menu
menu = new JMenu("Rechercher");
menu.setMnemonic(KeyEvent.VK_A);
menu.getAccessibleContext().setAccessibleDescription(
        "The only menu in this program that has menu items");
menuBar.add(menu);

//a submenu
menu.addSeparator();
submenu = new JMenu("Employés");

menuItem = new JMenuItem("Docteurs");
submenu.add(menuItem);
menuItem.addActionListener(this);

menuItem2 = new JMenuItem("Infirmiers");
submenu.add(menuItem2);
menuItem2.addActionListener(this);

submenu2 = new JMenuItem("Malades");

services = new JMenuItem("Services");
services.addActionListener(this);

menu.add(submenu);
menu.add(submenu2);
menu.add(services);
submenu2.addActionListener(this);

//Build second menu in the menu bar.
menu = new JMenu("Mettre à jour");
menuItem3 = new JMenuItem("Ajouter");
menu.add(menuItem3);
menuItem4 = new JMenuItem("Supprimer");
menu.add(menuItem4);
menuBar.add(menu);

resulting = new JMenu("Statistiques");
graphes = new JMenuItem("Graphes");
resulting.add(graphes);
menuBar.add(resulting);

autre = new JMenu("Autre");
quitter = new JMenuItem("Quitter");
autre.add(quitter);
menuBar.add(autre);
quitter.addActionListener(this);

frame.setJMenuBar(menuBar);

frame.setVisible(true);

}

public static void main (String args[])
    {
        new Acceuil();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quitter)
        {
            System.exit(0);
        }
        if (e.getSource() == submenu2)
        {
            System.out.println("okkkk");
            new RechercherMalade();
        }
        if (e.getSource() == menuItem)
        {
            System.out.println("okkkk docteurs");
            new RechercherDocteur();
        }
        if (e.getSource() == menuItem2)
        {
            System.out.println("okkkk infirmiers");
            new RechercherInfirmier();
        }
        if (e.getSource() == services)
        {
            System.out.println("Services okkkk");
            new RechercherService();
        }
        
    }
    }
    
    
    

