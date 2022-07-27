package com.iu.employees;

public class EmployeesView {
	
	public void view(EmployeesDTO employee) {
		System.out.println(employee.getEmployee_id());
		System.out.println(employee.getFirst_name());
		System.out.println(employee.getLast_name());
		System.out.println(employee.getEmail());
		System.out.println(employee.getPhone_number());
		System.out.println(employee.getHire_date());
		System.out.println(employee.getJob_id());
		System.out.println(employee.getSalary());
		System.out.println(employee.getCommission_pct());
		System.out.println(employee.getManager_id());
		System.out.println(employee.getDepartment_id());
		
	}

}
