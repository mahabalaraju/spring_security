package com.worker.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worker.entity.worker;
@Repository
public interface workerrepo extends JpaRepository<worker, Integer>{
Optional<worker> findbyname(String name);
}
