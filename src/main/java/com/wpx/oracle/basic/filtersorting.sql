/*
��ѯdepno=10�����в�����Ϣ
*/
select * from emp where deptno=10;
/*
��Сд����
*/
select * from emp where ename='KING';
select * from emp where ename='king';
/*
���ڸ�ʽ����
*/
select * from emp where hiredate='17-11��-81';
/*
�޸����ڸ�ʽ
*/
select * from V$NLS_PARAMETERS;
alter session set NLS_DATE_FORMAT='yyyy-mm-dd ';
select * from emp where hiredate='1981-11-17'; 

/*
between and
  1.���б߽�
  2.Сֵ��ǰ ��ֵ�ں�
*/
select * from emp where sal between 1000 and 2000;
/*
nullֵ 
�����������null����ʹ��not in,������ʹ��in
*/
select * from emp where deptno not in (10,20,null);
select * from emp where deptno  in (10,20,null);
/*
ģ����ѯ
*/
select * from emp where ename like '%S';
select * from emp where ename like '____';
/*
ģ����ѯ ����'_'���ֶ�
*/
insert into emp(empno,ename,sal,deptno) values(1001,'Wang_px',3000,10);
select * from emp where ename like '%\_%' escape '\';

/*
Sql�Ż�
where ����˳��:��->��
*/
select * from emp order by  sal*12 desc;
select * from emp order by 6 desc;
/*
  ���������
  orader �����ں����������,�Ȱ��յ�һ����,�ٺ������
   descֻ�����������������
   
*/
select * from emp order by deptno,sal;
select * from emp order by sal,deptno desc;
select * from emp order by deptno desc,sal;
 /*
  ϣ���������н����е�nullֵ�������
  nullֵ���
 */
 select * from emp order by comm;
 select * from emp order by comm desc;
 select * from emp order by comm desc nulls last;