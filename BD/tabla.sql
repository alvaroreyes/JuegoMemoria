/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     18/05/2013 10:51:13 p.m.                     */
/*==============================================================*/


drop index DATOS_PK;

drop table DATOS;

/*==============================================================*/
/* Table: DATOS                                                 */
/*==============================================================*/
create table DATOS (
   NOMBRE               VARCHAR(20)          not null,
   PUNTAJE              INT4                 not null,
   TIEMPO               TIME                 not null,
   FECHA                DATE                 not null,
   constraint PK_DATOS primary key (NOMBRE)
);

/*==============================================================*/
/* Index: DATOS_PK                                              */
/*==============================================================*/
create unique index DATOS_PK on DATOS (
NOMBRE
);

