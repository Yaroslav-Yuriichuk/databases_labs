DROP TRIGGER IF EXISTS `yuriichuk_7_72`.`users_BEFORE_UPDATE`;

DELIMITER $$
USE `yuriichuk_7_72`$$
CREATE DEFINER = CURRENT_USER TRIGGER `yuriichuk_7_72`.`users_BEFORE_UPDATE` BEFORE UPDATE ON `users` FOR EACH ROW
BEGIN
	IF NOT new.password_id IN (
		SELECT id FROM passwords) THEN
        SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK constraint. Referenced password NOT FOUND.";
    END IF;
END$$
DELIMITER ;
