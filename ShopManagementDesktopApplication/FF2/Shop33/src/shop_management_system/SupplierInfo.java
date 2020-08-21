package shop_management_system;

import java.sql.Date;

public class SupplierInfo {
        private String _nic;
         private String _name;
         private String _mail;
         private String _pnum;
         private Date _date;
         private String _saddr;
         
         public SupplierInfo(String _nic,String _name,String _mail,String _pnum,Date _date,String _saddr)
         {
        	 this._nic=_nic;
        	 this._name=_name;
        	 this._mail=_mail;
        	 this._pnum=_pnum;
        	 this._date=_date;
        	 this._saddr=_saddr;
         }
         public String NIC()
         {
        	 return _nic;
         }
         public void NIC(String nic)
         {
        	 _nic=nic;
         }
         public String Name()
         {
        	 return _name;
         }
         public void Name(String name)
         {
        	 _nic=name;
         }
         public String Mail()
         {
        	 return _mail;
         }
         public void Mail(String mail)
         {
        	 _mail=mail;
         }
         public String Pnum()
         {
        	 return _pnum;
         }
         public void Pnum(String pnum)
         {
        	 _pnum=pnum;
         }
         public Date _Date()
         {
        	 return _date;
         }
         public void _Date(Date date)
         {
        	 _date =date;
         }
         public String Saddress()
         {
        	 return _saddr;
         }
         public void Saddress(String addr)
         {
        	 _saddr = addr;
         }
}

