package assig;

 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SRTF extends Frame{
    private float endG ;
    private float unitTime;
    
   public SRTF(){
       super("SRTF");
        endG = 0 ;
        unitTime = 0.5f;
        count = 0;
       
    }
   void btnAddPressed() {
      // System.out.println("in prio");
        Process p = new Process();
        p.setBurst(Float.valueOf(txtBurst.getText()));
        p.setArrival(Float.valueOf(txtArrival.getText()));
        p.setPriority(Float.valueOf(txtBurst.getText()));
        txtBurst.setText("");
        txtArrival.setText("");
        p.setName(count++); 
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
      // for(int i = 0;i< size;i++)
        //   System.out.println(processArr.get(i).getName());
       Process first = getMinPrio();
       endG = first.getArrival();
       sortAscPriority();
    //   for(int i = 0;i< size;i++)
      //     System.out.println(processArr.get(i).getName());
       ArrayList<Process> tmp = new ArrayList<>();
       tmp = (ArrayList<Process>)processArr.clone();
       
       while((processArr.isEmpty())==false){
           if(first.getTurns()>1){
               first.createSubProcess(endG, endG+unitTime);
               endG += unitTime;
               first.setTurns(first.getTurns()-1);
               first.setPriority(first.getPriority()-unitTime);
               sortAscPriority();
               if(processArr.indexOf(first)!=0){
                   for(int i = 0; i<processArr.indexOf(first);i++ ){
                       if((processArr.get(i).getSubProcess().size()>0)&&
                           //handling if the above process and first have equal priorities
                            (processArr.get(i).getPriority()<first.getPriority()))
                        {first = processArr.get(i);
                           break;
                           //if priorities are equal..first remain unchanged
                        }
                       else
                           if((processArr.get(i).getArrival()<=endG)
                           &&(processArr.get(i).getPriority()<first.getPriority()))
                           {first = processArr.get(i);
                           break;}
                           //if priorities are equal..first remain unchanged
                   }
               }
           }
           else if (first.getTurns()==1){
               first.createSubProcess(endG, endG+first.getRem());
               endG += first.getRem();
               first.setTurns(first.getTurns()-1);
               Process temp = first; 
               processArr.remove(first);
               //sortAscPriority();
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
       gant.createGantt("SRTF Scheduling",processArr);
       this.dispose();
    }
        
}
