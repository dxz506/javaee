/*
����ȷ��
нˮ�Ǻ���������ǰ
*/
create or replace trigger checksalary
before update
on emp
for each row
begin
  --if ��ǰ��нˮ< �Ǻ�Ĺ��� then 
  if :new.sal < :old.sal then
    raise_application_error(-20002,'�Ǻ�Ĺ��ʲ��ܵ�����ǰ');
  end if;
end checksalary;
/