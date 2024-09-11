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
        if(registerAction){loginReg.createAccount(response);}
        if(email == null){
            email = response;
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
                        logger.createLog("password did not match", "login", false);
                    }
                }
                else{
                    logger.createLog("email not found", "login", false);
                }
            }
        }
    }

    public void addAccount(String email, String password){
        accounts.add(email);
        passwords.add(password);
    }
}

