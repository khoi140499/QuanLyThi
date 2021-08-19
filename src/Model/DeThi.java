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
public class DeThi {
    private String made;
    private String mon;
    private String loaibai;
    private String cauhoi;
    private String daA;
    private String daB;
    private String daC;
    private String daD;
    private String daDung;
    private Connection conn;

    public DeThi() {
        Connec();
    }

    public DeThi(String made, String mon, String loaibai, String cauhoi, String daA, String daB, String daC, String daD, String daDung) {
        this.made = made;
        this.mon = mon;
        this.loaibai = loaibai;
        this.cauhoi = cauhoi;
        this.daA = daA;
        this.daB = daB;
        this.daC = daC;
        this.daD = daD;
        this.daDung = daDung;
    }
    
    public DeThi(String cauhoi, String daA, String daB, String daC, String daD, String daDung) {
        this.cauhoi = cauhoi;
        this.daA = daA;
        this.daB = daB;
        this.daC = daC;
        this.daD = daD;
        this.daDung = daDung;
        
    }
    
    public DeThi(String mon, String loaibai){
        this.mon = mon;
        this.loaibai = loaibai;
        Connec();
    }
    
    public DeThi(String made){
        this.made = made;
        Connec();
    }

    public String getMade() {
        return made;
    }

    public String getMon() {
        return mon;
    }

    public String getLoaibai() {
        return loaibai;
    }

    public String getCauhoi() {
        return cauhoi;
    }

    public String getDaA() {
        return daA;
    }

    public String getDaB() {
        return daB;
    }

    public String getDaC() {
        return daC;
    }

    public String getDaD() {
        return daD;
    }

    public String getDaDung() {
        return daDung;
    }

    public void setMade(String made) {
        this.made = made;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public void setLoaibai(String loaibai) {
        this.loaibai = loaibai;
    }

    public void setCauhoi(String cauhoi) {
        this.cauhoi = cauhoi;
    }

    public void setDaA(String daA) {
        this.daA = daA;
    }

    public void setDaB(String daB) {
        this.daB = daB;
    }

    public void setDaC(String daC) {
        this.daC = daC;
    }

    public void setDaD(String daD) {
        this.daD = daD;
    }

    public void setDaDung(String daDung) {
        this.daDung = daDung;
    }
    
    public void themDeThi(ArrayList<DeThi> dt1){
        ArrayList<DeThi> dt=new DeThi().loadDt();
        try {
            for(DeThi as:dt1){
                String sql="insert into DThi(made, mon,loaibai, cauhoi, daA, daB, daC, daD, daDung) values(?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps=conn.prepareStatement(sql);
                ps.setString(1, "DT"+dt.size());
                ps.setString(2, this.mon);
                ps.setString(3, this.loaibai);
                ps.setString(4, as.getCauhoi());
                ps.setString(5, as.getDaA());
                ps.setString(6, as.getDaB());
                ps.setString(7, as.getDaC());
                ps.setString(8, as.getDaD());
                ps.setString(9, as.getDaDung());
                ps.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void updateDeThi(ArrayList<DeThi> dt1, String made){
        try {
            String sql="delete from DThi where made=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, made);
            ps.executeUpdate();
            ps.close();
            
            for(DeThi as:dt1){
                String sql1="insert into DThi(made, mon,loaibai, cauhoi, daA, daB, daC, daD, daDung) values(?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps1=conn.prepareStatement(sql1);
                ps1.setString(1, made);
                ps1.setString(2, this.mon);
                ps1.setString(3, this.loaibai);
                ps1.setString(4, as.getCauhoi());
                ps1.setString(5, as.getDaA());
                ps1.setString(6, as.getDaB());
                ps1.setString(7, as.getDaC());
                ps1.setString(8, as.getDaD());
                ps1.setString(9, as.getDaDung());
                ps1.executeUpdate();
                ps1.close();
            }
            JOptionPane.showMessageDialog(null, "Sửa thành công");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void xoaDeThi(){
        try {
            String sql="delete from DThi where made=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, this.made);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<DeThi> loadDt(){
        ArrayList<DeThi> dt=new ArrayList<>();
        try {
            String sql="select * from DThi";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                DeThi a=new DeThi(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
                dt.add(a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return dt;
    }
    
    public ArrayList<DeThi> upLoadDT(){
        ArrayList<DeThi> dt=new ArrayList();
        try {
            String sql="select cauhoi, daA, daB, daC, daD, daDung from DThi where made=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, this.made);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                DeThi a=new DeThi(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                dt.add(a);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return dt;
    }
    
    private void Connec(){
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
        return this.cauhoi+"\r\n"+this.daA+"\r\n"+this.daC+"\r\n"+this.daB+"\r\n"+this.daD+"\r\n"+this.daDung;
    }
    
}
