package com.yuriichuk.Lab6.repository;

import com.yuriichuk.Lab6.model.VendingMachineSnacksLoading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendingMachineSnacksLoadingRepository
        extends JpaRepository<VendingMachineSnacksLoading, Integer> {
}
