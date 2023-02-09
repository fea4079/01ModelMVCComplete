PRODUCT 테이블 구조
    1	            2               3                 4                    5                 6             7
 PROD_NO	PROD_NAME	PROD_DETAIL	MANUFACTURE_DAY		PRICE		IMAGE_FILE	REG_DATE
NN NUMBER     NN VARCHAR2(100)  VARCHAR2(200)   VARCHAR2(10)            NUMBER(10)      VARCHAR2(100)   DATE


findUser
	select * from USERS where USER_ID=?
	select * from USERS WHERE USER_ID LIKE'%user%'

예제참고select employee_id,first_name,salary
	from employees
	where LOWER(first_name) like'%al%'
	and salary>=4000


insertUser
	insert into PRODUCT(PROD_NO, PROD_NAME, PROD_DETAIL, MANUFACTURE_DAY, PRICE, IMAGE_FILE, REG_DATE) 
			    values (seq_product_prod_no.NEXTVAL, '1AF', 'ASDF', '23-33-3', 90000, 'ASDA', SYSDATE)
			    //들어간거 확인

	insert into PRODUCT(PROD_NO, PROD_NAME, PROD_DETAIL, MANUFACTURE_DAY, PRICE, IMAGE_FILE, REG_DATE) 
		    values (seq_product_prod_no.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)
			//productDAO sql문 작동 확인



updateUser
	update PRODUCT set PROD_NO=10001, PROD_NAME='자전거1', PROD_DETAIL='수정', 
			   MANUFACTURE_DAY='SYSDATE', PRICE=10001, IMAGE_FILE='수정', REG_DATE='23-2-5'

	
	update PRODUCT set PROD_NO=?, PROD_NAME=?, PROD_DETAIL=?, MANUFACTURE_DAY=?, PRICE=?, IMAGE_FILE=?, REG_DATE=?