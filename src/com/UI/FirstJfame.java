package com.UI;

import com.Data.DataContainer;

import javax.swing.*;
import java.awt.*;


public class FirstJfame extends JFrame implements Runnable {

    private int[] xR = DataContainer.data.getxRightRode();
    private JLabel[] jLabels = new JLabel[ 10 ];
    private ImageIcon BackstageIcon = new ImageIcon("./res/" + "蜂蜜浏览器_01" + ".png");
    private ImageIcon xLCar = new ImageIcon("./res/" + "蜂蜜浏览器_xLCar" + ".png");

    public FirstJfame() {
//        Container container = new Container();
//       // container.setLayout(new FlowLayout());
//        JPanel[] jPanels = new JPanel[ 10 ];
//        for (int i = 0; i < jPanels.length; i++) {
//            jPanels[ i ] = new JPanel();
//           // jPanels[ i ].setLayout(new BoxLayout(jPanels[ i ], BoxLayout.X_AXIS));
//            container.add(jPanels[ i ]);
//        }
//
//        //pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void run() {

    }
}
