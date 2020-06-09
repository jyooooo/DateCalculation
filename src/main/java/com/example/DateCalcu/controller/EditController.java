package com.example.DateCalcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.DateCalcu.domain.DomainForm;
import com.example.DateCalcu.service.CalcuService;

@Controller

public class EditController {

	@Autowired
	public CalcuService calcuService;


	//編集
	@GetMapping("/{dateId}/edit")
	public String edit(@PathVariable String dateId,@ModelAttribute("domainform") DomainForm domainform , Model model) {

		model.addAttribute("domainform", calcuService.findOne(dateId));
		return "edit";
	}

	//更新
	@PostMapping("/{dateId}/update")
	public String update(@Validated @ModelAttribute("domainform") DomainForm domainform,
			BindingResult results, @PathVariable String dateId, Model model) {
		//バリデーション
		if (results.hasErrors()) {
			return "edit";
		}

		//更新処理
		domainform.setDateId(dateId);
		calcuService.update(domainform);
		return "redirect:/";
	}

}
