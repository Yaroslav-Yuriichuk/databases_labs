-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema yuriichuk
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema yuriichuk
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `yuriichuk` DEFAULT CHARACTER SET utf8 ;
USE `yuriichuk` ;

DROP TABLE IF EXISTS `yuriichuk`.`brand`;
DROP TABLE IF EXISTS `yuriichuk`.`snack`;
DROP TABLE IF EXISTS `yuriichuk`.`address`;
DROP TABLE IF EXISTS `yuriichuk`.`vending_machine`;
DROP TABLE IF EXISTS `yuriichuk`.`technician`;
DROP TABLE IF EXISTS `yuriichuk`.`vending_machine_snacks_loading`;
DROP TABLE IF EXISTS `yuriichuk`.`vending_machine_money_loading`;
DROP TABLE IF EXISTS `yuriichuk`.`vending_machine_menu`;
DROP TABLE IF EXISTS `yuriichuk`.`vending_machine_available_snack`;
DROP TABLE IF EXISTS `yuriichuk`.`loaded_snack`;
DROP TABLE IF EXISTS `yuriichuk`.`vending_machine_sold_snack`;
DROP TABLE IF EXISTS `yuriichuk`.`vending_machine_money_unloading`;

-- -----------------------------------------------------
-- Table `yuriichuk`.`brand`
-- -----------------------------------------------------
CREATE TABLE `yuriichuk`.`brand` (
                                     `id` INT NOT NULL AUTO_INCREMENT,
                                     `name` VARCHAR(45) NOT NULL,
                                     `foundation_data` DATE NULL,
                                     PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yuriichuk`.`snack`
-- -----------------------------------------------------
CREATE TABLE `yuriichuk`.`snack` (
                                     `id` INT NOT NULL AUTO_INCREMENT,
                                     `name` VARCHAR(45) NOT NULL,
                                     `price` DECIMAL(7,2) NOT NULL,
                                     `weight` INT NOT NULL,
                                     `callories` INT NULL,
                                     `brand_id` INT NOT NULL,
                                     PRIMARY KEY (`id`, `brand_id`),
                                     INDEX `fk_snack_brand_idx` (`brand_id` ASC) VISIBLE,
                                     INDEX `snack_name_idx` (`name` ASC) VISIBLE,
                                     CONSTRAINT `fk_snack_brand`
                                         FOREIGN KEY (`brand_id`)
                                             REFERENCES `yuriichuk`.`brand` (`id`)
                                             ON DELETE NO ACTION
                                             ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yuriichuk`.`address`
-- -----------------------------------------------------
CREATE TABLE `yuriichuk`.`address` (
                                       `id` INT NOT NULL AUTO_INCREMENT,
                                       `region` VARCHAR(45) NOT NULL,
                                       `city_village` VARCHAR(45) NOT NULL,
                                       `street` VARCHAR(45) NOT NULL,
                                       `building` VARCHAR(45) NOT NULL,
                                       PRIMARY KEY (`id`),
                                       INDEX `address_city_village_idx` (`city_village` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yuriichuk`.`vending_machine`
-- -----------------------------------------------------
CREATE TABLE `yuriichuk`.`vending_machine` (
                                               `id` INT NOT NULL AUTO_INCREMENT,
                                               `coordinates` VARCHAR(45) NOT NULL,
                                               `address_id` INT NOT NULL,
                                               PRIMARY KEY (`id`),
                                               INDEX `fk_vending_machine_address1_idx` (`address_id` ASC) VISIBLE,
                                               CONSTRAINT `fk_vending_machine_address1`
                                                   FOREIGN KEY (`address_id`)
                                                       REFERENCES `yuriichuk`.`address` (`id`)
                                                       ON DELETE NO ACTION
                                                       ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yuriichuk`.`technician`
-- -----------------------------------------------------
CREATE TABLE `yuriichuk`.`technician` (
                                          `id` INT NOT NULL AUTO_INCREMENT,
                                          `first_name` VARCHAR(45) NOT NULL,
                                          `last_name` VARCHAR(45) NOT NULL,
                                          `age` INT NULL,
                                          `work_entry_date` DATE NOT NULL,
                                          PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yuriichuk`.`vending_machine_snacks_loading`
-- -----------------------------------------------------
CREATE TABLE `yuriichuk`.`vending_machine_snacks_loading` (
                                                              `id` INT NOT NULL AUTO_INCREMENT,
                                                              `technician_id` INT NOT NULL,
                                                              `vending_machine_id` INT NOT NULL,
                                                              `time` TIMESTAMP NOT NULL,
                                                              PRIMARY KEY (`id`, `technician_id`, `vending_machine_id`),
                                                              INDEX `fk_vending_machine_snacks_loading_technician1_idx` (`technician_id` ASC) VISIBLE,
                                                              INDEX `fk_vending_machine_snacks_loading_vending_machine1_idx` (`vending_machine_id` ASC) VISIBLE,
                                                              CONSTRAINT `fk_vending_machine_snacks_loading_technician1`
                                                                  FOREIGN KEY (`technician_id`)
                                                                      REFERENCES `yuriichuk`.`technician` (`id`)
                                                                      ON DELETE NO ACTION
                                                                      ON UPDATE NO ACTION,
                                                              CONSTRAINT `fk_vending_machine_snacks_loading_vending_machine1`
                                                                  FOREIGN KEY (`vending_machine_id`)
                                                                      REFERENCES `yuriichuk`.`vending_machine` (`id`)
                                                                      ON DELETE NO ACTION
                                                                      ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yuriichuk`.`vending_machine_money_loading`
-- -----------------------------------------------------
CREATE TABLE `yuriichuk`.`vending_machine_money_loading` (
                                                             `id` INT NOT NULL AUTO_INCREMENT,
                                                             `technician_id` INT NOT NULL,
                                                             `vending_machine_id` INT NOT NULL,
                                                             `time` TIMESTAMP NOT NULL,
                                                             `ammount` DECIMAL(7,2) NOT NULL,
                                                             PRIMARY KEY (`id`, `technician_id`, `vending_machine_id`),
                                                             INDEX `fk_vending_machine_money_loading_technician1_idx` (`technician_id` ASC) VISIBLE,
                                                             INDEX `fk_vending_machine_money_loading_vending_machine1_idx` (`vending_machine_id` ASC) VISIBLE,
                                                             CONSTRAINT `fk_vending_machine_money_loading_technician1`
                                                                 FOREIGN KEY (`technician_id`)
                                                                     REFERENCES `yuriichuk`.`technician` (`id`)
                                                                     ON DELETE NO ACTION
                                                                     ON UPDATE NO ACTION,
                                                             CONSTRAINT `fk_vending_machine_money_loading_vending_machine1`
                                                                 FOREIGN KEY (`vending_machine_id`)
                                                                     REFERENCES `yuriichuk`.`vending_machine` (`id`)
                                                                     ON DELETE NO ACTION
                                                                     ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yuriichuk`.`vending_machine_menu`
-- -----------------------------------------------------
CREATE TABLE `yuriichuk`.`vending_machine_menu` (
                                                    `vending_machine_id` INT NOT NULL,
                                                    `snack_id` INT NOT NULL,
                                                    PRIMARY KEY (`vending_machine_id`, `snack_id`),
                                                    INDEX `fk_vending_machine_has_snack_snack1_idx` (`snack_id` ASC) VISIBLE,
                                                    INDEX `fk_vending_machine_has_snack_vending_machine1_idx` (`vending_machine_id` ASC) VISIBLE,
                                                    CONSTRAINT `fk_vending_machine_has_snack_vending_machine1`
                                                        FOREIGN KEY (`vending_machine_id`)
                                                            REFERENCES `yuriichuk`.`vending_machine` (`id`)
                                                            ON DELETE NO ACTION
                                                            ON UPDATE NO ACTION,
                                                    CONSTRAINT `fk_vending_machine_has_snack_snack1`
                                                        FOREIGN KEY (`snack_id`)
                                                            REFERENCES `yuriichuk`.`snack` (`id`)
                                                            ON DELETE NO ACTION
                                                            ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yuriichuk`.`vending_machine_available_snack`
-- -----------------------------------------------------
CREATE TABLE `yuriichuk`.`vending_machine_available_snack` (
                                                               `vending_machine_id` INT NOT NULL,
                                                               `snack_id` INT NOT NULL,
                                                               `quantity` INT NOT NULL,
                                                               PRIMARY KEY (`vending_machine_id`, `snack_id`),
                                                               INDEX `fk_vending_machine_has_snack_snack2_idx` (`snack_id` ASC) VISIBLE,
                                                               INDEX `fk_vending_machine_has_snack_vending_machine2_idx` (`vending_machine_id` ASC) VISIBLE,
                                                               CONSTRAINT `fk_vending_machine_has_snack_vending_machine2`
                                                                   FOREIGN KEY (`vending_machine_id`)
                                                                       REFERENCES `yuriichuk`.`vending_machine` (`id`)
                                                                       ON DELETE NO ACTION
                                                                       ON UPDATE NO ACTION,
                                                               CONSTRAINT `fk_vending_machine_has_snack_snack2`
                                                                   FOREIGN KEY (`snack_id`)
                                                                       REFERENCES `yuriichuk`.`snack` (`id`)
                                                                       ON DELETE NO ACTION
                                                                       ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yuriichuk`.`loaded_snack`
-- -----------------------------------------------------
CREATE TABLE `yuriichuk`.`loaded_snack` (
                                            `vending_machine_snacks_loading_id` INT NOT NULL,
                                            `snack_id` INT NOT NULL,
                                            `quantity` INT NOT NULL,
                                            PRIMARY KEY (`vending_machine_snacks_loading_id`, `snack_id`),
                                            INDEX `fk_vending_machine_snacks_loading_has_snack_snack1_idx` (`snack_id` ASC) VISIBLE,
                                            INDEX `fk_vending_machine_snacks_loading_has_snack_vending_machine_idx` (`vending_machine_snacks_loading_id` ASC) VISIBLE,
                                            CONSTRAINT `fk_vending_machine_snacks_loading_has_snack_vending_machine_s1`
                                                FOREIGN KEY (`vending_machine_snacks_loading_id`)
                                                    REFERENCES `yuriichuk`.`vending_machine_snacks_loading` (`id`)
                                                    ON DELETE NO ACTION
                                                    ON UPDATE NO ACTION,
                                            CONSTRAINT `fk_vending_machine_snacks_loading_has_snack_snack1`
                                                FOREIGN KEY (`snack_id`)
                                                    REFERENCES `yuriichuk`.`snack` (`id`)
                                                    ON DELETE NO ACTION
                                                    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yuriichuk`.`vending_machine_sold_snack`
-- -----------------------------------------------------
CREATE TABLE `yuriichuk`.`vending_machine_sold_snack` (
                                                          `id` INT NOT NULL AUTO_INCREMENT,
                                                          `vending_machine_id` INT NOT NULL,
                                                          `snack_id` INT NOT NULL,
                                                          `quantity` INT NOT NULL,
                                                          `date` DATE NULL,
                                                          PRIMARY KEY (`id`, `vending_machine_id`, `snack_id`),
                                                          INDEX `fk_vending_machine_has_snack_snack3_idx` (`snack_id` ASC) VISIBLE,
                                                          INDEX `fk_vending_machine_has_snack_vending_machine3_idx` (`vending_machine_id` ASC) VISIBLE,
                                                          CONSTRAINT `fk_vending_machine_has_snack_vending_machine3`
                                                              FOREIGN KEY (`vending_machine_id`)
                                                                  REFERENCES `yuriichuk`.`vending_machine` (`id`)
                                                                  ON DELETE NO ACTION
                                                                  ON UPDATE NO ACTION,
                                                          CONSTRAINT `fk_vending_machine_has_snack_snack3`
                                                              FOREIGN KEY (`snack_id`)
                                                                  REFERENCES `yuriichuk`.`snack` (`id`)
                                                                  ON DELETE NO ACTION
                                                                  ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yuriichuk`.`vending_machine_money_unloading`
-- -----------------------------------------------------
CREATE TABLE `yuriichuk`.`vending_machine_money_unloading` (
                                                               `id` INT NOT NULL AUTO_INCREMENT,
                                                               `technician_id` INT NOT NULL,
                                                               `vending_machine_id` INT NOT NULL,
                                                               `time` TIMESTAMP NOT NULL,
                                                               `ammount` DECIMAL(7,2) NOT NULL,
                                                               PRIMARY KEY (`id`, `technician_id`, `vending_machine_id`),
                                                               INDEX `fk_vending_machine_money_unloading_technician1_idx` (`technician_id` ASC) VISIBLE,
                                                               INDEX `fk_vending_machine_money_unloading_vending_machine1_idx` (`vending_machine_id` ASC) VISIBLE,
                                                               CONSTRAINT `fk_vending_machine_money_unloading_technician1`
                                                                   FOREIGN KEY (`technician_id`)
                                                                       REFERENCES `yuriichuk`.`technician` (`id`)
                                                                       ON DELETE NO ACTION
                                                                       ON UPDATE NO ACTION,
                                                               CONSTRAINT `fk_vending_machine_money_unloading_vending_machine1`
                                                                   FOREIGN KEY (`vending_machine_id`)
                                                                       REFERENCES `yuriichuk`.`vending_machine` (`id`)
                                                                       ON DELETE NO ACTION
                                                                       ON UPDATE NO ACTION)
    ENGINE = InnoDB;


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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
