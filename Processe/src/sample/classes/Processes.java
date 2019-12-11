package sample.classes;

import java.util.ArrayList;

public class Processes{

    private Scheduler scheduler;

    public ArrayList<Process> getList() {
        return list;
    }

    private ArrayList<Process> list;
    private Queue queue;

    public Processes(Scheduler scheduler){
        this.list = new ArrayList<>();
        this.scheduler = scheduler;
    }

    public void CheckByPriority() {
        Process runningProcess = null;
        Process processNew = null;
        boolean isFind = false;

        for (Process process:getList()) {
            if(process.getTypeState().equals(State.RUNNING)){
                runningProcess = process;
            }

            if(runningProcess!=null) {
                if (process.getPriority() < runningProcess.getPriority()) {
                    if (queue.add(process)) {
                        getList().get(getList().indexOf(runningProcess)).setTypeState(State.WAITING);
                        process.setTypeState(State.RUNNING);
                        processNew = process;
                        isFind = true;
                        break;
                    } else {
                        process.setTypeState(State.REJECTED);
                    }
                }
            }
        }
        if(isFind){
            scheduler.deleteBlock(scheduler.findById(runningProcess.getId()));
            toWork(processNew);
        }
    }

    public Process processMinPriority(){
        int minPriority=32;
        Process currentProcess = null;
        for (Process process:this.getList()) {
            if(process.getPriority()<minPriority&&!process.getTypeState().equals(State.REJECTED)&&!process.getTypeState().equals(State.RUNNING)&&!process.getTypeState().equals(State.TERMINATED)){
                minPriority=process.getPriority();
                currentProcess = process;
            }
        }
    return currentProcess;
    }

    public void Work() {
        Process currentProcess = processMinPriority();
        queue = new Queue(scheduler);
        if(currentProcess!=null) {
            if (queue.add(currentProcess)) {
                toWork(currentProcess);
                queue.addConfirmedProcess(currentProcess);
            } else {
                getList().get(getList().indexOf(currentProcess)).setTypeState(State.REJECTED);
                queue.addRejectedProcess(currentProcess);
            }
        }
    }

    private void toWork(Process process) {
        getList().get(getList().indexOf(process)).setTypeState(State.RUNNING);
        MemoryBlock memoryBlock = new MemoryBlock(process.getId(), queue.getStart() + 1, queue.getStart() + process.getSize()+1);
        scheduler.add(memoryBlock);
        scheduler.getMemoryBlocks().sort(MemoryBlock.byAsc);
    }

    public void findTerminatedProcesses(){
        for (Process process:this.list) {
            if(process.getTypeState().equals(State.TERMINATED)){
                scheduler.deleteBlock(scheduler.findById(process.getId()));
            }
        }
    }

    public void ChangePriority(int id, int priority){
        for (Process process:this.list) {
            if(process.getId()==id){
                process.setPriority(priority);
            }
        }
    }
}