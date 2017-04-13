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
    static private ArrayList<Process> p;
    JButton[] item = new JButton[6];
    //JLabel lblChoose;
    JButton btnOk;
    JLabel lbl;
    JPanel sPanel;
    Frame f;
    JButton repeat;
    private String str;
    public MainFrame(){
        
        p = new ArrayList<Process>(0);
        Frame.gant = new Gantt("No Scheduling Chosen", p);
        this.setTitle("CPU Scheduling");
        this.setSize(500,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      //  RefineryUtilities.centerFrameOnScreen(this);
        //this.pack();
        Container c = this.getContentPane();
       c.setLayout(new GridLayout(2,2));
       repeat = new JButton("Repeat with same processes");
        lbl = new JLabel("Choose one");
        item[0] = new JButton("FCFS");
        item[1] = new JButton("SJF");
        item[2] = new JButton("SRTF"); 
        item[3] = new JButton("RR");
        item[4] = new JButton("Pre-Priority");
        item[5] = new JButton("Priority");
        btnOk = new JButton("Okey");
        
         sPanel = new JPanel(new GridLayout(6,1));
        sPanel.add(lbl);
         for(int i= 0;i<6;i++)        
        sPanel.add(item[i]);
      
        c.add(sPanel);
        c.add(new AvgWTp());
        c.add(new FPanel());
        c.add(repeat);
      //  c.setVisible(true);
        
        for(int i = 0;i < 6; i++){
        item[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 initAlg(e);
                }
        });
        }
        repeat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 Frame.setProcessArr(p);
                }
        });
        
    }
    private void initAlg(ActionEvent e){
        str = ((JButton)(e.getSource())).getText();
        switch (str){
            case "FCFS":
                f = new FCFS();
                break;
            case "SJF":
                f = new SJF();
                break;
            case "SRTF":
                f = new SRTF();
                break;
            case "RR":
                f = new RR();
                break;
            case "Preemptive Priority":
                 f = new Prio();
                 break;
            case "Priority":
                 f = new PrioNon();
                 break;
        }
            f.setVisible(true);    
        
    }
    static void  setProArr(ArrayList<Process> pa){
        p = pa;
    }
}

