package com.quintlr.tools;

import com.quintlr.net.HttpHeader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.quintlr.net.QProxy;
import java.net.Authenticator;
/**
 *
 * @author prashanth
 */
public class FileDownload {

    private String url = null;
    private URL downloadUrl = null;

    public String getUrl() {
        return this.url;
    }

    public void download(String url, QProxy qproxy) throws InterruptedException {
        try {
            this.url = url;
            this.downloadUrl = new URL(url);

            HttpURLConnection httpConn = (HttpURLConnection) downloadUrl.openConnection();
            if(qproxy != null)
                Authenticator.setDefault(qproxy.getAuthenticator());
            
            int len = httpConn.getContentLength();
            
            PartFileThread part1 = new PartFileThread(url, 0, len/2, qproxy);
            Thread t1 = new Thread(part1);
            t1.start();
            
            PartFileThread part2 = new PartFileThread(url, len/2 + 1, len-1,qproxy);
            Thread t2 = new Thread(part2);
            t2.start();
            
            t1.join();
            t2.join();
            
            System.out.println("Done!");
        } catch (MalformedURLException ex) {
            Logger.getLogger(FileDownload.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileDownload.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}