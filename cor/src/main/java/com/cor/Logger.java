package com.cor;

public class Logger {

    Server server;
    LoginAuth loginAuth;
    LoginReg loginReg;
    
    public Logger(){}

    public Logger(Server server, LoginAuth loginAuth, LoginReg loginReg){
        this.server = server;
        this.loginAuth = loginAuth;
        this.loginReg = loginReg;
    }
}
