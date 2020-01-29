package com.etna.gpe.repository;

import org.springframework.data.repository.CrudRepository;

import com.etna.gpe.model.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {

}
