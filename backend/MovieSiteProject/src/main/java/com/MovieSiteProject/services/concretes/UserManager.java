package com.MovieSiteProject.services.concretes;

import com.MovieSiteProject.dataAccess.UserRepository;
import com.MovieSiteProject.entities.concretes.User;
import com.MovieSiteProject.entities.model.RegisterRequest;
import com.MovieSiteProject.exceptions.AlreadyExistException;
import com.MovieSiteProject.exceptions.NotFoundException;
import com.MovieSiteProject.services.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User findUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);

        if(user == null){
            throw new NotFoundException("User not found");
        }

        return user;

    }

    @Override
    public void registerUser(RegisterRequest registerRequest){
        User user = userRepository.findUserByEmail(registerRequest.getEmail());
        if(user == null){
            try {
                User newUser = new User();
                newUser.setUserName(registerRequest.getEmail());
                newUser.setPassword(registerRequest.getPassword());
                newUser.setEmail(registerRequest.getEmail());

                userRepository.save(newUser);
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        } else{
            throw new AlreadyExistException("User already exist");
        }
    }
}
