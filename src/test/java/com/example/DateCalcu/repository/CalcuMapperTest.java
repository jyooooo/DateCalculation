package com.example.DateCalcu.repository;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.DateCalcu.domain.DomainForm;

@RunWith(SpringRunner.class)
@MybatisTest
@TestPropertySource(locations = "classpath:test.properties")
public class CalcuMapperTest {

	@Autowired
	private CalcuMapper sut;

	@Test
	public void 計算式を全件取得できるか()throws Exception {
		List<DomainForm> actual = sut.findAll();
		assertThat(actual.size(), is(2));
	}
}