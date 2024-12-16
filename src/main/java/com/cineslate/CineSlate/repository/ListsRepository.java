package com.cineslate.CineSlate.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cineslate.CineSlate.entities.Lists;

@Repository
public interface ListsRepository extends JpaRepository<Lists, Long> {
}
