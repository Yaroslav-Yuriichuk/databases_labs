INSERT INTO `yuriichuk`.`brand` (`name`, `foundation_data`) VALUES ('Lay\'s', '1940-07-25');
INSERT INTO `yuriichuk`.`brand` (`name`, `foundation_data`) VALUES ('Oreo', '1912-05-16');
INSERT INTO `yuriichuk`.`brand` (`name`, `foundation_data`) VALUES ('Kit Kat', '1935-01-23');
INSERT INTO `yuriichuk`.`brand` (`name`, `foundation_data`) VALUES ('M&M\'s', '1941-09-10');
INSERT INTO `yuriichuk`.`brand` (`name`, `foundation_data`) VALUES ('Cheetos', '1948-04-12');
INSERT INTO `yuriichuk`.`brand` (`name`, `foundation_data`) VALUES ('Ritz', '1934-03-27');


INSERT INTO `yuriichuk`.`snack` (`name`, `price`, `weight`, `callories`, `brand_id`) VALUES ('Cookies', '40', '120', '250', '2');
INSERT INTO `yuriichuk`.`snack` (`name`, `price`, `weight`, `callories`, `brand_id`) VALUES ('Chips', '50', '150', '380', '5');
INSERT INTO `yuriichuk`.`snack` (`name`, `price`, `weight`, `callories`, `brand_id`) VALUES ('Chocolate-cover wafer', '35', '100', '180', '3');
INSERT INTO `yuriichuk`.`snack` (`name`, `price`, `weight`, `callories`, `brand_id`) VALUES ('Chips', '45', '140', '350', '1');
INSERT INTO `yuriichuk`.`snack` (`name`, `price`, `weight`, `callories`, `brand_id`) VALUES ('Chips', '60', '220', '500', '5');
INSERT INTO `yuriichuk`.`snack` (`name`, `price`, `weight`, `callories`, `brand_id`) VALUES ('Multi-colored chocolates', '35', '90', '180', '4');
INSERT INTO `yuriichuk`.`snack` (`name`, `price`, `weight`, `callories`, `brand_id`) VALUES ('Crackers', '50', '150', '290', '6');


INSERT INTO `yuriichuk`.`address` (`region`, `city_village`, `street`, `building`) VALUES ('Lviv', 'Lviv', 'Horodotska', '47');
INSERT INTO `yuriichuk`.`address` (`region`, `city_village`, `street`, `building`) VALUES ('Chernivtsi', 'Chernivtsi', 'Holovna', '23');
INSERT INTO `yuriichuk`.`address` (`region`, `city_village`, `street`, `building`) VALUES ('Lviv', 'Lviv', 'Zelena', '40');
INSERT INTO `yuriichuk`.`address` (`region`, `city_village`, `street`, `building`) VALUES ('Lviv', 'Lviv', 'Naukova', '59');
INSERT INTO `yuriichuk`.`address` (`region`, `city_village`, `street`, `building`) VALUES ('Chernivtsi', 'Chernivtsi', 'Kobylanska', '34');
INSERT INTO `yuriichuk`.`address` (`region`, `city_village`, `street`, `building`) VALUES ('Chernivtsi', 'Chernivtsi', 'Universitetska', '3');
INSERT INTO `yuriichuk`.`address` (`region`, `city_village`, `street`, `building`) VALUES ('Chernivtsi', 'Chernivtsi', 'Heroiv Maidanu', '20');


INSERT INTO `yuriichuk`.`vending_machine` (`coordinates`, `address_id`) VALUES ('48.239672, 25.968857', '2');
INSERT INTO `yuriichuk`.`vending_machine` (`coordinates`, `address_id`) VALUES ('48.288089, 25.937828', '5');
INSERT INTO `yuriichuk`.`vending_machine` (`coordinates`, `address_id`) VALUES ('48.292649, 25.934834', '6');
INSERT INTO `yuriichuk`.`vending_machine` (`coordinates`, `address_id`) VALUES ('48.285731, 25.933454', '7');
INSERT INTO `yuriichuk`.`vending_machine` (`coordinates`, `address_id`) VALUES ('49.842565, 24.018386', '1');
INSERT INTO `yuriichuk`.`vending_machine` (`coordinates`, `address_id`) VALUES ('49.832514, 24.040938', '3');
INSERT INTO `yuriichuk`.`vending_machine` (`coordinates`, `address_id`) VALUES ('49.802530, 24.012419', '4');


