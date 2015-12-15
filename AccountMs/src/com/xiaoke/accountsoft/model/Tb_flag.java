package com.xiaoke.accountsoft.model;


public class Tb_flag {
	private int _id;
	private String flag;

	public Tb_flag() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Tb_flag(int id,String flag)
	{
		super();
		this._id=id;
		this.flag=flag;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
}
