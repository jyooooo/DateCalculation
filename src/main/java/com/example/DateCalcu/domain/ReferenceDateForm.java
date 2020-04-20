package com.example.DateCalcu.domain;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class ReferenceDateForm {

		//計算基準日
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private LocalDate ReferenceDate;

		@Size(min = 1, max = 5, message = "Please input 5characters or Less")
		@NotBlank
		private String dateId;


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




		//計算基準日を設定
//		public ReferenceDateForm(String RefarenceDate) {
//			this.ReferenceDate=RefarenceDate;
//
//		}

}
