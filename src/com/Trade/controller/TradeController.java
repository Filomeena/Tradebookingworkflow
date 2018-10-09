package com.Trade.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import com.Trade.bean;
import com.Trade.Bean.Trade;
import com.Trade.dao.Tradedao;
import com.Trade.service.TradeService;



@Controller
public class TradeController {
	@Autowired
	Tradedao td;
	@RequestMapping(value="check",method=RequestMethod.POST)
	public ModelAndView checkUser(HttpServletRequest req, Trade tt) {
		String un=req.getParameter("name");
		String pw=req.getParameter("password");
		ModelAndView mav=new ModelAndView();
		HttpSession hs=req.getSession();
		String role=ts.checkLogin(un,pw);
		
		if(role.equals("admin")) {
			
			mav.setViewName("admin.jsp");
		}
		else if(role.equals("cust_user")) {
			tt.setUsername(un);
			tt.setPassword(pw);
			int id=td.getid(un,pw);
			tt.setCust_Id(id);
			hs.setAttribute("obj", tt);
			mav.setViewName("userhome.jsp");	
		}
		else if(role.equals("trade_user")) {
			tt.setUsername(un);
			tt.setPassword(pw);
			int id=td.gettid(un);
			tt.setTrader_Id(id);
			hs.setAttribute("obj", tt);
			mav.setViewName("Traderhome.jsp");
		}
		else
		{
		mav.addObject("msg","Invalid User info!!! Incorrect username or password!!!!");
		mav.setViewName("index.jsp");
		}
		
		return mav;
		
		
	}
	/*@RequestMapping(value="check",method=RequestMethod.POST)
	public ModelAndView checkUser(HttpServletRequest req, Trade tt) {
		String type=req.getParameter("type");
		ModelAndView mav=new ModelAndView();
		HttpSession hs=req.getSession();
		if(type.equals("admin"))
			{
			String username=req.getParameter("name");
			
			String password=req.getParameter("password");
			if(username.equals("admin") && password.equals("admin"))
				{
				mav.setViewName("admin.jsp");
				}
			else
				{
				mav.addObject("errorMsg","invalid admin info");
				mav.setViewName("login.jsp");
				}
			}
			
			else if(type.equals("user"))
			{
			String username=req.getParameter("name");
			//System.out.println("hello");
			String password=req.getParameter("password");
			tt.setUsername(username);
			tt.setPassword(password);
			int id=td.getid(username,password);
			tt.setCust_Id(id);
			hs.setAttribute("obj", tt);
			int res=0;
			res=ts.checkCustInfo(tt);
			if(res>0)
				{
				mav.setViewName("userhome.jsp");
				}
			else
			{
				mav.addObject("msg","invalid user info");
				mav.setViewName("index.jsp");
			}
			}
			else if(type.equals("Trader"))
			{
				String username=req.getParameter("name");
				//System.out.println("hello");
				String password=req.getParameter("password");
				tt.setUsername(username);
				tt.setPassword(password);
				int id=td.gettid(username);
				tt.setTrader_Id(id);
				hs.setAttribute("obj", tt);
				int res=0;
				res=ts.checkTraderInfo(tt);
				System.out.println(res);
				if(res>0)
					{
					mav.setViewName("Traderhome.jsp");
					}
				else
				{
					mav.addObject("msg","invalid user info");
					mav.setViewName("index.jsp");
				}
			}
		return mav;
		
	}*/
	
