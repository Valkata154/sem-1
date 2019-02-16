package com.napier.sem;

import com.napier.sem.storage.Database;

import java.sql.*;
import java.util.ArrayList;

public class App {

    private static Database db = null;

    public static void main(String[] args) {
        //Create a new Application
        App a = new App();

        db = new Database("mysql://db:3306/employees", "root", "example");

        //Get employee
        Employee emp = a.getEmployee(255530);

        ArrayList<Employee> emps = a.getAllSalaries();

        //Display Employee Details
        if (emp != null) {
            System.out.println(emp);
        }

        //Display employees with salaries
        for(Employee e : emps){
            System.out.println(e.first_name + " " + e.last_name + " - " + e.salary);
        }

        //Disconnect from database
        db.disconnect();
    }

    public Employee getEmployee(int ID) {
        // Execute SQL statement
        ResultSet rset = db.query("SELECT emp_no, first_name, last_name "
                + "FROM employees "
                + "WHERE emp_no = " + ID);
        // Check one is returned
        try {
            if (rset.next()) {
                Employee emp = new Employee();
                emp.emp_no = rset.getInt("emp_no");
                emp.first_name = rset.getString("first_name");
                emp.last_name = rset.getString("last_name");
                return emp;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get employee details");
            return null;
        }
    }

    /**
     * Gets all the current employees and salaries.
     * @return A list of all employees and salaries, or null if there is an error.
     */
    public ArrayList<Employee> getAllSalaries()
    {
        try
        {
            ResultSet rset = db.query("SELECT employees.emp_no, employees.first_name, employees.last_name, salaries.salary "
                    + "FROM employees, salaries "
                    + "WHERE employees.emp_no = salaries.emp_no AND salaries.to_date = '9999-01-01' "
                    + "ORDER BY employees.emp_no ASC");
            // Extract employee information
            ArrayList<Employee> employees = new ArrayList<Employee>();
            while (rset.next())
            {
                Employee emp = new Employee();
                emp.emp_no = rset.getInt("employees.emp_no");
                emp.first_name = rset.getString("employees.first_name");
                emp.last_name = rset.getString("employees.last_name");
                emp.salary = rset.getInt("salaries.salary");
                employees.add(emp);
            }
            return employees;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }
}