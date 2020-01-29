package com.etna.gpe.repository;

import org.springframework.data.repository.CrudRepository;

import com.etna.gpe.model.Message;

public interface MessageRepository extends CrudRepository<Message, Integer>{

}
