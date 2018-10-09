package com.Trade.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.Trade.Bean.Trade;
//import com.project2.bean.Athlete;
//import com.project2.bean.Athlete;
//import com.project2.bean.Athlete;
//import com.project2.dao.MyRowMapper;


@Repository("td")
public class Tradedao {	
@Autowired
JdbcTemplate jt;



	public int insertdata(Trade tt) {
		// TODO Auto-generated method stub
		int r = 0;
		try {
			
		r=jt.update("insert into TradeFinal1 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",tt.getCust_Id(),tt.getCust_FirstName(),tt.getCust_LastName(),tt.getCust_Mobile_Number(),tt.getTrader_Id(),tt.getTrader_FirstName(),tt.getTrader_LastName(),tt.getTrader_Contact(),tt.getTrade_Type(),tt.getTrade_Date(),tt.getTrademod_Timestamp(),
				tt.getTradeUniqueId(),tt.getTransaction_Id(),tt.getTransaction_Type(),tt.getBuy_Sell(),tt.getSettlement_Id(),tt.getSettlement_Date(),tt.getSettlement_Timestamp(),tt.getOrder_Id(),tt.getOrder_Timestamp(),tt.getQuantity(),tt.getStatus(),tt.getCancel_Date(),tt.getCancel_Time(),tt.getBID(),tt.getASK(),tt.getLTP(),tt.getCountry(),tt.getCurrency(),tt.getExchange(),tt.getSector_Id(),tt.getISIN_Code(),tt.getLocation_Id());
		
		if(tt.getTrade_Type()==1)
		{
			int r1=jt.update("insert into Bond values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",tt.getCust_Id(),tt.getCust_FirstName(),tt.getCust_LastName(),tt.getCust_Mobile_Number(),tt.getTrader_Id(),tt.getTrader_FirstName(),tt.getTrader_LastName(),tt.getTrader_Contact(),tt.getTrade_Type(),tt.getTrade_Date(),tt.getTrademod_Timestamp(),
					tt.getTradeUniqueId(),tt.getTransaction_Id(),tt.getTransaction_Type(),tt.getBuy_Sell(),tt.getSettlement_Id(),tt.getSettlement_Date(),tt.getSettlement_Timestamp(),tt.getOrder_Id(),tt.getOrder_Timestamp(),tt.getQuantity(),tt.getStatus(),tt.getCancel_Date(),tt.getCancel_Time(),tt.getBID(),tt.getASK(),tt.getLTP(),tt.getCountry(),tt.getCurrency(),tt.getExchange(),tt.getSector_Id(),tt.getISIN_Code(),tt.getLocation_Id());
		}
		else
		{
			int r2=jt.update("insert into Repo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",tt.getCust_Id(),tt.getCust_FirstName(),tt.getCust_LastName(),tt.getCust_Mobile_Number(),tt.getTrader_Id(),tt.getTrader_FirstName(),tt.getTrader_LastName(),tt.getTrader_Contact(),tt.getTrade_Type(),tt.getTrade_Date(),tt.getTrademod_Timestamp(),
					tt.getTradeUniqueId(),tt.getTransaction_Id(),tt.getTransaction_Type(),tt.getBuy_Sell(),tt.getSettlement_Id(),tt.getSettlement_Date(),tt.getSettlement_Timestamp(),tt.getOrder_Id(),tt.getOrder_Timestamp(),tt.getQuantity(),tt.getStatus(),tt.getCancel_Date(),tt.getCancel_Time(),tt.getBID(),tt.getASK(),tt.getLTP(),tt.getCountry(),tt.getCurrency(),tt.getExchange(),tt.getSector_Id(),tt.getISIN_Code(),tt.getLocation_Id());
		}}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		return r;
		}
	
	
	
	public List<Trade> getTradeInfoDao()
	{
		return jt.query("select * from TradeFinal1", new MyRowMapper());
	}
	
	public List<Trade> getBondDaoInfo()
	{
		return jt.query("select * from Bond", new MyRowMapper());
	}
	
	public List<Trade> getRepoDaoInfo()
	{
		return jt.query("select * from Repo", new MyRowMapper());
	}
	
