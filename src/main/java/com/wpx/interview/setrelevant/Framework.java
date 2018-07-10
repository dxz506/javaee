package com.wpx.interview.setrelevant;
/**
 * 
 * JAVA����
 * 
 * 	javaר���ṩ��һ���ܴ�ܶ����ݵ���,�м�����
 *  �������Ϊ��������:
 *  	���ȿ��Զ�̬����
 *   	һ�������п��Դ��������͵�����
 * 
 * ���Ϸֵ�ֵ����/˫ֵ����
 * 
 * 		public interface Collection<E> extends Iterable<E>{...} (��ֵ����)
 * 
 * 			public interface List<E> extends Collection<E> { //���������еķ���}(����+���ظ�)
 *				ʵ��List�ӿڵ���Vector,LinkedList,ArrayList 
 * 				(1)public class Vector<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable{...}
 * 				(2)public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, java.io.Serializable{...}
 * 				(3)public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable{...}
 * 				
 * 				˵��:
 * 				(1)  public Vector() { this(10); } 
 * 					  �ײ�Ϊ��̬������ṹ,ʹ�ô�����synchronized�ؼ�������,���̰߳�ȫ	
 * 					  ��ɾ�������(���߳�),��ʼ��Ĭ������Ϊ10 ����Ϊ10 
 * 				(2)  �ײ�Ϊ�������ݽṹ,�̲߳���ȫ,��Ԫ�ص���ɾ�Ĳ���Ч�ʺܸ�,�����ѯ��Ч�ʵ�
 * 					 (ʹ���ƶ�ָ��Ѱַ).Ĭ�ϳ�ʼ����Ϊ0,��������ȷ
 *   			(3)   private static final int DEFAULT_CAPACITY = 10;
 *   				 �ײ�Ϊ��̬������ṹ(˳��洢),��ɾ��,��ѯ��,�̲߳���ȫ
 *   				 Ĭ�ϳ�ʼ����Ϊ10,����δָ��,ԼΪԭ������50%
 *   			 ע��:
 *   			 ��Ϊ�����п��Դ��������͵�����,��˴������Ͱ�ȫ����,����취--����
 *   			 ���͵ļ���ʵ��ϸ��:
 *     			 	JDK1.5���뷺�ͼ���
 *     				SUN����ʦ�ڱ������м���һ����Է��͵��﷨����,����ͨ����,��������
 *     	  			�ֽ����ļ��з��Ƿ��͵Ĵ���ɾ��
 *     			    
 * 			public interface Set<E> extends Collection<E> {...}(����+�����ظ�)
 * 
 * 			Set������û�д��±�ķ���,ʵ��Set�ӿڵ���HashSet,LinkedHashSet,
 * 				(1) public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, java.io.Serializable{...}
 * 				(2) public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, java.io.Serializable {...}
 * 				(3) public class TreeSet<E> extends AbstractSet<E>  implements NavigableSet<E>, Cloneable, java.io.Serializable{...}
 * 						public interface NavigableSet<E> extends SortedSet<E> {...}
 * 							public interface SortedSet<E> extends Set<E> {...}
 * 				
 * 				˵��:
 * 				(1) �ײ����ݽṹ:ɢ�б�(Ŀ¼+����),��ɾ�Ͳ��Ҷ���,���ܱ�֤�̰߳�ȫ,����
 * 					HashSet()	�޲ι��� //default initial capacity (16) and load factor (0.75)
 * 					HashSet(int initialCapacity)	ָ����ʼ������Ĭ�ϼ�������Ϊ0.75��Ҳ���ǰٷ�֮75��
 * 					HashSet(int initialCapacity,float loadFactor)	ָ����ʼ������ָ���������ӡ�
 * 				(2) �ײ����ݽṹ: ɢ�б�(Ŀ¼+����)+����(��¼�˲����˳��),���ܱ�֤�̰߳�ȫ,��ɾ�Ͳ�ѯ����
 * 					Ĭ�ϳ�ʼ����16,Ĭ�ϼ���������0.75,�̳���HashSet
 * 				(3) TreeSet�ײ�ΪTreeMap
 * 		
 * 			public interface Map<K,V>{...}(˫ֵ����)
 * 				ʵ��Map�ӿڵ�����HashMap,LinkedHashMap
 * 				(1)public class HashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable {...}
 * 				(2)public class LinkedHashMap<K,V> extends HashMap<K,V> implements Map<K,V> {...}
 * 				(3)public class Hashtable<K,V> extends Dictionary<K,V> implements Map<K,V>, Cloneable, java.io.Serializable {...}
 * 				˵��: 
 * 				(1)	�ײ����ݽṹΪɢ�б�(Ŀ¼+����),��ɾ�Ͳ�ѯ����,���ܱ�֤�̰߳�ȫ,
 * 				 ����,���������ظ�,
 * 				 HashMap()  Ĭ�ϳ�ʼ������Ϊ16,��������Ϊ0.75
 * 				 HashMap(int initialCapacity) �Զ����ʼ������,Ĭ�ϼ�������Ϊ0.75
 * 				 HashMao(int initialCapacity, float loadFactor)  �Զ����ʼ������,��������
 * 				(2) �ײ����ݽṹΪɢ�б�(Ŀ¼+����)+����(��¼�����˳��),��ɾ�Ͳ�ѯ����,���ܱ�֤�̰߳�ȫ,
 * 				 ����,���������ظ�,
 * 				(3) private transient Entry<?,?>[] table;	
 * 				��ϣ��ײ�Ϊ ɢ�б�+����,��ɾ�Ͳ�ѯ����,�ײ�ʹ���˴�����synchronized�ؼ�������,
 * 				���̰߳�ȫ,��ʼ������С11,��������0.75
 * @author wangpx
 */
public class Framework {

}
