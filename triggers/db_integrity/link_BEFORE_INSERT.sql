DROP TRIGGER IF EXISTS `yuriichuk_7_72`.`link_BEFORE_INSERT`;

DELIMITER $$
USE `yuriichuk_7_72`$$
CREATE DEFINER = CURRENT_USER TRIGGER `yuriichuk_7_72`.`link_BEFORE_INSERT`
BEFORE INSERT ON `link`
FOR EACH ROW
BEGIN
	IF NOT new.book_id IN (
		SELECT id FROM book) THEN
        SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK constraint. Not found referenced book.";
	END IF;
END$$
DELIMITER ;