	public int checkCustInfoDao(Trade tt)
	{
		
		return jt.queryForObject("select count(*) from TradeFinal1 where CUST_FIRSTNAME like ? and CUST_LASTNAME like ?",new Object[] {tt.getUsername(),tt.getPassword()},Integer.class);
	}
	
	public String checkLoginType(String un,String pw)
	{
		int check=0;
		check=jt.queryForObject("select count(*) from login2 where username= ? and password=?",new Object[] {un,pw},Integer.class);
		String role="";
		if(check==1) {
			role= jt.queryForObject("select role from login2 where username= ? and password=?",new Object[] {un,pw},String.class);
			
		}
		else if(check<1) {
			role="no";
		
		
		
			
		}
		return role;
	}
	
	
	public int checkTraderInfoDaoById(long id)
	{
		
		return jt.queryForObject("select count(*) from TradeFinal1 where Trader_Id = ?",new Object[] {id},Integer.class);
	}
	
	public int checkTraderInfoDao(Trade tt)
	{
		
		return jt.queryForObject("select count(*) from TradeFinal1 where TRADER_FIRSTNAME like ? and TRADER_LASTNAME like ?",new Object[] {tt.getUsername(),tt.getPassword()},Integer.class);
	}
	
	
	public int checkOneUserDao(String uname,String pass)
	{
		System.out.println(uname);
		System.out.println(pass);
		return jt.queryForObject("select count(*) from TradeFinal1 where Cust_Firstname like ? and Cust_Lastname like ?", new Object[] {uname,pass},Integer.class);
	}
	
	public List<Trade> getOneLoginInfo(String username)
	{
		return jt.query("select * from TradeFinal1 where Cust_Firstname = ?",new Object[] {username} ,new MyRowMapper());}
	
	public List<Trade> getOneLoginInfoById(int id)
	{
		return jt.query("select * from TradeFinal1 where Cust_Id = ?",new Object[] {id} ,new MyRowMapper());}
	
	public List<Trade> getOneLoginInfoByTId(long id)
	{
		return jt.query("select * from TradeFinal1 where Trader_Id = ?",new Object[] {id} ,new MyRowMapper());}
	
	
	
	
	public int checkCustInfoDaoById(int id)
	{
		return jt.queryForObject("select count(*) from TradeFinal1 where Cust_Id = ?",new Object[] {id},Integer.class);
	}
	public int getid(String un,String pw)
	{
		return jt.queryForObject("select Cust_Id from TradeFinal1 where Cust_Firstname like ? and Cust_Lastname like ?",new Object[] {un,pw},Integer.class);
	}
	
	public int gettid(String un)
	{
		return jt.queryForObject("select Trader_Id from TradeFinal1 where Trader_Firstname like ?",new Object[] {un},Integer.class);
	}
	
	public int updateCustDaoByFName(String name,int id)
	{
		String sql = "SELECT trade_type FROM TRADEFINAL1 WHERE cust_id= ?";
		
		int  trade= jt.queryForObject(sql,new Object[] {id},Integer.class);
		if(trade==1) {
			
		int res1=jt.update("update Bond set Cust_Firstname=? where cust_id=?", name,id);
		 }
		else
		{
			int res1=jt.update("update Repo set Cust_Firstname=? where cust_id=?",name, id);
		}
		int res=jt.update("update TradeFinal1 set Cust_Firstname=? where Cust_Id=?",name,id);
	
		String sql1 = "SELECT Cust_Lastname FROM TRADEFINAL1 WHERE cust_id= ? and Cust_Firstname=?";
		
		String  last= jt.queryForObject(sql1,new Object[] {id,name},String.class);
		jt.update("update login2 set username=? where password=?",name,last);
		//jt.update("delete from login2 where username=? and password=?",str2,str3);
		//return jt.update("update TradeFinal1 set Cust_Firstname=? where Cust_Id=?",name,id);
		return res;
	}
	
