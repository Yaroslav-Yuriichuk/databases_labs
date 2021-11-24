DROP TRIGGER IF EXISTS `yuriichuk_7_72`.`users_VALIDATE_RATING`;

DELIMITER $$
USE `yuriichuk_7_72`$$
CREATE DEFINER = `root`@`localhost` TRIGGER `yuriichuk_7_72`.`users_VALIDATE_RATING` BEFORE INSERT ON `users` FOR EACH ROW FOLLOWS `users_VALIDATE_LOGIN`
BEGIN
	IF NOT new.rating BETWEEN 1 AND 10 THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Rating must be between 1 and 10 inclusively";
    END IF;
END$$
DELIMITER ;
