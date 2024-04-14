package com.MovieSiteProject.services.abstracts;

import com.MovieSiteProject.entities.concretes.User;
import com.MovieSiteProject.entities.model.RegisterRequest;

public interface UserService {
    User findUserByEmail(String email);
    void registerUser(RegisterRequest registerRequest);
}
