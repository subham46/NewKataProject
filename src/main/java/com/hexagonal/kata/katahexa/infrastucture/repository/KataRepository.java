package com.hexagonal.kata.katahexa.infrastucture.repository;


import com.hexagonal.kata.katahexa.infrastucture.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KataRepository extends JpaRepository<User,Long>{

}
