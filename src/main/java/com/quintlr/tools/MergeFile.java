package com.quintlr.tools;

import java.io.File;

/**
 *
 * @author prashanth
 */
public class MergeFile {

    private String firstFilePath = null;
    private String secondFilePath = null;
    private File firstFile = null;
    private File secondFile = null;
    
    public void merge(String firstFilePath, String secondFilePath) {
        firstFile = new File(firstFilePath);
        secondFile = new File(secondFilePath);
        
        if(firstFile.exists())
        {
            
        }
    }
}