	public int updateCustDaoByLName(String name,int id)
	{
		
		String sql = "SELECT trade_type FROM TRADEFINAL1 WHERE cust_id= ?";
		
		int  trade= jt.queryForObject(sql,new Object[] {id},Integer.class);
		if(trade==1) {
			
		int res1=jt.update("update Bond set Cust_Lastname=? where cust_id=?", name,id);
		 }
		else
		{
			int res1=jt.update("update Repo set Cust_Lastname=? where cust_id=?",name, id);
		}
		int res=jt.update("update TradeFinal1 set Cust_Lastname=? where Cust_Id=?",name,id);	
		String sql1 = "SELECT Cust_Firstname FROM TRADEFINAL1 WHERE cust_id= ? and Cust_Lastname=?";
		
		String  first= jt.queryForObject(sql1,new Object[] {id,name},String.class);
		jt.update("update login2 set password=? where username=?",name,first);
		//jt.update("delete from login2 where username=? and password=?",str2,str3);
		//return jt.update("update TradeFinal1 set Cust_Firstname=? where Cust_Id=?",name,id);
		return res;
	}
	
	public int updateCustDaoByMobile(String mobile,int id)
	{
		String sql = "SELECT trade_type FROM TRADEFINAL1 WHERE cust_id= ?";
		
		int  trade= jt.queryForObject(sql,new Object[] {id},Integer.class);
		if(trade==1) {
			
		int res1=jt.update("update Bond set Cust_mobile_number=? where cust_id=?", mobile,id);
		 }
		else
		{
			int res1=jt.update("update Repo set Cust_mobile_number=? where cust_id=?",mobile, id);
		}
		
		return jt.update("update TradeFinal1 set Cust_mobile_number=? where Cust_Id=?",mobile,id);
	}
	
	
	public int updateTraderDaoByFName(String name,long id)
	{
		String sql = "SELECT trade_type FROM TRADEFINAL1 WHERE Trader_id= ?";
		
		int  trade= jt.queryForObject(sql,new Object[] {id},Integer.class);
		if(trade==1) {
			
		int res1=jt.update("update Bond set Trader_Firstname=? where Trader_id=?", name,id);
		 }
		else
		{
			int res1=jt.update("update Repo set Trader_Firstname=? where Trader_id=?",name, id);
		}
		int res= jt.update("update TradeFinal1 set Trader_Firstname=? where Trader_Id=?",name,id);
		String sql1 = "SELECT Trader_Lastname FROM TRADEFINAL1 WHERE Trader_Id= ? and Trader_Firstname=?";
		
		String  last= jt.queryForObject(sql1,new Object[] {id,name},String.class);
		jt.update("update login2 set username=? where password=?",name,last);
		//jt.update("delete from login2 where username=? and password=?",str2,str3);
		//return jt.update("update TradeFinal1 set Cust_Firstname=? where Cust_Id=?",name,id);
		return res;
	}
	
	public int updateTraderDaoByLName(String name,long id)
	{
		String sql = "SELECT trade_type FROM TRADEFINAL1 WHERE Trader_id= ?";
		
		int  trade= jt.queryForObject(sql,new Object[] {id},Integer.class);
		if(trade==1) {
			
		int res1=jt.update("update Bond set Trader_Lastname=? where Trader_id=?", name,id);
		 }
		else
		{
			int res1=jt.update("update Repo set Trader_Lastname=? where Trader_id=?",name, id);
		}
		int res=jt.update("update TradeFinal1 set Trader_Lastname=? where Trader_Id=?",name,id);
		String sql1 = "SELECT Trader_Firstname FROM TRADEFINAL1 WHERE Trader_Id= ? and Trader_Lastname=?";
		
		String  first= jt.queryForObject(sql1,new Object[] {id,name},String.class);
		jt.update("update login2 set password=? where username=?",name,first);
		//jt.update("delete from login2 where username=? and password=?",str2,str3);
		//return jt.update("update TradeFinal1 set Cust_Firstname=? where Cust_Id=?",name,id);
		return res;
	}
	
	public int updateTraderDaoByMobile(String mobile,long id)
	{
		String sql = "SELECT trade_type FROM TRADEFINAL1 WHERE Trader_id= ?";
		
		int  trade= jt.queryForObject(sql,new Object[] {id},Integer.class);
		if(trade==1) {
			
		int res1=jt.update("update Bond set Trader_contact=? where Trader_id=?", mobile,id);
		 }
		else
		{
			int res1=jt.update("update Repo set Trader_contact=? where Trader_id=?",mobile, id);
		}
		return jt.update("update TradeFinal1 set Trader_contact=? where Trader_Id=?",mobile,id);
	}
	
	
	public Trade getbycustid(int cid) {
		String sql = "SELECT * FROM TRADEFINAL1 WHERE CUST_ID = ?";
		
		Trade  trade= jt.queryForObject(sql, new Object[] { cid }, new MyRowMapper());
		System.out.println(trade);
			
		return trade;
		}
	
