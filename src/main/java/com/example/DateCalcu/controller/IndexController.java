package com.example.DateCalcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DateCalcu.domain.DomainForm;
import com.example.DateCalcu.domain.ReferenceDateForm;
import com.example.DateCalcu.service.CalcuService;

@Controller
@RequestMapping("/")

public class IndexController {

	@Autowired
	public CalcuService calcuService;

	@ModelAttribute
	DomainForm domainForm() {
		return new DomainForm();
	}


	//全件表示
	@GetMapping("/")
	public String index(@ModelAttribute("ReferenceDateForm") ReferenceDateForm form,Model model) {

		model.addAttribute("Calculation", calcuService.findAll());
		//index.htmlに画面遷移
		return "index";
	}


}
