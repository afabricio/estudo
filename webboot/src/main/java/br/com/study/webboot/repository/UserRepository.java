package br.com.study.webboot.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.study.webboot.domain.User;

public interface  UserRepository extends CrudRepository<User, Long>{

}
