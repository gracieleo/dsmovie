package com.devsuperior.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmovie.entities.User;

public interface UserRepository extends JpaRepository <User, Long>{

	User findByEmail (String email);  //colocando o método com o mesmo nome do campo a ser buscado já é suficiente
}
