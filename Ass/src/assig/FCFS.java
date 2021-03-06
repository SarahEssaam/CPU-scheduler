package assig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import org.jfree.ui.RefineryUtilities;


public class FCFS extends Frame{
    
    public FCFS(){
       super("FCFS");
    }
   void btnAddPressed() {
       //System.out.println("in FCFS");
        Process p = new Process();
        p.setBurst(Float.valueOf(txtBurst.getText()));
        p.setArrival(Float.valueOf(txtArrival.getText()));
        p.setName(count++);
        rowData[0] = p.getName();
        rowData[1]= txtArrival.getText();
        rowData[2] = txtBurst.getText();
        rowData[3] = "";
        //set priority of each process to be arrival time
       // p.setPriority(Integer.valueOf(txtArrival.getText()));
       Table.addRow(rowData);
        txtBurst.setText("");
        txtArrival.setText("");
        processArr.add(p);
    }

     void btnDonePressed() {
       this.setVisible(false);
       count = 0;
       super.sortAscArrival();
       avgWT = 0;
       processArr.get(0).NonPremEvaluate(null);
       avgWT+= processArr.get(0).getWaitingTime();
        for(int i = 1;i< processArr.size();i++){
           processArr.get(i).NonPremEvaluate(processArr.get(i-1));
           avgWT+= processArr.get(i).getWaitingTime();
       }
        avgWT /= processArr.size();
     /*    JFrame f = new JFrame();
        f.setSize(300,200);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        RefineryUtilities.centerFrameOnScreen(f);
       // f.pack();
        Container c = f.getContentPane();
        c.setLayout(new FlowLayout());
        JTextField t = new JTextField();
        JLabel l = new JLabel("Average Waiting time =");
        c.add(l);
        c.add(t);
        t.setText(String.valueOf(avgWT));
        f.setVisible(true);
*/
     AvgWTp.setAvgWT(avgWT);
       gant.createGantt("FCFS Scheduling",processArr);
       this.dispose();
    }
     
        
}
