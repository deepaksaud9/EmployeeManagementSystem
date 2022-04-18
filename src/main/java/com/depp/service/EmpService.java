package com.depp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.depp.entity.Employee;
import com.depp.repository.EmpRepo;
@Service
public class EmpService {
	
	@Autowired
	private EmpRepo eRepo;
	
	public void addEmp(Employee e)
	{	
		eRepo.save(e);
		
	}

	public List<Employee> getAllEmp()
	{
		return eRepo.findAll();
	}
	
	public Employee getEmpById(int id)
	{
		
		Optional<Employee> e= eRepo.findById(id);
		if(e.isPresent())
		{
			return e.get();
		}
		return null;
	}
	
	public void deleteEmp(int id)
	{
		eRepo.deleteById(id);
	}
}

