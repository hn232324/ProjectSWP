/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Debit;

/**
 *
 *
 */
public class DAO extends DBContext {

    public void add(Debit d) {
        try {

            String sql = "INSERT INTO [dbo].[Debit]\n"
                    + "           ([name]\n"
                    + "           ,[address]\n"
                    + "           ,[phone]\n"
                    + "           ,[email]\n"
                    + "           ,[total]\n"
                    + "           ,[crday]\n"
                    + "           ,[uday]\n"
                    + "           ,[aid])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, d.getName());
            st.setString(2, d.getAddress());
            st.setInt(3, d.getPhone());
            st.setString(4, d.getEmail());
            st.setDouble(5, d.getTotal());
            st.setString(6, d.getCrday());
            st.setString(7, d.getUday());
            st.setInt(8, d.getAid());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void update(Debit d) {
        try {

            String sql = "UPDATE Debit\n"
                    + "SET name = ?, address = ?, phone = ?, email = ?, uday = ?, aid = ?\n"
                    + "WHERE id=?;";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, d.getName());
            st.setString(2, d.getAddress());
            st.setInt(3, d.getPhone());
            st.setString(4, d.getEmail());
            st.setString(5, d.getUday());
            st.setInt(6, d.getAid());
            st.setInt(7, d.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

}
