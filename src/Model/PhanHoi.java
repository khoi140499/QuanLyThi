/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author khoi
 */
public class PhanHoi {
    private String mang;
    private String mann;
    private String nd;
    private int tt;
    private Connection conn;
    public PhanHoi() {
        Connect();
    }

    public PhanHoi(String mang, String mann, String nd, int tt) {
        this.mang = mang;
        this.mann = mann;
        this.nd = nd;
        this.tt = tt;
        Connect();
    }
    
    public PhanHoi(String mang, String mann) {
        this.mang = mang;
        this.mann = mann;
        Connect();
    }

    public String getMang() {
        return mang;
    }

    public String getMann() {
        return mann;
    }

    public String getNd() {
        return nd;
    }

    public int getTt() {
        return tt;
    }
    
    public void guiPH(){
        try {
            String sql="insert into PhanHoi(mang, mann, nd, tt) values(?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, this.mang);
            ps.setString(2, this.mann);
            ps.setString(3, this.nd);
            ps.setInt(4, this.tt);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Gửi thành công");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void updatePH(){
        try {
            String sql="update PhanHoi set tt=? where mang=? and mann=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, 2);
            ps.setString(2, this.mang);
            ps.setString(3, this.mann);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<PhanHoi> loadPH(){
        ArrayList<PhanHoi> ph=new ArrayList<>();
        try {
            String sql="select * from PhanHoi";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                PhanHoi a=new PhanHoi(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                ph.add(a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ph;
    }
    
    private void Connect(){
        try {
            String sql="jdbc:mysql://localhost/qlthi1";
            String user="root";
            String pass="";
            conn=DriverManager.getConnection(sql, user, pass);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return this.mang+": "+this.nd+"\r\n";
    }
    
    
}
