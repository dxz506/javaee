/*
�洢����
*/
create or replace query_emp_income_function(eno in number)
return number
is
	--����������ڴ洢Ա�����ʺͽ���
	psal emp.sal%type;
	pcomm emp.comm%type;
begin
	--�����ʺͽ�����Ϣ��ֵ������
	select sal,comm into psal,pcomm from emp where empno = eno;
	--���ڷ���������Ϣ
	return psal*12+nvl(comm,0);
end query_emp_income_function;
/


/*
���ô洢����
*/
select query_emp_income_funtion(7654) from dual;
