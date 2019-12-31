package model.dto;

import java.sql.Date;

public class Employee {
	private String emp_id;
	private String emp_name;
	private String emp_no;
	private String email;
	private String phone;
	private Date hire_date;
	private String job_id;
	private int salary;
	private int bonus_pct;
	private String marriage;
	private String mgr_id;
	private String dept_id;
	
	public Employee() {}

	public Employee(String emp_id, String emp_name, String emp_no, String email, String phone, Date hire_date,
			String job_id, int salary, int bonus_pct, String marriage, String mgr_id, String dept_id) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_no = emp_no;
		this.email = email;
		this.phone = phone;
		this.hire_date = hire_date;
		this.job_id = job_id;
		this.salary = salary;
		this.bonus_pct = bonus_pct;
		this.marriage = marriage;
		this.mgr_id = mgr_id;
		this.dept_id = dept_id;
	}

	public Employee(String emp_id, String emp_name, String emp_no, String email, String phone, String job_id,
			int salary, int bonus_pct, String marriage, String mgr_id, String dept_id) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_no = emp_no;
		this.email = email;
		this.phone = phone;
		this.job_id = job_id;
		this.salary = salary;
		this.bonus_pct = bonus_pct;
		this.marriage = marriage;
		this.mgr_id = mgr_id;
		this.dept_id = dept_id;
	}

	public Employee(String emp_id, String job_id, int salary, int bonus_pct, String dept_id) {
		super();
		this.emp_id = emp_id;
		this.job_id = job_id;
		this.salary = salary;
		this.bonus_pct = bonus_pct;
		this.dept_id = dept_id;
	}

	public Employee(String job_id, int salary, int bonus_pct, String dept_id) {
		super();
		this.job_id = job_id;
		this.salary = salary;
		this.bonus_pct = bonus_pct;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getBonus_pct() {
		return bonus_pct;
	}

	public void setBonus_pct(int bonus_pct) {
		this.bonus_pct = bonus_pct;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getMgr_id() {
		return mgr_id;
	}

	public void setMgr_id(String mgr_id) {
		this.mgr_id = mgr_id;
	}

	public String getDept_id() {
		return dept_id;
	}

	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_no=" + emp_no + ", email=" + email
				+ ", phone=" + phone + ", hire_date=" + hire_date + ", job_id=" + job_id + ", salary=" + salary
				+ ", bonus_pct=" + bonus_pct + ", marriage=" + marriage + ", mgr_id=" + mgr_id + ", dept_id=" + dept_id
				+ "]";
	}
	
	
	
	
	
	/*
	EMP_ID	CHAR(3 BYTE)
	EMP_NAME	VARCHAR2(20 BYTE)
	EMP_NO	CHAR(14 BYTE)
	EMAIL	VARCHAR2(25 BYTE)
	PHONE	VARCHAR2(12 BYTE)
	HIRE_DATE	DATE
	JOB_ID	CHAR(2 BYTE)
	SALARY	NUMBER
	BONUS_PCT	NUMBER
	MARRIAGE	CHAR(1 BYTE)
	MGR_ID	CHAR(3 BYTE)
	DEPT_ID	CHAR(2 BYTE)
	*/
}
