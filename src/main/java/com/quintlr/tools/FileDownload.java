package com.quintlr.tools;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.quintlr.net.QProxy;
/**
 *
 * @author prashanth
 */
public class FileDownload implements Runnable{

    private String url = null;
    private URL downloadUrl = null;

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUrl() {
        return this.url;
    }

    public void download(String url, QProxy qproxy) {
        try {
            this.url = url;
            this.downloadUrl = new URL(url);

            HttpURLConnection httpConn = (HttpURLConnection) downloadUrl.openConnection(qproxy.getProxyObject());
        } catch (MalformedURLException ex) {
            Logger.getLogger(FileDownload.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileDownload.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
