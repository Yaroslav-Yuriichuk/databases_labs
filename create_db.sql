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

-- -----------------------------------------------------
-- Table `yuriichuk`.`brand`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yuriichuk`.`brand` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `foundation_data` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yuriichuk`.`snack`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yuriichuk`.`snack` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DECIMAL(7,2) NOT NULL,
  `weight` INT NOT NULL,
  `callories` INT NULL,
  `brand_id` INT NOT NULL,
  PRIMARY KEY (`id`, `brand_id`),
  INDEX `fk_snack_brand_idx` (`brand_id` ASC) VISIBLE,
  CONSTRAINT `fk_snack_brand`
    FOREIGN KEY (`brand_id`)
    REFERENCES `yuriichuk`.`brand` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yuriichuk`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yuriichuk`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `region` VARCHAR(45) NOT NULL,
  `city_village` VARCHAR(45) NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  `building` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yuriichuk`.`vending_machine`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yuriichuk`.`vending_machine` (
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
CREATE TABLE IF NOT EXISTS `yuriichuk`.`technician` (
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
CREATE TABLE IF NOT EXISTS `yuriichuk`.`vending_machine_snacks_loading` (
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
CREATE TABLE IF NOT EXISTS `yuriichuk`.`vending_machine_money_loading` (
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
CREATE TABLE IF NOT EXISTS `yuriichuk`.`vending_machine_menu` (
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
CREATE TABLE IF NOT EXISTS `yuriichuk`.`vending_machine_available_snack` (
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
CREATE TABLE IF NOT EXISTS `yuriichuk`.`loaded_snack` (
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
CREATE TABLE IF NOT EXISTS `yuriichuk`.`vending_machine_sold_snack` (
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
CREATE TABLE IF NOT EXISTS `yuriichuk`.`vending_machine_money_unloading` (
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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
