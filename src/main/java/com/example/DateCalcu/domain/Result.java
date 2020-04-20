package com.example.DateCalcu.domain;

public class Result {

	//計算式
	private DomainForm formula;

	//計算結果
	private String calcuresult;

	//コンストラクタ
	public Result(DomainForm formula) {
		this.formula = formula;
	}







	public DomainForm getFormula() {
		return formula;
	}

	public void setFormula(DomainForm formula) {
		this.formula = formula;
	}

	public String getCalcuresult() {
		return calcuresult;
	}

	public void setCalcuresult(String calcuresult) {
		this.calcuresult = calcuresult;
	}




}
