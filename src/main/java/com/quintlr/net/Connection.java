/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quintlr.net;

import java.io.IOException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author prashanth
 */
public class Connection {

    private String urlString = null;
    private URL connectionUrl= null;
    private HttpURLConnection httpConn = null;
    private final Authenticator auth = null;
    
    public Connection(String url) throws IOException{
        this(url, null);
    }
    
    public Connection(String url, QProxy qproxy) throws MalformedURLException, IOException {
        this.urlString = url;
        connectionUrl = new URL(url);
        httpConn = (HttpURLConnection) connectionUrl.openConnection(qproxy.getProxyObject());
        Authenticator.setDefault(auth);
        
    }

    public String getUrlString() {
        return urlString;
    }

    public URL getDownloadUrl() {
        return connectionUrl;
    }

    public HttpURLConnection getHttpConn() {
        return httpConn;
    }
    
}
