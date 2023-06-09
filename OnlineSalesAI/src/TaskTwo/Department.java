package TaskTwo;

public class Department {

	private int id;
    private String name;
    private double averageSalary;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(double averageSalary) {
        this.averageSalary = averageSalary;
    }

	
}
