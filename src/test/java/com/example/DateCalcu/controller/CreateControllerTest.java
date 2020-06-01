package com.example.DateCalcu.controller;

import static org.mockito.Mockito.*;
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
	public void 新規登録画面の日付IDが空白のまま登録処理に移った場合例外情報が入った状態で画面が返る事() throws Exception {
		DomainForm form = new DomainForm();
		//空白をセット
		form.setDateId(" ");
		form.setDateName("テスト");
		mockMvc.perform((post("/create")).flashAttr("form", form))
				//エラー判定
				.andExpect(model().hasErrors())
				//指定のviewを返すか？
				.andExpect(view().name("register"));
	}

	@Test
	public void 新規登録画面の日付IDが空のまま登録処理に移った場合例外情報が入った状態で画面が返る事() throws Exception {
		DomainForm form = new DomainForm();
		//空をセット
		form.setDateName("");
		form.setDateId("テスト");

		mockMvc.perform((post("/create")).flashAttr("form", form))
				//エラー判定
				.andExpect(model().hasErrors())
				//指定のviewを返すか？
				.andExpect(view().name("register"));
	}

	@Test
	public void 新規登録画面の日付IDがNullのまま登録処理に移った場合例外情報が入った状態で画面が返る事() throws Exception {
		DomainForm form = new DomainForm();
		//日付名のみセット
		form.setDateName("テスト");

		mockMvc.perform((post("/create")).flashAttr("form", form))
				//エラー判定
				.andExpect(model().hasErrors())
				//指定のviewを返すか？
				.andExpect(view().name("register"));
	}

	@Test
	public void 新規登録画面の日付IDが6桁以上のまま登録処理に移った場合例外情報が入った状態で画面が返る事() throws Exception {
		DomainForm form = new DomainForm();
		//6桁の日付IDをセット
		form.setDateId("1234567");
		form.setDateName("テスト");

		mockMvc.perform((post("/create")).flashAttr("form", form))
				//エラー判定
				.andExpect(model().hasErrors())
				//指定のviewを返すか？
				.andExpect(view().name("register"));
	}
	@Test
	public void 新規登録画面の日付名が空白のまま登録処理に移った場合例外情報が入った状態で画面が返る事() throws Exception {
		DomainForm form = new DomainForm();
		//空白をセット
		form.setDateName(" ");
		form.setDateId("TEST");
		mockMvc.perform((post("/create")).flashAttr("form", form))
				//エラー判定
				.andExpect(model().hasErrors())
				//指定のviewを返すか？
				.andExpect(view().name("register"));
	}

	@Test
	public void 新規登録画面の日付名が空のまま登録処理に移った場合例外情報が入った状態で画面が返る事() throws Exception {
		DomainForm form = new DomainForm();
		//空をセット
		form.setDateName("");
		form.setDateId("TEST");

		mockMvc.perform((post("/create")).flashAttr("form", form))
				//エラー判定
				.andExpect(model().hasErrors())
				//指定のviewを返すか？
				.andExpect(view().name("register"));
	}

	@Test
	public void 新規登録画面の日付名がNullのまま登録処理に移った場合例外情報が入った状態で画面が返る事() throws Exception {
		DomainForm form = new DomainForm();
		//日付IDのみセット
		form.setDateId("テスト");

		mockMvc.perform((post("/create")).flashAttr("form", form))
				//エラー判定
				.andExpect(model().hasErrors())
				//指定のviewを返すか？
				.andExpect(view().name("register"));
	}

	@Test
	public void 新規登録画面の日付名が32桁以上のまま登録処理に移った場合例外情報が入った状態で画面が返る事() throws Exception {
		DomainForm form = new DomainForm();
		//6桁の日付IDをセット
		form.setDateName("0123456789ABCDEF101112131415161718");
		form.setDateId("テスト");

		mockMvc.perform((post("/create")).flashAttr("form", form))
				//エラー判定
				.andExpect(model().hasErrors())
				//指定のviewを返すか？
				.andExpect(view().name("register"));
	}
	@Test
	public void バリデーションエラーが発生しない場合() throws Exception {
		DomainForm form = new DomainForm();

		form.setDateId("hoge");

		mockMvc.perform((post("/create")).flashAttr("form", form))
				//エラー判定
				.andExpect(model().hasNoErrors())
				.andExpect(model().attribute("form", form))
				//指定のviewを返すか？
				.andExpect(view().name("index"));
		//CalcuService.saveがformというインスタンスを引数に1回呼ばれることをテスト
		verify(mockFormService, times(1)).save(form);

	}
}