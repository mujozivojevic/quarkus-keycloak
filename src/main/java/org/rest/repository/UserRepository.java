package org.rest.repository;


import org.rest.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class UserRepository extends Repository<User, Integer> {
    protected UserRepository() {
        super((User.class));
    }


    public void userDelete(Integer id){
        Query query = entityManager.createNativeQuery("DELETE FROM fruit.user u where u.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