	@Autowired
	TradeService ts;
	@RequestMapping(value="csv",method=RequestMethod.POST)
	public ModelAndView upload(HttpServletRequest req, Trade tt) throws IOException {
	ModelAndView mav=new ModelAndView();
	String type=req.getParameter("type");
	
	if(type.equals("upload"))
	{
		int res=ts.uploadcsv(tt,req);
		
	

	if(res>0)
	{
		mav.setViewName("admin.jsp");
		mav.addObject("msg", "successfully added");
		
	}
	else
	{
		mav.setViewName("admin.jsp");
		mav.addObject("msg", "File not added!!! Record has been added already!!!!");
	}}
	else if(type.equals("display")) 
		{
		
		List<Trade>listOfData=ts.getTradeInfo();
		//System.out.println("hi");
		mav.setViewName("displaydata.jsp");
		//System.out.println("hello");
		//System.out.println(listOfData.size());
		mav.addObject("data",listOfData);
	}
	else if(type.equals("search")){
		mav.setViewName("search.jsp");
	}
	
	else if(type.equals("delete")){
		mav.setViewName("delete.jsp");
	}
	
	else if(type.equals("update"))
		
	{
		HttpSession hs2=req.getSession();
		Trade tr=(Trade)hs2.getAttribute("obj");
		mav.setViewName("updatingadmin.jsp");
		mav.addObject("data",tr);
	}
	else if(type.equals("REPORT"))
	{
		//ModelAndView mav= new ModelAndView();
		//System.out.println("hello");
		ts.csvWriter();
		ts.bondWriter();
		ts.repoWriter();
		ts.generateReport();
		
		
		mav.setViewName("admin.jsp");
		mav.addObject("msg","Reports sucessfully generated");
		
	}
	else if(type.equals("bondreport"))
	{
		
		List<Trade>listOfData=ts.getBondInfo();
		//System.out.println("hi");
		mav.setViewName("displaydata.jsp");
		//System.out.println("hello");
		//System.out.println(listOfData.size());
		mav.addObject("data",listOfData);
	}
	else if(type.equals("reporeport"))
	{
		List<Trade>listOfData=ts.getRepoInfo();
		//System.out.println("hi");
		mav.setViewName("displaydata.jsp");
		//System.out.println("hello");
		//System.out.println(listOfData.size());
		mav.addObject("data",listOfData);
	}
	else if(type.equals("displayreport"))
	{
		//ModelAndView mav= new ModelAndView();
		mav.setViewName("displayreport.jsp");
		
	
	}
	
	else if(type.equals(null))
	{
		mav.addObject("msg","please select any option");
	}



	return mav;
	}
	
