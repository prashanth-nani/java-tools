package com.quintlr.net;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author prashanth
 */
public class QConnection {

    private String urlString = null;
    private URL connectionUrl= null;
    private URLConnection urlConn = null;
    private HttpURLConnection httpConn = null;
    
    public QConnection(String url) throws IOException{
        this(url, null);
    }
    
    public QConnection(String url, QProxy qproxy) throws MalformedURLException, IOException {
        this.urlString = url;
        connectionUrl = new URL(url);
        if(qproxy != null)
            urlConn = connectionUrl.openConnection(qproxy.getProxyObject());
        else
            urlConn = connectionUrl.openConnection();
        httpConn = (HttpURLConnection) urlConn;
    }

    public String getUrlString() {
        return urlString;
    }

    public URL getDownloadUrl() {
        return connectionUrl;
    }
    
    public URLConnection getUrlConn() {
        return urlConn;
    }

    public HttpURLConnection getHttpConn() {
        return httpConn;
    }
    
}
