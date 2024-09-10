package com.cor;

import java.util.regex.Pattern;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.util.Collections;

public class Logger {

    Server server;
    LoginAuth loginAuth;
    LoginReg loginReg;
    String userAction; //debug com: "log" ou "reg"
    
    public Logger(){}

    public void setter(Server server, LoginAuth loginAuth, LoginReg loginReg){
        this.server = server;
        this.loginAuth = loginAuth;
        this.loginReg = loginReg;
    }

    public Boolean createLog(String response, String action, Boolean result){
        String log;
        if(action == "response"){
            if(response.matches("^(?i)(Sim|S|Nao|N)$")){
                if(result){
                    log = "User response ok, log-in action.";
                    userAction = "log";
                }
                else{
                    log = "User response ok, register action.";
                    userAction = "reg";
                }
            }
            else{
                log = "rpErr: User response error. Cause: '" + response + "'";
                System.out.println(log);
                server.responseError(log);
            }
        }
        else if(action == "email"){
            if(result){
                log = "User email input ok.";
                if(userAction == "log"){
                    loginAuth.logUser(response);
                }
                else if(userAction == "reg"){

                }
            }
            else{
                
                log = "@Err: User email input error. Cause: '" + response + "'";
            }
        }
        else if(action == "password"){
            if(result){
                log = "User password input ok.";
                if(userAction == "log"){

                }
                else if(userAction == "reg"){
                    
                }
            }
            else{
                log = "pwErr: User password input error. Cause: '" + response + "'";
            }
        }
        else if(action == "login"){
            if(result){
                log = "User log-in successfull.";
            }
            else{
                log = "User log-in failed. Cause: '" + response + "'";
            }
        }
        else if(action == "register"){
            if(result){
                log = "User register successfull.";
            }
            else{
                log = "User register failed. Cause: " + response;
            }
        }
        else{
            log = "Log Error.";
        }

        try {
            Files.write(Paths.get("log.txt"), Collections.singletonList(log),StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            return true;
        } catch (IOException e) {
            System.err.println("Write Failure: " + e.getMessage());
            return false;
        }

    }

}
