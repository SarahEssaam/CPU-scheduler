package assig;

 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class SJF extends Frame{
    
    public SJF(){
       super("SJF");
    }
   void btnAddPressed() {
       //System.out.println("in FCFS");
        Process p = new Process();
        p.setBurst(Integer.valueOf(txtBurst.getText()));
        p.setArrival(Integer.valueOf(txtArrival.getText()));
        p.setName(count++);
        p.setPriority(Integer.valueOf(txtArrival.getText()));
        txtBurst.setText("");
        txtArrival.setText("");
        processArr.add(p);
    }

     void btnDonePressed() {
       this.setVisible(false);
       count = 0;
       super.sortAsc();     //1st sort according to arrival time
       Process firstPro = super.getMin();
       //minimumm of arrival but with minimum priority
       processArr.remove(firstPro);
       for(int i = 0;i< processArr.size();i++){
           processArr.get(i).setPriority(processArr.get(i).getBurst());
       }
       super.sortAsc();
       ArrayList<Process> pBurst = (ArrayList < Process >)processArr.clone();
       processArr.clear();
       
       firstPro.NonPremEvaluate(null);
       
       processArr.add(firstPro);
       int i =0;
       while(i < pBurst.size()){
           if(firstPro.getEnd()<pBurst.get(i).getArrival()){
               i++;
               if(i==pBurst.size()){
                   //handling if all elements have arrival > end
                   pBurst.get(0).NonPremEvaluate(firstPro);
                   firstPro = pBurst.get(0);
                   pBurst.remove(0);
                   processArr.add(firstPro);
                   i = 0;
               }
           }
           else{  
               pBurst.get(i).NonPremEvaluate(firstPro);
               firstPro = pBurst.get(i);
               pBurst.remove(i);
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
       new Gantt("SJF Scheduling",processArr);
       this.dispose();
    }
        
}
