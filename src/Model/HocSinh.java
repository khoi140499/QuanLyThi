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
public class HocSinh {
    private String matk;
    private String ten;
    private String ngaysinh;
    private String gioitinh;
    private String email;
    private String sdt;
    private String lop;
    private String diachi;
    private int khoahoc;
    private Connection conn;

    public HocSinh() {
        Connection();
    }

    public HocSinh(String matk, String ten, String ngaysinh, String gioitinh, String email, String sdt, String lop, String diachi, int khoahoc) {
        this.matk = matk;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.email = email;
        this.sdt = sdt;
        this.lop = lop;
        this.diachi = diachi;
        this.khoahoc = khoahoc;
        Connection();
    }

    public String getMatk() {
        return matk;
    }

    public void setMatk(String matk) {
        this.matk = matk;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getKhoahoc() {
        return khoahoc;
    }

    public void setKhoahoc(int khoahoc) {
        this.khoahoc = khoahoc;
    }
    
    private boolean ktraTrung(){
        try {
            String sql="select * from HocSinh where matk=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, this.matk);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public String themHS(){
        String s1="";
        try {
            if(ktraTrung()==true){
                JOptionPane.showMessageDialog(null, "Học sinh đã tồn tại");
            }
            else if(ktraTrung()==false){
                String s="insert into HocSinh values(?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps=conn.prepareStatement(s); 
                ps.setString(1, this.matk);
                ps.setString(2, this.ten);
                ps.setString(3, this.ngaysinh);
                ps.setString(4, this.gioitinh);
                ps.setString(5, this.email);
                ps.setString(6, this.sdt);
                ps.setString(7, this.lop);
                ps.setString(8, this.diachi);
                ps.setInt(9, this.khoahoc);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                s1="1";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return s1;
    }
    
    public ArrayList<HocSinh> loadHS(){
        ArrayList<HocSinh> hs=new ArrayList<>();
        try {
            String sql="select * from HocSinh";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                HocSinh a=new HocSinh(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
                hs.add(a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return hs;
    }
    
    public String updateHS(){
        String s1="";
        try {
            String sql="update HocSinh set ten=?, ngaysinh=?, gioitinh=?, email=?, sdt=?, lop=?, diachi=?, khoahoc=? where matk=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, this.ten);
            ps.setString(2, this.ngaysinh);
            ps.setString(3, this.gioitinh);
            ps.setString(4, this.email);
            ps.setString(5, this.sdt);
            ps.setString(6, this.lop);
            ps.setString(7, this.diachi);
            ps.setInt(8, this.khoahoc);
            ps.setString(9, this.matk);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa thành công");
            s1="1";
        } catch (Exception e) {
            System.out.println(e);
        }
        return s1;
    }
    
    public String deleteHS(){
        String s1="";
        try {
            String sql="delete from HocSinh where matk=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, this.matk);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công");
            s1="1";
        } catch (Exception e) {
            System.out.println(e);
        }
        return s1;
    }
    
    private void Connection(){
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
