package com.etna.gpe.repository;

import com.etna.gpe.model.Particular;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.etna.gpe.model.Organization;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Integer> {

    @Query("select o from Organization o where o.organizationEmail =:email")
    public Organization getOrganizationByOrganizationEmail(String email);

    @Query("select o from Organization o where o.organizationEmail =:email and o.organizationPassword =:password")
    public Organization getOrganizationByOrganizationEmailAndOrganizationPassword(String email, String password);

}
