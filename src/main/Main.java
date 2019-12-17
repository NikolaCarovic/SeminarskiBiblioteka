/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.Controller;
import javax.swing.JFrame;
import ui.form.FLogin;
import ui.form.FMain;

/**
 *
 * @author Nikola
 */
public class Main {
    public static void main(String[] args) {
        //JFrame frame = new FMain();
        //frame.setVisible(true);
        Controller.getInstance().formaMain2();
    }
}
