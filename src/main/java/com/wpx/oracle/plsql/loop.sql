/*
�ض���ǰ����ѭ��
*/
set serveroutput on;
declare 
  mynum number := 1;
begin
  while mynum <= 10 loop
    DBMS_OUTPUT.PUT_LINE (mynum);
    mynum := mynum+1;
  end loop;
end;
/
/*
ѭ���������˳�����
*/
set serveroutput on;
declare
  mynum number := 1;
begin
  loop
    exit when mynum > 10;
    dbms_output.put_line(mynum);
    mynum := mynum+1;
  end loop;
end;
/

/*
ʹ��for
*/
set serveroutput on;
declare 
  step number;
begin
  for step in 1 .. 10 loop
    dbms_output.put_line(step);
  end loop;
end;
/


