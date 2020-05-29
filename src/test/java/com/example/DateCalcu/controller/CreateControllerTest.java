package com.example.DateCalcu.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.DateCalcu.domain.DomainForm;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CreateControllerTest {

	private MockMvc mockMvc;

	//テスト対象のクラスをDIコンテナに登録
	@Autowired
	CreateController target;

	//このmockMvcインスタンスを利用して、仮想のリクエストを発生させテストを実行する
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(target).build();
	}

	@Test
	public void 新規登録画面のリクエスト結果が正常となりViewとしてregisterが返る事() throws Exception {
		mockMvc.perform(get("/register"))
				//HTTPステータスコードのテスト
				.andExpect(status().isOk())
				//指定のviewを返すか？
				.andExpect(view().name("register"));
	}

	@Test
	public void バリデーションエラーが発生した場合() throws Exception {
		DomainForm form = new DomainForm();
		form.setDateId("hoge");

		mockMvc.perform((post("/create")).flashAttr("form", form))
				//エラー判定
				.andExpect(model().hasErrors())
				//指定のviewを返すか？
				.andExpect(view().name("index"));
	}
}