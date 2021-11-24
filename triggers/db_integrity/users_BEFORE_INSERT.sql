DROP TRIGGER IF EXISTS `yuriichuk_7_72`.`users_BEFORE_INSERT`;

DELIMITER $$
USE `yuriichuk_7_72`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `users_BEFORE_INSERT` BEFORE INSERT ON `users` FOR EACH ROW BEGIN
	IF NOT new.password_id IN (
		SELECT id FROM passwords) THEN
        SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK constraint. Referenced password NOT FOUND.";
    END IF;    
END$$
DELIMITER ;
