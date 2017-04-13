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

public GanttCategoryDataset createDataset() {
    Task t;
    TaskSeries s;
    TaskSeriesCollection collection = new TaskSeriesCollection();
    for(int i= 0 ;i<processArr.size();i++){
     s = new TaskSeries(processArr.get(i).getName());
      t = new Task(processArr.get(i).getName(),new SimpleTimePeriod(processArr.get(i).getStart(),processArr.get(i).getEnd())); 
       ArrayList <Process> p = processArr.get(i).getSubProcess();
        for(int j = 0; j < p.size(); j++){
          //  System.out.println("ksdksk");
            t.addSubtask(new Task("",new SimpleTimePeriod(p.get(j).getStart(),p.get(j).getEnd())));
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
    final JFreeChart chart = ChartFactory.createGanttChart(
            "Gantt ", // chart title
            "PRO", // domain axis label
            "TIME (ms)", // range axis label
            dataset, // data
            true, // include legend
            true, // tooltips
            false // urls
    );
    CategoryPlot plot = chart.getCategoryPlot();

    DateAxis axis = (DateAxis) plot.getRangeAxis();

    axis.setDateFormatOverride(new SimpleDateFormat("S"));
    //axis.setMaximumDate(new Date(70));
    return chart;
}
}