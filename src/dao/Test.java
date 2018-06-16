package dao;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Qcode;

public class Test {
public static void main(String[] args) {
	QcodeDao qcodeDao=new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml").getBean("qcodeDao",QcodeDao.class);
	Qcode q=new Qcode();
	
	q.setCode_no("666");
	qcodeDao.save(q);

}
}
