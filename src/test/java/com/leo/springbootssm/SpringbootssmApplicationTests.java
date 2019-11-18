package com.leo.springbootssm;

import com.leo.springbootssm.dao.BookDao;
import com.leo.springbootssm.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootssmApplicationTests {

	@Autowired
	private BookDao bookDao;
	@Test
	public void contextLoads() {
		Book book = bookDao.queryById(1);
		System.out.println(book);
	}

}
