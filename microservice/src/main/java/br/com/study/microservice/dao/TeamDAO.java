package br.com.study.microservice.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import br.com.study.microservice.domain.Team;

@RestResource(path="teams", rel="teams")
public interface TeamDAO extends CrudRepository<Team, Long> {
	
	List<Team> findAll();
	
	Team findByName(String name);

}
