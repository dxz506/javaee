/*
��������˵��
  
  ����(char,varchar2,date,number,boolean,long)
  
  var char(15); --˵��������Ϊvar����������Ϊchar(15);
  married boolean :=true; ��boolean���и�ֵ
  psal number(7,2);
  my_name emp.ename%type; my_name������emp�е�ename�е�ʫ������
  
*/
set serveroutput on;
declare 
  myname emp.ename%type;
begin
  --��emp����,�ҵ�empno=7654��Ա��,������Ա��������ͨ��into ��ֵ���Ϸ������myname
  select t.ename into myname from emp t where t.empno = 7654;
  dbms_output.put_line(myname);
end;
/
