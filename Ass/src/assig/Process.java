
package assig;
import java.util.ArrayList;

public class Process {
    private float arrival;
    private float start;
    private float end;
    private float burst;
    private float prio;
    private float Q;
    private String name;
    private int turns;
    private float remainder;
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
          if((burst%Q)>0)
           remainder = ((burst)%Q);
          else
              remainder = Q;
    }
    void setRem(float t){
        remainder = t;
    }
    float getRem(){
        return remainder;
    }
    void createSubProcess(float s,float e){
        Process p = new Process();
        p.start = s;
        p.end = e;
        subPro.add(p);
    }
    float getWaitingTime(){
        float w = start - arrival;
        if(subPro.size()==0)    //non preemptive mfish ta2ti3
        return w;
        else{
            w += (end-start-burst); 
            return w;
        }
    }
    float getStart(){
        return start;
    }
    float getEnd(){
        return end;
    }
    float getArrival(){
        return arrival;
    }
    float getPriority(){
        return prio;
    }
    float getBurst(){
        return burst;
    }
    String getName(){
        return name;
    }
    float getQ(){
        return Q;
    }
    void setName(int s){
        name += Integer.toString(s);
    }
    public ArrayList<Process> getSubProcess(){
        return subPro;
    }
    public void setBurst(float b){
        burst = b;
    }
    public void setStart(float b){
        start = b;
    }
    public void setEnd(float b){
        end = b;
    }
    public void setArrival(float s){
        arrival = s;
    }
    public void setPriority(float p){
        prio = p;
    }
    public void setQ(float p){
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
   
}
