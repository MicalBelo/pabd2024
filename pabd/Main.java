/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pabd;

import java.sql.*;

/**
 *
 * @author 20221074010025
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Customer c = new Customer(1, "dalai", "lama", "dalai@microsoft.com", 10, 1);

        //Customer c2 = new Customer()
        CustomerDAO dao = new CustomerDAO();
        //dao.insertCustomer(c);
        dao.updateCustomer(0);
        dao.showCustomer();
        dao.deleteCustomer(0);

        Connection con = null;

        try {

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.close();
            System.out.println("Connection Closed!");
        }

//tentativa, captura, finaliza conexão 
//st = executar consulta       
//rs.get colunas
//conectar
//statemente - query insert delete update
//leitura - query executa armazena conjunto de dadps resoltset
//rs.next(); for                 
//inserir atualizar e remover objeto      
//rs.next(); for                 
//inserir a
    }

}
