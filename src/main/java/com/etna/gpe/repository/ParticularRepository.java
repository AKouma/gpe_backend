package com.etna.gpe.repository;

import com.etna.gpe.model.Particular;


import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticularRepository extends CrudRepository<Particular, Integer> {


    @Query("select p from Particular p where p.particularEmail =:particularEmail")
    public Particular findParticularByParticularEmail(String particularEmail);

    @Query("select p from Particular p where p.particularEmail =:particularEmail and p.particularPassword =:particularPassword")
    public Particular findParticularByparticularEmailAndParticularPassword(String particularEmail, String particularPassword);
}