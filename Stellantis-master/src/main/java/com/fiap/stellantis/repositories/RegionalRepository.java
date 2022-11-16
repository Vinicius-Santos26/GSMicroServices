package com.fiap.stellantis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.stellantis.entities.Regional;

@Repository
public interface RegionalRepository extends JpaRepository<Regional, Long>{

}
