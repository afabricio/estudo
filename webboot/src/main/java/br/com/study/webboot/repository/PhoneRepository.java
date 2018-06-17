package br.com.study.webboot.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.study.webboot.domain.Phone;

public interface  PhoneRepository extends CrudRepository<Phone, Long>{

}
