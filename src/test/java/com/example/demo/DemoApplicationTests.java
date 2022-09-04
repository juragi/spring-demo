package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Pagination;

@SpringBootTest
class DemoApplicationTests {

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

}
