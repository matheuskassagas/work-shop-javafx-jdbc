package service;

import java.util.ArrayList;
import java.util.List;

import entity.Department;

public class DepartmentService {
	
	public List<Department> findAll(){
		List<Department> list = new ArrayList<>();
		list.add(new Department(1, "School"));
		return list;
	}

}