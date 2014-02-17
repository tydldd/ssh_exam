package com.ru.javaExam.threadnew;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Description:
 * User: NanChengRu
 * Date: 13-11-19
 * Time: 下午4:26
 * JDK: 1.6
 * version: 1.0
 */
public class TraditionalTimer {

    public static void main(String[] args){
        Timer timer = new Timer();
        timer.schedule(new TimerTaskExam(), 5000);
    }

    //内部定时任务类
    static class TimerTaskExam extends TimerTask{

        /**
         * The action to be performed by this timer task.
         */
        @Override
        public void run() {
            System.out.println("炸");
            new Timer().schedule(new TimerTaskExam(), 4000, 4000);
        }
    }
}
