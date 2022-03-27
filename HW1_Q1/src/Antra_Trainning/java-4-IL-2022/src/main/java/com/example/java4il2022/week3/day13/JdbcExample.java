package com.example.java4il2022.week3.day13;

import java.sql.*;

/**
 *  question1:
 *      why do we need to reuse connection?
 *      how to reuse connection?
 *          connection pool
 *      how to impl connection pool?
 *          blocking queue
 *  question2:
 *      what happened if we migrate database from MySQL -> Oracle
 *          centralized query
 *  question3:
 *      object mapping
 *  question4:
 *      memory leak
 *  question5:
 *      student m - 1 teacher
 *      in database:  select * from student => only return students
 *
 *      class Student {
 *          private String id;
 *          private Teacher teacher;
 *      }
 *
 *      class Teacher {
 *          private String id;
 *          private List<Student> list = new ArrayList<>();
 *      }
 *
 *      in backend: select * from student => lazy loading + eager loading
 *          eager loading :
 *          lazy loading :
 *  question6:
 *      what is cache ?
 *
 *      why do we use cache ?
 *
 *      how do we create cache ?
 *          1. local cache
 *          2. global cache
 *      what data should we store in cache ?
 *          1. frequently used data
 *          2.
 *  question7:
 *                      client
 *                         |
 *                    Load Balancer(random, weight, round robin, geo location, ...)
 *                  /           \
 *      node1(payment service)   node2(payment service)
 *         local cache              local cache
 *                  \               /
 *                   global cache (redis)
 *
 */

public class JdbcExample {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/EMP";

    //  Database credentials
    static final String USER = "username";
    static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            //STEP 2: Register JDBC driver -> DriverManager
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            conn.setAutoCommit(false);
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            String sql = "SELECT .... first, last, age FROM Employees";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
            conn.commit();
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            //Handle errors for JDBC
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }//end main
}
