/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author khoi
 */
public class GiaoVien {
    private String matk;
    private String matkhau;
    private String ten;
    private String ngaysinh;
    private String gioitinh;
    private String email;
    private String sdt;
    private String monday;
    private String diachi;
    private Connection conn;

    public GiaoVien() {
        try {
            String sql="jdbc:mysql://localhost/qlthi1";
            String user="root";
            String pass="";
            conn=DriverManager.getConnection(sql, user, pass);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public GiaoVien(String matk, String ten, String ngaysinh, String gioitinh, String email, String sdt, String monday, String diachi) {
        this.matk = matk;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.email = email;
        this.sdt = sdt;
        this.monday = monday;
        this.diachi = diachi;
        try {
            String sql="jdbc:mysql://localhost/qlthi1";
            String user="root";
            String pass="";
            conn=DriverManager.getConnection(sql, user, pass);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public String getMatkhau() {
        return matkhau;
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

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    
    private boolean ktraTrung(){
        try {
            String sql="select * from GiaoVien where matk=?";
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
    
    public String themGiaoVien(){
        String s1="";
        try {
            if(ktraTrung()==true){
                JOptionPane.showMessageDialog(null, "Giáo viên đã tồn tại");
            }
            else if(ktraTrung()==false){
                String s="insert into GiaoVien values(?,?,?,?,?,?,?,?)";
                PreparedStatement ps=conn.prepareStatement(s); 
                ps.setString(1, this.matk);
                ps.setString(2, this.ten);
                ps.setString(3, this.ngaysinh);
                ps.setString(4, this.gioitinh);
                ps.setString(5, this.email);
                ps.setString(6, this.sdt);
                ps.setString(7, this.monday);
                ps.setString(8, this.diachi);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                s1="1";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return s1;
    }
    
    public ArrayList<GiaoVien> loadGV(){
        ArrayList<GiaoVien> gv=new ArrayList<>();
        try {
            String sql="select * from GiaoVien";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                GiaoVien a=new GiaoVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                gv.add(a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return gv;
    }
    
    public String updateGV(){
        String s1="";
        try {
            String s="update GiaoVien set ten=?, ngaysinh=?, gioitinh=?, email=?, sdt=?, monday=?, diachi=? where matk=?";
            PreparedStatement ps=conn.prepareStatement(s);
            ps.setString(1, this.ten);
            ps.setString(2, this.ngaysinh);
            ps.setString(3, this.gioitinh);
            ps.setString(4, this.email);
            ps.setString(5, this.sdt);
            ps.setString(6, this.monday);
            ps.setString(7, this.diachi);
            ps.setString(8, this.matk);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa thành công");
            s1="1";
        } catch (Exception e) {
            System.out.println(e);
        }
        return s1;
    }
    
    public String deleteGV(){
        String s1="";
        try {
            String sql="delete from GiaoVien where matk=?";
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
}
