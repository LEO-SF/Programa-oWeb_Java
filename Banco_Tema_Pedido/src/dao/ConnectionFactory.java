package dao;

import java.sql.*;

public class ConnectionFactory {
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String urlBD = "jdbc:mysql://localhost:3306/bd";
            return DriverManager.getConnection(urlBD, "root", "");
        }catch (SQLException e)  {
            System.out.println("Exceção SQL" + e.getMessage() + "\n" + "Verificar classe ConnectionFactory.java");
        }catch (ClassNotFoundException e) {
            System.out.println("Exceção Classe não encontrada:" + e.getMessage() + "\n" + "Verificar classe ConnectionFactory.java");
        }
        return null;
    }
}