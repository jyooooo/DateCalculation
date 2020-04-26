package com.example.DateCalcu.domain;

import java.time.LocalDate;

public class Result {

	//計算式
	private DomainForm formula;

	//計算結果
	private LocalDate calculated;

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

	public LocalDate getCalculated() {
		return calculated;
	}

	public void setCalculated(LocalDate calculated) {
		this.calculated = calculated;
	}

}
