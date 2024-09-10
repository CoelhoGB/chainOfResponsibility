package com.cor;

public class Main {

    public static void main(String[] args){
        
        Logger logger = new Logger();
        Validator validator =  new Validator();
        LoginReg loginReg = new LoginReg();
        LoginAuth loginAuth = new LoginAuth();
        Client client = new Client();
        Server server = new Server(client, loginAuth, loginReg, logger, validator);

        loginAuth.setter(logger, loginReg);
        loginReg.setter(logger);
        logger.setter(server, loginAuth, loginReg);
        client.setter(validator);
        validator.setter(logger, loginAuth);
    }
}
