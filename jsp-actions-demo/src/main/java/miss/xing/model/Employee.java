package miss.xing.model;

import java.io.Serializable;

public class Employee extends Person implements Serializable {

    private Integer salary = 1000;

    public Employee(){
        System.out.println("Employee().......");
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
