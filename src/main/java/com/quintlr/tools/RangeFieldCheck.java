/*
 *This class checks where the server accepts 'range = bytes-from-to-' or not.
 */
package com.quintlr.tools;

import com.quintlr.net.QProxy;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prashanth
 */
public class RangeFieldCheck {
    public String getRangeHeaderField(String url){
        /* Use Connection class to make connections from com.quintlr.net package*/
        
//        try {
//            URL downloadUrl = new URL(url);
//            HttpURLConnection httpCon = (HttpURLConnection) downloadUrl.openConnection();
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(RangeFieldCheck.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return ""; //Return the response field value
    }
}
