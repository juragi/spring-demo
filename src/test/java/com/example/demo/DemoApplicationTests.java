package com.example.demo;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Pagination;
import com.example.demo.repository.TestRepository;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	TestRepository testRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void paginationTest() {
		int totalItemCount = 90;
		int page = 16;
		int pageSize = 9;
		Pagination pagination = new Pagination(page, totalItemCount, pageSize);
		System.out.println("start page : " + pagination.getStartPage());
		System.out.println("last page : " + pagination.getLastPage());
		System.out.println("end page : " + pagination.getEndPage());
		System.out.println("has prev : " + pagination.getHasPrev());
		System.out.println("has next : " + pagination.getHasNext());
		System.out.println("modified page : " + pagination.getPage());
	}

	@Test
	void jdbcTest() {
		int insertedId = testRepository.insert("name2");
		System.out.println("insertedId: " + insertedId);
		List<Map<String, Object>> list = testRepository.getList("name");
		System.out.println(list);
	}

}
