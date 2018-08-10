package br.com.study.microservice;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.study.microservice.dao.TeamDAO;
import br.com.study.microservice.domain.Player;
import br.com.study.microservice.domain.Team;

@SpringBootApplication
@EnableAutoConfiguration
public class App 
{
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Autowired
	TeamDAO TeamDAO;
	
	@PostConstruct
	public void init() {
		Set<Player> players = new HashSet<Player>();
		players.add(new Player("Charlie Brown", "pitcher"));
		players.add(new Player("Snopy", "shortstop"));
		
		
		Team team = new Team("charlote","California",players);
		
		TeamDAO.save(team);

	}

}
