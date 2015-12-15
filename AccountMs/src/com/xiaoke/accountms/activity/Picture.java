package com.xiaoke.accountms.activity;
//用来定义功能图标及说明文字的实体
public class Picture 
{
	private String title;
	
	private int imageId;
	public Picture()
	{
		super();
	}
	public Picture(String title,int imageId)
	{
		super();
		this.title=title;
		this.imageId=imageId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	
}
