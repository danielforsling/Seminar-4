package model.DTO;

import model.POS.Sale;

/**
 * The class represents the receipt that will be printed.
 *
 */
public class Receipt {

	private SaleInformation saleInfo;
	
	/**
	 * Creates a new instance by using the {@link SaleInformation}.
	 * @param saleInfo contains information about the {@link Sale}.
	 */
	public Receipt(SaleInformation saleInfo) {
		this.saleInfo = saleInfo;
	}
	
	/**
	 * Returns the <code>String</code>-representation of this instance. Will be used when 
	 * printing the receipt.  
	 */
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("-------Receipt-------\n");
		sb.append(saleInfo.getItemListAsString());
		sb.append("---------------------\n");
		sb.append("VAT: " + saleInfo.getTotalVAT());
		sb.append("\nTotal Price: "+saleInfo.getTotalPrice().getFinalPrice());
		sb.append("\nAmount paid: "+saleInfo.getAmountPaid());
		sb.append("\nChange: "+ saleInfo.getChange());
		sb.append("\n---------------------");
		sb.append("\nTime of sale: ");
		sb.append(getHourAndMinute()+"\n");
		sb.append("Date: ");
		sb.append(saleInfo.getDate()+"\n");
		sb.append("---------------------\n");
		sb.append("Thank you for shopping\n@ FAKE STORE™");
		
		return sb.toString();
		
	}
	
	private String getHourAndMinute() {
		return saleInfo.getSaleTime().getHour()+":"+saleInfo.getSaleTime().getMinute();
	}
	
}
