package com.quintlr.tools;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prashanth
 */
public class MergeFile {

    private File firstFile = null;
    private File secondFile = null;
    
    public void merge(String firstFilePath, String secondFilePath){
        firstFile = new File(firstFilePath);
        secondFile = new File(secondFilePath);
        
        if(firstFile.exists())
        {
            try(InputStream in = new FileInputStream(secondFile); 
                BufferedInputStream secondFileInputStream = new BufferedInputStream(in);
                FileOutputStream firstFileOutputStream = new FileOutputStream(firstFile, true)){
                
                byte data[] = new byte[1024];
                int bytesRead = -1;
                
                while((bytesRead = secondFileInputStream.read(data)) != -1){
                    firstFileOutputStream.write(data);
                }
            } catch (IOException ex) {
                Logger.getLogger(MergeFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
