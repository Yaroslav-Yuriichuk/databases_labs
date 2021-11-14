package com.yuriichuk.Lab6.repository;

import com.yuriichuk.Lab6.model.VendingMachineMenu;
import com.yuriichuk.Lab6.model.composite_key.VendingMachineMenuPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendingMachineMenuRepository extends JpaRepository<VendingMachineMenu, VendingMachineMenuPK> {
}
