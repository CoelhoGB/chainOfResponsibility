package com.cor;

public class LoginAuth {

    Logger logger;
    String[] accounts = {"user1@email.com", "user2@email.com", "user3@email.com"};
    String[] passwords = {"user1pass", "user2pass", "user3pass"};
    String selected;
    
    public LoginAuth(Logger logger){
        this.logger = logger;
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

