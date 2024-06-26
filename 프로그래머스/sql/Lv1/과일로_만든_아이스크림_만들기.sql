# 소요시간
# [240503] : 8분

# 상반기 주문 정보를 담은 FIRST_HALF
#  아이스크림 성분에 대한 정보를 담은 ICECREAM_INFO

# 아이스크림 공장에서 아이스크림 가게까지의
# SHIPMENT_ID, FLAVOR, TOTAL_ORDER 는 각각
# 출하 번호, 아이스크림 맛, 상반기 아이스크림 총주문량

-- 코드를 입력하세요
SELECT FIRST_HALF.FLAVOR FROM FIRST_HALF
JOIN ICECREAM_INFO
ON FIRST_HALF.FLAVOR = ICECREAM_INFO.FLAVOR
WHERE FIRST_HALF.TOTAL_ORDER > 3000 AND ICECREAM_INFO.INGREDIENT_TYPE = 'fruit_based'
ORDER BY FIRST_HALF.TOTAL_ORDER DESC;
