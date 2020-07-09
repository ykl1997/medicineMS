--------------------------------------------------------
--  File created - 星期二-七月-07-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SEQ_CUS
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_CUS"  MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 11 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_EMP
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_EMP"  MINVALUE 1 MAXVALUE 99999 INCREMENT BY 1 START WITH 12 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_INPUT
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_INPUT"  MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 20 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_MEDI
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_MEDI"  MINVALUE 1 MAXVALUE 99999999 INCREMENT BY 1 START WITH 21 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_OUT
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_OUT"  MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 10 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table CUSTOMER_INFO
--------------------------------------------------------

  CREATE TABLE "CUSTOMER_INFO" 
   (	"ID" NUMBER(20,0), 
	"NAME" VARCHAR2(255), 
	"PHONE" VARCHAR2(255), 
	"PASSWORD" VARCHAR2(10)
   ) ;
--------------------------------------------------------
--  DDL for Table EMPLOYEE_INFO
--------------------------------------------------------

  CREATE TABLE "EMPLOYEE_INFO" 
   (	"ID" NUMBER(20,0), 
	"NAME" VARCHAR2(255), 
	"SEX" VARCHAR2(255), 
	"DEGREE" VARCHAR2(255), 
	"POSITION" VARCHAR2(255), 
	"AGE" NUMBER(3,0), 
	"PASSWORD" VARCHAR2(20)
   ) ;
--------------------------------------------------------
--  DDL for Table MEDI_INFO
--------------------------------------------------------

  CREATE TABLE "MEDI_INFO" 
   (	"MEDI_ID" NUMBER(10,0), 
	"MEDI_NAME" VARCHAR2(255), 
	"MUNIFAC" VARCHAR2(255), 
	"MUNIDATE" DATE, 
	"FACTION" VARCHAR2(255), 
	"PRICE" NUMBER(5,2), 
	"DEAD_LINE" DATE, 
	"NUM" NUMBER(20,0), 
	"POSITION" VARCHAR2(30)
   ) ;
--------------------------------------------------------
--  DDL for Table T_INPUT
--------------------------------------------------------

  CREATE TABLE "T_INPUT" 
   (	"ID" NUMBER, 
	"MEDI_ID" NUMBER, 
	"INNUM" NUMBER, 
	"EID" NUMBER
   ) ;
--------------------------------------------------------
--  DDL for Table T_OUTPUT
--------------------------------------------------------

  CREATE TABLE "T_OUTPUT" 
   (	"ID" NUMBER, 
	"MEDI_ID" NUMBER, 
	"OUTNUM" NUMBER, 
	"CID" NUMBER, 
	"TOTAL_PRINCE" NUMBER(10,2), 
	"OUT_DATE" DATE
   ) ;

---------------------------------------------------
--   DATA FOR TABLE CUSTOMER_INFO
--   FILTER = none used
---------------------------------------------------
REM INSERTING into CUSTOMER_INFO
Insert into CUSTOMER_INFO (ID,NAME,PHONE,PASSWORD) values (10,'王方','18956422368','123456');
Insert into CUSTOMER_INFO (ID,NAME,PHONE,PASSWORD) values (1,'李华','123456','123456');

---------------------------------------------------
--   END DATA FOR TABLE CUSTOMER_INFO
---------------------------------------------------


---------------------------------------------------
--   DATA FOR TABLE EMPLOYEE_INFO
--   FILTER = none used
---------------------------------------------------
REM INSERTING into EMPLOYEE_INFO
Insert into EMPLOYEE_INFO (ID,NAME,SEX,DEGREE,POSITION,AGE,PASSWORD) values (1,'李华','男','本科','员工',28,'123456');

---------------------------------------------------
--   END DATA FOR TABLE EMPLOYEE_INFO
---------------------------------------------------


