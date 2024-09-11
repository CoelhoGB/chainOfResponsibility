package com.cor;

public class LoginReg {

    Logger logger;
    String email;
    String password;
    
    public LoginReg(){}

    public void setter(Logger logger) {
        this.logger = logger;
    }

    public void createAccount(String response){
        if(response.matches("^Invalid.*") == false){
            if(email == null){
                email = response;
            }
            else{
                password = response;
                logger.createLog(response, "register", true);
            }
        }
        else{
            logger.createLog("email already in userbase", "register", false);
        }
    }

    public void restart(){
        email =  null;
    }
}
