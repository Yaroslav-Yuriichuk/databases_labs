package com.yuriichuk.Lab6.repository;

import com.yuriichuk.Lab6.model.Snack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnackRepository extends JpaRepository<Snack, Integer> {
}
