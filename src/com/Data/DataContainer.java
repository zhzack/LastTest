package com.Data;

public class DataContainer {
    public static class data {
        //public static int RTime = 10000;
        public static boolean Stop=false;//通过修改来间接控制其他线程的运行（run方法中嵌套if语句）
        public static int GTime = 10000;
        public static int BTime = 1000;
        public static int AddcarTime=800;
        /**
         * x红绿灯标识
         */
        static int xRGBInts;
        /**
         * y红绿灯标识
         */
        static int yRGBInts;


        /**
         * xLeft方向
         */
        static int[] xLRode = new int[ 11 ];
        /**
         * xRight方向
         */
        static int[] xRRode = new int[ 11];
        /**
         * yLeft方向
         */
        static int[] yLeftRode = new int[ 11 ];
        /**
         * yRight方向
         */
        static int[] yURode = new int[ 11 ];

        public static int getxRGBInts() {
            return xRGBInts;
        }

        public static void setxRGBInts(int xRGBInts) {
            data.xRGBInts = xRGBInts;
        }

        public static int getyRGBInts() {
            return yRGBInts;
        }

        public static void setyRGBInts(int yRGBInts) {
            data.yRGBInts = yRGBInts;
        }

        public static int[] getxLRode() {
            return xLRode;
        }

        public static void setxLRode(int[] xLRode) {
            data.xLRode = xLRode;
        }

        public static int[] getxRRode() {
            return xRRode;
        }

        public static void setxRRode(int[] xRRode) {
            data.xRRode = xRRode;
        }


        public static int[] getyLeftRode() {
            return yLeftRode;
        }

        public static void setyLeftRode(int[] yLeftRode) {
            data.yLeftRode = yLeftRode;
        }

        public static int[] getyURode() {
            return yURode;
        }

        public static void setyURode(int[] yURode) {
            data.yURode = yURode;
        }

    }


}