	@RequestMapping(value="updateadm",method=RequestMethod.POST)
	public ModelAndView updateadm (HttpServletRequest req,@ModelAttribute("Cust_Id") Trade Cust_Id) {
		
	
		ModelAndView mav=new ModelAndView();
		Trade at=new Trade();
		HttpSession hs2=req.getSession();
	
	
		//System.out.println(at.getCust_Id());
		//System.out.println("after geting from form:"+Cust_Id.getCust_Id());
	
	
	at.setCust_Id(Cust_Id.getCust_Id());
	String choice=req.getParameter("type");
	//System.out.println(choice);
		if(choice.equals("tradetype"))
			{
			mav.setViewName("updatetradetype.jsp");
			mav.addObject("data",at);
			
			}
					
		else if(choice.equals("transtype"))
			{
				mav.setViewName("updatetranstype.jsp");
				mav.addObject("data",at);
			
			}
		
			
		else if(choice.equals("buysell"))
			{
				mav.setViewName("updatebuysell.jsp");
				mav.addObject("data",at);
		
			}
		
	else if(choice.equals("country"))
		{
			mav.setViewName("updatecountry.jsp");
			mav.addObject("data",at);
		
		}
	
		
	else if(choice.equals("currency"))
		{
			mav.setViewName("updatecurrency.jsp");
			mav.addObject("data",at);
	
		}
		
	else if(choice.equals("exchange"))
		{
			mav.setViewName("updateexchange.jsp");
			mav.addObject("data",at);
		
		}
	
		
	else if(choice.equals("status"))
		{
			mav.setViewName("updatestatus.jsp");
			mav.addObject("data",at);
	
		}
		
		
	else if(choice.equals("quantity"))
		{
			mav.setViewName("updatequantity.jsp");
			mav.addObject("data",at);
		
		}
	
		
	else if(choice.equals("sectorid"))
		{
			mav.setViewName("updatesectorid.jsp");
			mav.addObject("data",at);
	
		}
		
	else if(choice.equals("isincode"))
		{
			mav.setViewName("updateisinid.jsp");
			mav.addObject("data",at);
		
		}
	
		
	else if(choice.equals("locationid"))
		{
			mav.setViewName("updatelocationid.jsp");
			mav.addObject("data",at);
	
		}
	else
			{
				mav.addObject("msg","please select any option");
			}
		
		
		
		return mav;
		
	}
	
	
	@RequestMapping(value="userfunction", method=RequestMethod.POST)
	public ModelAndView userfunctions(HttpServletRequest req,Trade tt)
	{
		
		ModelAndView mav=new ModelAndView();
		HttpSession hs1=req.getSession();
		Trade t=(Trade)hs1.getAttribute("obj");
		String option=req.getParameter("type");
		if(option.equals("view"))
		{
			//System.out.println("hf");
			//int res=ts.checkOneUserInfo(t.getUsername(),t.getPassword());
		
			   // System.out.println("custid:"+Cust_Id.getCust_Id());
			Trade t1=(Trade)hs1.getAttribute("obj");
			
				List<Trade>listOfData=ts.getOneLoginDetailsById(t1.getCust_Id());
				mav.setViewName("displayData1.jsp");
				mav.addObject("data",listOfData);
				
			
		}
		else if(option.equals("update"))
			
		{
			HttpSession hs2=req.getSession();
			Trade tr=(Trade)hs2.getAttribute("obj");
			mav.setViewName("update.jsp");
			mav.addObject("data",tr);
		}
		else
		{
			mav.addObject("msg","please select any option");
		}
		return mav;
	}
	
	

	
	@RequestMapping(value="updating",method=RequestMethod.POST)
	public ModelAndView updating (HttpServletRequest req,@ModelAttribute("Cust_Id") Trade Cust_Id) {
		
	
		ModelAndView mav=new ModelAndView();
		Trade at=new Trade();
		HttpSession hs2=req.getSession();
	
	
		//System.out.println(at.getCust_Id());
		//System.out.println("after geting from form:"+Cust_Id.getCust_Id());
	
	
	at.setCust_Id(Cust_Id.getCust_Id());
	String choice=req.getParameter("type");
	//System.out.println(choice);
		if(choice.equals("fname"))
			{
				mav.setViewName("updatefname.jsp");
			    mav.addObject("data",at);
			
			}
					
		else if(choice.equals("lname"))
			{
				mav.setViewName("updatelname.jsp");
				mav.addObject("data",at);
			
			}
		
			
		else if(choice.equals("mobile_no"))
			{
				mav.setViewName("updatemobile.jsp");
				mav.addObject("data",at);
		
			}
		else
			{
			mav.setViewName("admin.jsp");
			mav.addObject("msg","please select any option");
			}
		
		
		
		return mav;
		
	}
	@RequestMapping(value="updatefname", method=RequestMethod.POST)
	public ModelAndView byname(HttpServletRequest req,@ModelAttribute("Cust_Id")Trade Cust_Id,@ModelAttribute("Cust_FirstName")Trade Cust_Firstname)
	{
		ModelAndView mav=new ModelAndView();
	
		//System.out.println("id:"+Cust_Id.getCust_Id());
		String name=req.getParameter("Cust_FirstName");
		//System.out.println("name:"+name);
		Trade at=new Trade();
		int r=Cust_Id.getCust_Id();
		HttpSession hs2=req.getSession();
		int res=ts.checkCustInfo(Cust_Id.getCust_Id());
		//System.out.println(res);
		if(res>0) {
		int res1=ts.updateCustByFname(name,Cust_Id.getCust_Id());
		if(res1>0)
		{
			mav.setViewName("update1.jsp");
			
			//mav.addObject("data",r);
			mav.addObject("msg","successfully updated");
			
		}}
		else
		{
			mav.setViewName("update1.jsp");
			//mav.addObject("data",res);
			mav.addObject("msg","not updated");
		}
		return mav;

}
	
