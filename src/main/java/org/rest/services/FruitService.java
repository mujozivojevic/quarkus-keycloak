package org.rest.services;

import org.rest.entity.dto.FruitDto;

import java.util.List;

public interface FruitService {
    List<FruitDto> getFruits();
    FruitDto addFruit(FruitDto fruitDto);
    String removeFruit(Integer id);

}
