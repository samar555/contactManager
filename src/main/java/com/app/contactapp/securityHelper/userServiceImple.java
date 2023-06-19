package com.app.contactapp.securityHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import com.app.contactapp.Repository.UserRepository;
import com.app.contactapp.entites.user;

public class userServiceImple  implements UserDetailsService{
    @Autowired
    private  UserRepository userrepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        user User=userrepo.findUserByName(username);
        
        if(User==null){
            throw new UsernameNotFoundException("Colud Not Found User By This Email");
        }
        userDetail user=new userDetail(User);
        return user;
    }
    
}
