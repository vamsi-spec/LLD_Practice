class Employee {
    private int id;
    private String name;
    private double salary;

    Employee(int id,String name,double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class salaryCalculator {
    public void calculateSalary(Employee employee) {
        System.out.println("Calculating salary...");
    }
}

class reportGenerator {
    public void reportGenerator(Employee employee) {
        System.out.println("report generating...");
    }
}

class databaseSave {
    public void savetoDatabase(Employee employee) {
        System.out.println("Saving employee to database...");
    }
}

class EmployeeEmailService {

    public void sendEmail(Employee employee) {
        System.out.println("Sending email to employee...");
    }
}


class SRP {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101,"vamsi",50000);
        salaryCalculator sc = new salaryCalculator();
        sc.calculateSalary(emp1);
        reportGenerator rg = new reportGenerator();
        rg.reportGenerator(emp1);
        databaseSave ds = new databaseSave();
        ds.savetoDatabase(emp1);
        EmployeeEmailService es = new EmployeeEmailService();
        es.sendEmail(emp1);
    }
}