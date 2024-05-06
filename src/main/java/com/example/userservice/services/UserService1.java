package com.example.userservice.services;

import com.example.userservice.models.Token;
import com.example.userservice.models.User;
import com.example.userservice.repository.TokenRpository;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service

public class UserService1 {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  BCryptPasswordEncoder  bCryptPasswordEncoder;

    @Autowired
    private TokenRpository tokenRepository;

    public User signup(String name,String email, String password){

        //Skipping email verification part
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()){

            //throw some exception
            // user aleready present

        }
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setHashedPassword(bCryptPasswordEncoder.encode(password));
        return userRepository.save(user);




    }

    public Token login(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            //throw user is not valid
            return  null;

        }
        User user = optionalUser.get();
        if (!bCryptPasswordEncoder.matches(password, user.getHashedPassword())){
            // throw password is wrong

            return null;
        }
        Token token = new Token();
        token.setUser(user);
        token.setExpirydate(get30DaysLter());
        token.setValue(UUID.randomUUID().toString());

        return tokenRepository.save(token);

    }

    private Date get30DaysLter() {

        Date date = new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);

        //Add 30 days in calaender

        calendar.add(Calendar.DAY_OF_MONTH,30);
        //extract date from calander

        return calendar.getTime();


    }

    public void logout(String token) {
        //if the token is already deleated no need to do anything
        //if the token is already expired no need to do anything
        // else set deleted as true

        Optional<Token> tokenOptional =
                tokenRepository.findByValueAndIsDeletedEquals(token, false);

        if (tokenOptional.isEmpty()){
            //throw an expection token is not present or already deleted
            return;

        }
        Token Updatedtoken1 = tokenOptional.get();
        Updatedtoken1.setDeleted(true);
        tokenRepository.save(Updatedtoken1);



    }

    public boolean validateToken(String token) {

        /*
        1.check if the token is present in db
        2.check if the token is not deleted
        3. check if the token is not expired
         */

        //1
        Optional<Token> tokenOptional =
                tokenRepository.findByValueAndIsDeletedEqualsAndExpirydateGreaterThan(
                token, false, new Date());
        return tokenOptional.isPresent();
    }
}
