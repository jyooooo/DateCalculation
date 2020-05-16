package com.example.DateCalcu.domain;

import java.util.Arrays;
import java.util.StringJoiner;

public class Result {

	//計算式
	private DomainForm formula;

	//計算結果
	private String calculated;

	//コンストラクタ
	public Result(DomainForm formula) {
		this.formula = formula;
	}
	//計算式を取得
	public DomainForm getFormula() {
		return formula;
	}
	//計算式を設定
	public void setFormula(DomainForm formula) {
		this.formula = formula;
	}
	//計算結果を取得
	public String getCalculated() {
		return calculated;
	}
	//計算結果を設定
	public void setCalculated(String calculated) {
		this.calculated = calculated;
	}
	//日付IDを取得
	public String getDateId() {
		return formula.getDateId();
	}

	//日付名を取得
	public String getDateName() {
		return formula.getDateName();
	}
	public String getYmdFormula() {
		int[] ymdFormula = {formula.getYear(), formula.getMonth(), formula.getDate()};
		StringJoiner joiner = new StringJoiner(" / ");
		Arrays.stream(ymdFormula).forEach(i -> joiner.add(String.valueOf(i)));
		return joiner.toString();
	}

}
