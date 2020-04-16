package com.example.DateCalcu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.DateCalcu.domain.DomainForm;
import com.example.DateCalcu.repository.CalcuMapper;;



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

	//	日付計算を行う
	public String calculate() {
		return "";
	}

}