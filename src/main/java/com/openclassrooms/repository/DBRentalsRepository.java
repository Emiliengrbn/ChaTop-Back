package com.openclassrooms.repository;

import com.openclassrooms.model.DBRentals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBRentalsRepository extends JpaRepository<DBRentals, Integer> {
}
