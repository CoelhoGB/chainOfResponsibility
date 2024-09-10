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

    Pattern emailPat = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    Pattern passwordPat = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    Pattern responsePat = Pattern.compile("^(?i)(Sim|S|Nao|N)$");
    
    public Logger(){}

    public Logger(Server server, LoginAuth loginAuth, LoginReg loginReg){
        this.server = server;
        this.loginAuth = loginAuth;
        this.loginReg = loginReg;
    }

    public void createLog(String response, String action, Boolean result){
        String log;
        if(action == "response"){
            if(response.matches("^(?i)(Sim|S|Nao|N)$")){
                if(result){
                    log = "User response ok, log-in action";
                }
                else{
                    log = "User response ok, register action";
                }
            }
            else{
                log = "User response error. Cause:'" + response + "'";
            }
        }
        else if(action == "email"){

        }
        else if(action == "password"){

        }
        else{
            log = "Log Error.";
        }

        try {
            Files.write(Paths.get("log.txt"), Collections.singletonList(log), 
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Write Failure: " + e.getMessage());
        }
    }
}
