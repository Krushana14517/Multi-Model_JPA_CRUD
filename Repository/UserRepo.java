package com.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.Model.User;

public interface UserRepo extends JpaRepository<User, Long>  {

}
