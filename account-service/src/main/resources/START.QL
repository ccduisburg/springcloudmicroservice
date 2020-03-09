CREATE KEYSPACE springcloud
    WITH replication={'class':'SimpleStrategy','replication_factor': 3};

USE springcloud;

CREATE TABLE EMP( EMP_ID INT PRIMARY KEY ,
                  EMP_NAME TEXT,
                  EMP_CITY TEXT,
                  EMP_SAL VARINT,
                  EMP_PHONE VARINT)