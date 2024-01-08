package com.mahendra;

import java.sql.*;

public class App 
{
    private static final String URL="jdbc:mysql://sampledb.cimr0kdyqj64.us-east-1.rds.amazonaws.com:3306/sampledb";
    private static final String user = "admin";
    private static final String password = "Password!123";
    public static void main( String[] args )
    {
        Connection con = null;

        //Phase 1 : Load JDBC Driver 
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println("Unable to load JDBC Driver for MySQL");
            return;
        }
        
        //Phase 2 : Connect
        try{
            con = DriverManager.getConnection(App.URL, App.user, App.password);
            System.out.println("Connected to database....");   
        }catch(SQLException ex){
            System.out.println("Unable to connect database : "+ex.getMessage());
            return;
        }

        //Phase 3 : Execute Query and collect results

        try{
            Statement st = con.createStatement();
            ResultSet rs  = st.executeQuery("select * from employees");
            System.out.println("Fetching results...");
            while(rs.next()){
                System.out.println(rs.getInt(1)+", "+rs.getString(2)+", "+rs.getString(3));
            }
            System.out.println("-------------------------");
        }catch(SQLException ex){
            System.out.println("Query execution failed : "+ex.getMessage());
        }finally{
            try{
            con.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
}
