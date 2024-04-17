package com.akmal.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akmal.demo.io.entity.UserEntity;


@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity, Long>{
    UserEntity findUserByEmail(String email);
}
