package org.com.jdbc_integration.dao;

import org.com.jdbc_integration.config.DatabaseConnection;

import java.sql.*;

public class ProductDao {

    public void createTable() {
        String sql = "Create table if not exists product(id int auto_increment primary key,name varchar(100)," +
                "price double,quantity int)";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stm = conn.createStatement();) {

            stm.execute(sql);
            System.out.println("Table created successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void insertRecord(String name, double price, int quantity) {
        String sql = "insert into product(name,price,quantity) values(?,?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql);) {

            stm.setString(1,name);
            stm.setDouble(2,price);
            stm.setInt(3,quantity);
            stm.executeUpdate();
            System.out.println("Record inserted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void getAllRecords(){
        String sql = "select * from product";

        try(Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);){

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getInt(4));
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void updateRecord(int id,String name,double price,int quantity){

        String sql = "update product set name = ?, price = ?, quantity = ? where id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);){

            stm.setString(1,name);
            stm.setDouble(2,price);
            stm.setInt(3,quantity);
            stm.setInt(4,id);

            int rows = stm.executeUpdate();

            if(rows > 0){
                System.out.println("Record updated successfully");
            }else{
                System.out.println("Record not updated");
            }


        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRecord(int id) {
        String sql = "delete from product where id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, id);

            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Record deleted successfully");
            } else {
                System.out.println("No record found with id " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getRecordById(int id) {
        String sql = "SELECT * FROM product WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setInt(1, id);

            try (ResultSet rs = stm.executeQuery()) {

                boolean found = false;

                while (rs.next()) {
                    found = true;
                    int rowId = rs.getInt("id");
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    System.out.println(rowId + " " + name + " " + price + " " + quantity);
                }

                if (!found) {
                    System.out.println("No record found with id " + id);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
