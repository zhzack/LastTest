package com.UI;

import com.Data.DataContainer;
import com.Thread.AddCarThread;
import com.Thread.CarThread;
import com.Thread.RGBThread;

import javax.swing.*;
import java.awt.*;


public class FirstJfame extends JFrame implements Runnable {

    private int[] xR = DataContainer.data.getxRRode();
    private int[] xL = DataContainer.data.getxLRode();
    private int[] yD = DataContainer.data.getyLeftRode();
    private int[] yU = DataContainer.data.getyURode();

    private JLabel[] xRjlabels = new JLabel[ 10 ];
    private JLabel[] xLjlabels = new JLabel[ 10 ];
    private JLabel[] yUjlabels = new JLabel[ 8 ];
    private JLabel[] yDjlabels = new JLabel[ 8 ];


    private ImageIcon BackstageIcon = new ImageIcon("./res/" + "蜂蜜浏览器_01" + ".png");
    private ImageIcon DogsIcon = new ImageIcon("./res/" + "Dogs" + ".gif");
    private ImageIcon xlcarimageIcon = new ImageIcon("./res/" + "蜂蜜浏览器_xRCar" + ".png");
    private ImageIcon xrcarimageicon = new ImageIcon("./res/" + "蜂蜜浏览器_xLCar" + ".png");
    private ImageIcon yucarimageicon = new ImageIcon("./res/" + "蜂蜜浏览器_yDCar" + ".png");
    private ImageIcon ydcarimageicon = new ImageIcon("./res/" + "蜂蜜浏览器_yUCar" + ".png");



    public static void StartAllThread() {
        Runnable rgbTask = new RGBThread();
        Runnable addCarTask = new AddCarThread();
        Runnable carTask = new CarThread();
        // Runnable jframeTask = new MainJfame();
        FirstJfame firstJfame0 = new FirstJfame();
       
        firstJfame0.setVisible(true);


        Thread rgbThread = new Thread(rgbTask);
        Thread addCarThread = new Thread(addCarTask);
        Thread carThread = new Thread(carTask);
        //Thread jframeThread = new Thread(jframeTask);
        Thread firstThread = new Thread(firstJfame0);

        rgbThread.start();
        addCarThread.start();
        carThread.start();
        //jframeThread.start();
        firstThread.start();
    }

    private FirstJfame() {
        init();
        this.setSize(1095, 1095);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void init() {

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        addJlabels(yUjlabels, yDjlabels);
        addJlabels(xRjlabels, xLjlabels);
        JLabel dogJLabel=new JLabel();
        dogJLabel.setIcon(DogsIcon);
        GridBagConstraints s = new GridBagConstraints();//定义一个GridBagConstraints，
        s.fill = GridBagConstraints.NONE;
        s.gridwidth = 1;//该方法是设置组件水平所占用的格子数，如果为0，就说明该组件是该行的最后一个
        s.weightx = 0;//该方法设置组件水平的拉伸幅度，如果为0就说明不拉伸，不为0就随着窗口增大进行拉伸，0到1之间
        s.weighty = 0;//该方法设置组件垂直的拉伸幅度，如果为0就说明不拉伸，不为0就随着窗口增大进行拉伸，0到1之间


        for (int i = 0; i < yUjlabels.length; i++) {
            if (i < 4) {
                s.gridy = i;
                s.gridx = 4;
                layout.setConstraints(yDjlabels[ yUjlabels.length - i - 1 ], s);
                s.gridx = 5;
                layout.setConstraints(yUjlabels[ i ], s);
            } else {
                s.gridx = 4;
                s.gridy = i + 2;
                layout.setConstraints(yDjlabels[ yUjlabels.length - i - 1 ], s);
                s.gridx = 5;
                layout.setConstraints(yUjlabels[ i ], s);
            }
        }

        for (int i = 0; i < xRjlabels.length; i++) {
            s.gridy = 5;
            s.gridx = i;
            layout.setConstraints(xRjlabels[ i ], s);

            s.gridy = 4;
            layout.setConstraints(xLjlabels[ xRjlabels.length - i - 1 ], s);
        }
        s.gridy=8;
        s.gridx=8;
        s.weightx=2;
        layout.setConstraints(dogJLabel,s);
    }

    private void addJlabels(JLabel[] yUjlabels, JLabel[] yDjlabels) {
        for (int i = 0; i < yUjlabels.length; i++) {
            yUjlabels[ i ] = new JLabel();
            yUjlabels[ i ].setIcon(BackstageIcon);
            this.add(yUjlabels[ i ]);
            yDjlabels[ i ] = new JLabel();
            yDjlabels[ i ].setIcon(BackstageIcon);
            this.add(yDjlabels[ i ]);

        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < xR.length - 1; i++) {
                if (DataContainer.data.getxRGBInts() == 0) {
                    if (i < 4 || i > 5) {
                        move0(i, xR, xRjlabels, xrcarimageicon, xL, xLjlabels, xlcarimageIcon);
                    }

                } else {
                    move0(i, xR, xRjlabels, xrcarimageicon, xL, xLjlabels, xlcarimageIcon);
                }

                Thread.yield();
            }
            if (DataContainer.data.getyRGBInts() != 0) {

                move1(yU, xLjlabels, xRjlabels);

                move1(yD, xRjlabels, xLjlabels);

            }
            for (int i = 0; i < yU.length; i++) {
                if (i < 4) {
                    move0(i, yU, yUjlabels, yucarimageicon, yD, yDjlabels, yucarimageicon);

                }
                if (i > 5 && i < 10) {
                    if (yU[ i ] == 0) {
                        yUjlabels[ i - 2 ].setIcon(BackstageIcon);
                    } else {
                        yUjlabels[ i - 2 ].setIcon(yucarimageicon);
                    }
                    if (yD[ i ] == 0) {
                        yDjlabels[ i - 2 ].setIcon(BackstageIcon);
                    } else {
                        yDjlabels[ i - 2 ].setIcon(yucarimageicon);
                    }
                }
            }

        }
    }

    private void move1(int[] yD, JLabel[] xRjlabels, JLabel[] xLjlabels) {
        if (yD[ 4 ] == 0) {
            xRjlabels[ 4 ].setIcon(BackstageIcon);
        } else {
            xRjlabels[ 4 ].setIcon(yucarimageicon);
        }
        if (yD[ 5 ] == 0) {
            xLjlabels[ 5 ].setIcon(BackstageIcon);
        } else {
            xLjlabels[ 5 ].setIcon(yucarimageicon);
        }
    }

    private void move0(int i, int[] yU, JLabel[] yUjlabels, ImageIcon yucarimageicon, int[] yD, JLabel[] yDjlabels, ImageIcon yucarimageicon2) {
        if (yU[ i ] == 0) {
            yUjlabels[ i ].setIcon(BackstageIcon);
        } else {
            yUjlabels[ i ].setIcon(yucarimageicon);
        }
        if (yD[ i ] == 0) {
            yDjlabels[ i ].setIcon(BackstageIcon);
        } else {
            yDjlabels[ i ].setIcon(yucarimageicon2);
        }
    }


}
