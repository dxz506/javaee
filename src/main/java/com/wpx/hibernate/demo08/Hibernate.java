package com.wpx.hibernate.demo08;


import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.wpx.hibernate.demo03.HibernateUtils;
/**
 *
 * ���ü�����ʽ
 * 	1.OID get/load
 *  2.HQL
 *  3.QBC
 *  4.����SQL
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class Hibernate {

	
	SessionFactory sessionFactory=null;
	Session session=null;
	Transaction transaction=null;
	
	@Before
	public void before() {
		//����ָ����ӳ���ļ�
		 sessionFactory = HibernateUtils.getSessionSessionFactory(Customer.class,Order.class);
		//ʹ��sessionSessionFactory����session
		 session = sessionFactory.openSession();
		//��������
		 transaction = session.beginTransaction(); 
	}
	@After
	public void after() {
		//�ύ����
		transaction.commit();
		//�ͷ���Դ
		session.close();
		sessionFactory.close();
	}
	/**
	 *��������
	 * 
	 */
	@Test
	public void demo01() {
	
		Customer customer = new Customer("wangpx", 21);
		customer.getOrders().add(new  Order("����",customer));
		customer.getOrders().add(new  Order("�㶫",customer));
		session.save(customer);
	
	}
	/**
	 * Hibernate�����ּ�����ʽ
	 */
	@Test
	public void demo02(){
		//ʹ��HQL��ѯ
		List<Customer> list = session.createQuery("from Customer").list();
		for(Customer c : list) {
			System.out.println(c);
		}
		//ʹ��QBC�ķ�ʽ
		List<Order>  orderList= session.createCriteria(Order.class).list();
		for(Order o : orderList) {
			System.out.println(o);
		}
		
		//ʹ��SQL��װ��ʵ�������
		List<Customer> customerList = session.createSQLQuery("select * from t_customer08").addEntity(Customer.class).list();
		for(Customer c : customerList) {
			System.out.println(c);
		}
	}

	/**
	 * ʹ�ñ���
	 */
	@Test
	public void demo03() {
		//ʹ�ñ�������ѯ����
		List<Customer> list = session.createQuery("from Customer as  c where c.name = ? ").setString(0, "wangpx").list();
		System.out.println(list);		
	}
	
	/**
	 * ����
	 */
	@Test
	public void demo04() {
		//ʹ��HQL
		List<Customer> list = session.createQuery("from Customer c order by c.cid desc").list();
		for(Customer c: list) {
			System.out.println(c);
		}
		//ʹ��QBC
		List list2 = session.createCriteria(Order.class).addOrder(org.hibernate.criterion.Order.desc("oid")).list();
		System.out.println(list2);
	}
	/**
	 * ��ҳ��ѯ
	 */
	@Test
	public void demo05() {
		//HQL
		Query query = session.createQuery("from Order");
		query.setFirstResult(2);
		query.setMaxResults(5);
		List<Order> orderList = query.list();
		System.out.println(orderList);
		//QBC
		Criteria criteria = session.createCriteria(Order.class);
		List<Order> ol = criteria.setFirstResult(1).setMaxResults(3).list();
		System.out.println(ol);
	}
	/**
	 * ������������
	 */
	@Test
	public void demo06() {
		//HQL
		 Customer c = (Customer) session.createQuery("from Customer c where  c.cid = ?").setInteger(0, 1).uniqueResult();
		 System.out.println(c);
		 //QBC
		Customer customer= (Customer) session.createCriteria(Customer.class).add(Restrictions.eq("cid",3)).uniqueResult();
		System.out.println(customer);
	}
	
	/**
	 * �󶨲���
	 */
	@Test
	 public void demo07() {
		//Hql������ ʹ��?��
		Query query = session.createQuery("from Order o where o.oid =? and o.addr= ? ");
		query.setInteger(0, 2);
		query.setString(1,"�㶫");
		Order o = (Order) query.uniqueResult();
		System.out.println(o);
		//ʹ�����Ƶķ�ʽ
		Query query2 = session.createQuery("from Order o where o.oid= :oid and o.addr= :addr");
		query2.setInteger("oid", 3);
		query2.setString("addr", "�㶫");
		Order o2= (Order) query2.uniqueResult();
		System.out.println(o2);
	}
	/**
	 * ͶӰ����:��ѯ����ļ�������
	 */
	@Test
	public void demo08() {
		//��ѯ����
		List<String> list =session.createQuery("select c.name from Customer c").list();
		list.stream().forEach(System.out::println);
	
		//�������
		 List<Object[]> objList= session.createQuery("select c.cid,c.name from Customer c").list();
		 for(Object[] o: objList) {
			 System.out.println(Arrays.toString(o));
		 }
	}
	/**
	 * QBC��������
	 */
	@Test
	public void demo09() {
		Criteria criteria = session.createCriteria(Order.class);
		criteria.add(Restrictions.eq("oid", 3));
		criteria.add(Restrictions.eq("addr", "�㶫"));
		List<Order> list = criteria.list();
		if(list!=null && list.size()>0) {
			System.out.println(list.get(0));
		}
	}
	/**
	 * ģ����ѯ
	 */
	@Test
	public void demo10() {
		//HQL��ѯ
		Query query = session.createQuery("from Order o where o.addr like ?"); 
		query.setString(0, "%��");
		List<Order> list = query.list();
		System.out.println(list);
		//QBC��ѯ
		Criteria criteria = session.createCriteria(Order.class);
		criteria.add(Restrictions.ilike("addr","%��"));
		List<Order> orderList = criteria.list();
		System.out.println(orderList);
	}
	/**
	 * ����ѯ
	 */
	@Test
	public void demo11() {
		//����������������Ľ���
		 List<Object[]> list = session.createQuery("from Customer c inner join c.orders").list();
		 for(Object[] o: list) {
			 System.out.println(Arrays.toString(o));
		 }
		 
		 //���������� fetch(HQL)
		 List<Customer> list2 = session.createQuery("select distinct c from Customer c inner join fetch c.orders").list();
		 for(Customer c: list2) {
			 System.out.println(c);
		 }
	}
	/**
	 * �ۺϺ���
	 */
	@Test
	public void demo12() {
		//��ѯ���ж�������
		Long count = (Long) session.createQuery("select count(*) from Order ").uniqueResult();
		System.out.println(count);
	}
	/**
	 * ������ѯ
	 * 
	 * ��Customer.hbm.xml������
	 * 	
	 * <!-- ������ѯ�ķ�ʽ -->
		<query name="findAll">
			from Customer
		</query>
	 */
	@Test
	public void demo13() {
		List<Customer> list = session.getNamedQuery("findALl").list();
		System.out.println(list);
	}

	/**
	 * ����������ѯ
	 */
	@Test
	public void demo14() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Order.class);
		criteria.add(Restrictions.eq("oid", 3));
		criteria.add(Restrictions.eq("addr", "�㶫"));
		
		Criteria criteria2 = criteria.getExecutableCriteria(session);
		List<Order> list = criteria2.list();
		System.out.println(list);
	}
	
}

