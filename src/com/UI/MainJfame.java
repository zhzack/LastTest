package com.UI;

import com.Data.DataContainer;
import com.Thread.AddCarThread;
import com.Thread.CarThread;
import com.Thread.RGBThread;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainJfame extends JFrame implements Runnable {

    private final int[] xR = DataContainer.data.getxRRode();
    private final int[] xL = DataContainer.data.getxLRode();
    private final int[] yD = DataContainer.data.getyLeftRode();
    private final int[] yU = DataContainer.data.getyURode();

    private final JLabel[] xRjlabels = new JLabel[ 10 ];
    private final JLabel[] xLjlabels = new JLabel[ 10 ];
    private final JLabel[] yUjlabels = new JLabel[ 8 ];
    private final JLabel[] yDjlabels = new JLabel[ 8 ];


    private final ImageIcon BackstageIcon = new ImageIcon("./res/" + "蜂蜜浏览器_01" + ".png");
    private final ImageIcon DogsIcon = new ImageIcon("./res/" + "Dogs" + ".gif");
    private final ImageIcon xlcarimageIcon = new ImageIcon("./res/" + "蜂蜜浏览器_xRCar" + ".png");
    private final ImageIcon xrcarimageicon = new ImageIcon("./res/" + "蜂蜜浏览器_xLCar" + ".png");
    private final ImageIcon yucarimageicon = new ImageIcon("./res/" + "蜂蜜浏览器_yUCar" + ".png");
    private final ImageIcon ydcarimageicon = new ImageIcon("./res/" + "蜂蜜浏览器_yDCar" + ".png");
    private final JLabel jLabelTime = new JLabel();
    private final JLabel xJLabelRGY = new JLabel();
    private final JLabel yJLabelRGY = new JLabel();

    private static final Thread[] threads = new Thread[ 5 ];//线程数组

    public static void StartAllThread() {
        Runnable rgbTask = new RGBThread();
        Runnable addCarTask = new AddCarThread();
        Runnable carTask = new CarThread();
        MainJfame mainJfame0 = new MainJfame();
        mainJfame0.setVisible(true);


        Thread rgbThread = new Thread(rgbTask);
        Thread addCarThread = new Thread(addCarTask);
        Thread carThread = new Thread(carTask);
        Thread firstThread = new Thread(mainJfame0);

        threads[ 0 ] = rgbThread;
        threads[ 1 ] = addCarThread;
        threads[ 2 ] = carThread;
        for (int i = 0; i < 3; i++) {
            threads[ i ].start();
        }
        firstThread.start();
    }

    private MainJfame() {
        init();
        setUndecorated(true);
        this.setSize(1095, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void init() {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        JButton stopjButton = new JButton("暂停");
        JButton startjButton = new JButton("开始");
        JButton exitjButton = new JButton("退出");

        xJLabelRGY.setBackground(Color.white);
        yJLabelRGY.setBackground(Color.white);
        add(jLabelTime);
        add(startjButton);
        add(exitjButton);
        add(xJLabelRGY);
        add(yJLabelRGY);
        addJlabels(yUjlabels, yDjlabels);
        addJlabels(xRjlabels, xLjlabels);
        JLabel dogJLabel = new JLabel();
        add(dogJLabel);
        dogJLabel.setIcon(DogsIcon);
        GridBagConstraints s = new GridBagConstraints();//定义一个GridBagConstraints，
        s.fill = GridBagConstraints.NONE;
        s.gridwidth = 1;//该方法是设置组件水平所占用的格子数，如果为0，就说明该组件是该行的最后一个
        s.weightx = 0;//该方法设置组件水平的拉伸幅度，如果为0就说明不拉伸，不为0就随着窗口增大进行拉伸，0到1之间
        s.weighty = 0;//该方法设置组件垂直的拉伸幅度，如果为0就说明不拉伸，不为0就随着窗口增大进行拉伸，0到1之间

        stopjButton.addActionListener(e -> {
            DataContainer.data.Stop = true;//通过修改来间接控制其他线程的运行（run方法中嵌套if语句）
        });
        startjButton.addActionListener(e -> DataContainer.data.Stop = false);
        exitjButton.addActionListener(e -> System.exit(0));
        add(stopjButton);
        s.gridy = 7;
        s.gridx = 6;
        layout.setConstraints(stopjButton, s);
        s.gridx = 7;
        layout.setConstraints(startjButton, s);
        s.gridx = 8;
        layout.setConstraints(exitjButton, s);
        for (int i = 0; i < yUjlabels.length; i++) {
            if (i < 4) {
                s.gridy = i;
                s.gridx = 4;
            } else {
                s.gridx = 4;
                s.gridy = i + 2;
            }
            layout.setConstraints(yDjlabels[ yUjlabels.length - i - 1 ], s);
            s.gridx = 5;
            layout.setConstraints(yUjlabels[ i ], s);
        }

        for (int i = 0; i < xRjlabels.length; i++) {
            s.gridy = 5;
            s.gridx = i;
            layout.setConstraints(xRjlabels[ i ], s);

            s.gridy = 4;
            layout.setConstraints(xLjlabels[ xRjlabels.length - i - 1 ], s);
        }
        s.gridy = 8;
        s.gridx = 1;
        // s.weightx = 5;
        s.gridwidth = 3;
        layout.setConstraints(dogJLabel, s);
        s.gridy = 1;
        s.gridx = 1;
        layout.setConstraints(jLabelTime, s);
        s.gridy = 1;
        s.gridx = 6;
        layout.setConstraints(xJLabelRGY, s);
        s.gridy = 2;
        layout.setConstraints(yJLabelRGY, s);
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

    private void ShowRGY() {
        int index = DataContainer.data.getxRGBInts();
        if (index == 0) {
            xJLabelRGY.setForeground(Color.red);
            xJLabelRGY.setText("东西路：红灯");
        } else if (index == 1) {
            xJLabelRGY.setText("东西路：绿灯");
            xJLabelRGY.setForeground(Color.GREEN);
        } else if (index == 2) {
            xJLabelRGY.setText("东西路：黄灯");
            xJLabelRGY.setForeground(Color.YELLOW);
        }
        int index1 = DataContainer.data.getyRGBInts();
        if (index1 == 0) {
            yJLabelRGY.setForeground(Color.red);
            yJLabelRGY.setText("南北路：红灯");
        } else if (index1 == 1) {
            yJLabelRGY.setText("南北路：绿灯");
            yJLabelRGY.setForeground(Color.GREEN);
        } else if (index1 == 2) {
            yJLabelRGY.setText("南北路：黄灯");
            yJLabelRGY.setForeground(Color.YELLOW);
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
            ShowRGY();
            SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
            sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
            Date date = new Date();// 获取当前时间
            jLabelTime.setText("时间：" + sdf.format(date));
            //System.out.println("现在时间：" + sdf.format(date)); // 输出已经格式化的现在时间（24小时制）
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
                    move0(i, yU, yUjlabels, yucarimageicon, yD, yDjlabels, ydcarimageicon);

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
                        yDjlabels[ i - 2 ].setIcon(ydcarimageicon);
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
            xLjlabels[ 5 ].setIcon(ydcarimageicon);
        }
    }

    private void move0(int i, int[] yU, JLabel[] yUjlabels, ImageIcon yucarimageicon, int[] yD, JLabel[] yDjlabels, ImageIcon ydcarimageicon2) {
        if (yU[ i ] == 0) {
            yUjlabels[ i ].setIcon(BackstageIcon);
        } else {
            yUjlabels[ i ].setIcon(yucarimageicon);
        }
        if (yD[ i ] == 0) {
            yDjlabels[ i ].setIcon(BackstageIcon);
        } else {
            yDjlabels[ i ].setIcon(ydcarimageicon2);
        }
    }
}
