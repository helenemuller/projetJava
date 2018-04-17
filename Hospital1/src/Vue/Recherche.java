/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Vivien
 */
public class Recherche {
    private JPanel pan;
    private JComboBox selectbox;
    private JPanel select;
    private JLabel selecttxt= new JLabel("Choisissez le sujet de votre recherche: ");
    
    public Recherche(){
        pan =new JPanel();
        pan.setLayout(new BorderLayout());
        
        selectbox=new JComboBox();
        selectbox.addItem("Employé");
        selectbox.addItem("Service");
        selectbox.addItem("Malade");
        selectbox.addItem("Chambre");
        selectbox.addItem("Hospitalisation");
        select = new JPanel();
        select.setLayout(new BorderLayout());
        
        select.add(selecttxt, BorderLayout.WEST);
        select.add(selectbox, BorderLayout.CENTER);
        selecttxt.setFont(new Font("Tahoma", Font.BOLD, 30));
        selectbox.setFont(new Font("Tahoma", Font.BOLD, 30));
        select.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        pan.add(select, BorderLayout.CENTER);
        //pan.add(selectbox, BorderLayout.CENTER);
    }
    
    public JPanel getPane(){
        return pan;
    }
}
