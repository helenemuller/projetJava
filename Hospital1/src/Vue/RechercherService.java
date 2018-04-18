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
public class RechercherService extends JFrame {
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    
    // il va falloir afficher pour chacun des services
    public RechercherService()
    {
        frame = new JFrame();
        frame.setSize(300,210);
        panel = new JPanel();
        label = new JLabel("Voici tous les services");
        panel.add(label);
        frame.add(panel);
        frame.setVisible(true);
    }
    
}
