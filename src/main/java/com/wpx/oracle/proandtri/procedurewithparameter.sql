/*
��ѯĳ��Ա��������,нˮ��ְλ
*/
create or replace procedure query_emp_infomation_procedure(
                                                            eno in number,
                                                            pname out varchar2,
                                                            psal out number,
                                                            pjob out varchar2)
is
begin
  select ename,sal,job into pname,psal,pjob from emp where empno = eno;
end query_emp_infomation_procedure;
/
/*
����procedure
*/
set serveroutput on;
declare
  pname emp.ename%type;
  psal emp.sal%type;
  pjob emp.job%type;
begin
  query_emp_infomation_procedure(7654,pname,psal,pjob);
  dbms_output.put_line('����Ϊ: '||pname||' нˮ: '||psal||' ְλ: '||pjob);
end;
/
