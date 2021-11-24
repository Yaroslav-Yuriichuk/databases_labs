-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema yuriichuk_7_72
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema yuriichuk_7_72
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `yuriichuk_7_72` DEFAULT CHARACTER SET utf8 ;
USE `yuriichuk_7_72` ;

/*DROP TABLE IF EXISTS `yuriichuk_7_72`.`book`;
DROP TABLE IF EXISTS `yuriichuk_7_72`.`users`;
DROP TABLE IF EXISTS `yuriichuk_7_72`.`passwords`;
DROP TABLE IF EXISTS `yuriichuk_7_72`.`catalog_tree`;
DROP TABLE IF EXISTS `yuriichuk_7_72`.`link`;
DROP TABLE IF EXISTS `yuriichuk_7_72`.`bookmark`;*/


-- -----------------------------------------------------
-- Table `yuriichuk_7_72`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yuriichuk_7_72`.`book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `authors` VARCHAR(100) NOT NULL,
  `rating` DECIMAL(4,2) NOT NULL,
  `catalog_tree_id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yuriichuk_7_72`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yuriichuk_7_72`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `second_name` VARCHAR(45) NOT NULL,
  `middle_name` VARCHAR(45) NOT NULL,
  `date_of_birth` DATE NULL,
  `address_of_birth` VARCHAR(45) NULL,
  `residence_address` VARCHAR(45) NULL,
  `note` TEXT(100) NULL,
  `rating` DECIMAL(4,2) NULL,
  `password_id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yuriichuk_7_72`.`passwords`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yuriichuk_7_72`.`passwords` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yuriichuk_7_72`.`catalog_tree`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yuriichuk_7_72`.`catalog_tree` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `heading` VARCHAR(45) NOT NULL,
  `parent_catalog_id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yuriichuk_7_72`.`reference`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yuriichuk_7_72`.`link` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `book_email_address` VARCHAR(45) NOT NULL,
  `book_id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yuriichuk_7_72`.`bookmark`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yuriichuk_7_72`.`bookmark` (
  `user_id` INT NOT NULL,
  `book_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `book_id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
