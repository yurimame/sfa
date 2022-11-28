package model;

import java.io.Serializable;

public class Anken implements Serializable {
	private int anken_id;
	private String anken_name;
	private String anken_startday;
	private String anken_endday;
	private String client_name;
	private int sales_place;
	private String sales_name;
	private int display_position;


	public Anken () { }

	public Anken(int anken_id, String anken_name, String anken_startday, String anken_endday,
			String client_name, int sales_place, String sales_name, int display_position) {
		this.anken_id = anken_id;
		this.anken_name = anken_name;
		this.anken_startday = anken_startday;
		this.anken_endday = anken_endday;
		this.client_name = client_name;
		this.sales_place = sales_place;
		this.sales_name = sales_name;
		this.display_position = display_position;
	}

	public Anken(String anken_name, String anken_startday, String anken_endday,
			String client_name, int sales_place, String sales_name) {
		this.anken_name = anken_name;
		this.anken_startday = anken_startday;
		this.anken_endday = anken_endday;
		this.client_name = client_name;
		this.sales_place = sales_place;
		this.sales_name = sales_name;

	}

	public int getAnken_id() {
		return anken_id;
	}

	public String getAnken_name() {
		return anken_name;
	}

	public String getAnken_startday() {
		return anken_startday;
	}

	public String getAnken_endday() {
		return anken_endday;
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

	public int getDisplay_position() {
		return display_position;
	}

	public void setAnken_id(int anken_id) {
		this.anken_id = anken_id;
	}

	public void setAnken_name(String anken_name) {
		this.anken_name = anken_name;
	}

	public void setAnken_startday(String anken_startday) {
		this.anken_startday = anken_startday;
	}

	public void setAnken_endday(String anken_endday) {
		this.anken_endday = anken_endday;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public void setSales_place(int sales_place) {
		this.sales_place = sales_place;
	}

	public void setSales_name(String sales_name) {
		this.sales_name = sales_name;
	}

	public void setDisplay_position(int display_position) {
		this.display_position = display_position;
	}


}