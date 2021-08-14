package org.acme.lhsm.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Person {
    private Long id;
    private String name;

    @Id
    @SequenceGenerator(name = "personSeq", sequenceName = "person_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "personSeq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}