	public Trade getbytradeid(int tid) {
		String sql = "SELECT * FROM TRADEFINAL1 WHERE tradeuniqueid = ?";
		
		Trade  trade= jt.queryForObject(sql, new Object[] { tid }, new MyRowMapper());
		System.out.println(trade);
			
		return trade;
		}
	
	public Trade getbytraderid(long l) {
		String sql = "SELECT * FROM TRADEFINAL1 WHERE TRADER_ID= ?";
		
		Trade  trade= jt.queryForObject(sql, new Object[] { l }, new MyRowMapper());
		System.out.println(trade);
			
		return trade;
		}
	public int delcustomer(int cid) {
		//System.out.println("in delete");
	
		String sql = "SELECT trade_type FROM TRADEFINAL1 WHERE cust_id= ?";
		
		int  trade= jt.queryForObject(sql,new Object[] {cid},Integer.class);
		if(trade==1) {
			
		int res1=jt.update("delete from Bond where cust_id=?", cid);
		 }
		else
		{
			int res1=jt.update("delete from Repo where cust_id=?", cid);
		}
		String sql1 = "SELECT Cust_Firstname FROM TRADEFINAL1 WHERE cust_id= ?";
		
		String str= jt.queryForObject(sql1,new Object[] {cid},String.class);
		String sql2 = "SELECT Cust_Lastname FROM TRADEFINAL1 WHERE cust_id= ?";
		
		String str1= jt.queryForObject(sql2,new Object[] {cid},String.class);
		String sql3 = "SELECT Trader_Firstname FROM TRADEFINAL1 WHERE cust_id= ?";
		
		String str2= jt.queryForObject(sql3,new Object[] {cid},String.class);
		String sql4 = "SELECT Trader_Lastname FROM TRADEFINAL1 WHERE cust_id= ?";
		
		String str3= jt.queryForObject(sql4,new Object[] {cid},String.class);
	
	
		jt.update("delete from login2 where username=? and password=?",str,str1);
		jt.update("delete from login2 where username=? and password=?",str2,str3);
		 int res=jt.update("delete from tradefinal1 where cust_id=?", cid);
	 return res;
		
	}
	
	public int deltrade(int tid) {
		//System.out.println("in delete");

		 String sql = "SELECT trade_type FROM TRADEFINAL1 WHERE tradeuniqueid= ?";
			
			int  trade= jt.queryForObject(sql,new Object[] {tid},Integer.class);
			if(trade==1) {
				
			int res1=jt.update("delete from Bond where tradeuniqueid=?", tid);
			 }
			else
			{
				int res1=jt.update("delete from Repo where tradeuniqueid=?", tid);
			}
			String sql1 = "SELECT Cust_Firstname FROM TRADEFINAL1 WHERE tradeuniqueid= ?";
			
			String str= jt.queryForObject(sql1,new Object[] {tid},String.class);
			String sql2 = "SELECT Cust_Lastname FROM TRADEFINAL1 WHERE tradeuniqueid= ?";
			
			String str1= jt.queryForObject(sql2,new Object[] {tid},String.class);
			String sql3 = "SELECT Trader_Firstname FROM TRADEFINAL1 WHERE tradeuniqueid= ?";
			
			String str2= jt.queryForObject(sql3,new Object[] {tid},String.class);
			String sql4 = "SELECT Trader_Lastname FROM TRADEFINAL1 WHERE traderuniqueid= ?";
			
			String str3= jt.queryForObject(sql4,new Object[] {tid},String.class);
		
			jt.update("delete from login2 where username=? and password=?",str,str1);
			jt.update("delete from login2 where username=? and password=?",str2,str3);
	 int res=jt.update("delete from tradefinal1 where tradeuniqueid=?", tid);
	 return res;
		
	}
	
