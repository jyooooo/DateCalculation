package com.example.DateCalcu.service;

import java.time.LocalDate;
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

	//日付計算を行う
	public LocalDate calculate(LocalDate ReferenceDate,DomainForm formula) {

		//日付IDから年,月,日を取得。
		DomainForm domainform=findOne(formula.getDateId());

		int year=domainform.getYear();

		int month=domainform.getMonth();

		int date=domainform.getDate();

		//基準日に対して加算減算をする。
//		LocalDate ReferenceDate=ReferenceDate;

		ReferenceDate= ReferenceDate.plusYears(year);
		ReferenceDate = ReferenceDate.plusMonths(month);
		ReferenceDate = ReferenceDate.plusDays(date);

		System.out.println("計算結果は、、"+ReferenceDate+"です");


		return ReferenceDate;
	}

}