package sample.classes;

import java.util.TimerTask;

public class TimerTaskCheckTime extends TimerTask {

    private Processes processes;

    public TimerTaskCheckTime(Processes processes){
        this.processes = processes;
    }

    @Override
    public void run() {
        for (Process process : processes.getList()) {
            if(process.getTypeState().equals(State.RUNNING)){
                if(process.getTime()>0) {
                    process.setTime((process.getTime() - Utils.workOdds));
                    if(process.getTime() < 0){
                        process.setTime(0);
                    }
                }
            }
            if(process.getTime()<=0){
                process.setTypeState(State.TERMINATED);
                processes.findTerminatedProcesses();
            }
        }
    }
}