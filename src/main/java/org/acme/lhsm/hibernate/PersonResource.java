package org.acme.lhsm.hibernate;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject EntityManager entityManager;

    @GET
    @Transactional
    public List<Person> get(){
        Person person = new Person();
        person.setName("name");
        entityManager.persist(person);

        Query query = entityManager.createNativeQuery("SELECT * FROM person");

        return query.getResultList();
    }
}
