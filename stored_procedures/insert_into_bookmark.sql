USE `yuriichuk_7_72`;
DROP procedure IF EXISTS `insert_into_bookmark`;

DELIMITER $$
USE `yuriichuk_7_72`$$
CREATE PROCEDURE `insert_into_bookmark` (
	IN in_user_id INT,
    IN in_book_id INT)
BEGIN
	INSERT INTO `yuriichuk_7_72`.`bookmark` (
		`user_id`,
        `book_id`)
    VALUES (
		in_user_id,
        in_book_id);
END$$

DELIMITER ;
