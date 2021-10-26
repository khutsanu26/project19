package rgr26;

public abstract class AbstractCheckoutClass2 {
	double meterNow2; // Текущие показание счётчика 1
	double meterLast2; // Предыдущие показания счётчика 1
	double rate2; // Тариф 2
	double meterNow1; // Текущие показание счётчика 1
	double meterLast1; // Предыдущие показания счётчика 1
	double rate1; // Тариф 1

	public void setMeterNow1(double num) {
		this.meterNow1 = num;
	}

	public void setMeterNow2(double num) {
		this.meterNow2 = num;
	}

	public void setMeterLast1(double num) {

		this.meterLast1 = num;
	}

	public void setMeterLast2(double num) {

		this.meterLast2 = num;
	}

	public void setRate1(double rate) {
		this.rate1 = rate;
	}

	public void setRate2(double rate) {
		this.rate2 = rate;
	}

	public double calculateAmount() {
		return 0;
	}
}
