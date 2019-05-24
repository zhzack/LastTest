package com.UI;

import javax.swing.*;
import java.awt.*;

public class GraphicsT {


    /**
     * 窗口
     */
    public static class MyFrame extends JFrame {

        static final String TITLE = "Java图形绘制";

        static final int WIDTH = 250;
        static final int HEIGHT = 300;

        public MyFrame() {
            super();
            initFrame();
        }

        private void initFrame() {
            // 设置 窗口标题 和 窗口大小
            setTitle(TITLE);
            setSize(WIDTH, HEIGHT);

            // 设置窗口关闭按钮的默认操作(点击关闭时退出进程)
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            // 把窗口位置设置到屏幕的中心
            setLocationRelativeTo(null);

            // 设置窗口的内容面板
            MyPanel panel = new MyPanel(this);
            setContentPane(panel);
        }

    }

    /**
     * 内容面板
     */
    public static class MyPanel extends JPanel {

        private MyFrame frame;

        MyPanel(MyFrame frame) {
            super();
            this.frame = frame;
        }

        /**
         * 绘制面板的内容: 创建 JPanel 后会调用一次该方法绘制内容,
         * 之后如果数据改变需要重新绘制, 可调用 updateUI() 方法触发
         * 系统再次调用该方法绘制更新 JPanel 的内容。
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // 重新调用 Graphics 的绘制方法绘制时将自动擦除旧的内容
 
            /* 自行打开下面注释查看各绘制效果 */

            // 1. 线段 / 折线
            drawLine(g);


        }

        /**
         * 1. 线段 / 折线
         */
        private void drawLine(Graphics g) {
            frame.setTitle("1. 线段 / 折线");

            // 创建 Graphics 的副本, 需要改变 Graphics 的参数,
            // 这里必须使用副本, 避免影响到 Graphics 原有的设置
            Graphics2D g2d = (Graphics2D) g.create();

            // 抗锯齿
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // 设置画笔颜色
            g2d.setColor(Color.RED);

            Dimension d = getSize();
            // 1. 两点绘制线段: 点(20, 50), 点(200, 50)
            g2d.drawLine(0, 50, d.width, 50);

            // 3. 两点绘制线段（设置线宽为5px）: 点(50, 150), 点(200, 150)
            BasicStroke bs1 = new BasicStroke(5);       // 笔画的轮廓（画笔宽度/线宽为5px）
            g2d.setStroke(bs1);
            g2d.drawLine(50, 150, 200, 150);

            // 4. 绘制虚线: 将虚线分为若干段（ 实线段 和 空白段 都认为是一段）, 实线段 和 空白段 交替绘制,
            //             绘制的每一段（包括 实线段 和 空白段）的 长度 从 dash 虚线模式数组中取值（从首
            //             元素开始循环取值）, 下面数组即表示每段长度分别为: 5px, 10px, 5px, 10px, ...
            float[] dash = new float[]{5, 10};
            BasicStroke bs2 = new BasicStroke(
                    1,                      // 画笔宽度/线宽
                    BasicStroke.CAP_SQUARE,
                    BasicStroke.JOIN_MITER,
                    10.0f,
                    dash,                   // 虚线模式数组
                    0.0f
            );
            g2d.setStroke(bs2);
            g2d.drawLine(50, 200, 200, 200);

            // 自己创建的副本用完要销毁掉
            g2d.dispose();
        }


    }

}
