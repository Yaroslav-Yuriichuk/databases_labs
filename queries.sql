
-- Знайдіть номер моделі, тип та ціну для всіх 
-- принтерів, вартість яких менше 300 дол. Вивести: model, type, price. 
-- Вихідні дані впорядкувати за спаданням за стовпцем type.
SELECT model, type, price
FROM printer
WHERE price < 300
ORDER BY type desc;


-- Вивести назви битв, які складаються із двох слів та 
-- друге слово не закінчується на літеру 'c'.
SELECT name
FROM battles
WHERE name NOT LIKE '%c' AND name LIKE '% %' AND NOT name LIKE '% % %';


-- Для кораблів таблиці Ships вивести країни, яким 
-- вони належать.
SELECT ships.name, classes.country
FROM ships
LEFT JOIN classes
ON ships.class = classes.class;


-- Знайдіть виробників, що випускають ПК, але не 
-- ноутбуки (використати ключове слово SOME). Вивести maker.
SELECT distinct maker
FROM product
WHERE type = 'PC' AND NOT maker = SOME(
	SELECT maker FROM product
	WHERE type = 'Laptop');
    

-- За Вашингтонським міжнародним договором від 
-- початку 1922 р. заборонялося будувати лінійні кораблі 
-- водотоннажністю понад 35 тис. тонн. Вкажіть кораблі, що порушили 
-- цей договір (враховувати лише кораблі з відомим спуском на воду, 
-- тобто з таблиці Ships). Виведіть: name, launched, displacement.
SELECT name, launched, displacement
FROM ships
INNER JOIN classes
ON ships.class = classes.class
WHERE ships.launched IS NOT NULL AND classes.displacement <= 35000;


-- Для таблиці PC вивести всю інформацію з 
-- коментарями в кожній комірці, наприклад, 'модель: 1121', 'ціна: 
-- 600,00' і т.д.
SELECT
	CONCAT('Code: ', code) AS Code,
    CONCAT('Model: ', model) AS Model,
    CONCAT('Speed: ', speed) AS Speed,
    CONCAT('Ram: ', ram) AS Ram,
    CONCAT('Hd: ', hd) AS Hd,
    CONCAT('Cd: ', cd) AS cd
FROM pc;


-- Вкажіть битви, у яких брало участь, по крайній мірі, 
-- два кораблі однієї й тієї ж країни (Вибір країни здійснювати через таб-
-- лицю Ships, а назви кораблів для таблиці Outcomes, що відсутні в таб-
-- лиці Ships, не брати до уваги). Вивести: назву битви, країну, кількість 
-- кораблів.
SELECT * FROM
	(SELECT battle, country, COUNT(*) AS 'Number of Ships' FROM (ships
		INNER JOIN classes
		ON ships.class = classes.class)
	INNER JOIN
		(outcomes
		INNER JOIN battles
		ON outcomes.battle = battles.name)
	ON outcomes.ship = ships.name
	GROUP BY battle, country
	HAVING COUNT(*) > 1) as battles_all_countries
GROUP BY battle;


-- Для кожного виробника знайдіть середній 
-- розмір екрану для ноутбуків, що ним випускається. Вивести: maker, 
-- середній розмір екрану. (Підказка: використовувати підзапити  в 
-- якості обчислювальних стовпців)
SELECT maker, AVG(screen) FROM laptop
INNER JOIN product
ON product.model = laptop.model
GROUP BY maker;


-- Визначити назви всіх кораблів із таблиці Ships, які 
-- задовольняють, у крайньому випадку, комбінації будь-яких трьох кри-
-- теріїв із наступного списку: numGuns=9, bore=16, displacement=46000, 
-- type='bb', country='Japan', launched=1916, class='Revenge'. Вивести: 
-- name, numGuns, bore, displacement, type, country, launched, class. 
-- (Підказка: використати для перевірки умов оператор CASE)
SELECT *
FROM ships
INNER JOIN classes
ON ships.class = classes.class
WHERE (numGuns = 9) 
	+ (bore = 16)
    + (displacement = 46000)
    + (type = 'bb')
    + (country = 'Japan')
    + (launched = 1916)
    + (classes.class = 'Revenge')
    >= 3;


-- Знайдіть класи, у які входить лише один корабель з 
-- усієї БД (врахувати також кораблі в таблиці Outcomes, яких немає в 
-- таблиці Ships). Вивести: class. (Підказка: використовувати оператор 
-- UNION та операцію EXISTS)
SELECT class
FROM (SELECT classes.class, name as ship
	FROM ships
	INNER JOIN classes
	ON classes.class = ships.class
	UNION
	SELECT class, ship
	FROM outcomes
	INNER JOIN classes
	ON outcomes.ship = classes.class) as classes_all_ships
GROUP BY class
HAVING COUNT(*) = 1;
