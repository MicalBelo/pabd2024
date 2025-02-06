/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pabd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 20221074010025
 */
public class CustomerDAO {
    //conectar banco reazlizar finalizr conexao

    private Connection con;

    public CustomerDAO() throws SQLException {
        this.con = new ConnectionFactory().getConnection();
        System.out.println("Connection OK!");
        Statement st = con.createStatement();

        String query = "select * from customer order by customer_id desc limit 10   ";

        ResultSet rs = st.executeQuery(query);

        //matadados da resposta o que é cada dado nome colunas quantidade tipo 
        ResultSetMetaData md = rs.getMetaData();

        //metadados
        int col = md.getColumnCount();

        for (int i = 1; i < col; i++) {
            System.out.println(md.getColumnName(i) + "\t");
        }
        System.out.println("");

        while (rs.next()) {
            for (int i = 1; i <= col; i++) {

                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println("");
        }

        st.close();
        con.close();
    }

    public void insertCustomer(Customer c) throws SQLException {
        String sql = "insert into customer"
                + " (store_id, first_name, last_name, email, address_id, active)"
                + "values"
                + " (?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, 1);
        pst.setString(2, "Mical");
        pst.setString(3, "Belo");
        pst.setString(4, "micaloliveira17@gmail.com");
        pst.setInt(5, 1);
        pst.setInt(6, 1);

        pst.execute();
        pst.close();
        System.out.println("Customer added!");

    }

    public void deleteCustomer(int id) throws SQLException {
        String sql = "delete from customer where customer_id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        pst.execute();
        pst.close();
        System.out.println("");

    }

    public void updateCustomer(int id) {

    }

    public void showCustomer() {

    }

}
