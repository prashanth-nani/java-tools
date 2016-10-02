/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quintlr.tools;

import com.quintlr.net.QConnection;
import com.quintlr.net.QProxy;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prashanth
 */
public class PartFileThread implements Runnable {

    private String url = null;
    private long startByte = 0;
    private long lastByte = 0;
    private QProxy qproxy = null;
    private Integer responseCode = null;
    private Integer partNum = 1;
    
    public PartFileThread(String url, long startByte, long lastByte, QProxy qproxy) {
        this.url = url;
        this.startByte = startByte;
        this.lastByte = lastByte;
        this.qproxy = qproxy;
    }

    @Override
    public void run() {
        try {
            QConnection conn = new QConnection(url, qproxy);
            
            if(qproxy != null)
                Authenticator.setDefault(qproxy.getAuthenticator());
            
            HttpURLConnection httpConn = conn.getHttpConn();
            httpConn.setRequestProperty("Range", "bytes=" + startByte + "-" + lastByte);
            responseCode = httpConn.getResponseCode();
            
            if(responseCode == 200 || responseCode == 206)
            {
                InputStream is = httpConn.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(is);
                
                OutputStream out = new FileOutputStream(startByte+"-"+lastByte+".part"+partNum);
                BufferedOutputStream bos = new BufferedOutputStream(out);
                
                System.out.println("Starting download of part "+startByte+"-"+lastByte);
                
                byte data[] = new byte[512];
                int bytesRead = -1, completedBytes = 0;
                
                while((bytesRead = bis.read(data)) != -1){
                    bos.write(data);
                    completedBytes += bytesRead;
                }
                
                bos.close();
                bos.flush();
                
                out.close();
                out.flush();
                
                bis.close();
                is.close();
                System.out.println("Completed downloading part "+startByte+"-"+lastByte+" Size="+completedBytes+" Bytes");
            }
            else{
                System.out.println("Error while downloading part "+startByte+"-"+lastByte);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(PartFileThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
