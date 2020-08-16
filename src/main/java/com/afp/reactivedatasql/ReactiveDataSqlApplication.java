package com.afp.reactivedatasql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.connectionfactory.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.reactive.TransactionalOperator;

import io.r2dbc.spi.ConnectionFactory;

@SpringBootApplication
@EnableTransactionManagement
public class ReactiveDataSqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveDataSqlApplication.class, args);
	}
	
	@Bean
	TransactionalOperator transactionalOperator(ReactiveTransactionManager rtm) {
	  return TransactionalOperator.create(rtm);
	}
	
	@Bean
	ReactiveTransactionManager r2dbcTransactionManager(ConnectionFactory cf) {
	  return new R2dbcTransactionManager(cf);
	}

}
