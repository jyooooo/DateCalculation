package com.example.DateCalcu.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.DateCalcu.domain.DomainForm;
import com.example.DateCalcu.service.CalcuService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CreateControllerTest {

	private MockMvc mockMvc;

	//@Autowiredされるクラスをモック化
	@MockBean
	CalcuService mockFormService;

	//テスト対象のクラスをDIコンテナに登録
	@Autowired
	private CreateController target;

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
	public void 新規登録画面の日付IDが空白のまま登録処理に移った場合例外情報が入った状態で画面が返る事() throws Exception {
		DomainForm sut = new DomainForm();
		//空白をセット
		sut.setDateId(" ");
		sut.setDateName("テスト");
		mockMvc.perform((post("/create")).flashAttr("form", sut))
				//エラー判定
				.andExpect(model().hasErrors())
				//指定のviewを返すか？
				.andExpect(view().name("register"));
	}

	@Test
	public void 新規登録画面の日付IDが空のまま登録処理に移った場合例外情報が入った状態で画面が返る事() throws Exception {
		DomainForm sut = new DomainForm();
		//空をセット
		sut.setDateName("");
		sut.setDateId("テスト");

		mockMvc.perform((post("/create")).flashAttr("form", sut))
				//エラー判定
				.andExpect(model().hasErrors())
				//指定のviewを返すか？
				.andExpect(view().name("register"));
	}

	@Test
	public void 新規登録画面の日付IDがNullのまま登録処理に移った場合例外情報が入った状態で画面が返る事() throws Exception {
		DomainForm sut = new DomainForm();
		//日付名のみセット
		sut.setDateName("テスト");

		mockMvc.perform((post("/create")).flashAttr("form", sut))
				//エラー判定
				.andExpect(model().hasErrors())
				//指定のviewを返すか？
				.andExpect(view().name("register"));
	}

	@Test
	public void 新規登録画面の日付IDが6桁以上のまま登録処理に移った場合例外情報が入った状態で画面が返る事() throws Exception {
		DomainForm sut = new DomainForm();
		//6桁の日付IDをセット
		sut.setDateId("1234567");
		sut.setDateName("テスト");

		mockMvc.perform((post("/create")).flashAttr("form", sut))
				//エラー判定
				.andExpect(model().hasErrors())
				//指定のviewを返すか？
				.andExpect(view().name("register"));
	}
	@Test
	public void 新規登録画面の日付名が空白のまま登録処理に移った場合例外情報が入った状態で画面が返る事() throws Exception {
		DomainForm sut = new DomainForm();
		//空白をセット
		sut.setDateName(" ");
		sut.setDateId("TEST");
		mockMvc.perform((post("/create")).flashAttr("form", sut))
				//エラー判定
				.andExpect(model().hasErrors())
				//指定のviewを返すか？
				.andExpect(view().name("register"));
	}

	@Test
	public void 新規登録画面の日付名が空のまま登録処理に移った場合例外情報が入った状態で画面が返る事() throws Exception {
		DomainForm sut = new DomainForm();
		//空をセット
		sut.setDateName("");
		sut.setDateId("TEST");

		mockMvc.perform((post("/create")).flashAttr("form", sut))
				//エラー判定
				.andExpect(model().hasErrors())
				//指定のviewを返すか？
				.andExpect(view().name("register"));
	}

	@Test
	public void 新規登録画面の日付名がNullのまま登録処理に移った場合例外情報が入った状態で画面が返る事() throws Exception {
		DomainForm sut = new DomainForm();
		//日付IDのみセット
		sut.setDateId("テスト");

		mockMvc.perform((post("/create")).flashAttr("form", sut))
				//エラー判定
				.andExpect(model().hasErrors())
				//指定のviewを返すか？
				.andExpect(view().name("register"));
	}

	@Test
	public void 新規登録画面の日付名が32桁以上のまま登録処理に移った場合例外情報が入った状態で画面が返る事() throws Exception {
		DomainForm sut = new DomainForm();
		//6桁の日付IDをセット
		sut.setDateName("0123456789ABCDEF101112131415161718");
		sut.setDateId("テスト");

		mockMvc.perform((post("/create")).flashAttr("form", sut))
				//エラー判定
				.andExpect(model().hasErrors())
				//指定のviewを返すか？
				.andExpect(view().name("register"));
	}
	@Test
	public void 新規登録画面で登録されるとサービスクラスで処理され計算画面に遷移されること() throws Exception {
		DomainForm sut = new DomainForm();

		sut.setDateId("hoge");
		sut.setDateId("hoge");
		sut.setDateId("hoge");
		sut.setDateId("hoge");

		mockMvc.perform((post("/create")).flashAttr("form", sut))
				//エラー判定
				.andExpect(model().hasNoErrors())
				.andExpect(model().attribute("form", sut))
				//指定のviewを返すか？
				.andExpect(view().name("index"));
		//CalcuService.saveがformというインスタンスを引数に1回呼ばれることをテスト
		verify(mockFormService, times(1)).save(sut);

	}
}