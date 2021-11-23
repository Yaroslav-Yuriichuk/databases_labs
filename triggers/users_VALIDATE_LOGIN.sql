DROP TRIGGER IF EXISTS `yuriichuk_7_72`.`users_VALIDATE_LOGIN`;

DELIMITER $$
USE `yuriichuk_7_72`$$
CREATE DEFINER = `root`@`localhost` TRIGGER `yuriichuk_7_72`.`users_VALIDATE_LOGIN` BEFORE INSERT ON `users` FOR EACH ROW FOLLOWS `users_BEFORE_INSERT`
BEGIN
	IF (new.login RLIKE "^[0-9]" OR LENGTH(new.login) < 6) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK constraint. Login mustn't start with number and be shorter than 6 characters.";
    END IF;
END$$
DELIMITER ;