	@RequestMapping(value="updatelname", method=RequestMethod.POST)
	public ModelAndView bylname(HttpServletRequest req,@ModelAttribute("Cust_Id")Trade Cust_Id,@ModelAttribute("Cust_LastName")Trade Cust_Lastname)
	{
		ModelAndView mav=new ModelAndView();
	
		//System.out.println("id:"+Cust_Id.getCust_Id());
		String name=req.getParameter("Cust_LastName");
		//System.out.println("name:"+name);
	
		int res=ts.checkCustInfo(Cust_Id.getCust_Id());
		//System.out.println(res);
		if(res>0) {
		int res1=ts.updateCustByLname(name,Cust_Id.getCust_Id());
		if(res1>0)
		{
			mav.setViewName("update1.jsp");
			//System.out.println();
			//mav.addObject("data",res);
			mav.addObject("msg","successfully updated");
			
		}}
		else
		{
			mav.setViewName("update1.jsp");
			mav.addObject("msg","not updated");
		}
		return mav;

}
	@RequestMapping(value="updatemobile", method=RequestMethod.POST)
	public ModelAndView bymobile(HttpServletRequest req,@ModelAttribute("Cust_Id")Trade Cust_Id,@ModelAttribute("Cust_Mobile_number")Trade Cust_Mobile_number)
	{
		ModelAndView mav=new ModelAndView();
	
		//System.out.println("id:"+Cust_Id.getCust_Id());
		String mobile=req.getParameter("Mobile");
		//System.out.println("mobile:"+mobile);
	
		int res=ts.checkCustInfo(Cust_Id.getCust_Id());
		//System.out.println(res);
		if(res>0) {
		int res1=ts.updateCustByMobile(mobile, Cust_Id.getCust_Id());
		if(res1>0)
		{
			mav.setViewName("update1.jsp");
			mav.addObject("msg","successfully updated");
			
		}}
		else
		{
			mav.setViewName("update1.jsp");
			mav.addObject("msg","not updated");
		}
		return mav;

}
	
	@RequestMapping(value="custid")
	public ModelAndView viewSpecificInfo1(HttpServletRequest req,@ModelAttribute("user") Trade user) {
		
		ModelAndView mav=new ModelAndView();
		//int res=td.getbycustid(user.getCust_Id());
		Trade trade=td.getbycustid(user.getCust_Id());
	
		  mav.setViewName("display.jsp");
		  mav.addObject("data",trade);
		return mav;
	}
	
	@RequestMapping(value="tradeid")
	public ModelAndView viewSpecificInfo2(HttpServletRequest req,@ModelAttribute("user") Trade user) {
		
		ModelAndView mav=new ModelAndView();
		Trade trade=td.getbytradeid(user.getTradeUniqueId());
		
		  mav.setViewName("display.jsp");
		  mav.addObject("data",trade);
		return mav;
	}
	
	@RequestMapping(value="traderid")
	public ModelAndView viewSpecificInfo3(HttpServletRequest req,@ModelAttribute("user") Trade user) {
		
		ModelAndView mav=new ModelAndView();
		Trade trade=td.getbytraderid(user.getTrader_Id());
		
		  mav.setViewName("display.jsp");
		  mav.addObject("data",trade);
		return mav;
	}
	
	@RequestMapping(value="delcustid")
	public ModelAndView deleteInfo1(HttpServletRequest req,@ModelAttribute("user") Trade user) {
		
		ModelAndView mav=new ModelAndView();
		int res=td.delcustomer(user.getCust_Id());
		if(res>0) {
		mav.setViewName("delete.jsp");
		mav.addObject("msg", "Record deleted successfully");
		return mav;
		}
		else
		{
			mav.setViewName("delete.jsp");
			mav.addObject("msg", "Record not deleted ");
			return mav;
		}
		
		
		
	}
	
	@RequestMapping(value="deltradeid")
	public ModelAndView deleteInfo2(HttpServletRequest req,@ModelAttribute("user") Trade user) {
		ModelAndView mav=new ModelAndView();
		int res= td.deltrade(user.getTradeUniqueId());
		if(res>0) {
		 mav.setViewName("delete.jsp");
			mav.addObject("msg", "Record deleted successfully");
			return mav;}
		else
		{
			 mav.setViewName("delete.jsp");
				mav.addObject("msg", "Something went wrong!!Record not deleted");
				return mav;
		}
		
	}
	
	@RequestMapping(value="deltraderid")
	public ModelAndView deleteInfo3(HttpServletRequest req,@ModelAttribute("user") Trade user) {
		ModelAndView mav=new ModelAndView();
		int res= td.deltrader(user.getTrader_Id());
		if(res>0) {
		 mav.setViewName("delete.jsp");
			mav.addObject("msg", "Something went wrong!!Record deleted successfully");
			return mav;}
		else
		{
			 mav.setViewName("delete.jsp");
				mav.addObject("msg", "Something went wrong!!Record not deleted ");
				return mav;
		}
		
	}
	
