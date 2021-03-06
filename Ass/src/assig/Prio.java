package assig;

 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Prio extends Frame{
    private JTextField txtPrioNo;
    private JLabel lblPrioNo;
    private float endG ;
    private float unitTime;
    
    public Prio(){
        super("Priority Preemptive Scheduling");
        txtPrioNo = new JTextField("");
        lblPrioNo = new JLabel("Priority No.");
        super.grid.remove(4);
        super.grid.add(lblPrioNo,4);
        super.grid.remove(5);
        super.grid.add(txtPrioNo,5);
        endG = 0 ;
        unitTime = 0.5f;
       
    }
   void btnAddPressed() {
      // System.out.println("in prio");
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
        int size = processArr.size();
       for(int i = 0;i < size; i++){
           processArr.get(i).setQ(unitTime);
           processArr.get(i).evalTurns();
           processArr.get(i).evalRem();
       }
       sortAscArrival();
       Process first = getMinPrio();
       endG = (first.getArrival());
       sortAscPriority();
       
       ArrayList<Process> tmp = new ArrayList<>();
       tmp = (ArrayList<Process>)processArr.clone();
       
       while((processArr.isEmpty())==false){
           if(first.getTurns()>1){
               first.createSubProcess(endG, endG+unitTime);
               endG += unitTime;
               first.setTurns(first.getTurns()-1);
               if(processArr.indexOf(first)!=0){
                   for(int i = 0; i<processArr.indexOf(first);i++ ){
                       if(processArr.get(i).getSubProcess().size()>0){
                           first = processArr.get(i);
                           break;
                       }
                       else
                           if(processArr.get(i).getArrival()<=endG)
                           {first = processArr.get(i);
                           break;
                           }
                   }
               }
           }
           else if (first.getTurns()==1){
               first.createSubProcess(endG, endG+first.getRem());
               endG += first.getRem();
               first.setTurns(first.getTurns()-1);
               Process temp = first; 
               processArr.remove(first);
               if(processArr.size()>0){
                    for(int i = 0; i < processArr.size(); i++){
                         if((processArr.get(i).getSubProcess().size())>0){
                             first = processArr.get(i);
                             break;
                         }
                         else
                              if(processArr.get(i).getArrival()<=endG)
                              {
                                  first = processArr.get(i);
                                  break;
                              }
                         }
                         if(first == temp)
                             first = processArr.get(0);
                }
           }
       }
       processArr = tmp;
       avgWT = 0;
       int subSize;
       Process t;
       for(int i =0;i<size;i++){
           t = processArr.get(i);
           subSize = t.getSubProcess().size();
           t.setStart(t.getSubProcess().get(0).getStart());
           t.setEnd(t.getSubProcess().get(subSize-1).getEnd());
           avgWT+= t.getWaitingTime();
       }
        avgWT = avgWT/size ;
        AvgWTp.setAvgWT(avgWT);
       gant.createGantt("Preemptive Priority Scheduling",processArr);
       this.dispose();
    }
        
}
