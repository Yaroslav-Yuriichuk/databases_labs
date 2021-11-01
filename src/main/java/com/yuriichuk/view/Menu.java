package com.yuriichuk.view;

public final class Menu {

    private Menu() {}

    public static void displayMenu() {
        System.out.println("  Table                                |   Method\n" +
                "---------------------------------------|------------\n" +
                "  1: address                           |   1: GET ALL  \n" +
                "  2: brand                             |   2: GET      \n" +
                "  3: loaded_snack                      |   3: CREATE   \n" +
                "  4: snack                             |   4: UPDATE   \n" +
                "  5: technician                        |   5: DELETE   \n" +
                "  6: vending_machine                   |               \n" +
                "  7: vending_machine_menu              |               \n" +
                "  8: vending_machine_money_loading     |               \n" +
                "  9: vending_machine_money_unloading   |               \n" +
                "  10: vending_machine_snacks_loading   |               \n" +
                "  11: vending_machine_sold_snack       |               \n"
        );
    }
}
