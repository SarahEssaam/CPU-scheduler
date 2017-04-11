package assig;

 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Prio extends Frame{
    private JTextField txtPrioNo;
    private JLabel lblPrioNo;
    
    public Prio(){
        super("Priority Preemptive Scheduling");
        txtPrioNo = new JTextField("");
        lblPrioNo = new JLabel("Priority No.");
        super.grid.remove(4);
        super.grid.add(lblPrioNo,4);
        super.grid.remove(5);
        super.grid.add(txtPrioNo,5);
       
    }
   void btnAddPressed() {
       System.out.println("in prio");
        Process p = new Process();
        p.setBurst(Integer.valueOf(txtBurst.getText()));
        p.setArrival(Integer.valueOf(txtArrival.getText()));
        p.setPriority(Integer.valueOf(txtPrioNo.getText()));
        txtBurst.setText("");
        txtArrival.setText("");
        txtPrioNo.setText("");
        processArr.add(p);
    }

     void btnDonePressed() {
       this.setVisible(false);
        for(int i = 0;i< processArr.size();i++){
           processArr.get(i).prioEvaluate();
       }
       new Gantt("Priority Scheduling",processArr);
       this.dispose();
    }
        
}
