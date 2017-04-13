package assig;

 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RR extends Frame{
    private JTextField txtQ;
    private JLabel lblQ;
    private float q;
    private boolean firstAdd;
    public RR(){
        super("Round Robin");
        txtQ = new JTextField("");
        lblQ = new JLabel("Quantum ");
        super.grid.remove(4);
        super.grid.add(lblQ,4);
        super.grid.remove(5);
        super.grid.add(txtQ,5);
       firstAdd = true;
    }
   void btnAddPressed() {
       if(firstAdd==true){
           q = Integer.valueOf(txtQ.getText());
           firstAdd =  false;
           txtQ.setText("Done");
           super.grid.remove(4);
        super.grid.add(lblExtra,4);
        super.grid.remove(5);
        super.grid.add(lblExtra2,5);
           revalidate();
           repaint();
       }
     //  System.out.println("2");
        Process p = new Process();
        p.setBurst(Integer.valueOf(txtBurst.getText()));
        p.setArrival(Integer.valueOf(txtArrival.getText()));
        p.setPriority(Integer.valueOf(txtArrival.getText()));
        p.setQ(q);
        p.setName(count++);
        txtBurst.setText("");
        txtArrival.setText("");
        txtQ.setText("");
        processArr.add(p);
    }

     void btnDonePressed() {
       this.setVisible(false);
       count = 0;
       sortAscArrival();
       float endGlobal = (getMinPrio().getArrival());
    //   ArrayList<Float> turns = new ArrayList<>();
    //   ArrayList<Float> remainder = new ArrayList<>();
       ArrayList<Process> tmp = new ArrayList<>();
       
       tmp = (ArrayList<Process>)processArr.clone();
       
       int size = processArr.size();
       for(int i = 0; i < size; i++){
           processArr.get(i).evalTurns();
           processArr.get(i).evalRem();
       } 
       Process tmpp;
       while(processArr.isEmpty()==false){
       for(int i=0;i<processArr.size();i++){
           tmpp = processArr.get(i);
           if(tmpp.getTurns()==1){
               tmpp.createSubProcess(endGlobal, endGlobal+tmpp.getRem());
               endGlobal += tmpp.getRem(); 
               processArr.remove(i);
               i--;
           }
           else{
               processArr.get(i).createSubProcess(endGlobal, endGlobal+q);
               endGlobal += q;
               tmpp.setTurns(tmpp.getTurns()-1);
           }
       }}
       processArr = tmp;
       int subSize;
       Process t;
       avgWT = 0;
       for(int i =0;i<size;i++){
               t = processArr.get(i);
           subSize = t.getSubProcess().size();
           t.setStart(t.getSubProcess().get(0).getStart());
           t.setEnd(t.getSubProcess().get(subSize-1).getEnd());
           avgWT += t.getWaitingTime();
       }
       avgWT /= size;
       AvgWTp.setAvgWT(avgWT);
//    tmp.clear();
       new Gantt("RR Scheduling",processArr);
       this.dispose();
    }
        
}
