package com.Trade.service;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
//package csvreader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.RequestContext;

import com.Trade.Bean.Trade;
import com.Trade.dao.Tradedao;
//import com.project2.bean.Athlete;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
//import com.scb.bean.log;
//import com.scb.dao.logindao;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service("Ts")
public class TradeService {

	@Autowired
	 Tradedao td;
	static int updateCount=0;
	static int bondCount = 1;
	static int repoCount = 1;
	static int tradeCount = 1;
	
		public int uploadcsv(Trade tt,HttpServletRequest req)
		{
			int res =0;
	        String csvFile = "E:\\scb\\Trade.csv";
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";

	        try {

	            br = new BufferedReader(new FileReader(csvFile));
	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                String[] values = line.split(cvsSplitBy);

	               // System.out.println(values[0] + " " + values[1] + " "+ values[2]+ " "+ values[3]+ " "+ values[4]+ " "+ values[5]+ " "+ values[6]+ " "+ values[7]+ " "+ values[8]+ " "+ values[9]+ " "+ values[10]+ " ");
	               
	                tt.setCust_Id(Integer.parseInt(values[0]));
	                tt.setCust_FirstName(values[1]);
	                tt.setCust_LastName(values[2]);
	                tt.setCust_Mobile_Number(Long.parseLong(values[3]));
	                
	                
	                tt.setTrader_Id(Long.parseLong(values[4]));
	                tt.setTrader_FirstName(values[5]);
	                tt.setTrader_LastName(values[6]);
	                tt.setTrader_Contact(Long.parseLong(values[7]));
	               
	                
	                tt.setTrade_Type(Integer.parseInt(values[8]));
	                tt.setTrade_Date(values[9]);
	                tt.setTrademod_Timestamp(values[10]);
	                tt.setTradeUniqueId(Integer.parseInt(values[11]));
	               
	                
	                tt.setTransaction_Id(Long.parseLong(values[12]));
	                tt.setTransaction_Type(Integer.parseInt(values[13]));
	                tt.setBuy_Sell(Integer.parseInt(values[14]));
	                tt.setSettlement_Id(Long.parseLong(values[15]));
	                tt.setSettlement_Date((values[16]));
	                tt.setSettlement_Timestamp(values[17]);
	                tt.setOrder_Id(Integer.parseInt(values[18]));
	                tt.setOrder_Timestamp(values[19]);
	                tt.setQuantity(Long.parseLong(values[20]));
	                tt.setStatus(Integer.parseInt(values[21]));
	               
	                tt.setCancel_Date(values[22]);
	                tt.setCancel_Time(values[23]);
	                tt.setBID(Double.parseDouble(values[24]));
	                tt.setASK(Double.parseDouble(values[25]));
	                tt.setLTP(Double.parseDouble(values[26]));
	                
	                tt.setCountry(Integer.parseInt(values[27]));
	                tt.setCurrency(Integer.parseInt(values[28]));
	                tt.setExchange(Integer.parseInt(values[29]));
	                tt.setSector_Id(Integer.parseInt(values[30]));
	                tt.setISIN_Code(Integer.parseInt(values[31]));
	                tt.setLocation_Id(Long.parseLong(values[32]));
	                
	               
	               
	               HttpSession hs=req.getSession();
	              //System.out.println(tt.getFirstName());
	              //  System.out.println(tt.getLastName());
	              res= td.insertdata(tt);
	              hs.setAttribute("obj", tt);
	               
	                

	            }

	        } 
	       
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } 
	        catch (IOException e) {
	            e.printStackTrace();
	        } 
	        catch(Exception e)
	        {
	        	System.out.println(e);
	        }
	        finally {
	        
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	                
	            }
	            
	        }
			return res;
	        
	   
	    }
		
		
		public String checkLogin(String un,String pw)
		{
			return td.checkLoginType(un,pw);
		}
		
		public int checkCustInfo(Trade tt)
		{
			return td.checkCustInfoDao(tt);
		}
		
		public int checkCustInfo(int id)
		{
			return td.checkCustInfoDaoById(id);
		}
		
		public int checkTraderInfo(Trade tt)
		{
			return td.checkTraderInfoDao(tt);
		}
		
		public int checkTraderInfo(long id)
		{
			return td.checkTraderInfoDaoById(id);
		}
		
		public int checkOneUserInfo(String name,String pass)
		{
			return td.checkOneUserDao(name,pass);
		}
		
		public int updateCustByFname(String name,int id)
		{
			return td.updateCustDaoByFName(name,id);
		}
		
		public int updateCustByLname(String name,int id)
		{
			return td.updateCustDaoByLName(name,id);
		}
		
		public int  updateCustByMobile(String name,int id)
		{
			return td. updateCustDaoByMobile(name,id);
		}
		
		public int updateTraderByFname(String name,long id)
		{
			return td.updateTraderDaoByFName(name,id);
		}
		
		public int updateTraderByLname(String name,long id)
		{
			return td.updateTraderDaoByLName(name,id);
		}
		
		public int  updateTraderByMobile(String name,long id)
		{
			return td. updateTraderDaoByMobile(name,id);
		}
		
		public List<Trade> getOneLoginDetails(String s)
		{
		    
			return td.getOneLoginInfo(s);
		}
		
		public List<Trade> getBondInfo()
		{
			
			return td.getBondDaoInfo();
		}
		
		public List<Trade> getRepoInfo()
		{
			return td.getRepoDaoInfo();
		}
		
		public List<Trade> getOneLoginDetailsById(int id)
		{
			return td.getOneLoginInfoById(id);
		}
		
		public List<Trade> getOneLoginDetailsByTId(long id)
		{
			return td.getOneLoginInfoByTId(id);
		}
		public List<Trade> getTradeInfo()
		{
			return td.getTradeInfoDao();
		}
		
		public int updateTradeType(int Trade_Type,long id,HttpServletRequest req)
		{
			HttpSession hs=req.getSession();
			Trade tt=(Trade)hs.getAttribute("obj");
			return td.updateTradeTypeDao(Trade_Type,id,tt);
		}
		public int updateTransType(int Transaction_Type,long id)
		{
			return td.updateTransTypeDao(Transaction_Type,id);
		}
		public int updateStatus(int Status,long id)
		{
			return td.updateStatusDao(Status,id);
		}
		public int updateSectorId(int Sector_Id,long id)
		{
			return td.updateSectorIdDao(Sector_Id,id);
		}
		public int updateQuantity(int Quantity,long id)
		{
			return td.updateQuantityDao(Quantity,id);
		}
		public int updateLocationId(int Location_Id,long id)
		{
			return td.updateLocationIdDao(Location_Id,id);
		}
		public int updateExchange(int Exchange,long id)
		{
			return td.updateExchangeDao(Exchange,id);
		}
		public int updateCurrency(int Currency,long id)
		{
			return td.updateCurrencyDao(Currency,id);
		}
		public int updateCountry(int Country,long id)
		{
			return td.updateCountryDao(Country,id);
		}
		public int updateBuySell(int Buy_Sell,long id)
		{
			return td.updateBuySellDao(Buy_Sell,id);
		}
		public int updateIsinCode(int ISIN_Code,long id)
		{
			return td.updateIsinCodeDao(ISIN_Code,id);
		}
		
		
		public void csvWriter()
		{
			String COMMA_DELIMITER = ",";
			String NEW_LINE_SEPARATOR = "\n";
			String FILE_HEADER = "CUST_ID,CUST LAST_NAME,CUST FIRST_NAME,MOBILE_NUMBER,TRADE_ID,TRADE TYPE,ORDER ID,TXN ID,LOC ID,TRADE DATE,SETTLEMENT DATE,ORDER TIMESTAMP,SETTLEMENT TIMESTAMP,LTP,QTY,STATUS,TRANSACTION_TYPE,BUY OR SELL,SETTLEMENT_ID,TRADER_ID,TRADER_LASTNAME,TRADER_FIRSTNAME,TRADER CONTACT,SECTOR_ID,ISIN_CODE,CURRENCY,EXCHANGE,BID,ASK,TRADE MOD TIMESTAMP,CANCEL DATE,CANCEL TIMESTAMP,COUNTRY";
			List<Trade> to = td.getTradeInfoDao();
			Iterator<Trade> itr=to.iterator();
			FileWriter fileWriter = null;
			
	
			String filename = "E:\\scb\\Tradenew.csv"; 			
			
			
			try{
				fileWriter = new FileWriter(filename);
				fileWriter.append(FILE_HEADER.toString());
				fileWriter.append(NEW_LINE_SEPARATOR);
				
				while(itr.hasNext())
				{
					Trade tt=itr.next();
					
					fileWriter.append(String.valueOf(tt.getCust_Id()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getCust_FirstName());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getCust_LastName());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getCust_Mobile_Number()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getTrader_Id()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getTrader_FirstName());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getTrader_LastName());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getTrader_Contact()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getTrade_Type()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getTrade_Date());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getTrademod_Timestamp());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getTradeUniqueId()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getTransaction_Id()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getTransaction_Type()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getBuy_Sell()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getSettlement_Id()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getSettlement_Date());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getSettlement_Timestamp());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getOrder_Id()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getOrder_Timestamp());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getQuantity()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getStatus()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getCancel_Date());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getCancel_Time());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getBID()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getASK()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getLTP()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getCountry()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getCurrency()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getExchange()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getSector_Id()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getISIN_Code()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getLocation_Id()));
					fileWriter.append(NEW_LINE_SEPARATOR);

				
				}
			}
			catch(Exception e)
			{
				System.out.println("Writer error!");
				e.printStackTrace();
			}
			finally{
				try{
					fileWriter.flush();
					fileWriter.close();
				}
				catch (IOException e) {
					System.out.println("error while closing");
					e.printStackTrace();
				}
			}
		}
		
		public void bondWriter()
		{
			String COMMA_DELIMITER = ",";
			String NEW_LINE_SEPARATOR = "\n";
			String FILE_HEADER = "CUST_ID,CUST LAST_NAME,CUST FIRST_NAME,MOBILE_NUMBER,TRADE_ID,TRADE TYPE,ORDER ID,TXN ID,LOC ID,TRADE DATE,SETTLEMENT DATE,ORDER TIMESTAMP,SETTLEMENT TIMESTAMP,LTP,QTY,STATUS,TRANSACTION_TYPE,BUY OR SELL,SETTLEMENT_ID,TRADER_ID,TRADER_LASTNAME,TRADER_FIRSTNAME,TRADER CONTACT,SECTOR_ID,ISIN_CODE,CURRENCY,EXCHANGE,BID,ASK,TRADE MOD TIMESTAMP,CANCEL DATE,CANCEL TIMESTAMP,COUNTRY";
			List<Trade> to = td.getBondInfoDao();
			Iterator<Trade> itr=to.iterator();
			FileWriter fileWriter = null;
			
			String filename;
			if(bondCount == 1)
				{filename = "E:\\scb\\BondOld.csv"; bondCount = -1;}
			else
				{filename = "E:\\scb\\BondNew.csv"; bondCount = 1;}
			
			
			try{
				fileWriter = new FileWriter(filename);
				fileWriter.append(FILE_HEADER.toString());
				fileWriter.append(NEW_LINE_SEPARATOR);
				
				while(itr.hasNext())
				{
					Trade tt=itr.next();
					
					fileWriter.append(String.valueOf(tt.getCust_Id()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getCust_FirstName());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getCust_LastName());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getCust_Mobile_Number()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getTrader_Id()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getTrader_FirstName());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getTrader_LastName());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getTrader_Contact()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getTrade_Type()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getTrade_Date());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getTrademod_Timestamp());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getTradeUniqueId()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getTransaction_Id()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getTransaction_Type()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getBuy_Sell()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getSettlement_Id()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getSettlement_Date());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getSettlement_Timestamp());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getOrder_Id()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getOrder_Timestamp());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getQuantity()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getStatus()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getCancel_Date());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getCancel_Time());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getBID()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getASK()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getLTP()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getCountry()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getCurrency()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getExchange()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getSector_Id()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getISIN_Code()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getLocation_Id()));
					fileWriter.append(NEW_LINE_SEPARATOR);

				
				}
			}
			catch(Exception e)
			{
				System.out.println("Writer error!");
				e.printStackTrace();
			}
			finally{
				try{
					fileWriter.flush();
					fileWriter.close();
				}
				catch (IOException e) {
					System.out.println("error while closing");
					e.printStackTrace();
				}
			}
		}
			
		public void repoWriter()
		{
			String COMMA_DELIMITER = ",";
			String NEW_LINE_SEPARATOR = "\n";
			String FILE_HEADER = "CUST_ID,CUST LAST_NAME,CUST FIRST_NAME,MOBILE_NUMBER,TRADE_ID,TRADE TYPE,ORDER ID,TXN ID,LOC ID,TRADE DATE,SETTLEMENT DATE,ORDER TIMESTAMP,SETTLEMENT TIMESTAMP,LTP,QTY,STATUS,TRANSACTION_TYPE,BUY OR SELL,SETTLEMENT_ID,TRADER_ID,TRADER_LASTNAME,TRADER_FIRSTNAME,TRADER CONTACT,SECTOR_ID,ISIN_CODE,CURRENCY,EXCHANGE,BID,ASK,TRADE MOD TIMESTAMP,CANCEL DATE,CANCEL TIMESTAMP,COUNTRY";
			List<Trade> to = td.getRepoInfoDao();
			Iterator<Trade> itr=to.iterator();
			FileWriter fileWriter = null;
			
			String filename;
			if(repoCount == 1)
				{filename = "E:\\scb\\RepoOld.csv"; repoCount = -1;}
			else
				{filename = "E:\\scb\\RepoNew.csv"; repoCount = 1;}
			
			
			
			try{
				fileWriter = new FileWriter(filename);
				fileWriter.append(FILE_HEADER.toString());
				fileWriter.append(NEW_LINE_SEPARATOR);
				
				while(itr.hasNext())
				{
					Trade tt=itr.next();
					
					fileWriter.append(String.valueOf(tt.getCust_Id()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getCust_FirstName());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getCust_LastName());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getCust_Mobile_Number()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getTrader_Id()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getTrader_FirstName());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getTrader_LastName());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getTrader_Contact()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getTrade_Type()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getTrade_Date());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getTrademod_Timestamp());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getTradeUniqueId()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getTransaction_Id()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getTransaction_Type()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getBuy_Sell()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getSettlement_Id()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getSettlement_Date());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getSettlement_Timestamp());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getOrder_Id()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getOrder_Timestamp());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getQuantity()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getStatus()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getCancel_Date());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(tt.getCancel_Time());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getBID()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getASK()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getLTP()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getCountry()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getCurrency()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getExchange()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getSector_Id()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getISIN_Code()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(tt.getLocation_Id()));
					fileWriter.append(NEW_LINE_SEPARATOR);

				
				}
			}
			catch(Exception e)
			{
				System.out.println("Writer error!");
				e.printStackTrace();
			}
			finally{
				try{
					fileWriter.flush();
					fileWriter.close();
				}
				catch (IOException e) {
					System.out.println("error while closing");
					e.printStackTrace();
				}
			}
		}	
		
		
		public int countOldBondLines() throws IOException {
		LineNumberReader reader  = new LineNumberReader(new FileReader("E:\\scb\\BondOld.csv"));
		int cnt = -1;
		String lineRead = "";
		while ((lineRead = reader.readLine()) != null) {
			cnt++;
		}

		//cnt = reader.getLineNumber()-1; 
		
		reader.close();
		return cnt;
		}
		
		public int countNewBondLines() throws IOException {
		    LineNumberReader reader  = new LineNumberReader(new FileReader("E:\\scb\\BondNew.csv"));
		int cnt = -1;
		String lineRead = "";
		while ((lineRead = reader.readLine()) != null) {
			cnt++;
		}

		//cnt = reader.getLineNumber()-1; 
		reader.close();
		return cnt;
		}
		
		public int countOldRepoLines() throws IOException {
		    LineNumberReader reader  = new LineNumberReader(new FileReader("E:\\scb\\RepoOld.csv"));
		int cnt = -1;
		String lineRead = "";
		while ((lineRead = reader.readLine()) != null) {
			cnt++;
		}

		//cnt = reader.getLineNumber()-1; 
		reader.close();
		return cnt;
		}
		
		public int countNewRepoLines() throws IOException {
		    LineNumberReader reader  = new LineNumberReader(new FileReader("E:\\scb\\RepoNew.csv"));
		int cnt = -1;
		String lineRead = "";
		while ((lineRead = reader.readLine()) != null) {
			cnt++;
		}

		//cnt = reader.getLineNumber()-1; 
		reader.close();
		return cnt;
		}
		
		
		public int countOldTableLines() throws IOException {
		    LineNumberReader reader  = new LineNumberReader(new FileReader("E:\\scb\\Trade.csv"));
		int cnt = 0;
		String lineRead = "";
		while ((lineRead = reader.readLine()) != null) {
			cnt++;
		}

		//cnt = reader.getLineNumber(); 
		reader.close();
		return cnt;
		}
		
		public int countNewTableLines() throws IOException {
			csvWriter();
		    LineNumberReader reader  = new LineNumberReader(new FileReader("E:\\scb\\Tradenew.csv"));
		int cnt = 0;
		String lineRead = "";
		while ((lineRead = reader.readLine()) != null) {
			cnt++;
		}

		//cnt = reader.getLineNumber(); 
		reader.close();
		return cnt;
		}
		
		
	
		
		public void generateReport() throws IOException
		{
			int oldBondLines = countOldBondLines();
			int newBondLines = countNewBondLines();
			int oldRepoLines = countOldRepoLines();
			int newRepoLines = countNewRepoLines();
			int extraBond = (newBondLines - oldBondLines);
			int extraRepo =(newRepoLines - oldRepoLines);
			int oldtableCount = countOldTableLines();
			int newtableCount = countNewTableLines();
			int extraTable = Math.abs((newtableCount - oldtableCount)-1);
			String NEW_LINE_SEPARATOR = "\r\n";
			FileWriter fileWriter = null;
			
			try{
				fileWriter = new FileWriter("E:\\scb\\Report.txt");
				fileWriter.append("Number of Rows in old Bond File :");
				fileWriter.append(String.valueOf("15"));
				fileWriter.append(",");
				//fileWriter.append("\r\n");
				fileWriter.append(System.lineSeparator());
				fileWriter.append("No of Rows in new Bond File :");
				fileWriter.append(String.valueOf(newBondLines));
				fileWriter.append(",");
				fileWriter.append(System.lineSeparator());
				//fileWriter.append("\r\n");
				fileWriter.append("Number of Rows in old Repo File :");
				fileWriter.append(String.valueOf("15"));
				fileWriter.append(",");
				fileWriter.append(System.lineSeparator());
				//fileWriter.append("\r\n");
				//fileWriter.append("\r\n");
				//fileWriter.append(System.lineSeparator());
				fileWriter.append("No of Rows in new Repo File :");
				fileWriter.append(String.valueOf(newRepoLines));
				fileWriter.append(",");
				fileWriter.append(System.lineSeparator());
				//fileWriter.append("\r\n");
				//fileWriter.append(System.lineSeparator());
				fileWriter.append("Number of  Rows in old Trade File:");
				fileWriter.append(String.valueOf("30"));
				fileWriter.append(",");
				fileWriter.append(System.lineSeparator());
				//fileWriter.append("\r\n");
				//fileWriter.append(System.lineSeparator());
				//fileWriter.append(NEW_LINE_SEPARATOR);
				fileWriter.append("No of Rows in new Trade file :");
				fileWriter.append(String.valueOf(newtableCount-1));
				fileWriter.append(",");
				fileWriter.append(System.lineSeparator());
				//fileWriter.append("\r\n");
				//fileWriter.append(System.lineSeparator());
				//fileWriter.append(NEW_LINE_SEPARATOR);
				//fileWriter.append("Number of Mismatch Rows          :");
				//fileWriter.append(String.valueOf((oldtableCount-newtableCount)-1));
		      	//	fileWriter.append(",");
	            //	fileWriter.append(NEW_LINE_SEPARATOR);
				
				fileWriter.append("Number of Deleted Rows :");
				fileWriter.append(String.valueOf(extraTable));
				fileWriter.append("\r\n");
				//fileWriter.append(",");
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
			catch(Exception e)
			{
				System.out.println("Writer error!");
				e.printStackTrace();
			}
			finally{
				try{
					fileWriter.flush();
					fileWriter.close();
				}
				catch (IOException e) {
					System.out.println("error while closing");
					e.printStackTrace();
				}
			}
		}
}
