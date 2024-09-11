package com.cor;
import java.util.ArrayList;
import java.util.List;

public class LoginAuth {

    Logger logger;
    List<String> accounts = new ArrayList<String>();
    List<String> passwords = new ArrayList<String>();
    String email;
    LoginReg loginReg;
    Boolean registerAction = false;
    
    public LoginAuth(){
        accounts.add("user1@email.com");
        accounts.add("user2@email.com");
        accounts.add("user3@email.com");
        passwords.add("user1pass");
        passwords.add("user2pass");
        passwords.add("user3pass");
    }

    public void setter(Logger logger, LoginReg loginReg){
        this.logger = logger;
        this.loginReg = loginReg;
    }

    public void setRegister(){
        registerAction = true;
    }

    public void logUser(String response){
        if(email == null){
            email = response;
        }
        if(registerAction){
            if(email == null){
                for (int x = 0; x < accounts.size(); x++){
                    if(accounts.get(x).compareTo(response) == 0){
                        loginReg.createAccount("Invalid");
                        registerAction = false;
                        break;
                    }
                }
                email = response;
            }
            loginReg.createAccount(response);
        }
        else{
            for (int x = 0; x < accounts.size(); x++){
                if(accounts.get(x).compareTo(email) == 0){
                    if(passwords.get(x).compareTo(response) == 0){
                        registerAction = false;
                        logger.createLog("Login Ok", "login", true);
                        break;
                    }
                    else{
                        logger.createLog("Password did not match", "login", false);
                    }
                }
                else{
                    logger.createLog("Email not found", "login", false);
                }
            }
        }
    }

    public void restart(){
        email = null;
        registerAction = false;
    }
}

