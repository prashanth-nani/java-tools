/*
 *This class checks where the server accepts 'range: bytes=0-10' format or not.
 */
package com.quintlr.tools;

import com.quintlr.net.QConnection;
import com.quintlr.net.QProxy;
import java.io.IOException;
import java.net.Authenticator;
import java.net.HttpURLConnection;

/**
 *
 * @author prashanth
 */
public class RangeFieldCheck {
    public boolean getAllowAcceptRanges(String url) throws IOException{
        return RangeFieldCheck.this.getAllowAcceptRanges(url, null);
    }
    
    public boolean getAllowAcceptRanges(String url, QProxy qproxy) throws IOException{
        QConnection con = new QConnection(url, qproxy);
        
        HttpURLConnection httpConn =  con.getHttpConn();
        return RangeFieldCheck.this.getAllowAcceptRanges(httpConn, qproxy);
    }
    
    public boolean getAllowAcceptRanges(HttpURLConnection httpConn){
        return RangeFieldCheck.this.getAllowAcceptRanges(httpConn, null);
    }
    
    public boolean getAllowAcceptRanges(HttpURLConnection httpConn, QProxy qproxy){
        if(qproxy != null && qproxy.requireAuth)
            Authenticator.setDefault(qproxy.getAuthenticator());
        
        return httpConn.getHeaderField("Accept-Ranges").equals("bytes");
    }
}
