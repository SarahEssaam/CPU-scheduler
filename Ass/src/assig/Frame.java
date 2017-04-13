
package assig;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import org.jfree.ui.RefineryUtilities;

public class Frame extends JFrame {
     int count = 0;
     final JLabel lblBurst;
     final JLabel lblArrival;
     protected JTextField txtBurst;
    protected JLabel lblExtra;
    protected JLabel lblExtra2;
    protected JPanel grid;
    //protected JTextField txtExtra;
     protected JTextField txtArrival;
     //JLabel lblProcessNo;
     protected JButton btnAdd;
     protected JButton btnDone;
     protected float avgWT;
     protected ArrayList<Process> processArr;
    
    public Frame(String title){
        this.setTitle(title);
        this.setSize(300,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        RefineryUtilities.centerFrameOnScreen(this);
        //this.pack();
        Container c = this.getContentPane();
        avgWT = 0;
        processArr = new ArrayList<>(0);
        lblBurst = new JLabel("Burst Time");
        lblArrival = new JLabel("Arrival Time");
        txtBurst = new JTextField("");
        txtArrival = new JTextField("");
      //  lblProcessNo = new JLabel("Process 1 :");
        btnAdd = new JButton("ADD");
        btnDone = new JButton("DONE");
     lblExtra = new JLabel("");
     lblExtra2 = new JLabel("");
     //txtExtra = new JTextField("");
        grid = new JPanel();
        grid.setLayout(new GridLayout(4,2));
        grid.add(lblArrival,0);
        grid.add(txtArrival,1);
        grid.add(lblBurst,2);
        grid.add(txtBurst,3);
        grid.add(lblExtra,4);
        grid.add(lblExtra2,5);
        grid.add(btnAdd,6);
        grid.add(btnDone,7);
//c.add(lblProcessNo);
        c.add(grid);
    btnAdd.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnAddPressed();
                    }
                }
        );

        //Equal Button        
        
        btnDone.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnDonePressed();
                    }
                }
        );
     
    }

      
     void btnAddPressed() {
          
    }

     void btnDonePressed() {
       
    }
     //sort array ascendingly according to priority
     void sortAscPriority(){
         int size = processArr.size();
         if(size==1) return;
         int min;
        for(int i = 0 ;i < size-1 ;i++){
            min = i;
            for(int j = i+1; j < size ;j++ ){
                if((processArr.get(j).getPriority())<(processArr.get(min).getPriority())){
                    min = j;
                }
            }
            //swap i and min but keep l tarteeb
            Process tmp = processArr.get(min);
            processArr.remove(min);
            processArr.add(i, tmp);
        }
     }
     void sortAscArrival(){
         int size = processArr.size();
         if(size==1) return;
         int min;
        for(int i = 0 ;i < size-1 ;i++){
            min = i;
            for(int j = i+1; j < size ;j++ ){
                if((processArr.get(j).getArrival())<(processArr.get(min).getArrival())){
                    min = j;
                }
            }
            //swap i and min
           Process tmp = processArr.get(min);
            processArr.remove(min);
            processArr.add(i, tmp);
        }
     }
     
     //use only after sortAscArrival
     Process getMinPrio(){
         int size = processArr.size();
         if(size==1) return processArr.get(0);
         int min = 0;
          /*  for(int j = 1; j < size ;j++ ){
                if((processArr.get(j).getPriority())<(processArr.get(min).getPriority())){
                    min = j;
                }
            }
            //for equal minimum arrivals : find minimum in burst
            min = 0;*/
        for(int i = 1; i< size;i++){
            if(processArr.get(i).getArrival()==processArr.get(min).getArrival()){
                if(processArr.get(i).getPriority()<processArr.get(min).getPriority()){
                    min = i;
                }
            }
            else{
                break;
            }
        }
            //swap i and min
            return processArr.get(min);
        }
}
     /* for testing
     public void setProArr(ArrayList<Process> p){
         processArr = p;
     }
     public ArrayList<Process> getProArr(){
         return processArr;
     }
*/
