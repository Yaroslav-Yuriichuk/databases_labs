USE `yuriichuk_7_72`;
DROP procedure IF EXISTS `insert_into_passwords`;

DELIMITER $$
USE `yuriichuk_7_72`$$
CREATE PROCEDURE `insert_into_passwords` (
	IN in_password VARCHAR(45))
BEGIN
	INSERT INTO `yuriichuk_7_72`.`passwords` (`password`)
    VALUES (in_password);
END$$

DELIMITER ;
