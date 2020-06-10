package com.example.DateCalcu.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.example.DateCalcu.service.CalcuService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")

public class CalcuControllerTest {
	private MockMvc mockMvc;

	//@Autowiredされるクラスをモック化
	@MockBean
	private CalcuService mockFormService;

	//テスト対象のクラスをDIコンテナに登録
	@Autowired
	CalcuController target;

	//このmockMvcインスタンスを利用して、仮想のリクエストを発生させテストを実行する
	@Before
	public void setup() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("classpath:templates/");
		viewResolver.setSuffix(".html");

		mockMvc = MockMvcBuilders.standaloneSetup(target).setViewResolvers(viewResolver).build();
	}

	@Test
	public void 計算画面で計算基準日を入力して計算実行を押すと計算処理サービスが呼ばれること() throws Exception {

		mockMvc.perform(post("/calcu").param("ReferenceDate", "2020-01-01"))
				//HTTPステータスコードのテスト
				.andExpect(status().isOk())
				//指定のviewを返すか？
				.andExpect(view().name("index"));

				//verify(mockFormService, times(1)).calculate("2020-01-01",any());
	}

	@Test
	public void 計算画面で計算基準日をNULLして計算実行を押すと例外情報が入った状態で画面が返る事() throws Exception {

		mockMvc.perform(post("/calcu"))
				//エラー判定
				.andExpect(model().hasErrors())
				//HTTPステータスコードのテスト
				.andExpect(status().isOk())
				//指定のviewを返すか？
				.andExpect(view().name("index"));
	}

	@Test
	public void 計算画面で計算基準日を空にして計算実行を押すと例外情報が入った状態で画面が返る事() throws Exception {

		mockMvc.perform(post("/calcu").param("ReferenceDate", ""))
				//エラー判定
				.andExpect(model().hasErrors())
				//HTTPステータスコードのテスト
				.andExpect(status().isOk())
				//指定のviewを返すか？
				.andExpect(view().name("index"));
	}

	@Test
	public void 計算画面で計算基準日を空白にして計算実行を押すと例外情報が入った状態で画面が返る事() throws Exception {

		mockMvc.perform(post("/calcu").param("ReferenceDate", " "))
				//エラー判定
				.andExpect(model().hasErrors())
				//HTTPステータスコードのテスト
				.andExpect(status().isOk())
				//指定のviewを返すか？
				.andExpect(view().name("index"));
	}

	@Test
	public void 計算画面で計算基準日に不正な型を入れ計算実行を押すと例外情報が入った状態で画面が返る事() throws Exception {

		mockMvc.perform(post("/calcu").param("ReferenceDate", " 20200101"))
				//エラー判定
				.andExpect(model().hasErrors())
				//HTTPステータスコードのテスト
				.andExpect(status().isOk())
				//指定のviewを返すか？
				.andExpect(view().name("index"));
	}

	@Test
	public void 計算画面で計算基準日に不正な値を入れ計算実行を押すと例外情報が入った状態で画面が返る事() throws Exception {

		mockMvc.perform(post("/calcu").param("ReferenceDate", " 1800-01-01"))
				//エラー判定
				.andExpect(model().hasErrors())
				//HTTPステータスコードのテスト
				.andExpect(status().isOk())
				//指定のviewを返すか？
				.andExpect(view().name("index"));
	}
}