	@RequestMapping(value="Traderfunction", method=RequestMethod.POST)
	public ModelAndView Traderfunctions(HttpServletRequest req,Trade tt)
	{
		
		ModelAndView mav=new ModelAndView();
		HttpSession hs1=req.getSession();
		Trade t=(Trade)hs1.getAttribute("obj");
		String option=req.getParameter("type");
		if(option.equals("view"))
		{
			//System.out.println("hf");
			//int res=ts.checkOneUserInfo(t.getUsername(),t.getPassword());
		
			   // System.out.println("custid:"+Cust_Id.getCust_Id());
			Trade t1=(Trade)hs1.getAttribute("obj");
			
				List<Trade>listOfData=ts.getOneLoginDetailsByTId(t1.getTrader_Id());
				mav.setViewName("displayData1.jsp");
				mav.addObject("data",listOfData);
				
			
		}
		else if(option.equals("update"))
			
		{
			HttpSession hs2=req.getSession();
			Trade tr=(Trade)hs2.getAttribute("obj");
			mav.setViewName("updatetrader.jsp");
			mav.addObject("data",tr);
		}
		else if(option.equals(null))
		{
			mav.addObject("msg","please select any option");
		}
		return mav;
	}
	
	

	
	@RequestMapping(value="updatingTrader",method=RequestMethod.POST)
	public ModelAndView updatingTrader (HttpServletRequest req,@ModelAttribute("Trader_Id") Trade Trader_Id) {
		
	
		ModelAndView mav=new ModelAndView();
		Trade at=new Trade();
		HttpSession hs2=req.getSession();
	
	
		//System.out.println(at.getCust_Id());
		//System.out.println("after geting from form:"+Trader_Id.getTrader_Id());
	
	
	at.setTrader_Id(Trader_Id.getTrader_Id());
	String choice=req.getParameter("type");
	//System.out.println(choice);
		if(choice.equals("fname"))
			{
				mav.setViewName("updatetfname.jsp");
			mav.addObject("data",at);
			
			}
					
		else if(choice.equals("lname"))
			{
				mav.setViewName("updatetlname.jsp");
				mav.addObject("data",at);
			
			}
		
			
		else if(choice.equals("mobile_no"))
			{
				mav.setViewName("updatetmobile.jsp");
				mav.addObject("data",at);
		
			}
		else
			{
				mav.addObject("msg","please select any option");
			}
		
		
		
		return mav;
		
	}
	@RequestMapping(value="updatetfname", method=RequestMethod.POST)
	public ModelAndView bytname(HttpServletRequest req,@ModelAttribute("Trader_Id")Trade Trader_Id,@ModelAttribute("Trader_FirstName")Trade Trader_Firstname)
	{
		ModelAndView mav=new ModelAndView();
	
		//System.out.println("id:"+Trader_Id.getTrader_Id());
		String name=req.getParameter("Trader_FirstName");
		//System.out.println("name:"+name);
	   // System.out.println("ID:"+Trader_Id.getTrader_Id());
		int res=ts.checkTraderInfo(Trader_Id.getTrader_Id());
		//System.out.println(res);
		if(res>0) 
		{
		int res1=ts.updateTraderByFname(name,Trader_Id.getTrader_Id());
		if(res1>0)
		{
			mav.setViewName("updatetrader.jsp");
			mav.addObject("msg","Successfully updated");
			
		}
		else
		{
			mav.setViewName("updatetrader.jsp");
			mav.addObject("msg","Something went wrong!! record not updated");
		}
		}
		return mav;
		
}
	
