package com.examples.spring.web.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.examples.spring.web.mvc.model.Employee;


@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {
		
		private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

		@Autowired
		@Qualifier("hibernate5AnnotatedSessionFactory")
		private SessionFactory sessionFactory;
		
		public void setSessionFactory(SessionFactory sf){
			this.sessionFactory = sf;
		}

		public void addEmployee(Employee emp) {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(emp);
			logger.info("Employee saved successfully, Employee Details=" + emp);
		}

		public void updateEmployee(Employee emp) {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(emp);
			logger.info("Employee updated successfully, Employee Details= " + emp);
		}

		@SuppressWarnings("unchecked")
		public List<Employee> listEmployees() {
			Session session = this.sessionFactory.getCurrentSession();
			List<Employee> employeesList = session.createQuery("from Employee").list();
			for(Employee emp : employeesList){
				logger.info("Employee List::"+ emp);
			}
			return employeesList;
		}

		public Employee getEmployeeById(int id) {
			Session session = this.sessionFactory.getCurrentSession();		
			Employee emp = (Employee) session.load(Employee.class, new Integer(id));
			logger.info("Employee loaded successfully, Employee details=" + emp);
			return emp;
		}

		public void removeEmployee(int id) {
			Session session = this.sessionFactory.getCurrentSession();
			Employee emp = (Employee) session.load(Employee.class, new Integer(id));
			if(null != emp){
				session.delete(emp);
			}
			logger.info("Employee deleted successfully, Employee details="+ emp);
		}

}
