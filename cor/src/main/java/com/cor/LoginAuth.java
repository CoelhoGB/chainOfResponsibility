package com.cor;

public class LoginAuth {

    Logger logger;
    String[] accounts = {"user1@email.com", "user2@email.com", "user3@email.com"};
    String[] passwords = {"user1pass", "user2pass", "user3pass"};
    String selected;
    LoginReg loginReg;
    String action; //"log" ou "reg"
    
    public LoginAuth(){
    }

    public void setter(Logger logger, LoginReg loginReg){
        this.logger = logger;
        this.loginReg = loginReg;
    }

    public void logUser(String response){
        if(selected == null){
            selected = response;
        }
        else{
            for (int x = 0; x < accounts.length; x++){
                if(selected == accounts[x]){
                    if(response == passwords[x]){}
                }
            }
        }
    }
}

