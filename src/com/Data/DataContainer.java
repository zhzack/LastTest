package com.Data;

public class DataContainer {
    public static class data {
        //public static int RTime = 10000;
        public static int GTime = 10000;
        public static int BTime = 1000;
        public static int AddcarTime=1000;
        /**
         * x红绿灯标识
         */
        static int xRGBInts;
        /**
         * y红绿灯标识
         */
        static int yRGBInts;
        /**
         * x红绿灯展示
         */
        static String[] xRGBStrings = {"xR", "xG", "xB"};
        /**
         * y红绿灯展示
         */
        static String[] yRGBStrings = {"yR", "yG", "yB"};

        /**
         * xLeft方向
         */
        static int[] xLeftRode = new int[ 11 ];
        /**
         * xRight方向
         */
        static int[] xRightRode = new int[ 11];
        /**
         * yLeft方向
         */
        static int[] yLeftRode = new int[ 11 ];
        /**
         * yRight方向
         */
        static int[] yRightRode = new int[ 11 ];

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

        public static String[] getxRGBStrings() {
            return xRGBStrings;
        }

        public static void setxRGBStrings(String[] xRGBStrings) {
            data.xRGBStrings = xRGBStrings;
        }

        public static String[] getyRGBStrings() {
            return yRGBStrings;
        }

        public static void setyRGBStrings(String[] yRGBStrings) {
            data.yRGBStrings = yRGBStrings;
        }

        public static int[] getxLeftRode() {
            return xLeftRode;
        }

        public static void setxLeftRode(int[] xLeftRode) {
            data.xLeftRode = xLeftRode;
        }

        public static int[] getxRightRode() {
            return xRightRode;
        }

        public static void setxRightRode(int[] xRightRode) {
            data.xRightRode = xRightRode;
        }

        public static int[] getyLeftRode() {
            return yLeftRode;
        }

        public static void setyLeftRode(int[] yLeftRode) {
            data.yLeftRode = yLeftRode;
        }

        public static int[] getyRightRode() {
            return yRightRode;
        }

        public static void setyRightRode(int[] yRightRode) {
            data.yRightRode = yRightRode;
        }

    }


}
