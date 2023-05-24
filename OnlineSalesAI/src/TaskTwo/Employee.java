package TaskTwo;

public class Employee {
	 private int id;
	    private String name;
	    private int departmentId;

	    public Employee(int id, String name, int departmentId) {
	        this.id = id;
	        this.name = name;
	        this.departmentId = departmentId;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
			this.id = id;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setDepartmentId(int departmentId) {
			this.departmentId = departmentId;
		}

		public String getName() {
	        return name;
	    }

	    public int getDepartmentId() {
	        return departmentId;
	    }
}
