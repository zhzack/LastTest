package com.Main;

import com.UI.FirstJfame;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;


public class Main  {

    public static void main(String[] args) {
        //  new MainThread().start();
        initGobalFont(new Font("微软雅黑", Font.BOLD, 25));
        FirstJfame.StartAllThread();

    }
    private static void initGobalFont(Font font) {
        FontUIResource fontResource = new FontUIResource(font);
        for(Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if(value instanceof FontUIResource) {
                System.out.println(key);
                UIManager.put(key, fontResource);
            }
        }
    }
}
