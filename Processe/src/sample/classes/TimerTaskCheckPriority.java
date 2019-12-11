package sample.classes;

import java.util.TimerTask;

public class TimerTaskCheckPriority extends TimerTask {

    private Processes processes;

    public TimerTaskCheckPriority(Processes processes){
        this.processes = processes;
    }

    @Override
    public void run() {
        processes.CheckByPriority();
    }
}
