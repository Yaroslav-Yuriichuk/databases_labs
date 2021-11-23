DROP TRIGGER IF EXISTS `yuriichuk_7_72`.`bookmark_BEFORE_UPDATE`;

DELIMITER $$
USE `yuriichuk_7_72`$$
CREATE DEFINER = CURRENT_USER TRIGGER `yuriichuk_7_72`.`bookmark_BEFORE_UPDATE` BEFORE UPDATE ON `bookmark` FOR EACH ROW
BEGIN
	IF NOT new.user_id IN (
		SELECT id FROM users) THEN
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = "FK constraint. Referenced user NOT FOUND.";
    END IF;
    IF NOT new.book_id IN (
		SELECT id FROM book) THEN
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = "FK constraint. Referenced book NOT FOUND.";
    END IF;   
END$$
DELIMITER ;
