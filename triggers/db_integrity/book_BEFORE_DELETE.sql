DROP TRIGGER IF EXISTS `yuriichuk_7_72`.`book_BEFORE_DELETE`;

DELIMITER $$
USE `yuriichuk_7_72`$$
CREATE DEFINER = CURRENT_USER TRIGGER `yuriichuk_7_72`.`book_BEFORE_DELETE` BEFORE DELETE ON `book` FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT book_id FROM link) OR 
		old.id IN (SELECT book_id FROM bookmark)) THEN
        SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK constraint. Book is referenced.";
    END IF;    
END$$
DELIMITER ;
