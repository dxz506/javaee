/*
����procedure
*/

create or replace procedure sayhello
as 
  --��������
begin
  dbms_output.put_line('Hello World');
end;
/

/*
procedure�ĵ��÷�ʽһ
*/
exec sayhello();
/*
procedure�ĵ��÷�ʽ��
*/

begin
  sayhello();
  sayhello();
end;
/