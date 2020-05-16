package com.example.DateCalcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.DateCalcu.domain.DomainForm;
import com.example.DateCalcu.service.CalcuService;

@Controller

public class CreateController {

	@Autowired
	public CalcuService calcuService;

	//新規登録画面に遷移
	@GetMapping("/register")
	public String indexregister(@ModelAttribute("domainform") DomainForm domainform) {
		return "register";
	}

	//新規登録
	@PostMapping("/create")
	public String create(@Validated @ModelAttribute("domainform")DomainForm domainform,
			BindingResult result, Model model) {
		System.out.println(result);
		//バリデーション(新規)
			if (result.hasErrors()) {
				return "register";
			}

		//登録処理
		calcuService.save(domainform);
		System.out.println(domainform + "が登録されました");

		return "index";

		}

}
