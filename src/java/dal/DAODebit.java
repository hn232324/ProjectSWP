/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Debit;

/**
 *
 * @author Manh
 */
public class DAODebit extends DBContext {

    public List<Debit> getAll() {
        List<Debit> list = new ArrayList<>();
        String sql = "select * from Accounts";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Debit d = new Debit(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getLong(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10));
                list.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public int countAll() {
        String sql = "select count(*) from Debit";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<Debit> pagingDebit(int indexD, int indexD1) {
        List<Debit> debitList = new ArrayList<Debit>();
        String sql = "select * from Debit"
                + "order by id "
                + "offset ? rows fetch next ? rows only;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, (indexD - 1) * 5);
            st.setInt(2, (indexD1 + 4));
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Debit d = new Debit(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getLong(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10));

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return debitList;
    }

}
