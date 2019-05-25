package com.Thread;

import com.UI.FirstJfame;
import com.UI.MainJfame;

public class MainThread extends Thread {

    public void run() {
       // System.out.println("mainThread");

        //new MainJfame();
//        RGBThread rgbThread=new RGBThread();
//         rgbThread.start();
//        AddCarThread addCarThread=new AddCarThread();
//        addCarThread.start();
//        CarThread carThread = new CarThread();
//        carThread.start();
        Runnable rgbTask = new RGBThread();
        Runnable addCarTask = new AddCarThread();
        Runnable carTask = new CarThread();
        Runnable jframeTask = new MainJfame();
        Runnable firstJfame = new FirstJfame();

        Thread rgbThread = new Thread(rgbTask);
        Thread addCarThread = new Thread(addCarTask);
        Thread carThread = new Thread(carTask);
        //Thread jframeThread = new Thread(jframeTask);
        Thread firstThread = new Thread(firstJfame);

        rgbThread.start();
        addCarThread.start();
        carThread.start();
        //jframeThread.start();
       // firstThread.start();

    }
}