	public int deltrader(long l) {
		//System.out.println("in delete");

		 String sql = "SELECT trade_type FROM TRADEFINAL1 WHERE trader_id= ?";
			
			int  trade= jt.queryForObject(sql,new Object[] {l},Integer.class);
			if(trade==1) {
				
			int res1=jt.update("delete from Bond where trader_id=?", l);
			 }
			else
			{
				int res1=jt.update("delete from Repo where trader_id=?", l);
			}
			String sql1 = "SELECT Trader_Firstname FROM TRADEFINAL1 WHERE trader_id= ?";
			
			String str= jt.queryForObject(sql1,new Object[] {l},String.class);
			String sql2 = "SELECT Trader_Lastname FROM TRADEFINAL1 WHERE trader_id= ?";
			
			String str1= jt.queryForObject(sql2,new Object[] {l},String.class);
			String sql3 = "SELECT Cust_Firstname FROM TRADEFINAL1 WHERE trader_id= ?";
			
			String str2= jt.queryForObject(sql3,new Object[] {l},String.class);
			String sql4 = "SELECT Cust_Lastname FROM TRADEFINAL1 WHERE trader_id= ?";
			
			String str3= jt.queryForObject(sql4,new Object[] {l},String.class);
		
			jt.update("delete from login2 where username=? and password=?",str,str1);
			jt.update("delete from login2 where username=? and password=?",str2,str3);
	 int res=jt.update("delete from tradefinal1 where TRADER_ID=?", l);
	 return res;
		
	}
	
