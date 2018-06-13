
//extends the CommissionCompensationModel class, per the instructions
public class BasePlusCommissionCompensationModel extends CommissionCompensationModel {

	private double base;
	
	public BasePlusCommissionCompensationModel(double base, double grossSales, double commissionRate) {
		
		super(grossSales, commissionRate);
		this.base = base;	
	}
	
	@Override
	public double earnings() {
		
		return base + super.earnings();
	}
}
