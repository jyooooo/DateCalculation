package com.example.DateCalcu.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DomainForm {

	@NotBlank(message = "日付IDは必須項目です")
	@Size(min = 1, max = 5, message = "日付IDは1文字以上、5文字以内で日付IDを入力してください")
	private String dateId;

	@NotBlank(message = "日付名は必須項目です")
	@Size(min = 1, max = 5, message = "日付名は1文字以上、5文字以内で日付名を入力してください")
	private String dateName;


   @Min(value = 0, message = "{value}以上で入力してください。")
	private int year;


   @Min(value = 0, message = "{value}以上で入力してください。")
	private int month;


   @Min(value = 0, message = "{value}以上で入力してください。")
	private int date;

	//Getter,Setter

	public String getDateId() {
		return dateId;
	}

	public void setDateId(String dateId) {
		this.dateId = dateId;
	}

	public String getDateName() {
		return dateName;
	}

	public void setDateName(String dateName) {
		this.dateName = dateName;
	}


		public int getYear() {
			return year;
		}


		public void setYear(int year) {
			this.year = year;
		}


		public int getMonth() {
			return month;
		}


		public void setMonth(int month) {
			this.month = month;
		}


		public int getDate() {
			return date;
		}


		public void setDate(int date) {
			this.date = date;
		}

}
