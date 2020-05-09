package com.example.DateCalcu.domain;

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

}
