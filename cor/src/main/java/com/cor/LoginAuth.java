package com.cor;

public class LoginAuth {

    Logger logger;
    String[] accounts = {"user1@email.com", "user2@email.com", "user3@email.com"};
    String[] passwords = {"user1pass", "user2pass", "user3pass"};
    String email;
    LoginReg loginReg;
    Boolean registerAction = false;
    
    public LoginAuth(){
    }

    public void setter(Logger logger, LoginReg loginReg){
        this.logger = logger;
        this.loginReg = loginReg;
    }

    public void setRegister(){
        registerAction = true;
    }

    public void logUser(String response){
        if(registerAction){loginReg.createAccount(response);}
        if(email == null){
            email = response;
        }
        else{
            for (int x = 0; x < accounts.length; x++){
                if(accounts[x].compareTo(email) == 0){
                    if(passwords[x].compareTo(response) == 0){
                        registerAction = false;
                        logger.createLog("Login Ok", "login", false);
                    }
                    else{
                        logger.createLog("password did not match", "login", false);
                    }
                }
                else{
                    logger.createLog("email not found", "login", false);
                }
            }
        }
    }
}