---------------------------------------------------
--   DATA FOR TABLE MEDI_INFO
--   FILTER = none used
---------------------------------------------------
REM INSERTING into MEDI_INFO
Insert into MEDI_INFO (MEDI_ID,MEDI_NAME,MUNIFAC,MUNIDATE,FACTION,PRICE,DEAD_LINE,NUM,POSITION) values (1,'阿司匹林','光大制药',to_timestamp('05-5月 -20 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),'治感冒',12,to_timestamp('03-7月 -22 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),200,'A01');
Insert into MEDI_INFO (MEDI_ID,MEDI_NAME,MUNIFAC,MUNIDATE,FACTION,PRICE,DEAD_LINE,NUM,POSITION) values (2,'非那根','光大制药',to_timestamp('05-5月 -20 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),'治疗皮肤过敏',20,to_timestamp('03-7月 -22 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),400,'A02');
Insert into MEDI_INFO (MEDI_ID,MEDI_NAME,MUNIFAC,MUNIDATE,FACTION,PRICE,DEAD_LINE,NUM,POSITION) values (3,'盐酸奈福泮','光大制药',to_timestamp('14-4月 -20 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),'术后止痛',30,to_timestamp('03-7月 -22 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),400,'A03');
Insert into MEDI_INFO (MEDI_ID,MEDI_NAME,MUNIFAC,MUNIDATE,FACTION,PRICE,DEAD_LINE,NUM,POSITION) values (4,'三磷酸胞苷二钠','光大制药',to_timestamp('14-3月 -20 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),'用于颅脑外伤后综合证',80,to_timestamp('03-7月 -22 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),300,'A04');
Insert into MEDI_INFO (MEDI_ID,MEDI_NAME,MUNIFAC,MUNIDATE,FACTION,PRICE,DEAD_LINE,NUM,POSITION) values (5,'盐酸川芎嗪','光大制药',to_timestamp('05-5月 -20 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),'用于闭塞性脑血管疾病',100,to_timestamp('03-7月 -22 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),495,'A05');
Insert into MEDI_INFO (MEDI_ID,MEDI_NAME,MUNIFAC,MUNIDATE,FACTION,PRICE,DEAD_LINE,NUM,POSITION) values (6,'胃复安','光大制药',to_timestamp('09-2月 -20 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),'镇吐药',20,to_timestamp('03-7月 -21 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),497,'B01');
Insert into MEDI_INFO (MEDI_ID,MEDI_NAME,MUNIFAC,MUNIDATE,FACTION,PRICE,DEAD_LINE,NUM,POSITION) values (7,'可拉明','光大制药',to_timestamp('09-2月 -20 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),'用于中枢性呼吸抑制',150,to_timestamp('03-7月 -21 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),396,'B02');
Insert into MEDI_INFO (MEDI_ID,MEDI_NAME,MUNIFAC,MUNIDATE,FACTION,PRICE,DEAD_LINE,NUM,POSITION) values (8,'利巴韦林','光大制药',to_timestamp('01-3月 -20 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),'抗病毒药',45,to_timestamp('03-7月 -21 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),399,'B03');
Insert into MEDI_INFO (MEDI_ID,MEDI_NAME,MUNIFAC,MUNIDATE,FACTION,PRICE,DEAD_LINE,NUM,POSITION) values (9,'盐酸肾上腺注射液','光大制药',to_timestamp('01-3月 -19 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),'主要适用于因支气管痉挛所致严重呼吸困难',60,to_timestamp('03-7月 -21 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),499,'B04');
Insert into MEDI_INFO (MEDI_ID,MEDI_NAME,MUNIFAC,MUNIDATE,FACTION,PRICE,DEAD_LINE,NUM,POSITION) values (10,'鲁米那','光大制药',to_timestamp('09-2月 -20 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),'治疗癫痫',240,to_timestamp('03-10月-21 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),696,'B05');
Insert into MEDI_INFO (MEDI_ID,MEDI_NAME,MUNIFAC,MUNIDATE,FACTION,PRICE,DEAD_LINE,NUM,POSITION) values (11,'盐酸苯海拉明','光大制药',to_timestamp('01-3月 -20 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),'用于急性重症过敏反应',65,to_timestamp('03-10月-21 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),299,'C01');
Insert into MEDI_INFO (MEDI_ID,MEDI_NAME,MUNIFAC,MUNIDATE,FACTION,PRICE,DEAD_LINE,NUM,POSITION) values (12,'硫酸阿托品注射液','光大制药',to_timestamp('14-4月 -20 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),'缓解各种内脏绞痛',70,to_timestamp('03-10月-21 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),399,'C02');
Insert into MEDI_INFO (MEDI_ID,MEDI_NAME,MUNIFAC,MUNIDATE,FACTION,PRICE,DEAD_LINE,NUM,POSITION) values (13,'复方樟柳碱注射液','光大制药',to_timestamp('09-2月 -20 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),'用于缺血性视神经、视网膜、脉络膜病变',175,to_timestamp('03-10月-21 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),499,'C03');
Insert into MEDI_INFO (MEDI_ID,MEDI_NAME,MUNIFAC,MUNIDATE,FACTION,PRICE,DEAD_LINE,NUM,POSITION) values (14,'碳酸氢钠注射液','光大制药',to_timestamp('05-5月 -20 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),'治疗代谢性酸中毒',100,to_timestamp('03-10月-21 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),499,'C04');
Insert into MEDI_INFO (MEDI_ID,MEDI_NAME,MUNIFAC,MUNIDATE,FACTION,PRICE,DEAD_LINE,NUM,POSITION) values (15,'维生素C注射液','光大制药',to_timestamp('01-3月 -20 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),'治疗坏血病、慢性铁中毒',88,to_timestamp('03-10月-21 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),299,'C05');
Insert into MEDI_INFO (MEDI_ID,MEDI_NAME,MUNIFAC,MUNIDATE,FACTION,PRICE,DEAD_LINE,NUM,POSITION) values (20,'阿莫西林',' 国药集团汕头金石制药有限公司',to_timestamp('07-7月 -20 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),'阿莫西林杀菌作用强，穿透细胞壁的能力也强。是目前应用较为广泛的口服青霉素之一，其制剂有胶囊、片剂、颗粒剂、分散片等等',24.5,to_timestamp('07-7月 -22 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'),0,'A009');

---------------------------------------------------
--   END DATA FOR TABLE MEDI_INFO
---------------------------------------------------


---------------------------------------------------
--   DATA FOR TABLE T_INPUT
--   FILTER = none used
---------------------------------------------------
REM INSERTING into T_INPUT
Insert into T_INPUT (ID,MEDI_ID,INNUM,EID) values (1,1,300,1);
Insert into T_INPUT (ID,MEDI_ID,INNUM,EID) values (2,2,500,1);
Insert into T_INPUT (ID,MEDI_ID,INNUM,EID) values (3,3,500,1);
Insert into T_INPUT (ID,MEDI_ID,INNUM,EID) values (4,4,400,1);
Insert into T_INPUT (ID,MEDI_ID,INNUM,EID) values (5,5,600,1);
Insert into T_INPUT (ID,MEDI_ID,INNUM,EID) values (6,6,500,1);
Insert into T_INPUT (ID,MEDI_ID,INNUM,EID) values (7,7,400,1);
Insert into T_INPUT (ID,MEDI_ID,INNUM,EID) values (8,8,400,1);
Insert into T_INPUT (ID,MEDI_ID,INNUM,EID) values (9,9,500,1);
Insert into T_INPUT (ID,MEDI_ID,INNUM,EID) values (10,10,700,1);
Insert into T_INPUT (ID,MEDI_ID,INNUM,EID) values (11,11,300,1);
Insert into T_INPUT (ID,MEDI_ID,INNUM,EID) values (12,12,400,1);
Insert into T_INPUT (ID,MEDI_ID,INNUM,EID) values (13,13,500,1);
Insert into T_INPUT (ID,MEDI_ID,INNUM,EID) values (14,14,500,1);
Insert into T_INPUT (ID,MEDI_ID,INNUM,EID) values (15,15,300,1);

---------------------------------------------------
--   END DATA FOR TABLE T_INPUT
---------------------------------------------------


---------------------------------------------------
--   DATA FOR TABLE T_OUTPUT
--   FILTER = none used
---------------------------------------------------
REM INSERTING into T_OUTPUT
Insert into T_OUTPUT (ID,MEDI_ID,OUTNUM,CID,TOTAL_PRINCE,OUT_DATE) values (1,1,100,1,1200,to_timestamp('06-7月 -20 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'));
Insert into T_OUTPUT (ID,MEDI_ID,OUTNUM,CID,TOTAL_PRINCE,OUT_DATE) values (2,2,100,1,2000,to_timestamp('06-7月 -20 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'));
Insert into T_OUTPUT (ID,MEDI_ID,OUTNUM,CID,TOTAL_PRINCE,OUT_DATE) values (3,3,100,1,3000,to_timestamp('06-7月 -20 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'));
Insert into T_OUTPUT (ID,MEDI_ID,OUTNUM,CID,TOTAL_PRINCE,OUT_DATE) values (4,4,100,1,800,to_timestamp('06-7月 -20 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'));
Insert into T_OUTPUT (ID,MEDI_ID,OUTNUM,CID,TOTAL_PRINCE,OUT_DATE) values (5,5,100,1,10000,to_timestamp('06-7月 -20 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'));
Insert into T_OUTPUT (ID,MEDI_ID,OUTNUM,CID,TOTAL_PRINCE,OUT_DATE) values (6,6,1,1,20,to_timestamp('06-7月 -20 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'));
Insert into T_OUTPUT (ID,MEDI_ID,OUTNUM,CID,TOTAL_PRINCE,OUT_DATE) values (7,6,2,1,100,to_timestamp('07-7月 -20 12.00.00.000000000 上午','DD-MON-RR HH.MI.SS.FF AM'));

---------------------------------------------------
--   END DATA FOR TABLE T_OUTPUT
---------------------------------------------------

--------------------------------------------------------
--  Constraints for Table CUSTOMER_INFO
--------------------------------------------------------

  ALTER TABLE "CUSTOMER_INFO" ADD CONSTRAINT "CUSTOMER_INFO_PK" PRIMARY KEY ("ID") ENABLE;
 
  ALTER TABLE "CUSTOMER_INFO" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table T_INPUT
--------------------------------------------------------

  ALTER TABLE "T_INPUT" ADD CONSTRAINT "PK1" PRIMARY KEY ("ID") ENABLE;
 
  ALTER TABLE "T_INPUT" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "T_INPUT" MODIFY ("MEDI_ID" NOT NULL ENABLE);
 
  ALTER TABLE "T_INPUT" MODIFY ("INNUM" NOT NULL ENABLE);
 
  ALTER TABLE "T_INPUT" MODIFY ("EID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EMPLOYEE_INFO
--------------------------------------------------------

  ALTER TABLE "EMPLOYEE_INFO" ADD CONSTRAINT "EMPLOYEE_INFO_PK" PRIMARY KEY ("ID") ENABLE;
 
  ALTER TABLE "EMPLOYEE_INFO" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table T_OUTPUT
--------------------------------------------------------

  ALTER TABLE "T_OUTPUT" ADD CONSTRAINT "PRIKEY" PRIMARY KEY ("ID") ENABLE;
 
  ALTER TABLE "T_OUTPUT" MODIFY ("MEDI_ID" NOT NULL ENABLE);
 
  ALTER TABLE "T_OUTPUT" MODIFY ("OUTNUM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MEDI_INFO
--------------------------------------------------------

  ALTER TABLE "MEDI_INFO" ADD CONSTRAINT "MEDI_INFO_PK" PRIMARY KEY ("MEDI_ID") ENABLE;
 
  ALTER TABLE "MEDI_INFO" MODIFY ("MEDI_ID" NOT NULL ENABLE);
 
  ALTER TABLE "MEDI_INFO" MODIFY ("MEDI_NAME" NOT NULL ENABLE);
 
  ALTER TABLE "MEDI_INFO" MODIFY ("NUM" NOT NULL ENABLE);
--------------------------------------------------------
--  DDL for Index EMPLOYEE_INFO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "EMPLOYEE_INFO_PK" ON "EMPLOYEE_INFO" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index MEDI_INFO_IDX
--------------------------------------------------------

  CREATE INDEX "MEDI_INFO_IDX" ON "MEDI_INFO" ("MEDI_NAME") 
  ;
--------------------------------------------------------
--  DDL for Index PK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK1" ON "T_INPUT" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index MEDI_INFO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "MEDI_INFO_PK" ON "MEDI_INFO" ("MEDI_ID") 
  ;
--------------------------------------------------------
--  DDL for Index CUSTOMER_INFO_IDX
--------------------------------------------------------

  CREATE INDEX "CUSTOMER_INFO_IDX" ON "CUSTOMER_INFO" ("NAME") 
  ;
--------------------------------------------------------
--  DDL for Index CUSTOMER_INFO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CUSTOMER_INFO_PK" ON "CUSTOMER_INFO" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index PRIKEY
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRIKEY" ON "T_OUTPUT" ("ID") 
  ;



--------------------------------------------------------
--  Ref Constraints for Table T_INPUT
--------------------------------------------------------

  ALTER TABLE "T_INPUT" ADD CONSTRAINT "T_INPUT_FK1" FOREIGN KEY ("EID")
	  REFERENCES "EMPLOYEE_INFO" ("ID") ENABLE;
 
  ALTER TABLE "T_INPUT" ADD CONSTRAINT "T_INPUT_FK2" FOREIGN KEY ("MEDI_ID")
	  REFERENCES "MEDI_INFO" ("MEDI_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table T_OUTPUT
--------------------------------------------------------

  ALTER TABLE "T_OUTPUT" ADD CONSTRAINT "T_OUTPUT_FK1" FOREIGN KEY ("CID")
	  REFERENCES "CUSTOMER_INFO" ("ID") ENABLE;
 
  ALTER TABLE "T_OUTPUT" ADD CONSTRAINT "T_OUTPUT_FK2" FOREIGN KEY ("MEDI_ID")
	  REFERENCES "MEDI_INFO" ("MEDI_ID") ENABLE;
--------------------------------------------------------
--  DDL for Trigger TR_OUTPUT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TR_OUTPUT" 
AFTER insert
on t_output
for each row
begin
  IF inserting  then
    update MEDI_INFO set num=num-:new.outnum where medi_id=:new.medi_id;
    end if;
end;
/
ALTER TRIGGER "TR_OUTPUT" ENABLE;
--------------------------------------------------------
--  DDL for View V_ORDER
--------------------------------------------------------

  CREATE OR REPLACE VIEW "V_ORDER" ("NAME", "MEDI_NAME", "OUTNUM", "TOTAL_PRINCE") AS 
  SELECT
        c.name,
        m.medi_name,
        o.outnum,
        o.total_prince
    FROM
        customer_info c,
        t_output o,
        medi_info m
    WHERE
            o.medi_id = m.medi_id
        AND
            c.id = o.cid;
--------------------------------------------------------
--  DDL for Procedure UPDATE_MEDINUM
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "UPDATE_MEDINUM" (medi_idp in NUMBER)
as
    outnump NUMBER;
    innump  NUMBER;
begin
   select SUM(outnum) into outnump from T_output where medi_id = medi_idp;
   select sum(innum) into innump from T_input where medi_id = medi_idp;
   UPDATE medi_info set num=innump-outnump where medi_id = medi_idp;
end;

/

