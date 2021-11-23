DROP TRIGGER IF EXISTS `yuriichuk_7_72`.`passwords_BEFORE_DELETE`;

DELIMITER $$
USE `yuriichuk_7_72`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `passwords_BEFORE_DELETE` BEFORE DELETE ON `passwords` FOR EACH ROW BEGIN
	IF old.id IN (
		SELECT password_id FROM users) THEN
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = "FK constraint. Password is referenced.";
	END IF;		
END$$
DELIMITER ;
