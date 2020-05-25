package com.example.DateCalcu.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;



public class ReferenceDateForm {

	//計算基準日
	@NotBlank(message = "計算基準日を入力してください")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private String ReferenceDate;

	//計算結果
	private List<Result> results;

	//コンストラクタ
	public ReferenceDateForm(String ReferenceDate, List<DomainForm> results) {
		//計算基準日を設定
		this.ReferenceDate = ReferenceDate;
		//計算結果List初期化
		this.results = new ArrayList<>();
		//NullException対策
		if(results==null) {
		results = new ArrayList<>();
		}else {
			results.stream().forEach(r -> this.results.add(convertToResult(r)));
		}
		}

	public Result convertToResult(DomainForm formula) {
		return new Result(formula);
	}


	//計算結果取得
	public List<Result> getResults() {

		return results;
	}

	public String getReferenceDate() {
		return ReferenceDate;
	}

	public void setReferenceDate(String referenceDate) {
		ReferenceDate = referenceDate;
	}

}
