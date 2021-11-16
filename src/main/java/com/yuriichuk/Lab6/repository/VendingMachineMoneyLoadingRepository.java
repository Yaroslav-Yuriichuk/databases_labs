package com.yuriichuk.Lab6.repository;

import com.yuriichuk.Lab6.model.VendingMachineMoneyLoading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendingMachineMoneyLoadingRepository extends JpaRepository<VendingMachineMoneyLoading, Integer> {
}
