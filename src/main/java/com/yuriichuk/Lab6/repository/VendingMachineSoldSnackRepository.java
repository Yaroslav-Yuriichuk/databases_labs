package com.yuriichuk.Lab6.repository;

import com.yuriichuk.Lab6.model.VendingMachineSoldSnack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendingMachineSoldSnackRepository extends JpaRepository<VendingMachineSoldSnack, Integer> {
}
