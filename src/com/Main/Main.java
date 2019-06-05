package com.Main;

import com.UI.MainJfame;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;


public class Main  {

    public static void main(String[] args) {
        initGobalFont(new Font("微软雅黑", Font.BOLD, 25));
        MainJfame.StartAllThread();

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
