PRODUCT ���̺� ����
    1	            2               3                 4                    5                 6             7
 PROD_NO	PROD_NAME	PROD_DETAIL	MANUFACTURE_DAY		PRICE		IMAGE_FILE	REG_DATE
NN NUMBER     NN VARCHAR2(100)  VARCHAR2(200)   VARCHAR2(10)            NUMBER(10)      VARCHAR2(100)   DATE


findProduct
	select * from PRODUCT where PROD_NO=?

insertProduct
	insert into PRODUCT(PROD_NO, PROD_NAME, PROD_DETAIL, MANUFACTURE_DAY, PRICE, IMAGE_FILE, REG_DATE) 
			    values (seq_product_prod_no.NEXTVAL, '1AF', 'ASDF', '23-33-3', 90000, 'ASDA', SYSDATE)
			    //���� Ȯ��

	insert into PRODUCT(PROD_NO, PROD_NAME, PROD_DETAIL, MANUFACTURE_DAY, PRICE, IMAGE_FILE, REG_DATE) 
		    values (seq_product_prod_no.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)
			//productDAO sql�� �۵� Ȯ��



updateProduct
	update PRODUCT set PROD_NO=10001, PROD_NAME='������1', PROD_DETAIL='����', 
			   MANUFACTURE_DAY='SYSDATE', PRICE=10001, IMAGE_FILE='����', REG_DATE='23-2-5'

	
	update PRODUCT set PROD_NO=?, PROD_NAME=?, PROD_DETAIL=?, MANUFACTURE_DAY=?, PRICE=?, IMAGE_FILE=?, REG_DATE=?