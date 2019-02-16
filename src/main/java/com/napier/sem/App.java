package com.napier.sem;

import com.napier.sem.storage.Database;

import java.sql.*;

public class App {

    private static Database db = null;

    public static void main(String[] args) {
        //Create a new Application
        App a = new App();

        db = new Database("mysql://db:3306/employees", "root", "example");

        //Get employee
        Employee emp = a.getEmployee(255530);

        //Display Employee Details
        if (emp != null) {
            System.out.println(emp);
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
}