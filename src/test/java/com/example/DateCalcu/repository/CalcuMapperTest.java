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
	public void 計算式を全件取得できるか() throws Exception {
		List<DomainForm> actual = sut.findAll();
		assertThat(actual.size(), is(2));
	}

	@Test
	public void 日付IDのM01を検索して結果がキーに紐づく1件だけ取得出来る事() throws Exception {
		DomainForm actual = sut.findONE("M01");
		assertThat(actual.getDateId(), is("M01"));
		assertThat(actual.getDateName(), is("来月"));
		assertThat(actual.getYear(), is(0));
		assertThat(actual.getMonth(), is(1));
		assertThat(actual.getDate(), is(0));
	}

	@Test
	public void 新規登録が出来る事() throws Exception {
		DomainForm formula = NewFormula();
		sut.save(formula);
		DomainForm actual = sut.findONE("Y01");
		assertThat(actual.getDateId(), is("Y01"));
	}
	@Test
	public void 削除が出来る事() throws Exception {
		sut.delete("M01");
		List<DomainForm> actual = sut.findAll();
		assertThat(actual.size(), is(1));

	}
	//テスト用新規計算式
	private DomainForm NewFormula() {
		DomainForm formula = new DomainForm();
		formula.setDateId("Y01");
		formula.setDateName("翌年");
		formula.setYear(1);
		formula.setMonth(0);
		formula.setDate(0);
		return formula;
	}
}