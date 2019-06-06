package com.Thread;

import com.Data.DataContainer;

public class RGBThread implements Runnable {

    private void t_sleep(int s) {
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void setRGB(int x, int y) {
        DataContainer.data.setxRGBInts(x);//R
        DataContainer.data.setyRGBInts(y);//G
    }


    public void run() {
        // System.out.println("RGBThread");
        while (true) {
            if (!DataContainer.data.Stop) {
                for (int i = 0; i < 4; i++) {
                    switch (i) {
                        case 0:
                            setRGB(0, 1);//RG
                            t_sleep(DataContainer.data.GTime);
                            break;
                        case 1:
                            setRGB(0, 2);//RB
                            t_sleep(DataContainer.data.BTime);
                            break;
                        case 2:
                            setRGB(1, 0);//GR
                            t_sleep(DataContainer.data.GTime);
                            break;
                        case 3:
                            setRGB(2, 0);//BR
                            t_sleep(DataContainer.data.BTime);
                            break;
                    }
                    Thread.yield();

                }
            }
            t_sleep(30);

        }

    }
}