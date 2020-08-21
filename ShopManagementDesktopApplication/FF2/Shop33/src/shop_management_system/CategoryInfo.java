package shop_management_system;

import java.sql.Date;

public class CategoryInfo {

	private int _id;
	private String _name;
	private Date _date;
	
	public int Id()
	{
		return _id;
	}
	public void Id(int _id)
	{
		this._id=_id;
	}
	public String Name()
	{
		return _name;
	}
	public void Name(String _name)
	{
		this._name=_name;
	}
	public Date _Date()
	{
		return _date;
	}
	public void _Date(Date _date)
	{
		this._date=_date;
	}
	

}
