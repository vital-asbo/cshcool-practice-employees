package spring.employees;

import lombok.Data;

@Data
public class Emp {
    private int id;
    private String name;
    private float salary;
    private String designation;
    private String email;

    public Emp(int id, String name, float salary, String designation, String email) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.designation = designation;
        this.email = email;
    }

    public Emp() {}

}
