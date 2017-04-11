package assig;

 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class SRTF extends Frame{
    
    public SRTF(){
       super("SRTF");
    }
   void btnAddPressed() {
       //System.out.println("in FCFS");
       
        Process p = new Process();
        p.setBurst(Integer.valueOf(txtBurst.getText()));
        p.setArrival(Integer.valueOf(txtArrival.getText()));
        txtBurst.setText("");
        txtArrival.setText("");
        processArr.add(p);
    }

     void btnDonePressed() {
       this.setVisible(false);
        for(int i = 0;i< processArr.size();i++){
           processArr.get(i).SRTFevaluate();
       }
       new Gantt("SRTF Scheduling",processArr);
       this.dispose();
    }
        
}
