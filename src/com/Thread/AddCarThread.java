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
            int[] xR = DataContainer.data.getxRightRode();
            int[] xL=DataContainer.data.getyLeftRode();
            int[] yU=DataContainer.data.getyLeftRode();
            int[] yD=DataContainer.data.getyRightRode();

            DataContainer.data.setxRightRode(addcar(xR));
            DataContainer.data.setxLeftRode( addcar(xL));
            DataContainer.data.setyRightRode(addcar(yU));
            DataContainer.data.setyRightRode(addcar(yD));

            t_sleep(DataContainer.data.AddcarTime);
            Thread.yield();
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
