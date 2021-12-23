package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

	
	//objeto de coneccao com o banco de dados DO JDBC
    private static Connection conn = null;

    
    //metodo para conectar com db
    public static Connection getConnection() {
        if (conn == null) {
            try {
            	//propriedades do banco de dados. metodo static
                Properties props = loadProperties();
                //url do meu db
                String url = props.getProperty("dburl");
                //obtendo coneccao, instanciando um objeto do tipo Connection 
                conn = DriverManager.getConnection(url, props);
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    
    //Metodo que coloca o arquivo em uma variavel 
    //Instaciamos o Objeto Properties e usamos o metodo load para ler o arquivo em memoria "fs"
    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }
    
    
    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}