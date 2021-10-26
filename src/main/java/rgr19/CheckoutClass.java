package rgr26;

public class CheckoutClass extends AbstractCheckoutClass {
	
	public CheckoutClass(String rateType) {
		if (rateType == "физик") setRate(3.33);
		if (rateType == "льготник") setRate(1.92);
		if (rateType == "юрик") setRate(3.85);
	}
	
	@Override
	public double calculateAmount() {
		double amountToPay = (meterNow - meterLast) * rate;
		return amountToPay;
	}
	
}
