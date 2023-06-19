package com.app.contactapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.app.contactapp.entites.user;


@Repository
public interface UserRepository extends  JpaRepository<user,Integer>{
     
    @Query("Select u from user u where u.email= :email")
    public user findUserByName(@Param("email") String email);
    
}
