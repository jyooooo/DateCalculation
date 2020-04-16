package com.example.DateCalcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.DateCalcu.service.CalcuService;

@Controller

public class DeleteController {

	@Autowired
	public CalcuService calcuService;

	//削除
	@PostMapping("{dateId}")
	public String destroy(@PathVariable String dateId) {

		calcuService.delete(dateId);
		return "redirect:/";
	}

}
