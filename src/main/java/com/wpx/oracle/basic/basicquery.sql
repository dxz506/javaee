/*
��ѯ��ǰ�û�
*/
show user;
/*
��ѯ����table
*/
select * from tab;
/*
sql�Ż�ԭ��
ʹ��������
*/
select empno,ename,sal from emp;
/*
sql�е�null
 1.����null�ı��ʽ��Ϊnull
 2.null��Զ != null
 select empno,ename,sal,sal*12,comm,sal*12+comm from emp;���ܴﵽԤ�ڵĽ��
 nvl(a,b); ��aΪnullֵ����b
 nvl2(a,b,c);��aΪnullֵ����b,���򷵻�c
*/
select empno "Ա����",ename "����",sal "нˮ",sal*12 "��н",comm "����",sal*12+nvl(comm,0) "������" from emp;
select * from emp where comm=null;
/*
ȥ���ظ�����
�����ں����������
*/
select distinct deptno,job from emp;
/*
concat�������������ַ�,dualΪoracle�����
mysql��5.0�Ժ�汾Ҳ֧��
*/
select concat('hello',' world') from dual; 
select 'hello'||' world' from dual;
select ename ||'����ˮΪ'||sal from emp;
