/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assig;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.gantt.GanttCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.util.ArrayList;

public class Gantt extends ApplicationFrame {
   // private static final long serialVersionUID = 1L;
    private ArrayList<Process> processArr;
    public Gantt(final String title,ArrayList<Process> p) {
        super(title);
        processArr = p;
        final GanttCategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
        this.pack(); 
        RefineryUtilities.centerFrameOnScreen(this);
        this.setVisible(true);
}
    void createGantt(final String title,ArrayList<Process> p) {
        setTitle(title);
        processArr = p;
        final GanttCategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
        this.revalidate();
        this.repaint();
        
    }

public GanttCategoryDataset createDataset() {
    Task t;
    TaskSeries s;
    TaskSeriesCollection collection = new TaskSeriesCollection();
    Process tm ;
    if(FPanel.isFloating==false)
    for(int i= 0 ;i<processArr.size();i++){
     tm  = processArr.get(i);
        s = new TaskSeries(tm.getName());
     
      t = new Task(tm.getName(),new SimpleTimePeriod((int)(tm.getStart()),(int)(tm.getEnd()))); 
       ArrayList <Process> p = tm.getSubProcess();
        for(int j = 0; j < p.size(); j++){
          //  System.out.println("ksdksk");
            t.addSubtask(new Task("",new SimpleTimePeriod((int)(p.get(j).getStart()),(int)(p.get(j).getEnd()))));
        }
        s.add(t);
        collection.add(s);
    }
    else
        for(int i= 0 ;i<processArr.size();i++){
     tm  = processArr.get(i);
        s = new TaskSeries(tm.getName());
     
      t = new Task(tm.getName(),new SimpleTimePeriod((int)(tm.getStart()*1000),(int)(tm.getEnd()*1000))); 
       ArrayList <Process> p = tm.getSubProcess();
        for(int j = 0; j < p.size(); j++){
          //  System.out.println("ksdksk");
            t.addSubtask(new Task("",new SimpleTimePeriod((int)(p.get(j).getStart()*1000),(int)(p.get(j).getEnd()*1000))));
        }
        s.add(t);
        collection.add(s);
    }
    return collection;
}
    /*  private static Date date(final int day, final int month, final int year) {
     final Calendar calendar = Calendar.getInstance();
     calendar.set(year, month, day);
     final Date result = calendar.getTime();
     return result;
     */
private JFreeChart createChart(final GanttCategoryDataset dataset) {
    JFreeChart chart;
    if(FPanel.isFloating==false){
    chart = ChartFactory.createGanttChart(
            "Gantt ", // chart title
            "PRO", // domain axis label
            "TIME (ms)", // range axis label
            dataset, // data
            true, // include legend
            true, // tooltips
            false // urls
    );
    }
    else{
      chart = ChartFactory.createGanttChart(
            "Gantt ", // chart title
            "PRO", // domain axis label
            "TIME (MicroSec)", // range axis label
            dataset, // data
            true, // include legend
            true, // tooltips
            false // urls
    );  
    }
    CategoryPlot plot = chart.getCategoryPlot();

    DateAxis axis = (DateAxis) plot.getRangeAxis();

    axis.setDateFormatOverride(new SimpleDateFormat("S"));
    //axis.setMaximumDate(new Date(70));
    return chart;
}
}
