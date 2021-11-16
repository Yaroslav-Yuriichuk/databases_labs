package com.yuriichuk.Lab6.repository;

import com.yuriichuk.Lab6.model.LoadedSnack;
import com.yuriichuk.Lab6.model.composite_key.LoadedSnackPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadedSnackRepository extends JpaRepository<LoadedSnack, LoadedSnackPK> {
}
