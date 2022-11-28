package model;

import java.io.Serializable;

public class FormData implements Serializable{

	private int anken_id;
	private String anken_name;
	private String styear;
	private String stmonth;
	private String stday;
	private String edyear;
	private String edmonth;
	private String edday;
	private String client_name;
	private int sales_place;
	private String sales_name;

	public FormData(int anken_id,String anken_name,String styear,String stmonth,String stday,
			String edyear,String edmonth,String edday,String client_name, int sales_place,String sales_name) {
		this.anken_id = anken_id;
		this.anken_name = anken_name;
		this.styear = styear;
		this.stmonth = stmonth;
		this.stday = stday;
		this.edyear = edyear;
		this.edmonth = edmonth;
		this.edday = edday;
		this.client_name = client_name;
		this.sales_place = sales_place;
		this.sales_name = sales_name;
	}
	public FormData(String anken_name,String styear,String stmonth,String stday,
			String edyear,String edmonth,String edday,String client_name, int sales_place,String sales_name) {
		this.anken_name = anken_name;
		this.styear = styear;
		this.stmonth = stmonth;
		this.stday = stday;
		this.edyear = edyear;
		this.edmonth = edmonth;
		this.edday = edday;
		this.client_name = client_name;
		this.sales_place = sales_place;
		this.sales_name = sales_name;
	}
	

	public String getAnken_name() {
		return anken_name;
	}

	public String getStyear() {
		return styear;
	}

	public String getStmonth() {
		return stmonth;
	}

	public String getStday() {
		return stday;
	}

	public String getEdyear() {
		return edyear;
	}

	public String getEdmonth() {
		return edmonth;
	}

	public String getEdday() {
		return edday;
	}

	public String getClient_name() {
		return client_name;
	}

	public int getSales_place() {
		return sales_place;
	}

	public String getSales_name() {
		return sales_name;
	}

	public int getAnken_id() {
		return anken_id;
	}


}