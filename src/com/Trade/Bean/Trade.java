package com.Trade.Bean;

public class Trade {
	
	private int Cust_Id;
	private String Cust_FirstName;
	private String Cust_LastName;
	private long Cust_Mobile_Number;
	
	private long Trader_Id;
	private String Trader_FirstName;
	private String Trader_LastName;
	private long Trader_Contact;
	
	
	private int TradeUniqueId; 
	private int Trade_Type;
	private String Trade_Date;
	private String Trademod_Timestamp;
	
	
	private long Transaction_Id;
	private int Transaction_Type;
	private int Buy_Sell;
	private long Settlement_Id;
	private String Settlement_Date;
	private String Settlement_Timestamp;
	private int Order_Id;
	private String Order_Timestamp;
	private long Quantity;
	private int Status;
	
	
	private String Cancel_Date;
	private String Cancel_Time;
	private double BID;
	private double ASK;
	private double LTP;
	
	
	private int Country;
	private int Currency;
	private int Exchange;
	private int Sector_Id;
	private int ISIN_Code;
	private long Location_Id;
	
	
	
	
	private String Username;
	private String password;
	public int getCust_Id() {
		return Cust_Id;
	}
	public void setCust_Id(int cust_Id) {
		Cust_Id = cust_Id;
	}
	public String getCust_FirstName() {
		return Cust_FirstName;
	}
	public void setCust_FirstName(String cust_FirstName) {
		Cust_FirstName = cust_FirstName;
	}
	public String getCust_LastName() {
		return Cust_LastName;
	}
	public void setCust_LastName(String cust_LastName) {
		Cust_LastName = cust_LastName;
	}
	public long getCust_Mobile_Number() {
		return Cust_Mobile_Number;
	}
	public void setCust_Mobile_Number(long cust_Mobile_Number) {
		Cust_Mobile_Number = cust_Mobile_Number;
	}
	public long getTrader_Id() {
		return Trader_Id;
	}
	public void setTrader_Id(long trader_Id) {
		Trader_Id = trader_Id;
	}
	public String getTrader_FirstName() {
		return Trader_FirstName;
	}
	public void setTrader_FirstName(String trader_FirstName) {
		Trader_FirstName = trader_FirstName;
	}
	public String getTrader_LastName() {
		return Trader_LastName;
	}
	public void setTrader_LastName(String trader_LastName) {
		Trader_LastName = trader_LastName;
	}
	public long getTrader_Contact() {
		return Trader_Contact;
	}
	public void setTrader_Contact(long trader_Contact) {
		Trader_Contact = trader_Contact;
	}
	public int getTradeUniqueId() {
		return TradeUniqueId;
	}
	public void setTradeUniqueId(int tradeUniqueId) {
		TradeUniqueId = tradeUniqueId;
	}
	public int getTrade_Type() {
		return Trade_Type;
	}
	public void setTrade_Type(int trade_Type) {
		Trade_Type = trade_Type;
	}
	public String getTrade_Date() {
		return Trade_Date;
	}
	public void setTrade_Date(String trade_Date) {
		Trade_Date = trade_Date;
	}
	public String getTrademod_Timestamp() {
		return Trademod_Timestamp;
	}
	public void setTrademod_Timestamp(String trademod_Timestamp) {
		Trademod_Timestamp = trademod_Timestamp;
	}
	public long getTransaction_Id() {
		return Transaction_Id;
	}
	public void setTransaction_Id(long transaction_Id) {
		Transaction_Id = transaction_Id;
	}
	public int getTransaction_Type() {
		return Transaction_Type;
	}
	public void setTransaction_Type(int transaction_Type) {
		Transaction_Type = transaction_Type;
	}
	public int getBuy_Sell() {
		return Buy_Sell;
	}
	public void setBuy_Sell(int buy_Sell) {
		Buy_Sell = buy_Sell;
	}
	public long getSettlement_Id() {
		return Settlement_Id;
	}
	public void setSettlement_Id(long settlement_Id) {
		Settlement_Id = settlement_Id;
	}
	public String getSettlement_Date() {
		return Settlement_Date;
	}
	public void setSettlement_Date(String settlement_Date) {
		Settlement_Date = settlement_Date;
	}
	public String getSettlement_Timestamp() {
		return Settlement_Timestamp;
	}
	public void setSettlement_Timestamp(String settlement_Timestamp) {
		Settlement_Timestamp = settlement_Timestamp;
	}
	public int getOrder_Id() {
		return Order_Id;
	}
	public void setOrder_Id(int order_Id) {
		Order_Id = order_Id;
	}
	public String getOrder_Timestamp() {
		return Order_Timestamp;
	}
	public void setOrder_Timestamp(String order_Timestamp) {
		Order_Timestamp = order_Timestamp;
	}
	public long getQuantity() {
		return Quantity;
	}
	public void setQuantity(long quantity) {
		Quantity = quantity;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public String getCancel_Date() {
		return Cancel_Date;
	}
	public void setCancel_Date(String cancel_Date) {
		Cancel_Date = cancel_Date;
	}
	public String getCancel_Time() {
		return Cancel_Time;
	}
	public void setCancel_Time(String cancel_Time) {
		Cancel_Time = cancel_Time;
	}
	public double getBID() {
		return BID;
	}
	public void setBID(double d) {
		BID = d;
	}
	public double getASK() {
		return ASK;
	}
	public void setASK(double aSK) {
		ASK = aSK;
	}
	public double getLTP() {
		return LTP;
	}
	public void setLTP(double lTP) {
		LTP = lTP;
	}
	public int getCountry() {
		return Country;
	}
	public void setCountry(int country) {
		Country = country;
	}
	public int getCurrency() {
		return Currency;
	}
	public void setCurrency(int currency) {
		Currency = currency;
	}
	public int getExchange() {
		return Exchange;
	}
	public void setExchange(int exchange) {
		Exchange = exchange;
	}
	public int getSector_Id() {
		return Sector_Id;
	}
	public void setSector_Id(int sector_Id) {
		Sector_Id = sector_Id;
	}
	public int getISIN_Code() {
		return ISIN_Code;
	}
	public void setISIN_Code(int iSIN_Code) {
		ISIN_Code = iSIN_Code;
	}
	public long getLocation_Id() {
		return Location_Id;
	}
	public void setLocation_Id(long location_Id) {
		Location_Id = location_Id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}