USE `yuriichuk_7_72`;
DROP procedure IF EXISTS `insert_into_book`;

USE `yuriichuk_7_72`;
DROP procedure IF EXISTS `yuriichuk_7_72`.`insert_into_book`;
;

DELIMITER $$
USE `yuriichuk_7_72`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_into_book`(
	IN in_name VARCHAR(45),
    IN in_authors VARCHAR(45),
    IN in_rating DECIMAL(4, 2),
    IN in_catalog_tree_id INT)
BEGIN
	INSERT INTO `yuriichuk_7_72`.`book` (
		`name`,
        `authors`,
        `rating`,
        `catalog_tree_id`)
    VALUES (
		in_name,
        in_authors,
        in_rating,
        in_catalog_tree_id);
END$$

DELIMITER ;
;

