package com.UI;

import com.Data.DataContainer;

import javax.swing.*;
import java.awt.*;


public class MainJfame extends JFrame implements Runnable {

    private int[] xR = DataContainer.data.getxRRode();
    private JLabel[] jLabels = new JLabel[ 10 ];
    private JLabel[] jLabels0 = new JLabel[ 10 ];
    private ImageIcon BackstageIcon = new ImageIcon("./res/" + "蜂蜜浏览器_01" + ".png");
    private ImageIcon xlcarimageicon = new ImageIcon("./res/" + "蜂蜜浏览器_xLCar" + ".png");

    public MainJfame() {
        // setLayout(new FlowLayout());
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setVgap(0);
        flowLayout.setHgap(0);
        setSize(1000, 400);
        Container container = this.getContentPane();
        //container.setLayout(new BorderLayout());
        JPanel mainP = new JPanel();
        //mainP.setLayout(new BorderLayout());
        container.add(mainP);
        JPanel[] p = new JPanel[ 5 ];
        for (int i = 0; i < p.length; i++) {
            p[ i ] = new JPanel();
           // p[ i ].setLayout(flowLayout);
            mainP.add(p[ i ]);
        }
        for (int i = 0; i < xR.length - 1; i++) {
            jLabels[ i ] = new JLabel();
            jLabels[ i ].setIcon(BackstageIcon);
//            jLabels0[ i ] = new JLabel(String.valueOf(xR[ i ]));
//            p[ 0 ].add(jLabels0[ i ], BorderLayout.SOUTH);
            p[ 1 ].add(jLabels[ i ] );
        }
        //pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < xR.length - 1; i++) {
                if (xR[ i ] == 0) {
                    jLabels[ i ].setIcon(BackstageIcon);
                } else {
                    jLabels[ i ].setIcon(xlcarimageicon);
                }
            }
        }
    }
}
