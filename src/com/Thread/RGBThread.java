package com.Thread;

import com.Data.DataContainer;

public class RGBThread implements Runnable  {

    private void t_sleep(int s) {
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    private void setRGB(int x, int y){
        DataContainer.data.setxRGBInts(x);//R
        DataContainer.data.setyRGBInts(y);//G
    }
    private void t_sys(int x, int y){
//        System.out.print ( DataContainer.data.getxRGBStrings()[x]);
//         System.out.println( DataContainer.data.getyRGBStrings()[y]);
    }

    public void run() {
       // System.out.println("RGBThread");
        while (true) {
            for (int i = 0; i < 4; i++) {
                switch (i) {
                    case 0:
                        setRGB(0,1);//RG
                        t_sys(0, 1);
                        t_sleep(DataContainer.data.GTime);
                        break;
                    case 1:
                        setRGB(0,2);//RB
                        t_sys(0,2);
                        t_sleep(DataContainer.data.BTime);
                        break;
                    case 2:
                        setRGB(1,0);//GR
                        t_sys(1,0);
                        t_sleep(DataContainer.data.GTime);
                        break;
                    case 3:
                        setRGB(2,0);//BR
                        t_sys(2,0);
                        t_sleep(DataContainer.data.BTime);
                        break;
                }
                Thread.yield();


            }

        }

    }
}