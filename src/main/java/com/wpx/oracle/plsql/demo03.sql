/*
ΪԱ���ǹ���,����͵�����ÿ��10%,
�������ܶ�ܳ���5wԪ���㲢����ǹ��������������ܶ�
*/
set serveroutput on;
declare
  cursor cemp is select empno,sal from emp order by sal;
  pempno emp.empno%type;
  psal emp.sal%type;
  
  countEmp number := 0;
  salTotal number := 0;
begin
  rollback;
  --�õ������ܶ�ĳ�ʼֵ
  select sum(sal) into salTotal from emp;
  open cemp;
  loop
    --�ܶ����5w
    exit when salTotal > 50000;
    --ȡһ��Ա��
    fetch cemp into pempno,psal;
    --�������˳�
    exit when cemp%notfound;
    
    --ΪԱ���ǹ���
    update emp set sal=sal*1.1 where empno = pempno;
    --������1
    countEmp := countEmp + 1;
    --ˢ���Ǻ��ܹ��ʽ��
    salTotal := salTotal+psal*0.1;
  end loop;
  close cemp;
  commit;
  dbms_output.put_line('�ǹ��ʵ�����Ϊ '||countEmp||' �Ǻ����ܶ�Ϊ '||salTotal);
end;
/
