package sample.classes;

import java.util.TimerTask;

public class TimerTaskProcess extends TimerTask {

    private Processes processes;
    private Generate generateProcesses = new Generate();

    public TimerTaskProcess(Processes processes){
        this.processes = processes;
    }

    @Override
    public void run() {
        generateProcesses.generate(processes);
    }
}