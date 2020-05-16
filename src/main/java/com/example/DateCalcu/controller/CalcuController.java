package com.example.DateCalcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.DateCalcu.domain.DomainForm;
import com.example.DateCalcu.domain.ReferenceDateForm;
import com.example.DateCalcu.domain.Result;
import com.example.DateCalcu.service.CalcuService;

@Controller

public class CalcuController {

	@Autowired
	public CalcuService calcuService;

	@PostMapping("/calcu")
	public String calcu(@ModelAttribute("ReferenceDateForm") ReferenceDateForm form,DomainForm forms,Model model) {

		ReferenceDateForm resultForm = new ReferenceDateForm(form.getReferenceDate(), calcuService.findAll());

		//計算結果を取得してListに代入
		List<Result> results = resultForm.getResults();
		System.out.println("計算結果"+results+"です");
		//計算結果を設定
		results.stream().forEach(e -> e.setCalculated(calcuService.calculate(form.getReferenceDate(), e.getFormula())));

		model.addAttribute("results", results);


		return "index";

	}
}

