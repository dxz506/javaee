#!/bin/sh
DATE=`/bin/date +%F`
echo "today is $DATE"
#�������Ĳ�������
echo '$# :' $#
#�����������в���
echo '$* :' $*
#ִ����һ������ķ���ֵ
echo '$? :' $?
#��������PID
echo '$$ :' $$
#$(0-9) ��ʾλ�ñ���
echo '$0 :' $0
