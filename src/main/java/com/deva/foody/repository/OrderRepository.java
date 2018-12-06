package com.deva.foody.repository;

import com.deva.foody.entity.OrderDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<OrderDetail, Long> {

    Optional<OrderDetail> findByOrderId(Long aLong);

    Iterable<OrderDetail> findAll();
}
