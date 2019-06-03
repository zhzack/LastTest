package com.Thread;

import com.Data.DataContainer;


public class AddCarThread implements Runnable {


    private void t_sleep(int s_Time) {
        try {
            Thread.sleep(s_Time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
//        System.out.println("xR  ADD");
        while (true) {
            int[] xR = DataContainer.data.getxRRode();
            int[] xL = DataContainer.data.getxLRode();
            int[] yU = DataContainer.data.getyLeftRode();
            int[] yD = DataContainer.data.getyURode();

            DataContainer.data.setxRRode(addcar(xR));
            DataContainer.data.setxLRode(addcar(xL));
            DataContainer.data.setyLeftRode(addcar(yU));
            DataContainer.data.setyURode(addcar(yD));

            t_sleep(DataContainer.data.AddcarTime);
            //Thread.yield();
        }
    }

    private int[] addcar(int[] xR) {

        if (isRandom()) {
            if (xR[ xR.length - 1 ] == 0) {
                xR[ xR.length - 1 ] = 1;

            }
        }

        return xR;
    }

    private boolean isRandom() {
        return Math.random() < 0.5;
    }
}
