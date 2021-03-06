package assig;

 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PrioNon extends Frame{
    private JTextField txtPrioNo;
    private JLabel lblPrioNo;
    
    public PrioNon(){
        super("Priority Non Preemptive Scheduling");
        txtPrioNo = new JTextField("");
        lblPrioNo = new JLabel("Priority No.");
        super.grid.remove(4);
        super.grid.add(lblPrioNo,4);
        super.grid.remove(5);
        super.grid.add(txtPrioNo,5);
       
    }
   void btnAddPressed() {
     //  System.out.println("in prio");
        Process p = new Process();
        p.setBurst(Float.valueOf(txtBurst.getText()));
        p.setArrival(Float.valueOf(txtArrival.getText()));
        p.setPriority(Float.valueOf(txtPrioNo.getText()));
        p.setName(count++);
        rowData[0] = p.getName();
        rowData[1]= txtArrival.getText();
        rowData[2] = txtBurst.getText();
        rowData[3] = txtPrioNo.getText();
        Table.addRow(rowData);
        txtBurst.setText("");
        txtArrival.setText("");
        txtPrioNo.setText("");
        processArr.add(p);
    }

     void btnDonePressed() {
       this.setVisible(false);
       count = 0;
       super.sortAscArrival();//1st sort according to arrival time
       Process firstPro = super.getMinPrio();
       //minimumm of arrival but with minimum burst
       processArr.remove(firstPro);
       //now sort as SJF in pBurst
       super.sortAscPriority();
       ArrayList<Process> pPrio = (ArrayList < Process >)processArr.clone();
       processArr.clear();
       
       firstPro.NonPremEvaluate(null);
       
       processArr.add(firstPro);
       int i =0;
       while(i < pPrio.size()){
           if(firstPro.getEnd()<pPrio.get(i).getArrival()){
               i++;
               if(i==pPrio.size()){
                   //handling if all elements have arrival > end
                   pPrio.get(0).NonPremEvaluate(firstPro);
                   firstPro = pPrio.get(0);
                   pPrio.remove(0);
                   processArr.add(firstPro);
                   i = 0;
               }
           }
           else{  
               pPrio.get(i).NonPremEvaluate(firstPro);
               firstPro = pPrio.get(i);
               pPrio.remove(i);
               processArr.add(firstPro);
               i = 0;
           }
       }
       //pBurst should be empty now
       
       float avgWT = 0;
        for(int j = 0;j< processArr.size();j++){
           avgWT+= processArr.get(j).getWaitingTime();
       }
       avgWT /= processArr.size();
       AvgWTp.setAvgWT(avgWT);
       gant.createGantt("Priority Scheduling",processArr);
       this.dispose();
    }
        
}
