
package com.quintlr.net;

import java.io.IOException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author prashanth
 */
public class HttpHeader {
    
    private Map<String,List<String>> headerFields = null;
    
    public HttpHeader(String url) throws IOException{
        this(url, null);
    }
    
    public HttpHeader(String url, QProxy qproxy) throws IOException{
        HttpURLConnection httpConn = getHttpConn(url, qproxy);
        if(qproxy != null && qproxy.requireAuth)
            Authenticator.setDefault(qproxy.getAuthenticator());
        
        headerFields = httpConn.getHeaderFields();
    }
    
    public HttpHeader(HttpURLConnection httpConn){
        this(httpConn, null);
    }
    
    public HttpHeader(HttpURLConnection httpConn, QProxy qproxy){
        if(qproxy != null && qproxy.requireAuth)
            Authenticator.setDefault(qproxy.getAuthenticator());
        
        headerFields = httpConn.getHeaderFields();
    }
    
    private static HttpURLConnection getHttpConn(String url, QProxy qproxy) throws IOException{
        QConnection con = new QConnection(url, qproxy);
        HttpURLConnection httpConn =  con.getHttpConn();
        return httpConn;
    }
    
    public boolean getAllowAcceptRanges(HttpURLConnection httpConn, QProxy qproxy){
        return headerFields.get("Accept-Ranges").get(0).equals("bytes");
    }
    
    public String getContentLength() {
        return headerFields.get("Content-Length").get(0);
    }
    
    public String getContentType() {
        return headerFields.get("Content-Type").get(0);
    }
}