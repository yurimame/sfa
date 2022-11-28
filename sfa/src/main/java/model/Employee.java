package model;

import java.io.Serializable;

public class Employee implements Serializable {
	private int id;
	private String emp_no;
	private String name_kannji;
	private String standby_flg;  //不要だと思う。一応、残してる

	public Employee() { }

	public Employee(String emp_no,String name_kannji) {
		this.emp_no = emp_no;
		this.name_kannji = name_kannji;

	}



	public int getId() {
		return id;
	}

	public String getEmp_no() {
		return emp_no;
	}

	public String getName_kannji() {
		return name_kannji;
	}

	public String getStandby_flg() {
		return standby_flg;
	}

}