	@RequestMapping(value="updatetlname", method=RequestMethod.POST)
	public ModelAndView bytlname(HttpServletRequest req,@ModelAttribute("Trader_Id")Trade Trader_Id,@ModelAttribute("Trader_LastName")Trade Trader_Lastname)
	{
		ModelAndView mav=new ModelAndView();
	
		//System.out.println("id:"+Trader_Id.getTrader_Id());
		String name=req.getParameter("Trader_LastName");
		//System.out.println("name:"+name);
	
		int res=ts.checkTraderInfo(Trader_Id.getTrader_Id());
		//System.out.println(res);
		if(res>0) {
		int res1=ts.updateTraderByLname(name,Trader_Id.getTrader_Id());
		if(res1>0)
		{
			mav.setViewName("updatetrader.jsp");
			mav.addObject("msg","Successfully updated");
			
		}}
		else
		{
			mav.setViewName("updatetrader.jsp");
			mav.addObject("msg","Something went wrong!! record not updated");
		}
		return mav;

}
	@RequestMapping(value="updatetmobile", method=RequestMethod.POST)
	public ModelAndView bytmobile(HttpServletRequest req,@ModelAttribute("Trader_Id")Trade Trader_Id,@ModelAttribute("Trader_Contact")Trade Trader_Contact)
	{
		ModelAndView mav=new ModelAndView();
	
	//	System.out.println("id:"+Trader_Id.getTrader_Id());
		String mobile=req.getParameter("Mobile");
		//System.out.println("mobile:"+mobile);
	
		int res=ts.checkTraderInfo(Trader_Id.getTrader_Id());
		//System.out.println(res);
		if(res>0) {
		int res1=ts.updateTraderByMobile(mobile,Trader_Id.getTrader_Id());
		if(res1>0)
		{
			mav.setViewName("updatetrader.jsp");
			mav.addObject("msg","Successfully updated");
			
		}
		else
		{
			mav.setViewName("updatetrader.jsp");
			mav.addObject("msg","Something went wrong!! record not updated");
		}}
		return mav;

}

@RequestMapping(value="updatetradetype", method=RequestMethod.POST)
	public ModelAndView tradetype (HttpServletRequest req,@ModelAttribute("Cust_Id")Trade Cust_Id,@ModelAttribute("Trade_Type")Trade Trade_Type )
	{
		ModelAndView mav=new ModelAndView();
	   // Trade t=new Trade();
		//System.out.println("id:"+Cust_Id.getCust_Id());
		String type=req.getParameter("Trade_Type");
	int tradetype=Integer.parseInt(type);
		//System.out.println("name:"+tradetype);
	//ModelAndView mav=new ModelAndView();
	Trade tt=new Trade();


		int res=ts.checkCustInfo(Cust_Id.getCust_Id());
		//System.out.println(res);
		if(res>0) {
		int res1=ts.updateTradeType(tradetype,Cust_Id.getCust_Id(),req);
		if(res1>0)
		{
			mav.setViewName("updatingadmin.jsp");
			mav.addObject("msg","Successfully updated");
			
		}}
		else
		{
			mav.setViewName("updatingadmin.jsp");
			mav.addObject("msg","Something went wrong!! record not updated");
		}
		return mav;

}
	@RequestMapping(value="updatetranstype", method=RequestMethod.POST)
	public ModelAndView transtype (HttpServletRequest req,@ModelAttribute("Cust_Id")Trade Cust_Id,@ModelAttribute("Transaction_Type")Trade Transaction_Type )
	{
		ModelAndView mav=new ModelAndView();
	
	//	System.out.println("id:"+Cust_Id.getCust_Id());
		String type=req.getParameter("Transaction_Type");
	int transtype=Integer.parseInt(type);
		//System.out.println("name:"+transtype);
	
		int res=ts.checkCustInfo(Cust_Id.getCust_Id());
		//System.out.println(res);
		if(res>0) {
		int res1=ts.updateTransType(transtype,Cust_Id.getCust_Id());
		if(res1>0)
		{
			mav.setViewName("updatingadmin.jsp");
			mav.addObject("msg","Successfully updated");
			
		}}
		else
		{
			mav.setViewName("updatingadmin.jsp");
			mav.addObject("msg","Something went wrong!! record not updated");
		}
		return mav;

}
	@RequestMapping(value="updatestatus", method=RequestMethod.POST)
	public ModelAndView status(HttpServletRequest req,@ModelAttribute("Cust_Id")Trade Cust_Id,@ModelAttribute("Status")Trade Status)
	{
		ModelAndView mav=new ModelAndView();
	
		//System.out.println("id:"+Cust_Id.getCust_Id());
		String type=req.getParameter("Status");
	int status=Integer.parseInt(type);
		//System.out.println("name:"+status);
	
		int res=ts.checkCustInfo(Cust_Id.getCust_Id());
		//System.out.println(res);
		if(res>0) {
		int res1=ts.updateStatus(status,Cust_Id.getCust_Id());
		if(res1>0)
		{
			mav.setViewName("updatingadmin.jsp");
			mav.addObject("msg","Successfully updated");
			
		}}
		else
		{
			mav.setViewName("updatingadmin.jsp");
			mav.addObject("msg","Something went wrong!! record not updated");
		}
		return mav;

}
	@RequestMapping(value="updatesectorid", method=RequestMethod.POST)
	public ModelAndView sectorid(HttpServletRequest req,@ModelAttribute("Cust_Id")Trade Cust_Id,@ModelAttribute("Sector_Id")Trade Sector_Id)
	{
		ModelAndView mav=new ModelAndView();
	
		//System.out.println("id:"+Cust_Id.getCust_Id());
		String type=req.getParameter("Sector_Id");
	int sectorid=Integer.parseInt(type);
		//System.out.println("sector id:"+sectorid);
	
		int res=ts.checkCustInfo(Cust_Id.getCust_Id());
		//System.out.println(res);
		if(res>0) {
		int res1=ts.updateSectorId(sectorid,Cust_Id.getCust_Id());
		if(res1>0)
		{
			mav.setViewName("updatingadmin.jsp");
			mav.addObject("msg","Successfully updated");
			
		}}
		else
		{
			mav.setViewName("updatingadmin.jsp");
			mav.addObject("msg","Something went wrong!! record not updated");
		}
		return mav;
	}
		@RequestMapping(value="updatequantity", method=RequestMethod.POST)
		public ModelAndView quantity(HttpServletRequest req,@ModelAttribute("Cust_Id")Trade Cust_Id,@ModelAttribute("Quantity")Trade Quantity)
		{
			ModelAndView mav=new ModelAndView();
		
			//System.out.println("id:"+Cust_Id.getCust_Id());
			String type=req.getParameter("Quantity");
		int quantity=Integer.parseInt(type);
			//System.out.println("quantity:"+quantity);
		
			int res=ts.checkCustInfo(Cust_Id.getCust_Id());
			System.out.println(res);
			if(res>0) {
			int res1=ts.updateQuantity(quantity,Cust_Id.getCust_Id());
			if(res1>0)
			{
				mav.setViewName("updatingadmin.jsp");
				mav.addObject("msg","Successfully updated");
				
			}}
			else
			{
				mav.setViewName("updatingadmin.jsp");
				mav.addObject("msg","Something went wrong!! record not updated");
			}
			return mav;


}
		@RequestMapping(value="updatelocationid", method=RequestMethod.POST)
		public ModelAndView locationid(HttpServletRequest req,@ModelAttribute("Cust_Id")Trade Cust_Id,@ModelAttribute("Location_Id")Trade Location_Id)
		{
			ModelAndView mav=new ModelAndView();
		
			//System.out.println("id:"+Cust_Id.getCust_Id());
			String type=req.getParameter("Location_Id");
		int locationid=Integer.parseInt(type);
			//System.out.println("location id:"+locationid);
		
			int res=ts.checkCustInfo(Cust_Id.getCust_Id());
			//System.out.println(res);
			if(res>0) {
			int res1=ts.updateLocationId(locationid,Cust_Id.getCust_Id());
			if(res1>0)
			{
				mav.setViewName("updatingadmin.jsp");
				mav.addObject("msg","Successfully updated");
				
			}}
			else
			{
				mav.setViewName("updatingadmin.jsp");
				mav.addObject("msg","Something went wrong!! record not updated");
			}
			return mav;
		}
		@RequestMapping(value="updateexchange", method=RequestMethod.POST)
		public ModelAndView exchange(HttpServletRequest req,@ModelAttribute("Cust_Id")Trade Cust_Id,@ModelAttribute("Exchange")Trade Exchange)
		{
			ModelAndView mav=new ModelAndView();
		
			//System.out.println("id:"+Cust_Id.getCust_Id());
			String type=req.getParameter("Exchange");
		int exchange=Integer.parseInt(type);
			//System.out.println("exchange:"+exchange);
		
			int res=ts.checkCustInfo(Cust_Id.getCust_Id());
			//System.out.println(res);
			if(res>0) {
			int res1=ts.updateExchange(exchange,Cust_Id.getCust_Id());
			if(res1>0)
			{
				mav.setViewName("updatingadmin.jsp");
				mav.addObject("msg","Successfully updated");
				
			}}
			else
			{
				mav.setViewName("updatingadmin.jsp");
				mav.addObject("msg","Something went wrong!! record not updated");
			}
			return mav;


}
		
