package com.example.DateCalcu.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;



public class ReferenceDateForm {

	//計算基準日
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ReferenceDate;

	//計算結果
	private List<Result> results;

	//コンストラクタ

	public ReferenceDateForm(LocalDate ReferenceDate, List<DomainForm> results) {
		//計算基準日を設定
		this.ReferenceDate = ReferenceDate;
		//計算結果List初期化
		this.results = new ArrayList<>();
		results = new ArrayList<>();

		for(DomainForm formula :results) {
			this.results.add(convertToResult(formula));
		}
		}

	public Result convertToResult(DomainForm formula) {
		return new Result(formula);
	}


	//計算結果取得
	public List<Result> getResults() {

		return results;
	}

	public LocalDate getReferenceDate() {
		return ReferenceDate;
	}

	public void setReferenceDate(LocalDate referenceDate) {
		ReferenceDate = referenceDate;
	}

}
