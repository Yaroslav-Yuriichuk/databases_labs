DROP TRIGGER IF EXISTS `yuriichuk_7_72`.`book_BEFORE_INSERT`;

DELIMITER $$
USE `yuriichuk_7_72`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `book_BEFORE_INSERT` BEFORE INSERT ON `book` FOR EACH ROW BEGIN
	IF NOT new.catalog_tree_id IN (
		SELECT id FROM catalog_tree) THEN
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = "FK constraint. Referenced catalog_tree NOT FOUND.";
	END IF;		
END$$
DELIMITER ;
