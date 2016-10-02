~~1. Create a class to check for 'Range' field support in response header from server.~~
2. If server doesn't support range file retrieval, create a method which uses single thread to download.

~~3. Complete merge file method.~~

4. Try avoiding overhead of merging part files after download using RandomAccessFile by specifying offset.

5. Complete PartFileThread and implement setter and getter methods for information retrieval from them regarding download status.

6. Think about the sudden crash and resume of fileDownload.. (Saving state periodically into DB or a file? or get info from the partfile sizes?)

7. Change Authenticator to return null if no authentication is not needed.

~~8. Change comment in HttpHeader.java~~

9. Check the accepted <a href="http://stackoverflow.com/questions/3428102/how-to-resume-an-interrupted-download-part-2]">SO Answer here</a> and implement those things in the code.
