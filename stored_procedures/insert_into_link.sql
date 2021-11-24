USE `yuriichuk_7_72`;
DROP procedure IF EXISTS `insert_into_link`;

DELIMITER $$
USE `yuriichuk_7_72`$$
CREATE PROCEDURE `insert_into_link` (
	IN in_book_email_address VARCHAR(45),
    IN in_book_id INT)
BEGIN
	INSERT INTO `yuriichuk_7_72`.`link` (
		`book_email_address`,
        `book_id`)
    VALUES (
		in_book_email_address,
        in_book_id);
END$$

DELIMITER ;
