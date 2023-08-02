package entities;

public class ImportedProduct extends Product {
	private Double customsFee;
	
	public ImportedProduct() {
		super();
	}
  
	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}	
	
	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}

	@Override
	public final String priceTag() {
		return super.priceTag();
	}
	
	public final Double totalPrice() {
		return price+customsFee;
	}

	@Override
	public String toString() {
		return name + " $ " + String.format("%.2f", totalPrice()) +  " (Customs fee: $ " + String.format("%.2f", customsFee) + ")\n";
	}	
}
