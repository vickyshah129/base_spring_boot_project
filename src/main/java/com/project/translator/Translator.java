package com.project.translator;

public interface Translator<T1,T2> {
	
	public T1 translateToEntity(T2 t);
	
	public T2 translateToDTO(T1 t);
	
	/*public void translateDtoToEntity(T1 t1, T2 t2);

	public void translateEntityToDTO(T1 t1, T2 t2);*/

	public void translateDtoToEntity(T1 t1, T2 t2);

	/*default Object checkAndSetDefaultValues(Object obj){
		Date currentDate = Utils.getUTCTime();
		if(obj instanceof Employee){
			Employee employee = (Employee) obj;
			Long employeeId = employee.getId();
			if(employeeId == null || employeeId ==0){
				*//*employee.setDateCreation(currentDate);
				employee.setCreatedBy(1L);*//*
			}else{
				employee.setDateUpdate(currentDate);
			}

			if(employee.getDateCreation() == null){
				employee.setDateCreation(currentDate);
				employee.setCreatedBy(1L);
			}
			if(employee.getArchived() == null){
				employee.setArchived(false);
				employee.getUsers().stream().findFirst().get().setArchived(false);
			}
			if(employee.getEnabled() == null){
				employee.setEnabled(true);
			}
			return employee;
		}else
		if(obj instanceof EmployeeRole){
			EmployeeRole employeeRole = (EmployeeRole) obj;
			BigDecimal cycleGrossPay = employeeRole.getCycleGrossPay();
			String employeeCycle = employeeRole.getEmployeeCycle();
			if(cycleGrossPay == null){
				employeeRole.setCycleGrossPay(new BigDecimal(0.0));
			}
			if(employeeCycle == null || employeeCycle.isEmpty()){
				employeeRole.setEmployeeCycle("HOURLY");
			}
			return employeeRole;
		}else if(obj instanceof Roles){
			Roles role = (Roles) obj;
			Long roleId = role.getId();

			if(roleId == null || roleId<=0){
				role.setArchived(false);
				role.setDateCreation(currentDate);
				if(role.getEnabled() == null){
					role.setEnabled(true);
				}
				role.setCreatedBy(1L);
			}else{
				role.setDateUpdate(currentDate);
			}
			return role;
		}
		return obj;
	}*/

}
