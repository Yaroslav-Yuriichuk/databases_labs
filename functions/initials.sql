USE `yuriichuk_7_72`;
DROP function IF EXISTS `initials`;

DELIMITER $$
USE `yuriichuk_7_72`$$
CREATE FUNCTION `initials` (
	first_name VARCHAR(45),
    second_name VARCHAR(45),
    middle_name VARCHAR(45))
RETURNS VARCHAR(3)
DETERMINISTIC
BEGIN
RETURN CONCAT(
	LEFT(first_name, 1),
    LEFT(second_name, 1),
    LEFT(middle_name, 1));
END$$

DELIMITER ;

