package com.Thread;

import com.Data.DataContainer;

import java.util.Arrays;


public class CarThread implements Runnable {
    public void run() {
        // System.out.println("CarThread");
        int[] xR = DataContainer.data.getxRRode();
        int[] xL = DataContainer.data.getxLRode();
        int[] yU = DataContainer.data.getyLeftRode();
        int[] yD = DataContainer.data.getyURode();

        while (true) {
            if (!DataContainer.data.Stop) {
                DataContainer.data.setxRRode(xchange(xR));
                DataContainer.data.setxLRode(xchange(xL));

                DataContainer.data.setyLeftRode(ychange(yU));
                DataContainer.data.setyURode(ychange(yD));

                for (int x : xL) {
                    // System.out.print(x);
                }
                t_sleep(200);
            }
            t_sleep(30);

        }
    }

    private boolean isXRuning() {//判断红绿灯
        int x = DataContainer.data.getxRGBInts();
        return x == 0;
    }

    private boolean isYRuning() {//判断红绿灯
        int y = DataContainer.data.getyRGBInts();
        return y == 0;
    }

    private void t_sleep(int s) {//线程休眠
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private int[] xchange(int[] xr) {
        xr[ 0 ] = 0;
        if (isXRuning()) {//红灯时
            carmovex(xr);
        } else {
            carMove(xr);
        }
        // System.out.println(Arrays.toString(DataContainer.data.getyURode()) + DataContainer.data.getxRGBInts());
        return xr;
    }

    private int[] ychange(int[] xr) {
        xr[ 0 ] = 0;
        if (isYRuning()) {//红灯时
            carmovex(xr);
        } else {
            carMove(xr);
        }
        //System.out.println(Arrays.toString(DataContainer.data.getyURode()) + DataContainer.data.getxRGBInts());
        return xr;
    }

    private void carmovex(int[] xr) {
        for (int i = 1; i < xr.length; i++) {
//                xR[ 0 ] = 0;
            if (i != 6) {
                if (xr[ i - 1 ] == 0) {
                    xr[ i - 1 ] = xr[ i ];
                    xr[ i ] = 0;
                    if (i == (xr.length - 1)) {
                        xr[ xr.length - 1 ] = 0;
                    }
                }
            }
        }
    }

    private void carMove(int[] xr) {
        for (int i = 1; i < xr.length; i++) {

            if (xr[ i - 1 ] == 0) {
                xr[ i - 1 ] = xr[ i ];
                xr[ i ] = 0;
            }
            if (i == (xr.length - 1)) {
                xr[ xr.length - 1 ] = 0;
            }
        }
    }
}
