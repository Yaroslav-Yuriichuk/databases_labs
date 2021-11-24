USE `yuriichuk_7_72`;
DROP procedure IF EXISTS `insert_into_catalog_tree`;

DELIMITER $$
USE `yuriichuk_7_72`$$
CREATE PROCEDURE `insert_into_catalog_tree` (
	IN in_heading VARCHAR(45),
    IN in_parent_catalog_id INT)
BEGIN
	INSERT INTO `yuriichuk_7_72`.`catalog_tree` (
		`heading`,
        `parent_catalog_id`)
    VALUES (
		in_heading,
        in_parent_catalog_id);
END$$

DELIMITER ;
