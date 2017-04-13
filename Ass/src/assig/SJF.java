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
        p.setBurst(Float.valueOf(txtBurst.getText()));
        p.setArrival(Float.valueOf(txtArrival.getText()));
        p.setName(count++);
        p.setPriority(Float.valueOf(txtBurst.getText()));
        txtBurst.setText("");
        txtArrival.setText("");
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
       ArrayList<Process> pBurst = (ArrayList<Process>)processArr.clone();
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
       
        avgWT = 0;
        for(int j = 0;j< processArr.size();j++){
           avgWT+= processArr.get(j).getWaitingTime();
       }
       avgWT /= processArr.size();
       AvgWTp.setAvgWT(avgWT);
       gant.createGantt("SJF Scheduling",processArr);
       MainFrame.setProArr(processArr);
       this.dispose();
    }
        
}
