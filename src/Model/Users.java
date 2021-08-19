/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.Admin;
import View.GiaoVien;
import View.HocSinh;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author khoi
 */
public class Users {
    private String matk;
    private String matkhau;
    private int quyen;
    private Connection conn;
    public Users() {
        try {
            String sql="jdbc:mysql://localhost/qlthi1";
            String user="root";
            String pass="";
            conn=(Connection) DriverManager.getConnection(sql, user, pass);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Users(String matk, String matkhau) {
        this.matk = matk;
        this.matkhau = matkhau;
        try {
            String sql="jdbc:mysql://localhost/qlthi1";
            String user="root";
            String pass="";
            conn=(Connection) DriverManager.getConnection(sql, user, pass);
        } catch (Exception e) {
            System.out.println(e);
        }
    }    
    
    public Users(String matk, String matkhau, int quyen) {
        this.matk = matk;
        this.matkhau = matkhau;
        this.quyen = quyen;
        try {
            String sql="jdbc:mysql://localhost/qlthi1";
            String user="root";
            String pass="";
            conn=(Connection) DriverManager.getConnection(sql, user, pass);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getMatk() {
        return matk;
    }

    public void setMatk(String matk) {
        this.matk = matk;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getQuyen() {
        return quyen;
    }

    public void setQuyen(int quyen) {
        this.quyen = quyen;
    }
    
    public String checkLogin(){
        String s3="";
        try {
            String sql="select * from TaiKhoan where matk=? and matkhau=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, this.matk);
            ps.setString(2, this.matkhau);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                if(rs.getInt(4)==1){
                    new Admin().setVisible(true);
                    s3="1";
                }
                else if(rs.getInt(4)==2){
                    new GiaoVien().setVisible(true);
                    s3="1";
                }
                else if(rs.getInt(4)==3){
                    new HocSinh().setVisible(true);
                    s3="1";
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Sai thông tin đăng nhập");
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return s3;
    }
    
    public void themUser(){
        try {
            String sql="insert into TaiKhoan(matk,matkhau,quyen) values(?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, this.matk);
            ps.setString(2, this.matkhau);
            ps.setInt(3, this.quyen);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void updateUser(){
        try {
            String sql="update TaiKhoan set matkhau=? where matk=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, this.matkhau);
            ps.setString(2, this.matk);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<Users> loadUser(){
        ArrayList<Users> us=new ArrayList<>();
        try {
            String sql="select * from TaiKhoan";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                Users a=new Users(rs.getString(2), rs.getString(3));
                us.add(a);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return us;
    }
    
    public void deleteUser(){
        try {
            String sql="delete from TaiKhoan where matk=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, this.matk);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
