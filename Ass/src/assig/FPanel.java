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


public  class FPanel extends JPanel{
    JButton by;
    JButton bn;
    JLabel lbl ;
public static boolean isFloating;
    public  FPanel() {
        isFloating = false;
        lbl = new JLabel("float values?");
       by = new JButton("yes");
       bn = new JButton("no");
       this.setLayout(new FlowLayout());
       this.add(lbl);
       this.add(by);
       this.add(bn);
       this.setPreferredSize(new Dimension(100,75));
       by.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isFloating = true; //To change body of generated methods, choose Tools | Templates.
            }
        });
       bn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               isFloating = false; //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    
    
}
