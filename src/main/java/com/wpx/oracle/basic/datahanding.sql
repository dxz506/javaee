/*
SQL������
1.DML (Data Manipulation Language) :insert delete update select
2.DDL(Data Definition Language): create table,alter table,drop table,truncate table,create/drop view,sequnece,index,synonym
3.DCL(Data COntrol Language): grant(��Ȩ) revoke(����Ȩ��)
*/
/*
 &��ַ��
ԭֵ:insert into emp(empno,ename,sal,deptno) values(&empno,&ename,&sal,&deptno)
��ֵ:insert into emp(empno,ename,sal,deptno) values(1111,'wangpx',1000,30)
1 ���Ѳ��롣
*/
insert into emp(empno,ename,sal,deptno) values(&empno,&ename,&sal,&deptno);
select &l from emp;
select * from &t;
/*
һ�β��������¼
*/
create table emp10 as select * from emp where 1=2;
desc emp10;
select * from emp10;
/*
�����ź�Ϊ30������Ա����Ϣ���뵽emp10����
*/
insert into emp10 select * from emp where deptno=30;
select * from emp10;
/*
������������
  1.���ݱ�(PLSQL����) dbms_datapump(�����)
  2.SQL*Loader
  3.�ⲿ��
*/
/*
  delete��truncate������:
  1.delete����ɾ��,truncate���ȴݻٱ����ؽ�
  2.delete��DML,���Իع�,truncate��DDL���ܻع�
  3.delete�����ͷſռ�,truncate��
  4.delete�������Ƭ,truncate����
  5.delete����flashback,truncate����
*/
set feeback off;
set timing on;
/*
oracle �е�����
  1.��ʼ��־:�����еĵ�һ��DNL���
  2.������־:
    �ύ:��ʽ:commit ��ʽ:�����˳�DDL DCL
    �ع�:��ʽrollback ��ʽ:�������˳� 崻�
*/
/*
���������
*/
create table testsavepoint(
tid number,
tname varchar(20)
);
insert into testsavepoint values(1,'wangpx');
savepoint a;
insert into testsavepoint values(2,'wpx');
rollback to savepoint a;
select count(*) from testsavepoint;
/**
set transaction read only;
 �������� READ ONLY ��������ִ�в���/ɾ��/���²��� 
*/
/*
�к�rownum
  1.rownum ��Զ����Ĭ�ϵ�˳������
  2.rownum ֻ��ʹ��< <= ;����ʹ��> >=
*/
select rownum,empno,ename,sal from emp;
select rownum,empno,ename,sal from emp where rownum <= 3 order by sal desc; 
/*
��ѯ������������˵���Ϣ
*/
select rownum,empno,ename,sal
from (select * from emp order by sal desc)
where rownum <=3;
/*
oracle��ҳ
*/
select *
from (select rownum r,e1.* 
  from (select * from emp order by sal) e1 
  where rownum <=8
)
where r >=5;
/*
����Ӳ�ѯ
*/
select empno,ename,sal,(select avg(sal) from emp where deptno = e.deptno) avgsal
from emp e
where sal > (select avg(sal) from emp where deptno = e.deptno);
/*
��������
*/
/*
��ѯ10�ź�20�Ų��ŵ�Ա��
*/
select * 
from emp 
where deptno =10 or deptno =20;

select * 
from emp 
where deptno in(10,20,null);
/*
oracle ����ǿgroup by
*/
select deptno,job,sum(sal)
from emp
group by deptno,job;

select deptno,job,sum(sal) 
from emp
group by rollup(deptno,job);
/*
��ǿgroup by ���������������ǵȼ۵�

ORA-01789: ��ѯ����в���ȷ�Ľ������
01789. 00000 -  "query block has incorrect number of result columns"
*Cause:    
*Action:
�� 122 �� 1 ����

*/
select deptno,job,sum(sal) from emp group by deptno,job
union
select deptno,sum(sal) from emp group by deptno
union
select sum(sal) from emp;
/*
��������ԭ��:
  1.��������ĸ������ϱ�������
  2.���õ�һ��������Ϊ��ͷ
  3.order by ��Զ�����
  4.����
*/
select deptno,job,sum(sal) from emp group by deptno,job
union
select deptno,to_char(null),sum(sal) from emp group by deptno
union
select to_number(null),to_char(null),sum(sal) from emp;
