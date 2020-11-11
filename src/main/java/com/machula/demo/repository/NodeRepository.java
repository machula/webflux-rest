package com.machula.demo.repository;


import com.machula.demo.entity.NodeEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends ReactiveMongoRepository<NodeEntity, String> {
}
