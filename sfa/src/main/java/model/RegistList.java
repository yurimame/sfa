package model;

import java.io.Serializable;


public class RegistList implements Serializable {
	
	private int anken_id ;
	private String emp_no;
	private String name_kanji;

	public RegistList(String emp_no,String name_kanji) {
		this.emp_no = emp_no;
		this.name_kanji = name_kanji;
	}
	
	public RegistList(int anken_id,String emp_no,String name_kanji) {
		this.anken_id = anken_id;
		this.emp_no = emp_no;
		this.name_kanji = name_kanji;
	}

	public String getEmp_no() {
		return emp_no;
	}

	public String getName_kanji() {
		return name_kanji;
	}

	public int getAnken_id() {
		return anken_id;
	}
}
