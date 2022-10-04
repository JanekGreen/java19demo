package com.intive.structuredconcurrency;

public class UserService {

    public String findUser() throws InterruptedException {
        System.out.println("User service working...");
       RandomStuffSimulator.waitRandomTimeBetween("findUser ",1, 2);
        if(1>0)
            throw new InterruptedException("Ooops!");
        return "userName_"+RandomStuffSimulator.getRandomNumberBetween(1, 19999) ;

    }
}
