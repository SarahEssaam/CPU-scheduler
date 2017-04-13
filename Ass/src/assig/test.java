/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assig;

import assig.Frame;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import org.jfree.ui.RefineryUtilities;
public class test {
    public test(){
        JFrame j = new JFrame();
        j.setTitle("Main");
        j.setDefaultCloseOperation(EXIT_ON_CLOSE);
        j.setLayout(new FlowLayout());
        j.setSize(300, 200);
        Container c = j.getContentPane();
        
        JPanel p = new JPanel(new FlowLayout());
        
        
        JPopupMenu pop = new JPopupMenu("menu");
        pop.add("7amada");
        
        p.add(pop);
        p.add(new JButton("B"));
        c.add(p);         
        
j.setVisible(true);

     /*   ArrayList<Process> p = new ArrayList<>();
        Process p1 = new Process();
        p1.setPriority(1);
        p.add(p1);
         ArrayList<Process> p2 = new ArrayList<>();
        Process p3 = new Process();
        p3.setPriority(2);
        p2.add(p3);
        
        p2 = (ArrayList<Process>)p.clone();
        p.clear();
        System.out.println(p2.get(0).getPriority());
        /*
     Frame f = new Frame("a");
        
        ArrayList<Process> p = new ArrayList<>();
        Process p1 = new Process();
        p1.setPriority(3);
        p.add(p1);
        p1 = new Process();
        p1.setPriority(2);
        p.add(p1);
        p1 = new Process();
        p1.setPriority(4);
        p.add(p1);
        p1 = new Process();
        p1.setPriority(1);
        p.add(p1);
     //   f.setProArr(p);
        f.sortAsc();
       // p = f.getProArr();
        for(int i = 0;i<4;i++){
            System.out.println(p.get(i).getPriority());*/
        }
}