INSERT INTO `yuriichuk`.`technician` (`first_name`, `last_name`, `age`, `work_entry_date`) VALUES ('Ivan', 'Smith', '29', '2019-04-12');
INSERT INTO `yuriichuk`.`technician` (`first_name`, `last_name`, `age`, `work_entry_date`) VALUES ('Petro', 'Jones', '31', '2018-07-23');
INSERT INTO `yuriichuk`.`technician` (`first_name`, `last_name`, `age`, `work_entry_date`) VALUES ('Andriy', 'Brown', '45', '2016-05-19');
INSERT INTO `yuriichuk`.`technician` (`first_name`, `last_name`, `age`, `work_entry_date`) VALUES ('Serhiy', 'Johnson', '40', '2017-09-01');
INSERT INTO `yuriichuk`.`technician` (`first_name`, `last_name`, `age`, `work_entry_date`) VALUES ('Pavlo', 'Miller', '38', '2020-08-24');
INSERT INTO `yuriichuk`.`technician` (`first_name`, `last_name`, `age`, `work_entry_date`) VALUES ('Yuriy', 'Williams', '37', '2020-10-27');


INSERT INTO `yuriichuk`.`vending_machine_menu` (`vending_machine_id`, `snack_id`) VALUES ('1', '3');
INSERT INTO `yuriichuk`.`vending_machine_menu` (`vending_machine_id`, `snack_id`) VALUES ('1', '6');
INSERT INTO `yuriichuk`.`vending_machine_menu` (`vending_machine_id`, `snack_id`) VALUES ('1', '7');
INSERT INTO `yuriichuk`.`vending_machine_menu` (`vending_machine_id`, `snack_id`) VALUES ('2', '1');
INSERT INTO `yuriichuk`.`vending_machine_menu` (`vending_machine_id`, `snack_id`) VALUES ('2', '2');
INSERT INTO `yuriichuk`.`vending_machine_menu` (`vending_machine_id`, `snack_id`) VALUES ('2', '7');
INSERT INTO `yuriichuk`.`vending_machine_menu` (`vending_machine_id`, `snack_id`) VALUES ('3', '2');
INSERT INTO `yuriichuk`.`vending_machine_menu` (`vending_machine_id`, `snack_id`) VALUES ('3', '4');
INSERT INTO `yuriichuk`.`vending_machine_menu` (`vending_machine_id`, `snack_id`) VALUES ('3', '5');
INSERT INTO `yuriichuk`.`vending_machine_menu` (`vending_machine_id`, `snack_id`) VALUES ('4', '3');
INSERT INTO `yuriichuk`.`vending_machine_menu` (`vending_machine_id`, `snack_id`) VALUES ('4', '4');
INSERT INTO `yuriichuk`.`vending_machine_menu` (`vending_machine_id`, `snack_id`) VALUES ('4', '6');
INSERT INTO `yuriichuk`.`vending_machine_menu` (`vending_machine_id`, `snack_id`) VALUES ('5', '1');
INSERT INTO `yuriichuk`.`vending_machine_menu` (`vending_machine_id`, `snack_id`) VALUES ('5', '6');
INSERT INTO `yuriichuk`.`vending_machine_menu` (`vending_machine_id`, `snack_id`) VALUES ('5', '7');
INSERT INTO `yuriichuk`.`vending_machine_menu` (`vending_machine_id`, `snack_id`) VALUES ('6', '1');
INSERT INTO `yuriichuk`.`vending_machine_menu` (`vending_machine_id`, `snack_id`) VALUES ('6', '4');
INSERT INTO `yuriichuk`.`vending_machine_menu` (`vending_machine_id`, `snack_id`) VALUES ('6', '6');
INSERT INTO `yuriichuk`.`vending_machine_menu` (`vending_machine_id`, `snack_id`) VALUES ('7', '2');
INSERT INTO `yuriichuk`.`vending_machine_menu` (`vending_machine_id`, `snack_id`) VALUES ('7', '3');
INSERT INTO `yuriichuk`.`vending_machine_menu` (`vending_machine_id`, `snack_id`) VALUES ('7', '6');


