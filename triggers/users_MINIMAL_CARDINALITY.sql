DROP TRIGGER IF EXISTS `yuriichuk_7_72`.`users_AFTER_DELETE`;

DELIMITER $$
USE `yuriichuk_7_72`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `users_AFTER_DELETE` AFTER DELETE ON `users` FOR EACH ROW BEGIN
	IF (SELECT COUNT(*) FROM users) < 2 THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Cardinality constraint. Must be at least 2 users.";
    END IF;
END$$
DELIMITER ;
