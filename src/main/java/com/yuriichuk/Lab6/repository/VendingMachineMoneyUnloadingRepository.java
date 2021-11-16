package com.yuriichuk.Lab6.repository;

import com.yuriichuk.Lab6.model.VendingMachineMoneyUnloading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendingMachineMoneyUnloadingRepository extends JpaRepository<VendingMachineMoneyUnloading, Integer> {
}
