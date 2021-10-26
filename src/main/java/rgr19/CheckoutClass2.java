package rgr26;

public class CheckoutClass2 extends AbstractCheckoutClass2 {
	
	public CheckoutClass2(String rateType) {
		if (rateType == "физик") {
			setRate1(3.46);
			setRate2(3.02);
		}
		if (rateType == "льготник") {
			setRate1(2.02);
			setRate2(1.73);
			
		}
		if (rateType == "юрик") {
			setRate1(4.08);
			setRate2(2.98);
		}
	}
	
	@Override
	public double calculateAmount() {
		
		double amountToPay = (meterNow1 - meterLast1) * rate1 + (meterNow2 - meterLast2) * rate2;
		return amountToPay;
		
	}

}