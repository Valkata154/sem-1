package com.napier.sem;

/**
 * Represents an employee
 */
public class Employee {
    /**
     * Employee number
     */
    public int emp_no;

    /**
     * Employee's first name
     */
    public String first_name;

    /**
     * Employee's last name
     */
    public String last_name;

    /**
     * Employee's job title
     */
    public String title;

    /**
     * Employee's salary
     */
    public int salary;

    /**
     * Employee's current department
     */
    public Department dept;

    /**
     * Employee's manager
     */
    public Employee manager;

    public String toString() {
        return emp_no + " "
                + first_name + " "
                + last_name + "\n"
                + title + "\n"
                + "Salary:" + salary + "\n"
                + dept.name + "\n"
                + "Manager: " + manager.first_name + " " + manager.last_name + "\n";
    }
}
