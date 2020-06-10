package com.example.DateCalcu.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
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
public class DeleteControllerTest {

	private MockMvc mockMvc;

	//@Autowiredされるクラスをモック化
	@MockBean
	private CalcuService mockFormService;

	//テスト対象のクラスをDIコンテナに登録
	@Autowired
	private DeleteController target;

	//このmockMvcインスタンスを利用して、仮想のリクエストを発生させテストを実行する
	@Before
	public void setup() throws Exception {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("classpath:templates/");
		viewResolver.setSuffix(".html");

		mockMvc = MockMvcBuilders.standaloneSetup(target).setViewResolvers(viewResolver).build();
	}

	@Test
	public void 計算画面で削除されるとサービスクラスで処理され同一画面に遷移されること() throws Exception {

		mockMvc.perform(post("/{dateId}", "TEST"))

				//指定のviewを返すか？
				.andExpect(view().name("redirect:/"));

		verify(mockFormService, times(1)).delete(any());

	}

}
