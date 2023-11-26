insert into customers (ID,FIRST_NAME,LAST_NAME)
values ('1011', 'Antonio', 'Pontiveros');

insert into addresses (ID,CITY,COUNTRY,POSTCODE,STREET)
values ('9da9daf8-f3f6-4545-a965-fae431677dee',	'Madrid', 'Spain', '251111', 'Avd. Constitución 67 15-5-3');

insert into orders (ORDER_ID,CREATED_AT,EMAIL,ORDER_TOTAL,PILOTES_NUMBER,CUSTOMER_ID,DELIVERY_ADDRESS_ID)
values ('472bd97a-e744-4f40-9b14-159dc1881591',	'2023-11-24 17:48:02.196333','example@gmail.com','11.33','10','1011','9da9daf8-f3f6-4545-a965-fae431677dee');

insert into addresses (ID,CITY,COUNTRY,POSTCODE,STREET)
values ('9da9daf8-f3f6-4545-a965-fae431677det',	'Madrid', 'Spain', '251111', 'Avd. Constitución 67 15-5-3');

insert into orders (ORDER_ID,CREATED_AT,EMAIL,ORDER_TOTAL,PILOTES_NUMBER,CUSTOMER_ID,DELIVERY_ADDRESS_ID)
values ('472bd97a-e744-4f40-9b14-159dc188159t',	'2023-11-24 17:48:02.196333','example@gmail.com','11.33','10','1011','9da9daf8-f3f6-4545-a965-fae431677det');



insert into customers (ID,FIRST_NAME,LAST_NAME)
values ('1012', 'José', 'Perez');

insert into addresses (ID,CITY,COUNTRY,POSTCODE,STREET)
values ('9da9daf8-f3f6-4545-a965-fae431677dek',	'Málaga', 'Spain', '04700', 'Calle Olvido, 7' );

insert into orders (ORDER_ID,CREATED_AT, EMAIL, ORDER_TOTAL,PILOTES_NUMBER,CUSTOMER_ID,DELIVERY_ADDRESS_ID)
values ('472bd97a-e744-4f40-9b14-159dc1881594',	'2023-11-24 19:48:02.196333','example@gmail.com','6.65','5','1012','9da9daf8-f3f6-4545-a965-fae431677dek');



insert into customers (ID,FIRST_NAME,LAST_NAME)
values ('1013', 'Pepe', 'Martinez');

insert into addresses (ID,CITY,COUNTRY,POSTCODE,STREET)
values ('9da9daf8-f3f6-4545-a965-fae431677deh',	'Seville', 'Spain', '04700', 'Calle de la Vida, 42');

insert into orders (ORDER_ID,CREATED_AT,EMAIL,ORDER_TOTAL,PILOTES_NUMBER,CUSTOMER_ID,DELIVERY_ADDRESS_ID)
values ('472bd97a-e744-4f40-9b14-159dc1881596',	'2023-11-25 11:48:02.196333','example@gmail.com','6.65','5','1013','9da9daf8-f3f6-4545-a965-fae431677deh');



insert into customers (ID,FIRST_NAME,LAST_NAME)
values ('1014', 'Ana', 'Rodriguez');

insert into addresses (ID,CITY,COUNTRY,POSTCODE,STREET)
values ('9da9daf8-f3f6-4545-a965-fae431677131',	'Madrid', 'Spain', '251111', 'Avd. Constitución 67 15-5-3');

insert into orders (ORDER_ID,CREATED_AT,EMAIL,ORDER_TOTAL,PILOTES_NUMBER,CUSTOMER_ID,DELIVERY_ADDRESS_ID)
values ('472bd97a-e744-4f40-9b14-159dc188152h',	'2023-11-22 17:48:02.196333','example@gmail.com','11.33','10','1014','9da9daf8-f3f6-4545-a965-fae431677131');



insert into customers (ID,FIRST_NAME,LAST_NAME)
values ('1015', 'Anibal', 'García');

insert into addresses (ID,CITY,COUNTRY,POSTCODE,STREET)
values ('9da9daf8-f3f6-4545-a965-fae431677134',	'Madrid', 'Spain', '251111', 'Avd. Constitución 67 15-5-3');

insert into orders (ORDER_ID,CREATED_AT,EMAIL,ORDER_TOTAL,PILOTES_NUMBER,CUSTOMER_ID,DELIVERY_ADDRESS_ID)
values ('472bd97a-e744-4f40-9b14-159dc1881521',	'2023-11-22 17:48:02.196333','example@gmail.com','11.33','10','1015','9da9daf8-f3f6-4545-a965-fae431677134');



insert into AUTHORITIES(ID,NAME)
values ('1', 'READ');

insert into AUTHORITIES(ID,NAME)
values ('2', 'WRITE');

insert into AUTHORITIES(ID,NAME)
values ('3', 'ADMIN');

insert into USERS(ID,PASSWORD,USER_NAME)
values ('1011', '{bcrypt}$2a$10$cihVTJ5G9OYyOQiD7k28tOzmUOwOdh/NVUDpmig88Ao4bcP/YOMx.', 'arpontiverosc');

insert into USER_AUTHORITY(USER_ID,AUTHORITY_ID)
values ('1011', '1');

insert into USER_AUTHORITY(USER_ID,AUTHORITY_ID)
values ('1011', '2');

insert into USER_AUTHORITY(USER_ID,AUTHORITY_ID)
values ('1011', '3');