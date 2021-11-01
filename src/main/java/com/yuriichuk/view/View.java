package com.yuriichuk.view;

import com.yuriichuk.DAO.implementation.VendingMachineMenuDAO;
import com.yuriichuk.controller.implementation.*;
import com.yuriichuk.model.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private final static Scanner scanner = new Scanner(System.in);
    private final Map<String, Printable> menu = new HashMap<String, Printable>();

    private final AddressController addressController = new AddressController();
    private final BrandController brandController = new BrandController();
    private final SnackController snackController = new SnackController();
    private final TechnicianController technicianController = new TechnicianController();
    private final VendingMachineController vendingMachineController = new VendingMachineController();
    private final VendingMachineMenuController vendingMachineMenuController = new VendingMachineMenuController();

    public View() {
        menu.put("11", this::getAllAdresses);
        menu.put("12", this::getAdressById);
        menu.put("13", this::createAdress);
        menu.put("14", this::updateAdress);
        menu.put("15", this::deleteAdress);

        menu.put("21", this::getAllBrands);
        menu.put("22", this::getBrandById);
        menu.put("23", this::createBrand);
        menu.put("24", this::updateBrand);
        menu.put("25", this::deleteBrand);

        menu.put("41", this::getAllSnacks);
        menu.put("42", this::getSnackById);
        menu.put("43", this::createSnack);
        menu.put("44", this::updateSnack);
        menu.put("45", this::deleteSnack);

        menu.put("51", this::getAllTechnicians);
        menu.put("52", this::getTechnicianById);
        menu.put("53", this::createTechnician);
        menu.put("54", this::updateTechnician);
        menu.put("55", this::deleteTechnician);

        menu.put("61", this::getAllVendingMachines);
        menu.put("62", this::getVendingMachineById);
        menu.put("63", this::createVendingMachine);
        menu.put("64", this::updateVendingMachine);
        menu.put("65", this::deleteVendingMachine);

        menu.put("71", this::getAllVendingMachineMenus);
        menu.put("72", this::getVendingMachineMenuById);
        menu.put("73", this::createVendingMachineMenu);
        menu.put("74", this::updateVendingMachineMenu);
        menu.put("75", this::deleteVendingMachineMenu);
    }


    private void getAllAdresses() throws SQLException {
        System.out.println("");
        addressController.findAll().forEach(System.out::println);
        System.out.println("");
    }

    private void getAdressById() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        System.out.println("\n" + addressController.findById(id));
        System.out.println("");
    }

    private void createAdress() throws SQLException {
        System.out.println("");
        addressController.create(getAdressFromInput());
        System.out.println("");
    }

    private void updateAdress() throws SQLException {
        Integer id = readId("Type id:");
        Address address = getAdressFromInput();
        address.setId(id);
        addressController.update(address);
        System.out.println("");

    }

    private void deleteAdress() throws SQLException {
        Integer id = readId("Type id:");
        addressController.delete(id);
        System.out.println("");
    }

    private Address getAdressFromInput() {
        System.out.println("Type region:");
        String region = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type city or village:");
        String cityVillage = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type street:");
        String street = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type building:");
        String building = scanner.nextLine().replaceAll(" ", "");

        return new Address(region, cityVillage, street, building);
    }




    private void getAllBrands() throws SQLException {
        System.out.println("");
        brandController.findAll().forEach(System.out::println);
        System.out.println("");
    }

    private void getBrandById() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        System.out.println("\n" + brandController.findById(id));
        System.out.println("");
    }

    private void createBrand() throws SQLException {
        System.out.println("");
        brandController.create(getBrandFromInput());
        System.out.println("");
    }

    private void updateBrand() throws SQLException {
        Integer id = readId("Type id:");
        Brand brand = getBrandFromInput();
        brand.setId(id);
        brandController.update(brand);
        System.out.println("");

    }

    private void deleteBrand() throws SQLException {
        Integer id = readId("Type id:");
        brandController.delete(id);
        System.out.println("");
    }

    private Brand getBrandFromInput() {
        System.out.println("Type name:");
        String name = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type date:");
        String date = scanner.nextLine().replaceAll(" ", "");

        return new Brand(name, date);
    }



    private void getAllSnacks() throws SQLException {
        System.out.println("");
        snackController.findAll().forEach(System.out::println);
        System.out.println("");
    }

    private void getSnackById() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        System.out.println("\n" + snackController.findById(id));
        System.out.println("");
    }

    private void createSnack() throws SQLException {
        System.out.println("");
        snackController.create(getSnackFromInput());
        System.out.println("");
    }

    private void updateSnack() throws SQLException {
        Integer id = readId("Type id:");
        Snack snack = getSnackFromInput();
        snack.setId(id);
        snackController.update(snack);
        System.out.println("");

    }

    private void deleteSnack() throws SQLException {
        Integer id = readId("Type id:");
        snackController.delete(id);
        System.out.println("");
    }

    private Snack getSnackFromInput() {
        System.out.println("Type name:");
        String name = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type price:");
        Float price = Float.parseFloat(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type weight:");
        Integer weight = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type callories:");
        Integer callories = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type brand id:");
        Integer brandId = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));

        return new Snack(name, price, weight, callories, brandId);
    }



    private void getAllTechnicians() throws SQLException {
        System.out.println("");
        technicianController.findAll().forEach(System.out::println);
        System.out.println("");
    }

    private void getTechnicianById() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        System.out.println("\n" + technicianController.findById(id));
        System.out.println("");
    }

    private void createTechnician() throws SQLException {
        System.out.println("");
        technicianController.create(getTechnicianFromInput());
        System.out.println("");
    }

    private void updateTechnician() throws SQLException {
        Integer id = readId("Type id:");
        Technician technician = getTechnicianFromInput();
        technician.setId(id);
        technicianController.update(technician);
        System.out.println("");

    }

    private void deleteTechnician() throws SQLException {
        Integer id = readId("Type id:");
        technicianController.delete(id);
        System.out.println("");
    }

    private Technician getTechnicianFromInput() {
        System.out.println("Type first name:");
        String firstName = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type second name:");
        String lastName = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type age:");
        Integer age = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type work entry date:");
        String workEntryDate = scanner.nextLine().replaceAll(" ", "");

        return new Technician(firstName, lastName, age, workEntryDate);
    }



    private void getAllVendingMachines() throws SQLException {
        System.out.println("");
        vendingMachineController.findAll().forEach(System.out::println);
        System.out.println("");
    }

    private void getVendingMachineById() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        System.out.println("\n" + vendingMachineController.findById(id));
        System.out.println("");
    }

    private void createVendingMachine() throws SQLException {
        System.out.println("");
        vendingMachineController.create(getVendingMachineFromInput());
        System.out.println("");
    }

    private void updateVendingMachine() throws SQLException {
        Integer id = readId("Type id:");
        VendingMachine vendingMachine = getVendingMachineFromInput();
        vendingMachine.setId(id);
        vendingMachineController.update(vendingMachine);
        System.out.println("");

    }

    private void deleteVendingMachine() throws SQLException {
        Integer id = readId("Type id:");
        vendingMachineController.delete(id);
        System.out.println("");
    }

    private VendingMachine getVendingMachineFromInput() {
        System.out.println("Type coordinates:");
        String coordinates = scanner.nextLine().replaceAll(" ", ", ");
        System.out.println("Type address id:");
        Integer addressId = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));

        return new VendingMachine(coordinates, addressId);
    }



    private void getAllVendingMachineMenus() throws SQLException {
        System.out.println("");
        vendingMachineMenuController.findAll().forEach(System.out::println);
        System.out.println("");
    }

    private void getVendingMachineMenuById() throws SQLException {
        System.out.println("");
        Integer vendingMachineId = readId("Type vending machine id:");
        Integer snackId = readId("Type snack id");
        System.out.println("\n" + vendingMachineMenuController.findById(vendingMachineId, snackId));
        System.out.println("");
    }

    private void createVendingMachineMenu() throws SQLException {
        System.out.println("");
        Integer vendingMachineId = readId("Type vending machine id:");
        Integer snackId = readId("Type snack id");
        VendingMachineMenu vendingMachineMenu =  getVendingMachineMenuFromInput();
        vendingMachineMenu.setVendingMachineId(vendingMachineId);
        vendingMachineMenu.setSnackId(snackId);
        vendingMachineMenuController.create(vendingMachineMenu);
        System.out.println("");
    }

    private void updateVendingMachineMenu() throws SQLException {
        System.out.println("");
        Integer vendingMachineId = readId("Type vending machine id:");
        Integer snackId = readId("Type snack id");
        VendingMachineMenu vendingMachineMenu =  getVendingMachineMenuFromInput();
        vendingMachineMenu.setVendingMachineId(vendingMachineId);
        vendingMachineMenu.setSnackId(snackId);
        vendingMachineMenuController.update(vendingMachineMenu);
        System.out.println("");
    }

    private void deleteVendingMachineMenu() throws SQLException {
        System.out.println("");
        Integer vendingMachineId = readId("Type vending machine id:");
        Integer snackId = readId("Type snack id");
        vendingMachineMenuController.delete(vendingMachineId, snackId);
        System.out.println("");
    }

    private VendingMachineMenu getVendingMachineMenuFromInput() {
        System.out.println("Type quantity:");
        Integer quantity = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));

        return new VendingMachineMenu(quantity);
    }



    private Integer readId(String message) {
        System.out.println(message);
        String input = scanner.nextLine();
        input = input.replaceAll(" ", "");
        return Integer.parseInt(input);
    }

    public void show() throws SQLException {
        Menu.displayMenu();
        String input = scanner.nextLine();
        input = input.replaceAll(" ", "");

        while (!input.equals("QUIT")) {
            menu.get(input).print();
            input = scanner.nextLine();
            input = input.replaceAll("\\s", "");
        }
    }
}