INSERT INTO `yuriichuk`.`vending_machine_available_snack` (`vending_machine_id`, `snack_id`, `quantity`) VALUES ('1', '3', '10');
INSERT INTO `yuriichuk`.`vending_machine_available_snack` (`vending_machine_id`, `snack_id`, `quantity`) VALUES ('1', '6', '15');
INSERT INTO `yuriichuk`.`vending_machine_available_snack` (`vending_machine_id`, `snack_id`, `quantity`) VALUES ('1', '7', '7');
INSERT INTO `yuriichuk`.`vending_machine_available_snack` (`vending_machine_id`, `snack_id`, `quantity`) VALUES ('2', '1', '3');
INSERT INTO `yuriichuk`.`vending_machine_available_snack` (`vending_machine_id`, `snack_id`, `quantity`) VALUES ('2', '2', '9');
INSERT INTO `yuriichuk`.`vending_machine_available_snack` (`vending_machine_id`, `snack_id`, `quantity`) VALUES ('2', '7', '11');
INSERT INTO `yuriichuk`.`vending_machine_available_snack` (`vending_machine_id`, `snack_id`, `quantity`) VALUES ('3', '2', '20');
INSERT INTO `yuriichuk`.`vending_machine_available_snack` (`vending_machine_id`, `snack_id`, `quantity`) VALUES ('3', '4', '13');
INSERT INTO `yuriichuk`.`vending_machine_available_snack` (`vending_machine_id`, `snack_id`, `quantity`) VALUES ('3', '5', '4');
INSERT INTO `yuriichuk`.`vending_machine_available_snack` (`vending_machine_id`, `snack_id`, `quantity`) VALUES ('4', '3', '5');
INSERT INTO `yuriichuk`.`vending_machine_available_snack` (`vending_machine_id`, `snack_id`, `quantity`) VALUES ('4', '4', '12');
INSERT INTO `yuriichuk`.`vending_machine_available_snack` (`vending_machine_id`, `snack_id`, `quantity`) VALUES ('4', '6', '0');
INSERT INTO `yuriichuk`.`vending_machine_available_snack` (`vending_machine_id`, `snack_id`, `quantity`) VALUES ('5', '1', '19');
INSERT INTO `yuriichuk`.`vending_machine_available_snack` (`vending_machine_id`, `snack_id`, `quantity`) VALUES ('5', '6', '6');
INSERT INTO `yuriichuk`.`vending_machine_available_snack` (`vending_machine_id`, `snack_id`, `quantity`) VALUES ('5', '7', '14');
INSERT INTO `yuriichuk`.`vending_machine_available_snack` (`vending_machine_id`, `snack_id`, `quantity`) VALUES ('6', '1', '11');
INSERT INTO `yuriichuk`.`vending_machine_available_snack` (`vending_machine_id`, `snack_id`, `quantity`) VALUES ('6', '4', '21');
INSERT INTO `yuriichuk`.`vending_machine_available_snack` (`vending_machine_id`, `snack_id`, `quantity`) VALUES ('6', '6', '7');
INSERT INTO `yuriichuk`.`vending_machine_available_snack` (`vending_machine_id`, `snack_id`, `quantity`) VALUES ('7', '2', '1');
INSERT INTO `yuriichuk`.`vending_machine_available_snack` (`vending_machine_id`, `snack_id`, `quantity`) VALUES ('7', '3', '11');
INSERT INTO `yuriichuk`.`vending_machine_available_snack` (`vending_machine_id`, `snack_id`, `quantity`) VALUES ('7', '6', '9');



