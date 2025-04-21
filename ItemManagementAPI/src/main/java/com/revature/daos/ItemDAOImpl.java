package com.revature.daos;

import com.revature.models.Category;
import com.revature.models.Item;
import com.revature.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO{
    // All of these methods will be implemented to work with our database

    @Override
    public Item save(Item item) {

        try (Connection conn = ConnectionUtil.getConnection()){

            String sql = "INSERT INTO items (name, quantity, category) VALUES (?,?,?) RETURNING *";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getName());
            ps.setInt(2, item.getQuantity());
            ps.setString(3, item.getCategory().toString());

            // Execute query
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                Item newItem = new Item();

                newItem.setItemId(rs.getInt("item_id"));
                newItem.setName(rs.getString("name"));
                newItem.setQuantity(rs.getInt("quantity"));
                newItem.setCategory(Category.valueOf(rs.getString("category")));

                return newItem;
            }

        } catch (SQLException e) {
            System.out.println("Could not save item");
        }

        return null;
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> allItems = new ArrayList<>();

        // Try-With-Resources is a special kind of try-catch block that takes in some resource that can be closed
        // automatically. Basically you should use this anytime you want to close your resource/connection when you've
        // finished with this method

        // Three major steps when we do JDBC
        // Capture the connection
        try (Connection conn = ConnectionUtil.getConnection()){
            // Write the SQL Query
            String sql = "SELECT * FROM Items";

            // Execute the SQL Query
            Statement stmt = conn.createStatement();
            // This Statement object is going to be used to execute the Query
            // We should store the result in a ResultSet
            ResultSet rs = stmt.executeQuery(sql);

            // The ResultSet is a Java object that represents the table that is created with all of our SQL results
            while (rs.next()){
                // The cursor originally starts on the 0th row so we need to call rs.next before attempting to read
                // any results
                // We'll get all of the values for our item with rs.getDatatype("columnName")
                Item item = new Item();

                item.setItemId(rs.getInt("item_id"));
                item.setName(rs.getString("name"));
                item.setQuantity(rs.getInt("quantity"));
                item.setCategory(Category.valueOf(rs.getString("category")));

                allItems.add(item);
            }


        } catch (SQLException e){
            System.out.println("Could not get items");
            return null;
        }




        return allItems;
    }

    @Override
    public Item getItemByItemId(int itemId) {

        try (Connection conn = ConnectionUtil.getConnection()){

            // Write the SQL query
            // This is susceptible to SQL Injection
//            String sql = "SELECT * FROM ITEMS WHERE item_id = " + itemId;

            String sql = "SELECT * FROM ITEMS WHERE item_id = ?";

            // Using a prepared statement prevents SQL injection since the query is defined before any potentially
            // dangerous input comes in as well as it escapes all SQL statements to protect against any inject code
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, itemId);

            // Execute the query
            ResultSet rs = ps.executeQuery();

            // Since this only has 1 result
            // we'll use if (rs.next)

            if (rs.next()){
                Item item = new Item();

                item.setItemId(rs.getInt("item_id"));
                item.setName(rs.getString("name"));
                item.setQuantity(rs.getInt("quantity"));
                item.setCategory(Category.valueOf(rs.getString("category")));

                return item;
            }



        } catch (SQLException e) {
            System.out.println("Could not get item with id: " + itemId);
        }

        return null;
    }

    @Override
    public Item updateItem(Item item) {
        return null;
    }

    @Override
    public boolean deleteItem(int itemId) {
        return false;
    }
}
