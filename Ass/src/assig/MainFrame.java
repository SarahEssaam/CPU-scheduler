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


public class MainFrame extends JFrame {
    JPopupMenu menu;
    //JLabel lblChoose;
    JButton btnOk;
    Frame f;
    public MainFrame(){
        this.setTitle("CPU Scheduling");
        this.setSize(300,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        RefineryUtilities.centerFrameOnScreen(this);
        //this.pack();
        Container c = this.getContentPane();
        c.setLayout(new GridLayout(1,2));
        
        menu = new JPopupMenu("Choose Scheduling Algorithm");
        JMenuItem [] item = new JMenuItem[6] ;
        item[0] = new JMenuItem("FCFS");
        item[1] = new JMenuItem("SJF");
        item[2] = new JMenuItem("SRTF"); 
        item[3] = new JMenuItem("RR");
        item[4] = new JMenuItem("Preemptive Priority");
        item[5] = new JMenuItem("Priority");
        btnOk = new JButton("Okey");
        
        for(int i= 0;i<6;i++)        
        menu.add(item[i]);
      
        c.add(menu);
        c.setVisible(true);
        menu.show(c, 10, 10);
        c.add(btnOk);
        
       
        
        item[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 f = new FCFS();
                }
        });
        item[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 f = new SJF();
                }
        });
        item[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f = new SRTF();
                }
        });
        item[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 f = new RR();
                System.out.println("HNAa");
                }
        });
        item[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 f = new Prio();
                }
        });
        item[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 f = new PrioNon();
                }
        });
        
       
        btnOk.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        f.setVisible(true);
                    }
                }
        );
    }
}