		@RequestMapping(value="updatecurrency", method=RequestMethod.POST)
		public ModelAndView currency(HttpServletRequest req,@ModelAttribute("Cust_Id")Trade Cust_Id,@ModelAttribute("Currency")Trade Currency)
		{
			ModelAndView mav=new ModelAndView();
		
			//System.out.println("id:"+Cust_Id.getCust_Id());
			String type=req.getParameter("Currency");
		int currency=Integer.parseInt(type);
			//System.out.println("currency:"+currency);
		
			int res=ts.checkCustInfo(Cust_Id.getCust_Id());
			//System.out.println(res);
			if(res>0) {
			int res1=ts.updateCurrency(currency,Cust_Id.getCust_Id());
			if(res1>0)
			{
				mav.setViewName("updatingadmin.jsp");
				mav.addObject("msg","Successfully updated");
				
			}}
			else
			{
				mav.setViewName("updatingadmin.jsp");
				mav.addObject("msg","Something went wrong!! record not updated");
			}
			return mav;


}
		@RequestMapping(value="updatecountry", method=RequestMethod.POST)
		public ModelAndView country(HttpServletRequest req,@ModelAttribute("Cust_Id")Trade Cust_Id,@ModelAttribute("Country")Trade Country)
		{
			ModelAndView mav=new ModelAndView();
		
			//System.out.println("id:"+Cust_Id.getCust_Id());
			String type=req.getParameter("Country");
		int country=Integer.parseInt(type);
		//	System.out.println("country:"+country);
		
			int res=ts.checkCustInfo(Cust_Id.getCust_Id());
			//System.out.println(res);
			if(res>0) {
			int res1=ts.updateCountry(country,Cust_Id.getCust_Id());
			if(res1>0)
			{
				mav.setViewName("updatingadmin.jsp");
				mav.addObject("msg","Successfully updated");
				
			}}
			else
			{
				mav.setViewName("updatingadmin.jsp");
				mav.addObject("msg","Something went wrong!! record not updated");
			}
			return mav;


}
		@RequestMapping(value="updateisinid", method=RequestMethod.POST)
		public ModelAndView isincode(HttpServletRequest req,@ModelAttribute("Cust_Id")Trade Cust_Id,@ModelAttribute("ISIN_Code")Trade ISIN_Code)
		{
			ModelAndView mav=new ModelAndView();
		
		//	System.out.println("id:"+Cust_Id.getCust_Id());
			String type=req.getParameter("ISIN_Code");
		int isincode=Integer.parseInt(type);
		//	System.out.println("ISIN Code:"+isincode);
		
			int res=ts.checkCustInfo(Cust_Id.getCust_Id());
		//	System.out.println(res);
			if(res>0) {
			int res1=ts.updateIsinCode(isincode,Cust_Id.getCust_Id());
			if(res1>0)
			{
				mav.setViewName("updatingadmin.jsp");
				mav.addObject("msg","Successfully updated");
				
			}}
			else
			{
				mav.setViewName("updatingadmin.jsp");
				mav.addObject("msg","Something went wrong!! record not updated");
			}
			return mav;


}
		@RequestMapping(value="updatebuysell", method=RequestMethod.POST)
		public ModelAndView buysell(HttpServletRequest req,@ModelAttribute("Cust_Id")Trade Cust_Id,@ModelAttribute("Buy_Sell")Trade Buy_Sell)
		{
			ModelAndView mav=new ModelAndView();
		
			//System.out.println("id:"+Cust_Id.getCust_Id());
			String type=req.getParameter("Buy_Sell");
		int buysell=Integer.parseInt(type);
			//System.out.println("buy sell:"+buysell);
		
			int res=ts.checkCustInfo(Cust_Id.getCust_Id());
			//System.out.println(res);
			if(res>0) {
			int res1=ts.updateBuySell(buysell,Cust_Id.getCust_Id());
			if(res1>0)
			{
				mav.setViewName("updatingadmin.jsp");
				mav.addObject("msg","Successfully updated");
				
			}}
			else
			{
				mav.setViewName("updatingadmin.jsp");
				mav.addObject("msg","Something went wrong!! record not updated");
			}
			return mav;


}



}
