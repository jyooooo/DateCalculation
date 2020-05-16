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

	//計算基準日と日付IDで日付計算を行う
	public String calculate(LocalDate ReferenceDate,DomainForm formula) {

		//日付IDから年,月,日を取得。



		int year=formula.getYear();

		int month=formula.getMonth();

		int date=formula.getDate();

		ReferenceDate= ReferenceDate.plusYears(year);
		ReferenceDate = ReferenceDate.plusMonths(month);
		ReferenceDate = ReferenceDate.plusDays(date);

		return ReferenceDate.format(DateTimeFormatter.ofPattern("yyyy-M-d"));

	}

}