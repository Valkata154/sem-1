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

        //Display first 1000 employees with salaries - otherwise list is too long
        for (int i = 0; i < 1000; i++) {
            Employee e = emps.get(i);
            System.out.println(e.first_name + " " + e.last_name + " - " + e.salary);
        }

        //Get Salaries by title - first 1000 Engineers
        System.out.println("ENGINEERS:");
        ArrayList<Employee> empsbytitle = new ArrayList<>();
        empsbytitle = a.getEmployeeByRole("Engineer");
        for (int i = 0; i < 1000; i++) {
            Employee e = emps.get(i);
            System.out.println(e.first_name + " " + e.last_name + " " + e.salary);
        }


        //Get Salary by epartment



        //Disconnect from database
        db.disconnect();
    }

    //Method to get employee by their ID
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

    //Method to get Department by its' name
    public Department getDepartment(String name) {
        //Execute SQL Statement
        ResultSet rset = db.query("SELECT dept_no, dept_name, emp_no "
                + "FROM departments, dept_manager, employees "
                + "WHERE departments.dept_no = dept_manager.dept_no "
                + "AND dept_manager.emp_no = employees.emp_no "
                + "AND dept_name = " + name);
        try {
            if(rset.next()) {
                Department dept = new Department();
                dept.dept_no = rset.getInt("dept_no");
                dept.name = rset.getString("dept_name");
                dept.manager = getEmployee(rset.getInt("emp_no"));
                return dept;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Department details");
            return null;
        }
    }

    /**
     * Gets all the current employees and salaries.
     *
     * @return A list of all employees and salaries, or null if there is an error.
     */
    private ArrayList<Employee> getAllSalaries() {
        try {
            ResultSet rset = db.query("SELECT employees.emp_no, employees.first_name, employees.last_name, salaries.salary "
                    + "FROM employees, salaries "
                    + "WHERE employees.emp_no = salaries.emp_no AND salaries.to_date = '9999-01-01' "
                    + "ORDER BY employees.emp_no ASC");
            // Extract employee information
            ArrayList<Employee> employees = new ArrayList<Employee>();
            createEmployee(rset, employees);
            return employees;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }


    public ArrayList<Employee> getEmployeeByRole (String title) {
        try {
            ResultSet rset = db.query("SELECT employees.emp_no, employees.first_name, employees.last_name, salaries.salary " +
                    "FROM employees, salaries, titles " +
                    "WHERE employees.emp_no = salaries.emp_no " +
                    "AND employees.emp_no = titles.emp_no " +
                    "AND salaries.to_date = '9999-01-01' " +
                    "AND titles.to_date = '9999-01-01' " +
                    "AND titles.title = '"+title+"' " +
                    "ORDER BY employees.emp_no ASC");
            ArrayList<Employee> employees = new ArrayList<>();
            createEmployee(rset, employees);
            return employees;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }

    private ArrayList<Employee> getSalariesByDepartment(int dept_no) {
        try {
            ResultSet rset = db.query("SELECT employees.emp_no, employees.first_name, employees.last_name, salaries.salary " +
                    "FROM employees, salaries, dept_emp, departments " +
                    "WHERE employees.emp_no = salaries.emp_no " +
                    "AND employees.emp_no = dept_emp.emp_no " +
                    "AND dept_emp.dept_no = departments.dept_no " +
                    "AND salaries.to_date = '9999-01-01' " +
                    "AND departments.dept_no = '"+dept_no+"' " +
                    "ORDER BY employees.emp_no ASC");
            // Extract employee information
            ArrayList<Employee> employees = new ArrayList<Employee>();
            createEmployee(rset, employees);
            return employees;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }


    private void createEmployee(ResultSet rset, ArrayList<Employee> employees) throws SQLException {
        while (rset.next()) {
            Employee emp = new Employee();
            emp.emp_no = rset.getInt("employees.emp_no");
            emp.first_name = rset.getString("employees.first_name");
            emp.last_name = rset.getString("employees.last_name");
            emp.salary = rset.getInt("salaries.salary");
            employees.add(emp);
        }
    }
}