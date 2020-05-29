package com.example.DateCalcu.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.DateCalcu.domain.DomainForm;
import com.example.DateCalcu.repository.CalcuMapper;

@Service
public class CalcuService {

	@Autowired
	public CalcuMapper calcuMapper;

	@Transactional
	public List<DomainForm> findAll() {
		return calcuMapper.findAll();

	}

	@Transactional
	public DomainForm findOne(String dateId) {
		return calcuMapper.findONE(dateId);

	}

	@Transactional
	public void save(DomainForm domainform) {
		calcuMapper.save(domainform);
	}

	@Transactional
	public void update(DomainForm domainform) {
		calcuMapper.update(domainform);
	}

	@Transactional
	public void delete(String dateId) {
		calcuMapper.delete(dateId);
	}

	//計算基準日と計算式で日付計算を行う
	public String calculate(String ReferenceDate, DomainForm formula) {

		//StringからLocalDate型へ変換
		LocalDate Date = LocalDate.parse(ReferenceDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		//基準日から年月日を計算
		LocalDate calculatedDate =
				Date.plusYears(formula.getYear()).plusMonths(formula.getMonth()).plusDays(formula.getDate());
		return calculatedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

	}

}
