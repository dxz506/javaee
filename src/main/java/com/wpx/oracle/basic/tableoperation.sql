/*
������
*/
create table test1(
  tid number,
  tname varchar(20)
);
/*
rowid �е�ַ
*/
select rowid,empno,ename,sal
from emp;

select *
from emp
where rowid='AAAMfPAAEAAAAAgAAH';
/*
�´���Ա����,����20�Ų���Ա��
*/
create table emp20
as
select * 
from emp 
where deptno =20;
/*
������: Ա����,����,��н,��н,��������
*/
create table empinfo
as 
select e.EMPNO,e.ENAME,e.SAL,e.SAL*12 annsal,d.DNAME
from emp e,dept d
where
e.deptno=d.deptno;

select *
from empinfo;
/*
��������
*/
alter table test1 add photo blob;
desc test1;
/*
�޸���
*/
alter table test1 modify tname varchar2(40);
/*
ɾ����
*/
alter table test1 drop column photo;
desc test1;
/*
��������
*/
alter table test1 rename column tname to tusername;
desc test1;
/*
��������
*/
rename test1 to test01;
desc test01;
/*
ɾ����
*/
select * from tab;
drop table emp10;
/*
�鿴����վ
*/
show recyclebin;
/*
��ջ���վ
����Աû�л���վ
*/
purge recyclebin;