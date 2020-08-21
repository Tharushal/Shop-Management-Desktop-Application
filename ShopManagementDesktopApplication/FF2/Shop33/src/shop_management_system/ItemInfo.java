package shop_management_system;

import java.sql.Date;

public class ItemInfo {

    private String _cate;
    private String _name;
    private Date _date;
    
    public ItemInfo(String _cate,String _name,Date _date)
    {
    	this._cate=_cate;
    	this._name=_name;
    	this._date=_date;
    }
    public String Cate()
    {
    	return _cate;
    }
    public void Cate(String cate)
    {
    	_cate=cate;
    }
    public String Name()
    {
    	return _name;
    }
    public void Name(String name)
    {
    	_name=name;
    }
    public Date _Date()
    {
    	return _date;
    }
    public void Date(Date date)
    {
    	_date=date;
    }
}
