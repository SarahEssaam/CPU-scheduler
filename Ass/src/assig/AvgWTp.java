/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assig;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import org.jfree.ui.RefineryUtilities;

public  class AvgWTp extends JPanel{
    static JTextField txt ;
    JLabel lbl ;

    public  AvgWTp() {
        lbl = new JLabel("Average Waiting Time :");
        txt = new JTextField("               ");
       this.setLayout(new FlowLayout());
       this.add(lbl);
       this.add(txt);
       this.setPreferredSize(new Dimension(100,75));
    }
    public static void setAvgWT(float value){
        txt.setText(String.valueOf(value));
    }
    
}