INSERT INTO `yuriichuk`.`vending_machine_sold_snack` (`vending_machine_id`, `snack_id`, `quantity`, `date`) VALUES ('1', '3', '5', '2021-09-27');
INSERT INTO `yuriichuk`.`vending_machine_sold_snack` (`vending_machine_id`, `snack_id`, `quantity`, `date`) VALUES ('1', '6', '10', '2021-09-27');
INSERT INTO `yuriichuk`.`vending_machine_sold_snack` (`vending_machine_id`, `snack_id`, `quantity`, `date`) VALUES ('2', '2', '8', '2021-09-27');
INSERT INTO `yuriichuk`.`vending_machine_sold_snack` (`vending_machine_id`, `snack_id`, `quantity`, `date`) VALUES ('2', '7', '6', '2021-09-27');
INSERT INTO `yuriichuk`.`vending_machine_sold_snack` (`vending_machine_id`, `snack_id`, `quantity`, `date`) VALUES ('3', '4', '1', '2021-09-27');
INSERT INTO `yuriichuk`.`vending_machine_sold_snack` (`vending_machine_id`, `snack_id`, `quantity`, `date`) VALUES ('3', '5', '9', '2021-09-27');
INSERT INTO `yuriichuk`.`vending_machine_sold_snack` (`vending_machine_id`, `snack_id`, `quantity`, `date`) VALUES ('4', '3', '5', '2021-09-27');
INSERT INTO `yuriichuk`.`vending_machine_sold_snack` (`vending_machine_id`, `snack_id`, `quantity`, `date`) VALUES ('4', '6', '6', '2021-09-27');
INSERT INTO `yuriichuk`.`vending_machine_sold_snack` (`vending_machine_id`, `snack_id`, `quantity`, `date`) VALUES ('5', '1', '4', '2021-09-27');
INSERT INTO `yuriichuk`.`vending_machine_sold_snack` (`vending_machine_id`, `snack_id`, `quantity`, `date`) VALUES ('5', '7', '11', '2021-09-27');
INSERT INTO `yuriichuk`.`vending_machine_sold_snack` (`vending_machine_id`, `snack_id`, `quantity`, `date`) VALUES ('6', '4', '2', '2021-09-27');
INSERT INTO `yuriichuk`.`vending_machine_sold_snack` (`vending_machine_id`, `snack_id`, `quantity`, `date`) VALUES ('6', '6', '8', '2021-09-27');
INSERT INTO `yuriichuk`.`vending_machine_sold_snack` (`vending_machine_id`, `snack_id`, `quantity`, `date`) VALUES ('7', '3', '7', '2021-09-27');
INSERT INTO `yuriichuk`.`vending_machine_sold_snack` (`vending_machine_id`, `snack_id`, `quantity`, `date`) VALUES ('7', '6', '6', '2021-09-27');


INSERT INTO `yuriichuk`.`vending_machine_snacks_loading` (`technician_id`, `vending_machine_id`, `time`) VALUES ('1', '1', '2021-09-26 07:47:23');
INSERT INTO `yuriichuk`.`vending_machine_snacks_loading` (`technician_id`, `vending_machine_id`, `time`) VALUES ('4', '2', '2021-09-27 07:59:51');
INSERT INTO `yuriichuk`.`vending_machine_snacks_loading` (`technician_id`, `vending_machine_id`, `time`) VALUES ('2', '3', '2021-09-27 08:01:16');
INSERT INTO `yuriichuk`.`vending_machine_snacks_loading` (`technician_id`, `vending_machine_id`, `time`) VALUES ('5', '4', '2021-09-27 08:09:27');
INSERT INTO `yuriichuk`.`vending_machine_snacks_loading` (`technician_id`, `vending_machine_id`, `time`) VALUES ('6', '5', '2021-09-27 08:00:47');
INSERT INTO `yuriichuk`.`vending_machine_snacks_loading` (`technician_id`, `vending_machine_id`, `time`) VALUES ('3', '6', '2021-09-27 07:44:56');
INSERT INTO `yuriichuk`.`vending_machine_snacks_loading` (`technician_id`, `vending_machine_id`, `time`) VALUES ('3', '7', '2021-09-27 07:56:45');


