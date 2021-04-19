package com.learn.repo;

import org.springframework.data.repository.CrudRepository;

import com.learn.entity.OrderEntity;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {

}
