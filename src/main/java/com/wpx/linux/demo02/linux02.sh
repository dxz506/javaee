#!/bin/sh
#��ʽ����ʵ��������  >> Ϊ����׷��
/bin/date +%F >> /linux/linux02.info
echo "disk info" >> /linux/linux02.info
/bin/df -h >> /linux/linux02.info
echo "online users:" >> /linux/linux02.info
#-v ��ʾ�ų�
/usr/bin/who | bin/grep -v root >> /linux/linux02.info
echo "memory info" >> /linux/linux02.info
/usr/bin/free -m >> /linux/linux02.info
echo >> /linux/linux02.info
#write root < ��ʾ �ض�������
/usr/bin/write root < /linux/linux02.info && /bin/rm /linux/linux02.info
# ��ʱִ������ û��һ������
#crontab  -e
#0 9 * * 1-5 /bin /sh /linux/linux02.sh

