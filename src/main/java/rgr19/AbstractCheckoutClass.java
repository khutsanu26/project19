package rgr26;

public abstract class AbstractCheckoutClass {
	double meterNow; // Текущие показание счётчика 1
	double meterLast; // Предыдущие показания счётчика 1
	double rate; // Тариф 1

	public void setMeterNow(double num) {
		this.meterNow = num;
	}

	public void setMeterLast(double num) {

		this.meterLast = num;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double calculateAmount() {
		return 0;
	}
}
