USE `yuriichuk_7_72`;
DROP procedure IF EXISTS `yuriichuk_7_72`.`clear_tables`;
;

DELIMITER $$
USE `yuriichuk_7_72`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `clear_tables`()
BEGIN
	DELETE FROM bookmark;
    DELETE FROM users;
    DELETE FROM passwords;
    DELETE FROM link;
    DELETE FROM book;
    DELETE FROM catalog_tree ORDER BY id DESC;
    
    ALTER TABLE users AUTO_INCREMENT = 1;
    ALTER TABLE passwords AUTO_INCREMENT = 1;
    ALTER TABLE link AUTO_INCREMENT = 1;
    ALTER TABLE book AUTO_INCREMENT = 1;
    ALTER TABLE catalog_tree AUTO_INCREMENT = 1;
END$$

DELIMITER ;
