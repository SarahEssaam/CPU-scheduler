package assig;

 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RR extends Frame{
    private JTextField txtQ;
    private JLabel lblQ;
    
    public RR(){
        super("Round Robin");
        txtQ = new JTextField("");
        lblQ = new JLabel("Quantum ");
        super.grid.remove(4);
        super.grid.add(lblQ,4);
        super.grid.remove(5);
        super.grid.add(txtQ,5);
       
    }
   void btnAddPressed() {
       System.out.println("in prio");
        Process p = new Process();
        p.setBurst(Integer.valueOf(txtBurst.getText()));
        p.setArrival(Integer.valueOf(txtArrival.getText()));
        p.setQ(Integer.valueOf(txtQ.getText()));
        txtBurst.setText("");
        txtArrival.setText("");
        lblQ.setText("");
        processArr.add(p);
    }

     void btnDonePressed() {
       this.setVisible(false);
        for(int i = 0;i< processArr.size();i++){
           processArr.get(i).RRevaluate();
       }
       new Gantt("RR Scheduling",processArr);
       this.dispose();
    }
        
}
