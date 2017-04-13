
package assig;
import java.util.ArrayList;

public class Process {
    private int arrival;
    private int start;
    private int end;
    private int burst;
    private int prio;
    private int Q;
    private String name;
    private int turns;
    private int remainder;
    ArrayList<Process> subPro ;
    public Process(){
        subPro = new ArrayList<>(0);
        arrival = 0;
        start = 0;
        end = 0;
        prio = 0;
        burst = 0;
        Q = 0;
        name = "P";
    }
    void evalTurns(){
        turns = (int)((Math.ceil((double)(burst)/(double)Q)));
       
    }
    void setTurns(int t){
        turns = t;
    }
    int getTurns(){
        return turns;
    }
    void evalRem(){
          if((burst%Q)!=0)
           remainder = ((burst)%Q);
          else
              remainder = Q;
    }
    void setRem(int t){
        remainder = t;
    }
    int getRem(){
        return remainder;
    }
    void createSubProcess(int s,int e){
        Process p = new Process();
        p.start = s;
        p.end = e;
        subPro.add(p);
    }
    int getWaitingTime(){
        if(subPro.size()==0)    //non preemptive mfish ta2ti3
        return (start - arrival);
        else
            //////////////  
        return 0;
    }
    int getStart(){
        return start;
    }
    int getEnd(){
        return end;
    }
    int getArrival(){
        return arrival;
    }
    int getPriority(){
        return prio;
    }
    int getBurst(){
        return burst;
    }
    String getName(){
        return name;
    }
    void setName(int s){
        name += Integer.toString(s);
    }
    public ArrayList<Process> getSubProcess(){
        return subPro;
    }
    public void setBurst(int b){
        burst = b;
    }
    public void setStart(int b){
        start = b;
    }
    public void setEnd(int b){
        end = b;
    }
    public void setArrival(int s){
        arrival = s;
    }
    public void setPriority(int p){
        prio = p;
    }
    public void setQ(int p){
        Q = p;
    }
    public void NonPremEvaluate(Process previous){
        if(previous==null){
            //first element in array
            start = arrival;
            end = start +burst;
        }
        else{
            //start previous.end if arrival<previous.end
            //else start = arrival
            start = (arrival>previous.end)?arrival:previous.end;
            end = start + burst;
        }
    }
    public void prioNonEvaluate(){
        
    }
    public void prioEvaluate(){
        
    }
    public void RRevaluate(){
        
    }
    public void SJFevaluate(){
        
    }
    public void SRTFevaluate(){
        
    }
   
}