	public int updateTradeTypeDao(int Trade_Type,long id,Trade tt)
	{
		//System.out.println("tt:"+tt.getCancel_Time());
		//System.out.println("tt:"+tt.getCust_FirstName());
		//int res=jt.update("update TradeFinal1 set Trade_Type=? where Cust_Id=?",Trade_Type,id);
		String sql = "SELECT trade_type FROM TRADEFINAL1 WHERE 	Cust_Id= ?";
		
		int  trade= jt.queryForObject(sql,new Object[] {id},Integer.class);
		int res=jt.update("update TradeFinal1 set Trade_Type=? where Cust_Id=?",Trade_Type,id);
		if(trade==1 && Trade_Type==2) {
			System.out.println("going in bond");
			//System.out.println("tt:"+tt.getCancel_Time());
			//System.out.println("tt:"+tt.getCust_FirstName());
			//jt.update("INSERT INTO Repo(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) from SELECT * FROM TradeFinal1 FULL JOIN Repo ON Repo.trade_type = TradeFinal1.trade_type WHERE TradeFinal1.trade_type==2");
			//int r1=jt.update("insert into Repo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",tt.getCust_Id(),tt.getCust_FirstName(),tt.getCust_LastName(),tt.getCust_Mobile_Number(),tt.getTrader_Id(),tt.getTrader_FirstName(),tt.getTrader_LastName(),tt.getTrader_Contact(),tt.getTrade_Type(),tt.getTrade_Date(),tt.getTrademod_Timestamp(),
				//tt.getTradeUniqueId(),tt.getTransaction_Id(),tt.getTransaction_Type(),tt.getBuy_Sell(),tt.getSettlement_Id(),tt.getSettlement_Date(),tt.getSettlement_Timestamp(),tt.getOrder_Id(),tt.getOrder_Timestamp(),tt.getQuantity(),tt.getStatus(),tt.getCancel_Date(),tt.getCancel_Time(),tt.getBID(),tt.getASK(),tt.getLTP(),tt.getCountry(),tt.getCurrency(),tt.getExchange(),tt.getSector_Id(),tt.getISIN_Code(),tt.getLocation_Id());
		    int r1=jt.update("INSERT INTO REPO (Cust_Id,Cust_FirstName,Cust_LastName,Cust_Mobile_Number,Trader_Id,Trader_FirstName,Trader_LastName,Trader_Contact,TradeUniqueId, Trade_Type,Trade_Date,Trademod_Timestamp,Transaction_Id,Transaction_Type,Buy_Sell,Settlement_Id,Settlement_Date,Settlement_Timestamp,Order_Id,Order_Timestamp,Quantity,Status,Cancel_Date,Cancel_Time, BID,ASK,LTP, Country,Currency,Exchange,Sector_Id, ISIN_Code,Location_Id) SELECT Cust_Id,Cust_FirstName,Cust_LastName,Cust_Mobile_Number,Trader_Id,Trader_FirstName,Trader_LastName,Trader_Contact,TradeUniqueId, Trade_Type,Trade_Date,Trademod_Timestamp,Transaction_Id,Transaction_Type,Buy_Sell,Settlement_Id,Settlement_Date,Settlement_Timestamp,Order_Id,Order_Timestamp,Quantity,Status,Cancel_Date,Cancel_Time, BID,ASK,LTP, Country,Currency,Exchange,Sector_Id, ISIN_Code,Location_Id FROM TradeFinal1  WHERE TradeFinal1.trade_type =2 and Cust_Id="+id); 
			
			jt.update("delete from Bond where Cust_Id=?",id);
		 }
		else if(trade==2 && Trade_Type==1)
		{
			System.out.println("going in repo");
			//System.out.println("tt:"+tt.getCancel_Time());
			//System.out.println("tt:"+tt.getCust_FirstName());
			//int r1=jt.update("insert into Bond values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",tt.getCust_Id(),tt.getCust_FirstName(),tt.getCust_LastName(),tt.getCust_Mobile_Number(),tt.getTrader_Id(),tt.getTrader_FirstName(),tt.getTrader_LastName(),tt.getTrader_Contact(),tt.getTrade_Type(),tt.getTrade_Date(),tt.getTrademod_Timestamp(),
				//	tt.getTradeUniqueId(),tt.getTransaction_Id(),tt.getTransaction_Type(),tt.getBuy_Sell(),tt.getSettlement_Id(),tt.getSettlement_Date(),tt.getSettlement_Timestamp(),tt.getOrder_Id(),tt.getOrder_Timestamp(),tt.getQuantity(),tt.getStatus(),tt.getCancel_Date(),tt.getCancel_Time(),tt.getBID(),tt.getASK(),tt.getLTP(),tt.getCountry(),tt.getCurrency(),tt.getExchange(),tt.getSector_Id(),tt.getISIN_Code(),tt.getLocation_Id());
			
			int r1=jt.update("INSERT INTO BOND (Cust_Id,Cust_FirstName,Cust_LastName,Cust_Mobile_Number,Trader_Id,Trader_FirstName,Trader_LastName,Trader_Contact,TradeUniqueId, Trade_Type,Trade_Date,Trademod_Timestamp,Transaction_Id,Transaction_Type,Buy_Sell,Settlement_Id,Settlement_Date,Settlement_Timestamp,Order_Id,Order_Timestamp,Quantity,Status,Cancel_Date,Cancel_Time, BID,ASK,LTP, Country,Currency,Exchange,Sector_Id, ISIN_Code,Location_Id) SELECT Cust_Id,Cust_FirstName,Cust_LastName,Cust_Mobile_Number,Trader_Id,Trader_FirstName,Trader_LastName,Trader_Contact,TradeUniqueId, Trade_Type,Trade_Date,Trademod_Timestamp,Transaction_Id,Transaction_Type,Buy_Sell,Settlement_Id,Settlement_Date,Settlement_Timestamp,Order_Id,Order_Timestamp,Quantity,Status,Cancel_Date,Cancel_Time, BID,ASK,LTP, Country,Currency,Exchange,Sector_Id, ISIN_Code,Location_Id FROM TradeFinal1  WHERE TradeFinal1.trade_type =1 and Cust_Id="+id); 
			jt.update("delete from Repo where Cust_Id=?",id);
		}
		
		return res;
	}

