package com.napier.sem;

import com.napier.sem.storage.Database;

import javax.swing.text.DefaultEditorKit;
import java.sql.*;
import java.util.ArrayList;

public class App {

    private static Database db = null;

    public static void main(String[] args) {
        //Create a new Application
        App a = new App();

        db = new Database("mysql://db:3306/employees", "root", "albert-sapo");

        //Disconnect from database
        db.disconnect();
    }
}