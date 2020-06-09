package com.example.DateCalcu.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")

public class CalcuControllerTest {
	private MockMvc mockMvc;

	//テスト対象のクラスをDIコンテナに登録
	@Autowired
	CalcuController target;

	//このmockMvcインスタンスを利用して、仮想のリクエストを発生させテストを実行する
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(target).build();
	}

	//レスポンスのHTTPステータスコードは正しいか
	@Test
	public void getIndexTest() throws Exception {

		mockMvc.perform(post("/calcu"))
				.andExpect(status().isOk());
	}
}
