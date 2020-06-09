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

import com.example.DateCalcu.domain.DomainForm;
import com.example.DateCalcu.service.CalcuService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class EditControllerTest {

	private MockMvc mockMvc;

	//@Autowiredされるクラスをモック化
	@MockBean
	private CalcuService mockFormService;

	//テスト対象のクラスをDIコンテナに登録
	@Autowired
	private EditController target;

	//このmockMvcインスタンスを利用して、仮想のリクエストを発生させテストを実行する
	@Before
	public void setup() throws Exception {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("classpath:templates/");
		viewResolver.setSuffix(".html");

		mockMvc = MockMvcBuilders.standaloneSetup(target).setViewResolvers(viewResolver).build();
	}

	@Test
	public void 更新画面のリクエスト結果が正常となりViewとしてeditが返る事() throws Exception {
		mockMvc.perform(get("/{dateId}/edit", "TEST"))
				//HTTPステータスコードのテスト
				.andExpect(status().isOk())
				//指定のviewを返すか？
				.andExpect(view().name("edit"));
		verify(mockFormService, times(1)).findOne("TEST");
	}

	@Test
	public void 更新画面で登録されるとサービスクラスで処理され計算画面に遷移されること() throws Exception {

		mockMvc.perform(post("/{dateId}/update", "TEST").param("dateId", "TEST").param("dateName", "テスト"))

				//指定のviewを返すか？
				.andExpect(view().name("redirect:/"));

		verify(mockFormService, times(1)).update(any());

	}

	@Test
	public void 更新画面の日付名が空白のまま登録処理に移った場合例外情報が入った状態で画面が返る事() throws Exception {

		mockMvc.perform(post("/{dateId}/update", "TEST").param("dateId", "TEST").param("dateName", " "))
				//エラー判定
				.andExpect(model().hasErrors())
				//HTTPステータスコードのテスト
				.andExpect(status().isOk())
				//指定のviewを返すか？
				.andExpect(view().name("edit"));
	}

	@Test
	public void 更新画面の日付名が空のまま登録処理に移った場合例外情報が入った状態で画面が返る事() throws Exception {
		DomainForm sut = new DomainForm();
		//空をセット
		sut.setDateName("");
		sut.setDateId("TEST");
		mockMvc.perform(post("/{dateId}/update", "TEST"))

				//エラー判定
				.andExpect(model().hasErrors())
				//HTTPステータスコードのテスト
				.andExpect(status().isOk())
				//指定のviewを返すか？
				.andExpect(view().name("edit"));
	}

	@Test
	public void 更新画面の日付名がNullのまま登録処理に移った場合例外情報が入った状態で画面が返る事() throws Exception {
		DomainForm sut = new DomainForm();
		//日付IDのみセット
		sut.setDateId("TEST");
		mockMvc.perform(post("/{dateId}/update", "TEST"))
				//エラー判定
				.andExpect(model().hasErrors())
				//HTTPステータスコードのテスト
				.andExpect(status().isOk())
				//指定のviewを返すか？
				.andExpect(view().name("edit"));
	}

	@Test
	public void 更新画面の日付名が32桁以上のまま登録処理に移った場合例外情報が入った状態で画面が返る事() throws Exception {
		DomainForm sut = new DomainForm();
		//6桁の日付IDをセット
		sut.setDateName("0123456789ABCDEF101112131415161718");
		sut.setDateId("TEST");
		mockMvc.perform(post("/{dateId}/update", "TEST"))

				//エラー判定
				.andExpect(model().hasErrors())
				//HTTPステータスコードのテスト
				.andExpect(status().isOk())
				//指定のviewを返すか？
				.andExpect(view().name("edit"));
	}

}