INSERT INTO `yuriichuk`.`loaded_snack` (`vending_machine_snacks_loading_id`, `snack_id`, `quantity`) VALUES ('1', '3', '5');
INSERT INTO `yuriichuk`.`loaded_snack` (`vending_machine_snacks_loading_id`, `snack_id`, `quantity`) VALUES ('1', '6', '10');
INSERT INTO `yuriichuk`.`loaded_snack` (`vending_machine_snacks_loading_id`, `snack_id`, `quantity`) VALUES ('2', '2', '8');
INSERT INTO `yuriichuk`.`loaded_snack` (`vending_machine_snacks_loading_id`, `snack_id`, `quantity`) VALUES ('2', '7', '6');
INSERT INTO `yuriichuk`.`loaded_snack` (`vending_machine_snacks_loading_id`, `snack_id`, `quantity`) VALUES ('3', '4', '1');
INSERT INTO `yuriichuk`.`loaded_snack` (`vending_machine_snacks_loading_id`, `snack_id`, `quantity`) VALUES ('3', '5', '9');
INSERT INTO `yuriichuk`.`loaded_snack` (`vending_machine_snacks_loading_id`, `snack_id`, `quantity`) VALUES ('4', '3', '5');
INSERT INTO `yuriichuk`.`loaded_snack` (`vending_machine_snacks_loading_id`, `snack_id`, `quantity`) VALUES ('4', '6', '6');
INSERT INTO `yuriichuk`.`loaded_snack` (`vending_machine_snacks_loading_id`, `snack_id`, `quantity`) VALUES ('5', '1', '4');
INSERT INTO `yuriichuk`.`loaded_snack` (`vending_machine_snacks_loading_id`, `snack_id`, `quantity`) VALUES ('5', '7', '11');
INSERT INTO `yuriichuk`.`loaded_snack` (`vending_machine_snacks_loading_id`, `snack_id`, `quantity`) VALUES ('6', '4', '2');
INSERT INTO `yuriichuk`.`loaded_snack` (`vending_machine_snacks_loading_id`, `snack_id`, `quantity`) VALUES ('6', '6', '8');
INSERT INTO `yuriichuk`.`loaded_snack` (`vending_machine_snacks_loading_id`, `snack_id`, `quantity`) VALUES ('7', '3', '7');
INSERT INTO `yuriichuk`.`loaded_snack` (`vending_machine_snacks_loading_id`, `snack_id`, `quantity`) VALUES ('7', '6', '6');


INSERT INTO `yuriichuk`.`vending_machine_money_loading` (`technician_id`, `vending_machine_id`, `time`, `ammount`) VALUES ('1', '1', '2021-09-27 07:57:33', '1000');
INSERT INTO `yuriichuk`.`vending_machine_money_loading` (`technician_id`, `vending_machine_id`, `time`, `ammount`) VALUES ('4', '2', '2021-09-27 08:02:34', '900');
INSERT INTO `yuriichuk`.`vending_machine_money_loading` (`technician_id`, `vending_machine_id`, `time`, `ammount`) VALUES ('2', '3', '2021-09-27 08:06:23', '800');
INSERT INTO `yuriichuk`.`vending_machine_money_loading` (`technician_id`, `vending_machine_id`, `time`, `ammount`) VALUES ('5', '4', '2021-09-27 08:15:59', '1100');
INSERT INTO `yuriichuk`.`vending_machine_money_loading` (`technician_id`, `vending_machine_id`, `time`, `ammount`) VALUES ('6', '5', '2021-09-27 08:10:12', '950');
INSERT INTO `yuriichuk`.`vending_machine_money_loading` (`technician_id`, `vending_machine_id`, `time`, `ammount`) VALUES ('3', '6', '2021-09-27 07:53:44', '800');
INSERT INTO `yuriichuk`.`vending_machine_money_loading` (`technician_id`, `vending_machine_id`, `time`, `ammount`) VALUES ('3', '7', '2021-09-27 08:06:11', '750');


INSERT INTO `yuriichuk`.`vending_machine_money_unloading` (`technician_id`, `vending_machine_id`, `time`, `ammount`) VALUES ('1', '1', '2021-09-27 19:37:43', '525');
INSERT INTO `yuriichuk`.`vending_machine_money_unloading` (`technician_id`, `vending_machine_id`, `time`, `ammount`) VALUES ('4', '2', '2021-09-27 20:03:12', '700');
INSERT INTO `yuriichuk`.`vending_machine_money_unloading` (`technician_id`, `vending_machine_id`, `time`, `ammount`) VALUES ('2', '3', '2021-09-27 19:47:31', '585');
INSERT INTO `yuriichuk`.`vending_machine_money_unloading` (`technician_id`, `vending_machine_id`, `time`, `ammount`) VALUES ('5', '4', '2021-09-27 19:49:12', '385');
INSERT INTO `yuriichuk`.`vending_machine_money_unloading` (`technician_id`, `vending_machine_id`, `time`, `ammount`) VALUES ('6', '5', '2021-09-27 20:11:32', '640');
INSERT INTO `yuriichuk`.`vending_machine_money_unloading` (`technician_id`, `vending_machine_id`, `time`, `ammount`) VALUES ('3', '6', '2021-09-27 19:51:59', '370');
INSERT INTO `yuriichuk`.`vending_machine_money_unloading` (`technician_id`, `vending_machine_id`, `time`, `ammount`) VALUES ('3', '7', '2021-09-27 20:41:26', '455');