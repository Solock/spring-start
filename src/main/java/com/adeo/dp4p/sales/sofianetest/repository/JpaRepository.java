package com.adeo.dp4p.sales.sofianetest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRepository extends CrudRepository<ResultOperatorEntity, Long> {
}
