/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author khoi
 */
public class PhongThi {
    private String maphong;
    private String mon;
    private String lop;
    private String thoigianthi;
    private int thoiluongthi;
    private String giobatdau;
    private String made;
    private Connection conn;
    
    public PhongThi() {
        connect();
    }
    
    public PhongThi(String maphong, String mon, String lop, String thoigianthi, int thoiluongthi, String giobatdau, String made) {
        this.maphong = maphong;
        this.mon = mon;
        this.lop = lop;
        this.thoigianthi = thoigianthi;
        this.thoiluongthi = thoiluongthi;
        this.giobatdau = giobatdau;
        this.made = made;
        connect();
    }

    public PhongThi(String maphong) {
        this.maphong = maphong;
        connect();
    }
    
    public String getMaphong() {
        return maphong;
    }
    
    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getThoigianthi() {
        return thoigianthi;
    }

    public void setThoigianthi(String thoigianthi) {
        this.thoigianthi = thoigianthi;
    }

    public int getThoiluongthi() {
        return thoiluongthi;
    }

    public void setThoiluongthi(int thoiluongthi) {
        this.thoiluongthi = thoiluongthi;
    }

    public String getGiobatdau() {
        return giobatdau;
    }

    public void setGiobatdau(String giobatdau) {
        this.giobatdau = giobatdau;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }
    
    private boolean ktraTrung(){
        try {
            String sql="select * from PhongThi where maphong=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, this.maphong);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public void themPhongThi(){
        try {
            if(ktraTrung()==true){
                JOptionPane.showMessageDialog(null, "Phòng thi đã tồn tại");
            }
            else if(ktraTrung()==false){
                String sql="insert into PhongThi values(?,?,?,?,?,?,?)";
                PreparedStatement ps=conn.prepareStatement(sql);
                ps.setString(1, this.maphong);
                ps.setString(2, this.mon);
                ps.setString(3, this.lop);
                ps.setString(4, this.thoigianthi);
                ps.setInt(5, this.thoiluongthi);
                ps.setString(6, this.giobatdau);
                ps.setString(7, this.made);
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null, "Thêm thành công");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void uoadtePT(){
        try {
            String sql="update PhongThi set lop=?, thoigianthi=?, thoiluongthi=?, giobatdau=? where maphong=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, this.lop);
            ps.setString(2, this.thoigianthi);
            ps.setInt(3, this.thoiluongthi);
            ps.setString(4, this.giobatdau);
            ps.setString(5, this.maphong);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Sửa thành công");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void deletePT(){
        try {
            String sql="delete from PhongThi where maphong=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, this.maphong);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<PhongThi> loadPt(){
        ArrayList<PhongThi> pt=new ArrayList<>();
        try {
            String sql="select * from PhongThi";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                PhongThi a=new PhongThi(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getString(6), rs.getString(7));
                pt.add(a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return pt;
    }
    
    public void connect(){
        try {
            String sql="jdbc:mysql://localhost/qlthi1";
            String user="root";
            String pass="";
            conn=DriverManager.getConnection(sql, user, pass);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
