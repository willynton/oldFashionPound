package oldFashionPound;

import java.util.Objects;

public class UkOldPrice {
	private int pounds;
	private int shillings;
	private int pence;
	
	private boolean IsPositive;
	

	public final static int POUND_TO_SHILLINGS = 20;
	public final static int SHILLING_TO_PENCE = 12;
	public final static int POUND_TO_PENCE = SHILLING_TO_PENCE * POUND_TO_SHILLINGS;
	
	public int getPounds() {
		return pounds;
	}

	public void setPounds(int pounds) {
		this.pounds = pounds;
	}

	public int getShillings() {
		return shillings;
	}

	public void setShillings(int shillings) {
		this.shillings = shillings;
	}

	public int getPence() {
		return pence;
	}

	public void setPence(int pence) {
		this.pence = pence;
	}
	
	public boolean getIsPositive() {
		return this.IsPositive;
	}

	public void setIsPositive(boolean IsPositive) {
		this.IsPositive = IsPositive;
	}
	
	
	public UkOldPrice(){
		this.pounds=0;
		this.shillings=0;
		this.pence=0;
		IsPositive=true;
	}
	
	public UkOldPrice(int pounds, int shillings, int pence ){
		if(pounds<0) 
			IsPositive=false;
		else
			IsPositive=true;
		this.pounds=Math.abs(pounds);
		this.shillings=Math.abs(shillings);
		this.pence=Math.abs(pence);
	}
	
	public UkOldPrice(int pence ){
		if(pence<0) 
			IsPositive=false;
		else
			IsPositive=true;
		pence=Math.abs(pence);
		this.pounds=pence/POUND_TO_PENCE;
		pence = pence - (pounds*POUND_TO_PENCE);
		this.shillings=pence/SHILLING_TO_PENCE;
		this.pence=pence- (shillings*SHILLING_TO_PENCE);
		
	}
	
	public UkOldPrice(String arg ){

		arg=arg.trim();
		
		String[] parts = arg.toLowerCase().split(" ");
		String[] partsOK = new String[3];
		

		int j=0;
		for(int i =0; i<parts.length;i++) {
			if(!parts[i].trim().equals("")) {
					partsOK[j]=parts[i].trim();
					j++;
			}
					
		}		

			
		String pounds=partsOK[0].substring(0,partsOK[0].length()-1);
		String shillings=partsOK[1].substring(0,partsOK[1].length()-1);
		String pence=partsOK[2].substring(0,partsOK[2].length()-1);
		
		this.pounds=Integer.parseInt(pounds);
		this.shillings=Integer.parseInt(shillings);
		this.pence=Integer.parseInt(pence);

		IsPositive=true;
	}
	
	
	
	public int getTotalPence() {
		
		int totalPence= this.pounds*POUND_TO_PENCE+  this.shillings*SHILLING_TO_PENCE +  this.pence;
		if(IsPositive==false) {
			totalPence=totalPence*-1;
		}
		return totalPence;
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(this.IsPositive==false)
			sb.append("- ");
			
			
		sb.append(this.pounds + "p ");
		sb.append(this.shillings + "s ");
		sb.append(this.pence + "d");

		return sb.toString();

	}
	 
	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;

		if (other == this)
			return true;

		if (!(other instanceof UkOldPrice))
			return false;

		UkOldPrice otherPrice = (UkOldPrice) other;

		return otherPrice.getPounds() == pounds && otherPrice.getShillings() == shillings
				&& otherPrice.getPence() == pence;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pounds, shillings, pence);
	}	
	
	
	
}
