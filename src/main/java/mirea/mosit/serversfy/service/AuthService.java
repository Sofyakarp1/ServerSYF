package mirea.mosit.serversfy.service;

import mirea.mosit.serversfy.entity.Auth;
import mirea.mosit.serversfy.entity.Observed;
import mirea.mosit.serversfy.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    private final AuthRepository authRepository;


    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void createAuth(Auth auth){
        authRepository.save(auth);
    }

    public List<Auth> allAuths(){
        return authRepository.allAuths();
    }

    public String getPassword(String login){ return  authRepository.getPassword(login);}
}
