package TaskTwo;

public class Salary {

	private int employeeId;
    private int month;
    private double amount;

    public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Salary(int employeeId, int month, double amount) {
        this.employeeId = employeeId;
        this.month = month;
        this.amount = amount;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getMonth() {
        return month;
    }

    public double getAmount() {
        return amount;
    }
	
}
