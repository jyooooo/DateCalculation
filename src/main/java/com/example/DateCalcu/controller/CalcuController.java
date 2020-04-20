package com.example.DateCalcu.controller;

import java.time.LocalDate;
import java.util.List;

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
	public String calcu(@ModelAttribute ("referencedateform") ReferenceDateForm form,Model model) {
//
//		if (result.hasErrors()) {
//			return "index";
//		}
		System.out.println("calcu処理");

		List<DomainForm> list = calcuService.findAll();
		model.addAttribute("Lists",list);


		//日付IDから年,月,日を取得。
		DomainForm domainform=calcuService.findOne(form.getDateId());

		model.addAttribute("domainform",domainform);

		int year=domainform.getYear();

		int month=domainform.getMonth();

		int date=domainform.getDate();

		//基準日に対して加算減算をする。
		LocalDate ReferenceDate=form.getReferenceDate();

		ReferenceDate = ReferenceDate.plusYears(year);
		ReferenceDate = ReferenceDate.plusMonths(month);
		ReferenceDate = ReferenceDate.plusDays(date);
		System.out.println(ReferenceDate);
		model.addAttribute("referencedate", ReferenceDate);

		return "redirect:/";
	}



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

}
