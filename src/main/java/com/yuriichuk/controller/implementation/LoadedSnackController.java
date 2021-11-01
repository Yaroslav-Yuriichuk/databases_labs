package com.yuriichuk.controller.implementation;

import com.yuriichuk.controller.AbstractController;
import com.yuriichuk.model.LoadedSnack;
import com.yuriichuk.model.VendingMachineMenu;
import com.yuriichuk.service.implementation.LoadedSnackService;
import com.yuriichuk.service.implementation.VendingMachineMenuService;

import java.sql.SQLException;
import java.util.List;

public class LoadedSnackController implements AbstractController<LoadedSnack> {

    private final LoadedSnackService service = new LoadedSnackService();

    @Override
    public List<LoadedSnack> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public LoadedSnack findById(Integer firstId, Integer secondId) throws SQLException {
        return service.findById(firstId, secondId);
    }

    @Override
    public void create(LoadedSnack loadedSnack) throws SQLException {
        service.create(loadedSnack);
    }

    @Override
    public void update(LoadedSnack loadedSnack) throws  SQLException {
        service.update(loadedSnack);
    }

    @Override
    public void delete(Integer firstId, Integer secondId) throws SQLException {
        service.delete(firstId, secondId);
    }
}
