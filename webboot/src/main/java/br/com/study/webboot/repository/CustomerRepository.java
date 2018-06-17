package br.com.study.webboot.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.study.webboot.domain.Customer;

public interface  CustomerRepository extends CrudRepository<Customer, Long>{

}