	public int updateTransTypeDao(int Transaction_Type,long id)
	{
		String sql = "SELECT trade_type FROM TRADEFINAL1 WHERE Cust_Id= ?";
		
		int  trade= jt.queryForObject(sql,new Object[] {id},Integer.class);
		if(trade==1) {
			
		int res1=jt.update("update Bond set Transaction_Type=? where Cust_Id=?", Transaction_Type,id);
		 }
		else
		{
			int res1=jt.update("update Repo set Transaction_Type=? where Cust_Id=?",Transaction_Type, id);
		}
	return  jt.update("update TradeFinal1 set Transaction_Type=? where Cust_Id=?",Transaction_Type,id);
	
	}
	public int updateStatusDao(int Status,long id)
	{
		String sql = "SELECT trade_type FROM TRADEFINAL1 WHERE Cust_Id= ?";
		
		int  trade= jt.queryForObject(sql,new Object[] {id},Integer.class);
		if(trade==1) {
			
		int res1=jt.update("update Bond set Status=? where Cust_Id=?", Status,id);
		 }
		else
		{
			int res1=jt.update("update Repo set Status=? where Cust_Id=?",Status, id);
		}
		return jt.update("update TradeFinal1 set Status=? where Cust_Id=?",Status,id);
	}
	public int updateSectorIdDao(int Sector_Id,long id)
	{
		String sql = "SELECT trade_type FROM TRADEFINAL1 WHERE Cust_Id= ?";
		
		int  trade= jt.queryForObject(sql,new Object[] {id},Integer.class);
		if(trade==1) {
			
		int res1=jt.update("update Bond set Sector_Id=? where Cust_Id=?", Sector_Id,id);
		 }
		else
		{
			int res1=jt.update("update Repo set Sector_Id=? where Cust_Id=?",Sector_Id, id);
		}
		return jt.update("update TradeFinal1 set Sector_Id=? where Cust_Id=?",Sector_Id,id);
	}
	
	public int updateQuantityDao(int Quantity,long id)
	{
		String sql = "SELECT trade_type FROM TRADEFINAL1 WHERE Cust_Id= ?";
		
		int  trade= jt.queryForObject(sql,new Object[] {id},Integer.class);
		if(trade==1) {
			
		int res1=jt.update("update Bond set Quantity=? where Cust_Id=?", Quantity,id);
		 }
		else
		{
			int res1=jt.update("update Repo set Quantity=? where Cust_Id=?",Quantity, id);
		}
		return jt.update("update TradeFinal1 set Quantity=? where Cust_Id=?",Quantity,id);
	}
	public int updateLocationIdDao(int Location_Id,long id)
	{
		String sql = "SELECT trade_type FROM TRADEFINAL1 WHERE Cust_Id= ?";
		
		int  trade= jt.queryForObject(sql,new Object[] {id},Integer.class);
		if(trade==1) {
			
		int res1=jt.update("update Bond set Location_Id=? where Cust_Id=?",Location_Id,id);
		 }
		else
		{
			int res1=jt.update("update Repo set Location_Id=? where Cust_Id=?",Location_Id, id);
		}
		return jt.update("update TradeFinal1 set Location_Id=? where Cust_Id=?",Location_Id,id);
	}
	public int updateExchangeDao(int Exchange,long id)
	{
		String sql = "SELECT trade_type FROM TRADEFINAL1 WHERE Cust_Id= ?";
		
		int  trade= jt.queryForObject(sql,new Object[] {id},Integer.class);
		if(trade==1) {
			
		int res1=jt.update("update Bond set Exchange=? where Cust_Id=?",Exchange,id);
		 }
		else
		{
			int res1=jt.update("update Repo set Exchange=? where Cust_Id=?",Exchange, id);
		}
		return jt.update("update TradeFinal1 set Exchange=? where Cust_Id=?",Exchange,id);
	}
	
	public int updateCurrencyDao(int Currency,long id)
	{
		String sql = "SELECT trade_type FROM TRADEFINAL1 WHERE Cust_Id= ?";
		
		int  trade= jt.queryForObject(sql,new Object[] {id},Integer.class);
		if(trade==1) {
			
		int res1=jt.update("update Bond set Currency=? where Cust_Id=?", Currency,id);
		 }
		else
		{
			int res1=jt.update("update Repo set Currency=? where Cust_Id=?",Currency, id);
		}
		return jt.update("update TradeFinal1 set Currency=? where Cust_Id=?",Currency,id);
	}
	
