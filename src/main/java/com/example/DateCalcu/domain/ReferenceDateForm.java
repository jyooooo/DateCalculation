package com.example.DateCalcu.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ReferenceDateForm {

		//計算基準日
		@Size(min = 1, max = 5, message = "Please input 5characters or Less")
		@NotBlank
		private String ReferenceDate;

		public String getReferenceDate() {
			return ReferenceDate;
		}

		public void setReferenceDate(String referenceDate) {
			ReferenceDate = referenceDate;
		}

		//計算基準日を設定
		public ReferenceDateForm(String RefarenceDate) {
			this.ReferenceDate=RefarenceDate;

		}

}
