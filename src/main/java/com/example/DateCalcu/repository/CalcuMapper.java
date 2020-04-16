package com.example.DateCalcu.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
//
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.DateCalcu.domain.DomainForm;

@Mapper
public interface CalcuMapper {

	@Select("SELECT * FROM dateformula")
	List<DomainForm> findAll();


	@Select("SELECT * FROM dateformula WHERE dateId = #{dateId}")
	DomainForm findONE(String dateId);

	@Insert("INSERT INTO dateformula (dateId, dateName, year, month, date) values (#{dateId}, #{dateName}, #{year}, #{month}, #{date})")
	 void save(DomainForm domainform) ;


	@Update("UPDATE dateformula SET dateId = #{dateId}, dateName = #{dateName}, year = #{year}, month = #{month}, date = #{date} WHERE dateId = #{dateId}")
    void update(DomainForm domainform);

	@Delete("DELETE FROM dateformula WHERE dateId = #{dateId}")
	void delete(String dateId);

}

