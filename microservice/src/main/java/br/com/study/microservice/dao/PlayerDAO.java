package br.com.study.microservice.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.study.microservice.domain.Player;

public interface PlayerDAO extends CrudRepository<Player, Long> {

}
