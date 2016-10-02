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
public class Main {
    public static void main(String[] args) throws InterruptedException {
        FileDownload f = new FileDownload();
        f.download("http://localhost/test/1.mp3", null);
    }
}
