package com.rc.porms.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionHelper {
    public static String URL = "jdbc:oracle:thin:@localhost:1521:rogate";
    /**
     * The Oracle driver.
     */
    public static String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    /**
     * The username used to connect to the database.
     */
    public static String username = "prefect";
    /**
     * The password used to connect to the database.
     */
    public static String password = "Changeme2024";

    private static Logger LOGGER = LoggerFactory.getLogger(ConnectionHelper.class);

    /**
     * This method gets the connection from an Oracle database instance.
     */
    public static Connection getConnection() throws RuntimeException {
        try {
            Class.forName(ORACLE_DRIVER).newInstance();
            return DriverManager.getConnection(URL, username, password);
        } catch (ClassNotFoundException ex) {
            LOGGER.error("Error has occurred. Driver not found." + ex.getMessage());
        } catch (InstantiationException | IllegalAccessException ex) {
            LOGGER.error("Error has occurred. Cannot create a database instance." + ex.getMessage());
        } catch (SQLException ex) {
            LOGGER.error("Error has occurred. Cannot connect to the database." + ex.getMessage());
        }
        return null;
    }
}
