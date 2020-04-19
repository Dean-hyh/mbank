package com.dean.demo.utils.ftp;

import com.dean.demo.pojo.info.FtpInfo;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/12/3 17:52
 */
public class FtpFileUtil {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static FTPClient ftp;

    /**
     * 获取ftp连接
     * @param f
     * @return
     * @throws Exception
     */
    public static boolean connectFtp(FtpInfo f) throws Exception{
        ftp=new FTPClient();
        boolean flag=false;
        int reply;
        try{
            ftp.connect(f.getHost(),f.getPort());
            //ftp登陆
            ftp.login(f.getUsername(), f.getPassword());
            //设置文件传输类型
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            //检查延时
            reply = ftp.getReplyCode();
            //如果延时不在200到300之间，就关闭连接
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return flag;
            }
            ftp.changeWorkingDirectory(f.getRemoteDir());
            flag = true;
            return flag;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 关闭ftp连接
     */
    public static void closeFtp(){
        if (ftp!=null && ftp.isConnected()) {
            try {
                try {
                    ftp.logout();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ftp.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ftp上传文件
     * @param f
     * @throws Exception
     */
    public static void upload(File f) throws Exception{
        if (f.isDirectory()) {
            ftp.makeDirectory(f.getName());
            ftp.changeWorkingDirectory(f.getName());
            //返回目录名和文件名组成的字符串数组
            String[] files=f.list();
            for(String fstr : files){
                File file1=new File(f.getPath()+"/"+fstr);
                if (file1.isDirectory()) {
                    upload(file1);
                    ftp.changeToParentDirectory();
                }else{
                    File file2=new File(f.getPath()+"/"+fstr);
                    FileInputStream input=new FileInputStream(file2);
                    ftp.storeFile(file2.getName(),input);
                    input.close();
                }
            }
        }else{
            File file2=new File(f.getPath());
            FileInputStream input=new FileInputStream(file2);
            ftp.storeFile(file2.getName(),input);
            input.close();
        }
    }

    /**
     * 下载链接配置
     * @param f
     * @param localBaseDir 本地目录
     * @param remoteBaseDir 远程目录
     * @throws Exception
     */
    public static boolean startDown(FtpInfo f,String filename,String localBaseDir,String remoteBaseDir ) throws Exception{
        if (FtpFileUtil.connectFtp(f)) {

            try {
                FTPFile[] files = null;
                boolean changedir = ftp.changeWorkingDirectory(remoteBaseDir);
                if (changedir) {
                    ftp.setControlEncoding("GBK");
                    files = ftp.listFiles();
                    for (int i = 0; i < files.length; i++) {
                        try{
                            if(filename.equals(files[i].getName())){
                                downloadFile(files[i], localBaseDir, remoteBaseDir);
                                return true;
                            }
                        }catch(Exception e){
                            System.out.println(("<"+files[i].getName()+">下载失败"));
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("下载过程中出现异常");
            }
        }else{
            System.out.println("链接失败！");
        }
        return false;
    }


    /**
     *
     * 下载FTP文件
     * 当你需要下载FTP文件的时候，调用此方法
     * 根据获取的文件名，本地地址，远程地址进行下载
     *
     * @param ftpFile
     * @param relativeLocalPath
     * @param relativeRemotePath
     */
    private  static void downloadFile(FTPFile ftpFile, String relativeLocalPath,String relativeRemotePath) {
        if (ftpFile.isFile()) {
            if (ftpFile.getName().indexOf("?") == -1) {
                OutputStream outputStream = null;
                try {
                    File entryDir = new File(relativeLocalPath);
                    //如果文件夹路径不存在，则创建文件夹
                    if (!entryDir.exists() || !entryDir.isDirectory())
                    {
                        entryDir.mkdirs();
                    }
                    File locaFile= new File(relativeLocalPath+ ftpFile.getName());
                    //判断文件是否存在，存在则返回
                    if(locaFile.exists()){
                        return;
                    }else{
                        outputStream = new FileOutputStream(relativeLocalPath+ ftpFile.getName());
                        ftp.retrieveFile(ftpFile.getName(), outputStream);
                        outputStream.flush();
                        outputStream.close();
                    }
                } catch (Exception e) {

                } finally {
                    try {
                        if (outputStream != null){
                            outputStream.close();
                        }
                    } catch (IOException e) {

                    }
                }
            }
        } else {
            String newlocalRelatePath = relativeLocalPath + ftpFile.getName();
            String newRemote = new String(relativeRemotePath+ ftpFile.getName().toString());
            File fl = new File(newlocalRelatePath);
            if (!fl.exists()) {
                fl.mkdirs();
            }
            try {
                newlocalRelatePath = newlocalRelatePath + '/';
                newRemote = newRemote + "/";
                String currentWorkDir = ftpFile.getName().toString();
                boolean changedir = ftp.changeWorkingDirectory(currentWorkDir);
                if (changedir) {
                    FTPFile[] files = null;
                    files = ftp.listFiles();
                    for (int i = 0; i < files.length; i++) {
                        downloadFile(files[i], newlocalRelatePath, newRemote);
                    }
                }
                if (changedir){
                    ftp.changeToParentDirectory();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 先配置下载链接，在下载文件。 调用了startDown和downloadFile写的方法
     * @param f
     * @param savepath
     * @param filename
     * @return
     * @throws Exception
     */
    public static boolean downfile(FtpInfo f,String savepath,String filename) throws Exception{
        try{

            FtpFileUtil.connectFtp(f);
            return FtpFileUtil.startDown(f, filename ,savepath,f.getRemoteDir());

        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
