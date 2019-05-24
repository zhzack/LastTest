package com.UI;

import com.Data.DataContainer;

import javax.swing.*;
import java.awt.*;


public class MainJfame extends JFrame implements Runnable {
    private int[] xR = DataContainer.data.getxRightRode();
    private JLabel[] jLabels = new JLabel[ 20 ];
    private JPanel[] p = new JPanel[ 5 ];
    private ImageIcon BackstageIcon = new ImageIcon("./res/" + "蜂蜜浏览器_01" + ".png");
    private ImageIcon xlcarimageicon = new ImageIcon("./res/" + "蜂蜜浏览器_xLCar" + ".png");

    public MainJfame() {
        setLayout(new FlowLayout());
        setSize(1000,400);
        Container container = this.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        for (int i = 0; i < p.length; i++) {
            p[ i ] = new JPanel();
            p[i].setLayout(new FlowLayout());
           // p[i].setBounds(0,0,1920,1080);
            container.add(p[ i ]);
        }

        for (int i = 0; i < xR.length - 1; i++) {
            jLabels[ i ] = new JLabel( );
            //jLabels[ i ].setIcon(BackstageIcon);
            p[0].add(jLabels[i]);
            p[1].add(jLabels[i]);
            p[2].add(jLabels[i]);

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
                //jLabels[ i ].setText(xR[ i ] + "");
                if (xR[ i ] == 0) {
                     jLabels[ i ].setIcon(BackstageIcon);
                   // jLabels[ i ].setDisplayedMnemonic(20);
                } else {
                     jLabels[ i ].setIcon(xlcarimageicon);
                }

            }
        }
    }
}
