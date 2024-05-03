# 소요시간
# [240503] : 정답참고


# ANIMAL_INS : 동물 보호소에 들어온 동물의 정보
# ANIMAL_OUTS : 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블
# ANIMAL_OUTS 테이블의 ANIMAL_ID는 / ANIMAL_INS의 ANIMAL_ID의 외래 키입니다.

# 아직 입양을 못 간 동물 중,
# 가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회하는 SQL문을 작성해주세요.


-- 코드를 입력하세요

SELECT ANIMAL_INS.NAME, ANIMAL_INS.DATETIME FROM ANIMAL_INS
LEFT JOIN ANIMAL_OUTS
ON ANIMAL_OUTS.ANIMAL_ID = ANIMAL_INS.ANIMAL_ID
WHERE ANIMAL_OUTS.ANIMAL_ID IS NULL
ORDER BY ANIMAL_INS.DATETIME ASC
LIMIT 3;