/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controleur.TestBDD;
import java.sql.*;
import Vue.*;

/**
 *
 * @author Vivien
 */
public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Acceuil fenacc = new Acceuil();
        TestBDD tst = new TestBDD();
        tst.Afficher();
    }
}
