package com.Thread;

import com.Data.DataContainer;


public class CarThread implements Runnable {
    public void run() {
       // System.out.println("CarThread");
        int[] xR = DataContainer.data.getxRightRode();
        int[] xL = DataContainer.data.getyLeftRode();
        int[] yU = DataContainer.data.getyLeftRode();
        int[] yD = DataContainer.data.getyRightRode();
        while (true) {
            change(xR);
            change(xL);
            change(yU);
            change(yD);

            t_sleep(300);
        }
    }

    public boolean isRuning() {//判断红绿灯
        int x = DataContainer.data.getxRGBInts();
        return x == 0;
    }

    private void t_sleep(int s) {//线程休眠
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private int[] change(int[] xR) {
        xR[ 0 ] = 0;
        if (isRuning()) {//红灯时
            for (int i = 1; i < xR.length; i++) {
//                xR[ 0 ] = 0;
                if (i != 6) {
                    if (xR[ i - 1 ] == 0) {
                        xR[ i - 1 ] = xR[ i ];
                        xR[ i ] = 0;
                        if (i == (xR.length - 1)) {
                            xR[ xR.length - 1 ] = 0;
                        }
                    }
                }
            }
        } else {
            for (int i = 1; i < xR.length; i++) {

                if (xR[ i - 1 ] == 0) {
                    xR[ i - 1 ] = xR[ i ];
                    xR[ i ] = 0;
                }
                if (i == (xR.length - 1)) {
                    xR[ xR.length - 1 ] = 0;
                }
            }
        }
        // System.out.println( Arrays.toString(xR) + DataContainer.data.getxRGBInts());
        return xR;
    }
}
