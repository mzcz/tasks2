package com.crud.tasks.repository;

import com.crud.tasks.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

    @Override
    Item save(Item item);
}
