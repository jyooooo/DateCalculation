package com.example.DateCalcu.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
public class ReferenceDateForm {

		//計算基準日
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private LocalDate ReferenceDate;

		//日付ID
		@Size(min = 1, max = 5, message = "Please input 5characters or Less")
		@NotBlank
		private String dateId;

		//計算結果
		private List<Result> results;


		//日付計算式一覧
		public ReferenceDateForm(LocalDate ReferenceDate, List<DomainForm> results) {


			this.ReferenceDate = ReferenceDate;
			this.results = new ArrayList<>();

				results=new ArrayList<>();
				//List(計算式)から1つずつ取り出して、results(計算結果)に加える
				results.stream().forEach(r -> this.results.add(convertToResult(r)));

				System.out.println("Not empty");
		}

		//計算式を画面用計算結果オブジェクトへ変換
		public Result convertToResult(DomainForm domainform) {
				System.out.println(domainform);
				return new Result(domainform);
			}


		//計算結果取得
		public List<Result> getResults() {
			return getResults();
		}


		public LocalDate getReferenceDate() {
			return ReferenceDate;
		}

		public void setReferenceDate(LocalDate referenceDate) {
			ReferenceDate = referenceDate;
		}

		public String getDateId() {
			return dateId;
		}

		public void setDateId(String dateId) {
			this.dateId = dateId;
		}

}
