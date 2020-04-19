package com.dean.demo.pojo.info;

import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/12/3 17:33
 */
public class FtpInfo implements Serializable{
    /**
     * ftp服务器地址
     */
    private String host;
    /**
     * ftp 端口号 默认21
     */
    private Integer port = 21;
    /**
     * ftp服务器用户名
     */
    private String username;
    /**
     * ftp服务器密码
     */
    private String password;
    /**
     * ftp远程目录
     */
    private String remoteDir;
    /**
     * 本地存储目录
     */
    private String localDir;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemoteDir() {
        return remoteDir;
    }

    public void setRemoteDir(String remoteDir) {
        this.remoteDir = remoteDir;
    }

    public String getLocalDir() {
        return localDir;
    }

    public void setLocalDir(String localDir) {
        this.localDir = localDir;
    }
}
