package oldFashionPound;

import java.util.Objects;

public class UkOldPriceWithReminder extends UkOldPrice{
	
	private int shillingsReminder;
	private int penceReminder;
	
	public int getShillingsReminder() {
		return shillingsReminder;
	}

	public void setShillingsReminder(int shillingsReminder) {
		this.shillingsReminder = shillingsReminder;
	}
	
	public int getPenceReminder() {
		return penceReminder;
	}

	public void setPenceReminder(int penceReminder) {
		this.penceReminder = penceReminder;
	}
	
	public UkOldPriceWithReminder() {
		super();
		this.shillingsReminder=0;
		this.penceReminder =0;
	}
	
	public UkOldPriceWithReminder(UkOldPrice ukOldPrice) {
		super(ukOldPrice.getPounds(), ukOldPrice.getShillings(), ukOldPrice.getPence());
		this.shillingsReminder=0;
		this.penceReminder =0;
	}
	
	public UkOldPriceWithReminder(UkOldPrice ukOldPrice, int reminder) {
		super(ukOldPrice.getPounds(), ukOldPrice.getShillings(), ukOldPrice.getPence());
		
		this.shillingsReminder=reminder/UkOldPrice.SHILLING_TO_PENCE;
		this.penceReminder=reminder- (shillingsReminder*UkOldPrice.SHILLING_TO_PENCE);
		 

	}
	
	public UkOldPriceWithReminder(int pounds, int shillings, int pence, int shillingsReminder, int penceReminder) {
		super(pounds, shillings, pence);
		
		this.shillingsReminder=shillingsReminder;
		this.penceReminder=penceReminder;
		

	}
	
	public UkOldPriceWithReminder(int pounds, int shillings, int pence) {
		super(pounds, shillings, pence);
		
		this.shillingsReminder=0;
		this.penceReminder=0;
		

	}	
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(this.getIsPositive()==false)
			sb.append("- ");
			
			
		sb.append(this.getPounds() + "p ");
		sb.append(this.getShillings() + "s ");
		sb.append(this.getPence() + "d");

		if(this.shillingsReminder!=0 || this.penceReminder!=0) {
			sb.append(" (");
			if(this.shillingsReminder!=0) {
				sb.append(this.shillingsReminder + "s");
			}
			if(this.shillingsReminder!=0 && this.penceReminder!=0) {
				sb.append(" ");
			}
			
			if(this.penceReminder!=0) {
				sb.append(this.penceReminder + "d");
			}
			sb.append(")");
		}
			
		
		return sb.toString();

	}
	
	
	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;

		if (other == this)
			return true;

		if (!(other instanceof UkOldPriceWithReminder))
			return false;

		UkOldPriceWithReminder otherPrezzo = (UkOldPriceWithReminder) other;

		return otherPrezzo.getPounds() == getPounds() && otherPrezzo.getShillings() == getShillings()
				&& otherPrezzo.getPence() == getPence() && otherPrezzo.getShillingsReminder() == getShillingsReminder()  && otherPrezzo.getPenceReminder() == getPenceReminder();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getPounds(), getShillings(), getPence(), getShillingsReminder(), getPenceReminder());
	}	
	

}
