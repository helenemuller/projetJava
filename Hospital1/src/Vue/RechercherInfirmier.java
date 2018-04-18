/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;


/**
 *
 * @author Hélène
 */
public class RechercherInfirmier extends JFrame implements ActionListener{
    
    // Pour renseigner la rotation jour/nuit de l'infirmier recherché 

    private ButtonGroup group;
    private JRadioButton rotation1,rotation2;
    private JLabel name;
    private JTextField entree1;
    private JTextField entree2;
    private GridBagLayout gbl = new GridBagLayout();
    private JButton bouton;
    
    public RechercherInfirmier()
    {
        group = new ButtonGroup();
        name = new JLabel("Rotation : ");
        rotation1 = new JRadioButton("Nuit",true);
        rotation2 = new JRadioButton("Jour");
        group.add(rotation1);
        group.add(rotation2);
        
        // un listener sur les items en appelant la classe
        RadioListener listen = new RadioListener();
        rotation1.addActionListener(listen);
        rotation2.addActionListener(listen);
        
        
        this.setLayout(new FlowLayout());
        this.add(rotation1);
        this.add(rotation2);
        
        //this.add(name);
       
       this.setResizable(false);
       this.setSize(300, 210);
       this.setVisible(true);
    }

    // faire un sous-programme qui push l'entrée clavier dans le jtextfield dans une requête
    
    
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        // si le bouton a été cliqué
        if (e.getSource() == bouton)
        {
            System.out.println("ok");
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public class RadioListener implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent ae) {
            System.out.println("ActionEvent received: ");
           if (ae.getSource() == rotation1) {
               System.out.println(rotation1 + " pressed.");
           } else {
               System.out.println(rotation2 + " pressed.");
           }
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
