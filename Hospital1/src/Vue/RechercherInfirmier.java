/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;


/**
 *
 * @author Hélène
 */
public class RechercherInfirmier extends JFrame implements ActionListener{
    
    // Pour renseigner la rotation jour/nuit de l'infirmier recherché 
    private JFrame fen;
    private JPanel panRadio,panButton;
    private ButtonGroup group;
    private JRadioButton rotation;
    private GridBagLayout gbl = new GridBagLayout();
    private JButton bouton;
    
    public RechercherInfirmier()
    {
        fen = new JFrame();
        fen.setSize(300,150);
        panRadio = new JPanel();
        panButton = new JPanel();
        group = new ButtonGroup();
        bouton = new JButton("Valider");
        
        panRadio.add(rotation = new JRadioButton("Jour",true));
        rotation.setActionCommand("Jour");
        group.add(rotation);
        
        panRadio.add(rotation = new JRadioButton("Nuit"));
        rotation.setActionCommand("Nuit");
        group.add(rotation);
        
        panButton.add(bouton);
        bouton.addActionListener(this);
        
        Container content = fen.getContentPane();
        content.setLayout(new GridLayout(2,1));
        content.add(panRadio);
        content.add(panButton);

       fen.setVisible(true);
    }

    // faire un sous-programme qui push l'entrée clavier dans le jtextfield dans une requête
    
    
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        // rotation de nuit ou de jour ??
        String rot = group.getSelection().getActionCommand();
        System.out.println("Rotation de : " + rot);
        // on veut appeler la bonne requête en fonction de la rotation
        if (rot == "Jour")
        {
            System.out.println("Appeler les infirmiers de jour");
        }
        if (rot == "Nuit")
        {
            System.out.println("Appeler les infirmiers de nuit");
        }
        
        // si le bouton valider a été cliqué
        if (e.getSource() == bouton)
        {
            System.out.println("ok");
        }
    }

}
