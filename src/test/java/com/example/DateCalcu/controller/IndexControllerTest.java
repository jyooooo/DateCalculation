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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class IndexControllerTest {

	 private MockMvc mockMvc;

	 //テスト対象のクラスをDIコンテナに登録
	  @Autowired
	  IndexController target;

	  //このmockMvcインスタンスを利用して、仮想のリクエストを発生させテストを実行する
	  @Before
	  public void setup() {
	    mockMvc = MockMvcBuilders.standaloneSetup(target).build();
}

	  @Test
	    public void メイン画面のリクエスト結果が正常となりViewとしてindexが返る事() throws Exception {

	      mockMvc.perform(get("/"))
	      		//HTTPステータスコードのテスト
	           .andExpect(status().isOk())
	           	//指定のviewを返すか？
	           .andExpect(view().name("index"));
	    }



}
