package com.example.DateCalcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.DateCalcu.domain.ReferenceDateForm;
import com.example.DateCalcu.service.CalcuService;

@Controller

public class CalcuController {

	@Autowired
	public CalcuService calcuService;


	@PostMapping("/calcu")
	public String calcu(@ModelAttribute ReferenceDateForm form,Model model) {

//		ReferenceDateForm resultForm =new ReferenceDateForm(form.getReferenceDate(),calcuService.findAll());

		return "index";

	}

}
