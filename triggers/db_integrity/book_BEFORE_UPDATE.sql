DROP TRIGGER IF EXISTS `yuriichuk_7_72`.`book_BEFORE_UPDATE`;

DELIMITER $$
USE `yuriichuk_7_72`$$
CREATE DEFINER = CURRENT_USER TRIGGER `yuriichuk_7_72`.`book_BEFORE_UPDATE` BEFORE UPDATE ON `book` FOR EACH ROW
BEGIN
	IF NOT new.catalog_tree_id IN (
		SELECT id FROM catalog_tree) THEN
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = "FK constraint. Referenced book NOT FOUND.";
    END IF;    
END$$
DELIMITER ;
