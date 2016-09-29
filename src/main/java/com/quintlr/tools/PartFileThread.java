/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quintlr.tools;

/**
 *
 * @author prashanth
 */
public class PartFileThread implements Runnable {

    long startByte = 0;
    long lastByte = 0;
    
    public PartFileThread(long startByte, long lastByte) {
        this.startByte = startByte;
        this.lastByte = lastByte;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
