package br.com.study.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.study.microservice.dao.TeamDAO;
import br.com.study.microservice.domain.Team;

@RestController
public class TeamController {
	
	@Autowired
	TeamDAO TeamDAO;
	
	@RequestMapping("hi/{name}")
	public Team hiThere(@PathVariable String name) {
		
		return TeamDAO.findByName(name);

	}

}
