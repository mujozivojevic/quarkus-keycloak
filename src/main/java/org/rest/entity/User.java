package org.rest.entity;


import javax.persistence.*;

@Entity
@Table(schema = "fruit", name ="USER")
public class User extends ModelObject {
    @SequenceGenerator(
            name="userSeq",
            sequenceName = "USER_SEQ",
            schema = "fruit",
            allocationSize = 1
    )

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeq")
    @Id
    @Column(name ="ID", nullable = false)
    private Integer id;

    private String name;
    private String email;


    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Integer getId() {
        return this.id;
    }
}
