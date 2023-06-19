package com.app.contactapp.securityHelper;


import java.util.Collection;
import java.util.List;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.contactapp.entites.user;

public class userDetail implements UserDetails  {
    
     private user User;

    public userDetail(user user) {
      User = user;
   }

   @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      SimpleGrantedAuthority gAuth= new SimpleGrantedAuthority(User.getRole());
      
       return List.of(gAuth);
    }

    @Override
    public String getPassword() {
       
       return User.getPassword();
    }

    @Override
    public String getUsername() {
        return User.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
       return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
       return true;
    }
    
}
