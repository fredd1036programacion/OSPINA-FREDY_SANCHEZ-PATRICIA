package com.proyectoIntegrador.dentalClinic.dao;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/eliIntegrador5", "sa", "sa");
    }

    public static Connection create() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");

        /*String sqlFilePath = "dentalClinic/dentalClinic/create.sql";

        String currentDirectory = System.getProperty("user.dir");
        String absoluteSqlPath = currentDirectory + File.separator + sqlFilePath;

        absoluteSqlPath = absoluteSqlPath.replace("\\","/");

       return DriverManager.getConnection("jdbc:h2:~/eliIntegrador;INIT=RUNSCRIPT FROM '" + absoluteSqlPath + "'", "sa", "sa");
       */

        return DriverManager.getConnection("jdbc:h2:~/eliIntegrador5;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");
    }
}
