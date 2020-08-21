package shop_management_system;

import java.math.BigDecimal;

public class OrderInfo {

	private String _cate;
	private String _item;
	private BigDecimal _uprice;
	private int _quan;
	private BigDecimal _amount;
	
	public String Cate(){
		return _cate;
	}
	public void Cate(String _cate)
	{
		this._cate=_cate;
	}
	public String Item(){
		return _item;
	}
	public void Item(String _item)
	{
		this._item=_item;
	}
	public BigDecimal Uprice()
	{
		return _uprice;
	}
	public void Uprice(BigDecimal _uprice)
	{
		this._uprice = _uprice;
	}
	public int Quan()
	{
		return _quan;
	}
	public void Quan(int _quan)
	{
		this._quan=_quan;
	}
	public BigDecimal Amount()
	{
		return _amount;
	}
	public void Amount(BigDecimal _amount)
	{
		this._amount=_amount;
	}
	
	
}
