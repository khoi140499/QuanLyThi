/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author khoi
 */
public class DiemThi {
    private String matk;
    private String mon;
    private float diem15;
    private float diem45;
    private float diemck;
    private Connection conn;
    public DiemThi() {
        Connect();
    }

    public DiemThi(String matk, String mon, float diem15, float diem45, float diemck) {
        this.matk = matk;
        this.mon = mon;
        this.diem15 = diem15;
        this.diem45 = diem45;
        this.diemck = diemck;
        Connect();
    }

    public String getMatk() {
        return matk;
    }

    public String getMon() {
        return mon;
    }

    public float getDiem15() {
        return diem15;
    }

    public float getDiem45() {
        return diem45;
    }

    public float getDiemck() {
        return diemck;
    }
    
    public ArrayList<DiemThi> loadDT(){
        ArrayList<DiemThi> dt=new ArrayList<DiemThi>();
        try {
            String sql="select * from DiemThi";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                DiemThi a=new DiemThi(rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6));
                dt.add(a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return dt;
    }
    
    public ArrayList<DiemThi> hienDT(String lop){
        ArrayList<DiemThi> dt=new ArrayList<DiemThi>();
        try {
            String sql="SELECT HocSinh.ten , DiemThi.mon, DiemThi.diem15, DiemThi.diem45,DiemThi.diemck FROM DiemThi, HocSinh WHERE DiemThi.matk=HocSinh.matk AND HocSinh.lop=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, lop);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                DiemThi a=new DiemThi(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getFloat(5));
                dt.add(a);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return dt;
    }
    
    private boolean ktra(String masv, String mon){
        ArrayList<DiemThi> dt=new ArrayList<DiemThi>();
        try {
            String sql="select * from DiemThi";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                DiemThi a=new DiemThi(rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6));
                dt.add(a);
            }
            
            for(DiemThi ass:dt){
                if(ass.getMatk().equalsIgnoreCase(masv)==true && ass.getMon().equalsIgnoreCase(mon)==true){
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public void themDiemThi(String s1, String s2, float s3, String loaibai){
        try{
            if(ktra(s1, s2)==true){
                if(loaibai.equalsIgnoreCase("15 phút")==true){
                    String sql="update DiemThi set diem15=? where matk=? and mon=?";
                    PreparedStatement ps=conn.prepareStatement(sql);
                    ps.setFloat(1, s3);
                    ps.setString(2, s1);
                    ps.setString(3, s2);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Nop de thanh cong");
                }
                else if(loaibai.equalsIgnoreCase("45 phút")==true){
                    String sql="update DiemThi set diem45=? where matk=? and mon=?";
                    PreparedStatement ps=conn.prepareStatement(sql);
                    ps.setFloat(1, s3);
                    ps.setString(2, s1);
                    ps.setString(3, s2);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Nop de thanh cong");
                }
                else if(loaibai.equalsIgnoreCase("cuối kì")==true){
                    String sql="update DiemThi set diemck=? where matk=? and mon=?";
                    PreparedStatement ps=conn.prepareStatement(sql);
                    ps.setFloat(1, s3);
                    ps.setString(2, s1);
                    ps.setString(3, s2);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Nop de thanh cong"); 
                }
            }
            else{
                if(loaibai.equalsIgnoreCase("15 phút")==true){
                    String sql="insert into DiemThi(matk, mon, diem15 , diem45, diemck) values(?,?,?,?,?)";
                    PreparedStatement ps=conn.prepareStatement(sql);
                    ps.setString(1, s1);
                    ps.setString(2, s2);
                    ps.setFloat(3, s3);
                    ps.setFloat(4, 0);
                    ps.setFloat(5, 0);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Nop de thanh cong");
                }
                else if(loaibai.equalsIgnoreCase("45 phút")==true){
                    String sql="insert into DiemThi(matk, mon, diem15 , diem45, diemck) values(?,?,?,?,?)";
                    PreparedStatement ps=conn.prepareStatement(sql);
                    ps.setString(1, s1);
                    ps.setString(2, s2);
                    ps.setFloat(3, 0);
                    ps.setFloat(4, s3);
                    ps.setFloat(5, 0);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Nop de thanh cong");
                }
                else if(loaibai.equalsIgnoreCase("cuối kì")==true){
                    String sql="insert into DiemThi(matk, mon, diem15 , diem45, diemck) values(?,?,?,?,?)";
                    PreparedStatement ps=conn.prepareStatement(sql);
                    ps.setString(1, s1);
                    ps.setString(2, s2);
                    ps.setFloat(3, 0);
                    ps.setFloat(4, 0);
                    ps.setFloat(5, s3);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Nop de thanh cong");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
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
}
