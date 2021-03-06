INSERT INTO ADDRESSES (ADDRESS_ID, OWNER_CLASS, OWNER_CODE, ADDRESS_TYPE, PRIMARY_FLAG, MAIL_FLAG, STREET) VALUES (-1, 'AGY', 'BRMSYC', 'BUS', 'Y', 'Y', 'Justice Avenue');
INSERT INTO ADDRESSES (ADDRESS_ID, OWNER_CLASS, OWNER_CODE, ADDRESS_TYPE, PRIMARY_FLAG, MAIL_FLAG, STREET) VALUES (-2, 'AGY', 'WELBYC', 'BUS', 'Y', 'Y', 'Peyton Place');
INSERT INTO ADDRESSES (ADDRESS_ID, OWNER_CLASS, OWNER_CODE, ADDRESS_TYPE, PRIMARY_FLAG, MAIL_FLAG, STREET, CITY_CODE, COUNTRY_CODE) VALUES (-3, 'AGY', 'BMI', 'BUS', 'Y', 'Y', 'BMI Place', '27913', 'ENG');
INSERT INTO ADDRESSES (ADDRESS_ID, OWNER_CLASS, OWNER_CODE, ADDRESS_TYPE, PRIMARY_FLAG, MAIL_FLAG, STREET, CITY_CODE, COUNTRY_CODE) VALUES (-4, 'AGY', 'BMI', 'BUS', 'N', 'Y', 'Not Primary Address','27913', 'ENG');
INSERT INTO ADDRESSES (ADDRESS_ID, OWNER_CLASS, OWNER_CODE, ADDRESS_TYPE, PRIMARY_FLAG, MAIL_FLAG, STREET, CITY_CODE, COUNTRY_CODE, OWNER_ID) VALUES (-10, 'OFF', 'BMI', 'BUS', 'N', 'Y', 'Blah','27913', 'ENG', -1001);
INSERT INTO ADDRESSES (ADDRESS_ID, OWNER_CLASS, OWNER_CODE, ADDRESS_TYPE, PRIMARY_FLAG, MAIL_FLAG, STREET, CITY_CODE, COUNTRY_CODE, OWNER_ID) VALUES (-11, 'PER', 'BMI', 'BUS', 'N', 'Y', 'Blah','27913', 'ENG', -2222);
INSERT INTO ADDRESSES (ADDRESS_ID, OWNER_CLASS, OWNER_CODE, ADDRESS_TYPE, PRIMARY_FLAG, MAIL_FLAG, STREET, CITY_CODE, COUNTRY_CODE, OWNER_ID) VALUES (-12, 'CORP', 'BMI', 'BUS', 'N', 'Y', 'Blah','27913', 'ENG', -3333);
INSERT INTO ADDRESSES (ADDRESS_ID, OWNER_CLASS, OWNER_CODE, ADDRESS_TYPE, PRIMARY_FLAG, MAIL_FLAG, STREET, CITY_CODE, COUNTRY_CODE, OWNER_ID) VALUES (-13, 'STF', 'BMI', 'BUS', 'N', 'Y', 'Blah','27913', 'ENG', -4444);
INSERT INTO ADDRESSES (ADDRESS_ID, OWNER_CLASS, OWNER_CODE, ADDRESS_TYPE, PRIMARY_FLAG, MAIL_FLAG, STREET, CITY_CODE, COUNTRY_CODE, OWNER_ID) VALUES (-14, 'OFF_EMP', 'BMI', 'BUS', 'N', 'Y', 'Blah','27913', 'ENG', -5555);
INSERT INTO ADDRESSES (ADDRESS_ID, OWNER_CLASS, OWNER_CODE, ADDRESS_TYPE, PRIMARY_FLAG, MAIL_FLAG, STREET, CITY_CODE, COUNTRY_CODE, OWNER_ID) VALUES (-15, 'OFF_EDU', 'BMI', 'BUS', 'N', 'Y', 'Blah','27913', 'ENG', -6666);
INSERT INTO ADDRESSES (ADDRESS_ID, OWNER_CLASS, OWNER_CODE, ADDRESS_TYPE, PRIMARY_FLAG, MAIL_FLAG, STREET, CITY_CODE, COUNTRY_CODE, OWNER_ID) VALUES (-16, 'PER_EMP', 'BMI', 'BUS', 'N', 'Y', 'Blah','27913', 'ENG', -7777);

INSERT INTO ADDRESSES (ADDRESS_ID, OWNER_CLASS, OWNER_CODE, ADDRESS_TYPE, PRIMARY_FLAG, MAIL_FLAG, STREET, CITY_CODE, COUNTRY_CODE, OWNER_ID) VALUES (-20, 'PER', 'BMI', 'BUS', 'N', 'Y', 'Blah','27913', 'ENG', -1);


-- blank address
INSERT INTO ADDRESSES (ADDRESS_ID, OWNER_CLASS, OWNER_CODE, PRIMARY_FLAG, MAIL_FLAG, COUNTRY_CODE) VALUES (-5, 'AGY', 'BMI', 'N', 'Y','ENG');
INSERT INTO ADDRESSES (ADDRESS_ID, OWNER_CLASS, OWNER_CODE, ADDRESS_TYPE, PRIMARY_FLAG, MAIL_FLAG, STREET) VALUES (-6, 'AGY', 'BXI', 'BUS', 'Y', 'Y', 'BXI HMP');
INSERT INTO ADDRESSES (ADDRESS_ID, OWNER_CLASS, OWNER_CODE, ADDRESS_TYPE, PRIMARY_FLAG, MAIL_FLAG, STREET) VALUES (-7, 'AGY', 'TRO', 'BUS', 'N', 'Y', 'TRO HMP');
INSERT INTO ADDRESSES (ADDRESS_ID, OWNER_CLASS, OWNER_CODE, ADDRESS_TYPE, PRIMARY_FLAG, MAIL_FLAG, STREET, CITY_CODE) VALUES (-8, 'AGY', 'TRO', 'BUS', 'Y', 'Y', 'Coles Corner', '11129');
INSERT INTO ADDRESSES (ADDRESS_ID, OWNER_CLASS, OWNER_CODE, ADDRESS_TYPE, PRIMARY_FLAG, MAIL_FLAG, STREET, CITY_CODE) VALUES (-9, 'AGY', 'TRO', 'BUS', 'N', 'Y', 'Coles Corner', '11129');

INSERT INTO ADDRESSES (ADDRESS_ID, OWNER_CLASS, OWNER_ID, OWNER_SEQ, FLAT, PREMISE, STREET, LOCALITY, CITY_CODE, COUNTY_CODE, COUNTRY_CODE, CREATE_DATETIME, CREATE_USER_ID)
    VALUES (121010, 'OFF', -1001,	1, 42, 'heNtFFTheNtFF', '1364 BROOKS AVENUE', 'HULL', 13653, 'CLEVELAND', 'SCOT', '2018-03-08T12:21:23.963Z', 'XTAG')
;
