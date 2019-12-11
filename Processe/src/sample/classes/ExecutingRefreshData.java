package sample.classes;

import java.util.Date;
import java.util.Timer;

public class ExecutingRefreshData {

    public ExecutingRefreshData(){
        Refresh();
    }

    public void Refresh() {
        Timer timer = new Timer("Refresh data");
        TimerTaskRefreshData timerTaskRefreshData = new TimerTaskRefreshData();
        Date date = new Date();
        long delay = 1 * 1000;
        timer.scheduleAtFixedRate(timerTaskRefreshData, date, delay);
    }
}