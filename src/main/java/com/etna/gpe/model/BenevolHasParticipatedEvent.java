package com.etna.gpe.model;

import javax.persistence.*;

@Entity
@Table(name = "benevol_has_participated_event")
public class BenevolHasParticipatedEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "benevol_benevol_id")
	int benevolBenevolId;
	
	@ManyToOne
	Event event;
	
}
