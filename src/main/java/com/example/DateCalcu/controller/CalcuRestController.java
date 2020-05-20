package com.example.DateCalcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.DateCalcu.domain.DomainForm;
import com.example.DateCalcu.service.CalcuService;

@RestController
public class CalcuRestController {

	@Autowired
	public CalcuService calcuService;

	@GetMapping("/api")
	//計算式一覧取得
	public List<DomainForm> findAll(){

	return calcuService.findAll();
	}
	@GetMapping("/api/{dateId:.+}")
	//計算式一覧取得
	public DomainForm findONE(@PathVariable("dateId")String dateId){

	return calcuService.findOne(dateId);

	}

}
