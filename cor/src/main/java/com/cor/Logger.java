package com.cor;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.util.Collections;

public class Logger {

    Server server;
    LoginAuth loginAuth;
    LoginReg loginReg;
    
    public Logger(){}

    public void setter(Server server, LoginAuth loginAuth){
        this.server = server;
        this.loginAuth = loginAuth;
    }

    public boolean createLog(String response, String action, Boolean result){
        String log;
        if(action == "response"){
            if(response.matches("^(?i)(Sim|S|Nao|N)$")){
                if(result){
                    log = "User response ok, log-in action.";
                    log(log);
                }
                else{
                    log = "User response ok, register action.";
                    log(log);
                    loginAuth.setRegister();
                }
            }
            else{
                log = "rpErr: User response error. Cause: '" + response + "'";
                log(log);
                server.responseError(log);
            }
        }
        else if(action == "email"){
            if(result){
                log = "User email input ok.";
                log(log);
                loginAuth.logUser(response);
            }
            else{
                
                log = "@Err: User email input error. Cause: '" + response + "'";
                log(log);
            }
        }
        else if(action == "password"){
            if(result){
                log = "User password input ok.";
                log(log);
                loginAuth.logUser(response);
            }
            else{
                log = "pwErr: User password input error. Cause: '" + response + "'";
                log(log);
            }
        }
        else if(action == "login"){
            if(result){
                log = "User log-in successfull.";
                log(log);
                server.confirmLogin();
            }
            else{
                log = "User log-in failed. Cause: '" + response + "'";
                log(log);
            }
        }
        else if(action == "register"){
            if(result){
                log = "User registered successfully.";
                log(log);
                System.out.println("Registro criado.");
                server.confirmLogin();
            }
            else{
                log = "User register failed. Cause: " + response + "'";
                log(log);
                server.responseError("@Err");
                return false;
            }
        }
        else{
            log = "Log Error.";
            log(log);
        }
        return true;
    }

    private boolean log(String target){
        try {
            Files.write(Paths.get("log.txt"), Collections.singletonList(target),StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            return true;
        } catch (IOException e) {
            System.err.println("Write Failure: " + e.getMessage());
            return false;
        }
    }
}
