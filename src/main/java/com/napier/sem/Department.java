package com.napier.sem;


/**
 * Department Class
 */
public class Department {

    /**
      * Department number
     */
    public int dept_no;

    /**
     *  Department name
     */
    public String name;

    /**
     * Manager
     */
    public Employee manager;

    public String toString() {
        return dept_no + " \n"
                + name + " \n"
                + manager.first_name + " \n"
                + manager.last_name + "\n";
    }








}
