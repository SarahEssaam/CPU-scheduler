/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assig;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Table extends JPanel{   
    static JTable jt;
    static JScrollPane sp;
    static DefaultTableModel dtm;
    static int rows;
    Table(){     
        jt = new JTable();
    String data[][] = {{"","","",""}};    
    String header[] = new String[] {"Process","Arrival Time","Burst Time","Priority"};         
    dtm = new DefaultTableModel(0, 0);
     dtm.setColumnIdentifiers(header);
    jt.setModel(dtm);    
    rows = 0;
   // jt.setBounds(30,40,200,300);          
    sp=new JScrollPane(jt);
    add(sp);
}     
public static void initTable(){
   // System.out.println(rows);
    for(int i = 0;i < rows; i++){
        dtm.removeRow(0);
    }
    rows = 0;   
}
public static void addRow(String[] data){
    rows++;
    dtm.addRow(data);
}

}  
