package com.openclassrooms.repository;

import com.openclassrooms.model.DBMessages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBMessagesRepository extends JpaRepository<DBMessages, Integer> {
}
