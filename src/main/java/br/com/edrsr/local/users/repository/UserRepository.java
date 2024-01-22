package br.com.edrsr.local.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.edrsr.local.users.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository <UserModel, Long>{
    
}