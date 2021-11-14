package com.yuriichuk.Lab6.repository;

import com.yuriichuk.Lab6.model.VendingMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendingMachineRepository extends JpaRepository<VendingMachine, Integer> {
}
