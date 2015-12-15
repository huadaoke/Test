package com.xiaoke.accountms.activity;

import java.util.ArrayList;
import com.xiaoke.accountms.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class pictureAdapter extends BaseAdapter {
	private ArrayList<Picture>pictures;
	private LayoutInflater inflater;
	public pictureAdapter(String[] titles,int[] images,Context context)
	{
		super();
		pictures=new ArrayList<Picture>();
		 inflater = LayoutInflater.from(context);
		for(int i=0;i<images.length;i++)
		{
			Picture picture=new Picture(titles[i],images[i]);
			pictures.add(picture);
		}
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(null!=pictures)
			return pictures.size();
		else
			return 0;
	}
	//获取泛型集合指定索引处的项
	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return pictures.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder;
		if(arg1==null)
		{
			arg1=inflater.inflate(R.layout.gvitem, null);
			viewHolder=new ViewHolder();
			viewHolder.title=(TextView)arg1.findViewById(R.id.ItemTitle);
			viewHolder.image=(ImageView)arg1.findViewById(R.id.ItemImage);
			arg1.setTag(viewHolder);
		}
		else
		{
			viewHolder=(ViewHolder)arg1.getTag();
		}
		viewHolder.title.setText(pictures.get(arg0).getTitle());
		viewHolder.image.setImageResource(pictures.get(arg0).getImageId());
		return arg1;
	}

}
