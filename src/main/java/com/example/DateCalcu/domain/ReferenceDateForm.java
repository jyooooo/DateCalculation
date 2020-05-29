package com.example.DateCalcu.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;



public class ReferenceDateForm {

	//計算基準日
	@NotBlank
	//1900/1/1〜のみ適用
	@Pattern(regexp = "((19|[2-9][0-9])[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])")
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

	//コンストラクタ
	public ReferenceDateForm() {

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
