package com.example.DateCalcu.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.DateCalcu.domain.DomainForm;
import com.example.DateCalcu.domain.ReferenceDateForm;
import com.example.DateCalcu.service.CalcuService;

@Controller

public class CalcuController {

	@Autowired
	public CalcuService calcuService;

	@PostMapping("/calcu")
	public String calcu(@ModelAttribute("ReferenceDateForm") ReferenceDateForm form, DomainForm forms, Model model) {


		//計算基準日と計算式を取得
		LocalDate result = calcuService.calculate(form.getReferenceDate(), forms.getDateId());

		System.out.println("計算結果"+result);


		model.addAttribute("results", result);

		return "redirect:/";

	}
}
//計算基準日と計算式を取得
//		ReferenceDateForm resultForm = new ReferenceDateForm(form.getReferenceDate(), calcuService.findAll());
//		System.out.println(calcuService.findAll());

//計算基準日と計算式を取得
//		ReferenceDateForm resultForm=new ReferenceDateForm(form.getReferenceDate(),forms.getDateId());


//		//計算結果を取得
//		List<Result> results = resultForm.getResults();
//
//
//		//計算基準日と計算式を取得し、calculated(計算結果)にセット
//		results.stream().forEach(e -> e.setCalculated(calcuService.calculate(form.getReferenceDate(), e.getFormula())));
//
//
//		//日付IDから年,月,日を取得。
//		DomainForm domainform=calcuService.findOne(form.getDateId());
//
//		int year=domainform.getYear();
//
//		int month=domainform.getMonth();
//
//		int date=domainform.getDate();
//
//		//基準日に対して加算減算をする。
//		LocalDate ReferenceDate=form.getReferenceDate();
//
//		ReferenceDate= ReferenceDate.plusYears(year);
//		ReferenceDate = ReferenceDate.plusMonths(month);
//		ReferenceDate = ReferenceDate.plusDays(date);
//
//		System.out.println(ReferenceDate);
//		Result result=setCalcuresult(String ReferenceDate);
//
//		model.addAttribute("referencedate", ReferenceDate);

//入力フォームのidから計算式を取得して、年・月・日の増減値を取得。
//			WorkDateType workDateType = workDateService.findOneById(form.getId());
//			model.addAttribute("workDateType", workDateType);
//			Integer inputAddOrSubYear = workDateType.getInputAddOrSubYear();
//			Integer inputAddOrSubMonth = workDateType.getInputAddOrSubMonth();
//			Integer inputAddOrSubDay = workDateType.getInputAddOrSubDay();
//
//	//入力フォームの日付に年・月・日の値の加減を行う。
//			LocalDate inputDate = form.getInputDate();
//			inputDate = inputDate.plusYears(inputAddOrSubYear);
//			inputDate = inputDate.plusMonths(inputAddOrSubMonth);
//			inputDate = inputDate.plusDays(inputAddOrSubDay);
//			System.out.println(inputDate);
//			model.addAttribute("inputDate", inputDate);
//			return "calcResult";
//		}
