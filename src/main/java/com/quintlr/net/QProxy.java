package com.quintlr.net;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

/*
 *
 * @author prashanth
 */
public class QProxy {

    private String proxy = null;
    private Integer port = null;
    private String username = null;
    private String password = null;
    private Authenticator auth = null;
    
    public boolean requireAuth = true;

    public QProxy(String proxy, Integer port) {
        this(proxy, port, null, null);
        this.requireAuth = false;
    }

    public QProxy(String proxy, Integer port, String username, String password) {
        this.proxy = proxy;
        this.port = port;
        this.username = username;
        this.password = password;

        if (username != null && password != null) {
            auth = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password.toCharArray());
                }
            };
        }
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
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

    public Proxy getProxyObject() {
        SocketAddress sa = new InetSocketAddress(proxy, port);
        Proxy qproxy = new Proxy(Proxy.Type.HTTP, sa);
        return qproxy;
    }
    
    public Authenticator getAuthenticator() {
        return auth;
    }

}
