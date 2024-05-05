# DATE_FORMAT 함수

SELECT BOOK_ID,DATE_FORMAT(PUBLISHED_DATE,'%Y-%m-%d') FROM BOOK
WHERE category = '인문' AND published_date LIKE '2021-%'
ORDER BY published_date ASC;