	public int updateCountryDao(int Country,long id)
	{
		String sql = "SELECT trade_type FROM TRADEFINAL1 WHERE Cust_Id= ?";
		
		int  trade= jt.queryForObject(sql,new Object[] {id},Integer.class);
		if(trade==1) {
			
		int res1=jt.update("update Bond set Country=? where Cust_Id=?", Country,id);
		 }
		else
		{
			int res1=jt.update("update Repo set Country=? where Cust_Id=?",Country, id);
		}
		return jt.update("update TradeFinal1 set Country=? where Cust_Id=?",Country,id);
	}
	
	public int updateBuySellDao(int Buy_Sell,long id)
	{
		String sql = "SELECT trade_type FROM TRADEFINAL1 WHERE Cust_Id= ?";
		
		int  trade= jt.queryForObject(sql,new Object[] {id},Integer.class);
		if(trade==1) {
			
		int res1=jt.update("update Bond set Buy_Sell=? where Cust_Id=?", Buy_Sell,id);
		 }
		else
		{
			int res1=jt.update("update Repo set Buy_Sell=? where Cust_Id=?",Buy_Sell, id);
		}
		return jt.update("update TradeFinal1 set Buy_Sell=? where Cust_Id=?",Buy_Sell,id);
	}
	public int updateIsinCodeDao(int ISIN_Code,long id)
	{
		String sql = "SELECT trade_type FROM TRADEFINAL1 WHERE Cust_Id= ?";
		
		int  trade= jt.queryForObject(sql,new Object[] {id},Integer.class);
		if(trade==1) {
			
		int res1=jt.update("update Bond set ISIN_Code=? where Cust_Id=?",ISIN_Code,id);
		 }
		else
		{
			int res1=jt.update("update Repo set ISIN_Code=? where Cust_Id=?",ISIN_Code, id);
		}
		return jt.update("update TradeFinal1 set ISIN_Code=? where Cust_Id=?",ISIN_Code,id);
	}
	  public List<Trade> getBondInfoDao()
	    {
	        return jt.query("select * from Bond ", new MyRowMapper());
	    }
	    public List<Trade> getRepoInfoDao()
	    {
	        return jt.query("select * from Repo ", new MyRowMapper());
	    }


}

class MyRowMapper implements RowMapper<Trade>
{

	@Override
	public Trade mapRow(ResultSet arg0, int arg1) throws SQLException {
		Trade tt=new Trade();
		tt.setCust_Id(arg0.getInt(1));
        tt.setCust_FirstName(arg0.getString(2));
        tt.setCust_LastName(arg0.getString(3));
        tt.setCust_Mobile_Number(arg0.getLong(4));
        
        
        tt.setTrader_Id(arg0.getLong(5));
        tt.setTrader_FirstName(arg0.getString(6));
        tt.setTrader_LastName(arg0.getString(7));
        tt.setTrader_Contact(arg0.getLong(8));
       
        
        tt.setTrade_Type(arg0.getInt(9));
        tt.setTrade_Date(arg0.getString(10));
        tt.setTrademod_Timestamp(arg0.getString(11));
        tt.setTradeUniqueId(arg0.getInt(12));
       
        
        tt.setTransaction_Id(arg0.getLong(13));
        tt.setTransaction_Type(arg0.getInt(14));
        tt.setBuy_Sell(arg0.getInt(15));
        tt.setSettlement_Id(arg0.getLong(16));
        tt.setSettlement_Date(arg0.getString(17));
        tt.setSettlement_Timestamp(arg0.getString(18));
        tt.setOrder_Id(arg0.getInt(19));
        tt.setOrder_Timestamp(arg0.getString(20));
        tt.setQuantity(arg0.getLong(21));
        tt.setStatus(arg0.getInt(22));
       
        tt.setCancel_Date(arg0.getString(23));
        tt.setCancel_Time(arg0.getString(24));
        tt.setBID(arg0.getDouble(25));
        tt.setASK(arg0.getDouble(26));
        tt.setLTP(arg0.getDouble(27));
        
        tt.setCountry(arg0.getInt(28));
        tt.setCurrency(arg0.getInt(29));
        tt.setExchange(arg0.getInt(30));
        tt.setSector_Id(arg0.getInt(31));
        tt.setISIN_Code(arg0.getInt(32));
        tt.setLocation_Id(arg0.getLong(33));
        
		
		
		return tt;
	}
	
}

