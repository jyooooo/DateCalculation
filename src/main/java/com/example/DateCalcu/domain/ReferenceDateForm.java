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


			this.ReferenceDate = ReferenceDate;
			this.results = new ArrayList<>();

				results=new ArrayList<>();
				//List(計算式)から1つずつ取り出して、results(計算結果)に加える
				results.stream().forEach(r -> this.results.add(convertToResult(r)));


		}

		//計算式を画面用計算結果オブジェクトへ変換
		public Result convertToResult(DomainForm domainform) {
				System.out.println("domainformは"+domainform);
				return new Result(domainform);
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
