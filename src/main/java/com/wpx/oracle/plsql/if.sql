/*
if ���
  if ���� then ���1
    ���2
  end if;

*/
set serveroutput on;
declare 
  pnum number := &number;
begin
  if pnum = 1 then
    dbms_output.put_line('����1');
  end if;
end;
/
/*
if ����1 then 
  ���һ
else
  ����
end if;
*/
set serveroutput on;
declare 
  mynum number := &put_your_number;
begin
  if mynum = 1 then
    dbms_output.put_line('�������������1');
  else
    dbms_output.put_line('����������ֲ���1');
  end if;
end;
/
/*
if ����1
  ���һ
elsif ����2
  ����
elsif ����3
  �����
...
else 
 ���else
end if;
*/
set serveroutput on;
declare 
  mynum number := &put_your_number;
begin
  if mynum = 1 then 
    dbms_output.put_line('�������������һ');
  elsif mynum = 2 then  
    dbms_output.put_line('������������Ƕ�');
  elsif mynum = 3 then
    dbms_output.put_line('���������������');
  else
    dbms_output.put_line('������������ݲ�֧�ֽ���');
  end if;
end;
/