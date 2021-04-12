package org.rest.repository;

import org.rest.entity.Fruit;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class FruitRepository extends Repository<Fruit, Integer> {

    protected FruitRepository() {
        super((Fruit.class));
    }

    public void fruitDelete(Integer id){
        Query query = entityManager.createNativeQuery("DELETE FROM fruit.fruit f where f.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

}
