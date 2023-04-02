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
public class DAOAccount extends DBContext {

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String sql = "select * from Accounts";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account p = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Debit> pagingDebit(int index, int aid) {
        List<Debit> list = new ArrayList<>();
        String sql = " SELECT *\n"
                + "FROM [Debit]\n"
                + "WHERE aid = ?\n"
                + "ORDER BY aid\n"
                + "OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, aid);
            st.setInt(2, (index - 1) * 5);
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

    public int getTotalDebit(int aid) {
        String sql = " select count(*) from Debit Where aid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, aid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return 0;
    }

    public Debit getIdByDept(int id) {
        String sql = "select * from Debit where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Debit dept = new Debit();
                dept.setId(rs.getInt("id"));
                dept.setName(rs.getString("name"));
                dept.setAddress(rs.getString("address"));
                dept.setPhone(rs.getInt("phone"));
                dept.setEmail(rs.getString("email"));
                dept.setTotal(rs.getLong("total"));
                dept.setCrday(rs.getString("crday"));
                dept.setUday(rs.getString("uday"));
                dept.setAid(rs.getInt("aid"));
                dept.setNote(rs.getString("note"));

                return dept;
            }

        } catch (Exception e) {
        }
        return null;
    }

    public void updateDept(Debit dept, int id) {
        String sql = "Update Debit\n"
                + " SET [name] = ?,\n"
                + "      [address] =? ,\n"
                + "      [phone] = ?,\n"
                + "      [email] = ?,\n"
                + "      [total] = ?,\n"
                + "      [crday] = ?,\n"
                + "      [uday] = ?,\n"
                + "      [aid] = ?,\n"
                + "      [note] = ?\n"
                + "     where id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, dept.getName());
            st.setString(2, dept.getAddress());
            st.setInt(3, dept.getPhone());
            st.setString(4, dept.getEmail());
            st.setDouble(5, dept.getTotal());
            st.setString(6, dept.getCrday());
            st.setString(7, dept.getUday());
            st.setInt(10, id);
            st.setString(9, dept.getNote());
            st.setInt(8, dept.getAid());

            st.executeUpdate();

        } catch (Exception e) {
        }

    }

    public void UpdateInfor(String id, String fullname, String phone_num, String description) {
        String sql = "update Accounts set fullname= ? , phone_num = ?, description= ? where id = ? ";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);

            pre.setString(1, fullname);
            pre.setString(2, phone_num);
            pre.setString(3, description);
            pre.setString(4, id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Account> getAccountbyid(int id) {
        List<Account> list = new ArrayList<>();
        String sql = "select * from Accounts where id =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account p = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Debit> getAll() {
        List<Debit> list = new ArrayList<>();
        String sql = "select * from Debit";
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

    public Account check(String user, String pass) {

        String sql = " select * from Accounts"
                + " WHERE [usename] = ? and password = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
            }
        } catch (SQLException e) {

        }
        return null;
    }

    public int check(String usename) {
        String sql = "select * from Accounts where usename = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, usename);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int a = rs.getInt("id");
                return a;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return 0;
    }

    public Account checkExist(String user) {

        String sql = " select * from Accounts"
                + " WHERE [usename] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                return new Account(rs.getInt("id"),
                        rs.getString("usename"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("fullname"),
                        rs.getString("phone_num"),
                        rs.getString("description"),
                        rs.getInt("role"));

            }
        } catch (SQLException e) {

        }
        return null;
    }

    public void checkSignup(String user, String pass, String email) {

        String sql = " INSERT INTO [dbo].[Accounts] ([usename],[password],[email],role) VALUES(?,?,?,2);";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            st.setString(3, email);
            st.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public Account checkAccByEmail(String email) {
        String sql = "select * from Accounts where email = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                Account a = new Account(rs.getInt("id"),
                        rs.getString("usename"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("fullname"),
                        rs.getString("phone_num"),
                        rs.getString("description"),
                        rs.getInt("role"));
                return a;

            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public Account checku(String usename) {
        String sql = "select * from Accounts where usename = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, usename);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                Account a = new Account(rs.getInt("id"),
                        rs.getString("usename"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("fullname"),
                        rs.getString("phone_num"),
                        rs.getString("description"),
                        rs.getInt("role"));
                return a;

            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public void insert(String user, String pass) {
        String sql = "INSERT INTO [dbo].[Accounts] VALUES(?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, user);
            st.setString(2, pass);
            st.setInt(3, 2);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateRole(int role, int id) {
        String sql = "UPDATE [dbo].[Accounts]\n"
                + "   SET [role] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, role);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Account getAccountById(int id) {
        String sql = "select * from Accounts where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                Account a = new Account(rs.getInt("id"),
                        rs.getString("usename"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("fullname"),
                        rs.getString("phone_num"),
                        rs.getString("description"),
                        rs.getInt("role"));

                return a;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public boolean checkMailExist(String email) {
        String sql = "select * from Accounts where email = ? ";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, email);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {

                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Account checkmail(String usename, String email) {
        String sql = "select * from Accounts where usename =? and email =?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, usename);
            pre.setString(2, email);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                DAOAccount da = new DAOAccount();
                Account u = new Account(rs.getInt("id"),
                        rs.getString("usename"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("fullname"),
                        rs.getString("phone_num"),
                        rs.getString("description"),
                        rs.getInt("role"));
                return u;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int getIdByUsername(String usename) {
        String sql = "select * from Accounts where usename = ? ";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, usename);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public Account getAccount(int id) {
        String sql = "select * from Accounts  where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                Account a = new Account(rs.getInt("id"),
                        rs.getString("usename"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("fullname"),
                        rs.getString("phone_num"),
                        rs.getString("description"),
                        rs.getInt("role"));
                return a;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void updateActive(Account a) {
        String sql = "update Accounts set active = 1 where id = ? ";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, a.getId());
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateinfom(Account a) {
        String sql = "update Accounts set fullname=? , phone_num=? , description = ? where id = ? ";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, a.getId());
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void UpdatePassAndRole(Account a) {
        String sql = "update Accounts set password= ?, role= ? where id = ? ";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, a.getPassword());
            pre.setInt(2, a.getRole());
            pre.setInt(3, a.getId());

            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean checkPhoneExist(String phone_num) {
        String sql = "select * from Accounts where phone_num = ? ";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, phone_num);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {

                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Account getUser(int id) {
        String sql = "select * from Accounts where id = ? ";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                Account a = new Account(rs.getInt("id"),
                        rs.getString("usename"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("fullname"),
                        rs.getString("phone_num"),
                        rs.getString("description"),
                        rs.getInt("role"));
                return a;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void UpdateInfor(Account a) {
        String sql = "update Accounts set fullname= ? , phone_num = ?, description= ?, email = ? where id = ? ";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(5, a.getId());
            pre.setString(1, a.getFullname());
            pre.setString(2, a.getPhone_num());
            pre.setString(3, a.getDescription());
            pre.setString(4, a.getEmail());
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Debit> getDebitbyaid(int id) {
        List<Debit> list = new ArrayList<>();
        String sql = " select * from Debit WHERE aid= ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
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

    public List<Debit> getCreditByEmail(String email) {
        List<Debit> list = new ArrayList<>();
        String sql = " Select * from Debit where email = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
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

    public static void main(String[] args) {
        DAOAccount p = new DAOAccount();
        List<Debit> l = p.getDebitbyaid(1);

    }

    public void ChangePass(String email, String pass) {
        String sql = "update Accounts set password = ? where email = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(2, email);
            pre.setString(1, pass);
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
