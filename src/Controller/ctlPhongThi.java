/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DeThi;
import Model.GiaoVien;
import Model.HocSinh;
import Model.PhongThi;
import View.LichThi;
import View.QLDeThi;
import View.QLPhongThi;
import View.TaoPT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khoi
 */
public class ctlPhongThi {
    private QLPhongThi view;
    private LichThi view2;
    private TaoPT view1;
    DefaultTableModel dm=new DefaultTableModel();
    private ArrayList<PhongThi> pt=new PhongThi().loadPt();
    private ArrayList<HocSinh> hs=new HocSinh().loadHS();
    private ArrayList<DeThi> dt=new DeThi().loadDt();
    private ArrayList<GiaoVien> gv=new GiaoVien().loadGV();
    private String s1="";
    public ctlPhongThi() {
    }

    public ctlPhongThi(QLPhongThi view) {
        this.view = view;
    }

    public ctlPhongThi(LichThi view2) {
        this.view2 = view2;
    }
    

    public ctlPhongThi(TaoPT view1) {
        this.view1 = view1;
    }
    
    private void tb(String s){
        try {
            throw new StringIndexOutOfBoundsException(s+" không được để trống");
        } catch (StringIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private String ktraNS(String s){
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        sf.setLenient(false);
        try {
            sf.parse(s);
        } catch (ParseException e) {
            s="1";
        }
        return s;
    }
    
    public void themPT(){
        view.getBtnThemPT().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if(view.getTxtMaPhong().getText().isEmpty()){
                        tb("Mã phòng");
                    }
                    else if(ktraNS(view.getTxtThoiGianThi().getText()).equals("1")==true){
                        JOptionPane.showMessageDialog(null, "Ngày phải có định dạng yyyy-MM-dd");
                    }
                    else if(Integer.parseInt(view.getTxtThoiLuongThi().getText())<=0){
                        try {
                            throw new Exception("Thời lượng thi phải lớn 0");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else if(view.getTxtGioBatDau().getText().isEmpty()){
                        tb("Giờ bắt đầu");
                    }
                    else {
                        PhongThi a=new PhongThi(view.getTxtMaPhong().getText(), view.getComboTenMon().getSelectedItem().toString(), view.getComboLop().getSelectedItem().toString(), view.getTxtThoiGianThi().getText(),
                        Integer.parseInt(view.getTxtThoiLuongThi().getText()), view.getTxtGioBatDau().getText(), view.getComboMaDe().getSelectedItem().toString());
                        a.themPhongThi();
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Không được nhập chuỗi vào ô thời lượng thi");
                }
            }
        });
    }
    
    public void uoadtePT(){
        view.getBtnSuaPT().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if(view.getTxtMaPhong().getText().isEmpty()){
                        tb("Mã phòng");
                    }
                    else if(ktraNS(view.getTxtThoiGianThi().getText()).equals("1")==true){
                        JOptionPane.showMessageDialog(null, "Ngày phải có định dạng yyyy-MM-dd");
                    }
                    else if(Integer.parseInt(view.getTxtThoiLuongThi().getText())<=0){
                        try {
                            throw new Exception("Thời lượng thi phải lớn 0");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else if(view.getTxtGioBatDau().getText().isEmpty()){
                        tb("Giờ bắt đầu");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Không được nhập chuỗi vào ô thời lượng thi");
                }
                PhongThi a=new PhongThi(view.getTxtMaPhong().getText(), view.getComboTenMon().getSelectedItem().toString(), view.getComboLop().getSelectedItem().toString(), view.getTxtThoiGianThi().getText(),
                        Integer.parseInt(view.getTxtThoiLuongThi().getText()), view.getTxtGioBatDau().getText(), view.getComboMaDe().getSelectedItem().toString());
                a.uoadtePT();
            }
        });
    }
    
    public void deletePT(){
        view.getBtnXoaPT().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PhongThi a=new PhongThi(view.getTxtMaPhong().getText());
                a.deletePT();
            }
        });
    }
    
    public void loadPT(){
        Vector a=new Vector();
        Vector b=new Vector();
        a.add("Mã phòng");
        a.add("Môn");
        a.add("Lớp");
        a.add("Thời gian thi");
        a.add("Thời lượng thi");
        a.add("Giờ bắt đầu");
        a.add("Mã đề");
        dm=(DefaultTableModel)view.getTbPhongThi().getModel();
        dm.setDataVector(b, a);
        
        for(PhongThi as:pt){
            Vector c=new Vector();
            c.add(as.getMaphong());
            c.add(as.getMon());
            c.add(as.getLop());
            c.add(as.getThoigianthi());
            c.add(as.getThoiluongthi());
            c.add(as.getGiobatdau());
            c.add(as.getMade());
            b.add(c);
        }
        view.getTbPhongThi().updateUI();
    }
    
    public void clickPT(){
        view.getTbPhongThi().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                int r=view.getTbPhongThi().getSelectedRow();
                view.getTxtMaPhong().setText(view.getTbPhongThi().getValueAt(r, 0).toString());
                view.getTxtThoiGianThi().setText(view.getTbPhongThi().getValueAt(r, 3).toString());
                view.getTxtThoiLuongThi().setText(view.getTbPhongThi().getValueAt(r, 4).toString());
                view.getTxtGioBatDau().setText(view.getTbPhongThi().getValueAt(r, 5).toString());
                for(int i=0;i<view.getComboTenMon().getItemCount();i++){
                    if(view.getComboTenMon().getItemAt(i).toString().equals(view.getTbPhongThi().getValueAt(r, 1).toString())==true){
                        view.getComboTenMon().setSelectedIndex(i);
                    }
                }
                for(int i=0;i<view.getComboLop().getItemCount();i++){
                    if(view.getComboLop().getItemAt(i).toString().equals(view.getTbPhongThi().getValueAt(r, 2).toString())==true){
                        view.getComboLop().setSelectedIndex(i);
                    }
                }
                for(int i=0;i<view.getComboMaDe().getItemCount();i++){
                    if(view.getComboMaDe().getItemAt(i).toString().equals(view.getTbPhongThi().getValueAt(r, 6).toString())==true){
                        view.getComboMaDe().setSelectedIndex(i);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {}

            @Override
            public void mouseReleased(MouseEvent me) {}

            @Override
            public void mouseEntered(MouseEvent me) {}

            @Override
            public void mouseExited(MouseEvent me) {}
        });
    }
    
    public void loadCB(){
        HashSet<String> hss=new HashSet<String>();
        HashSet<String> hsp=new HashSet<String>();
        for(HocSinh as:hs){
            hss.add(as.getLop());
        }
        view.getComboLop().removeAllItems();
        for(String as:hss){
           view.getComboLop().addItem(as.toString());
        }
    }
    
    public void loadMaDe(){
        view.getComboTenMon().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                HashSet<String> hs=new HashSet<String>();
                int n=0;
                String s="";
                for(int i=0;i<view.getComboTenMon().getSelectedIndex();i++){
                    n=view.getComboTenMon().getSelectedIndex();
                    s=view.getComboTenMon().getItemAt(n).toString();
                }
                for(DeThi as:dt){
                    if(as.getMon().equalsIgnoreCase(s)==true
                        && as.getLoaibai().equalsIgnoreCase("Cuối kì")==true){
                    hs.add(as.getMade());
                    }
                }
                view.getComboMaDe().removeAllItems();
                for(String as:hs){
                    view.getComboMaDe().addItem(as.toString());
                }
            }
        });
    }
    
    public void loadCB1(){
        view1.getComboLop().removeAllItems();
        view1.getComboMaDe().removeAllItems();
        HashSet<String> has=new HashSet<>();
        HashSet<String> has1=new HashSet<>();
        for(HocSinh as:hs){
            has.add(as.getLop());
        }
        for(String as:has){
            view1.getComboLop().addItem(as.toString());
        }
        for(GiaoVien as:gv){
            if(as.getMatk().equalsIgnoreCase(maTK())==true){
                s1=as.getMonday();
            }
        }
        for(DeThi as:dt){
            if(as.getMon().equalsIgnoreCase(s1)==true && as.getLoaibai().equalsIgnoreCase("Cuối kì")==false){
                has1.add(as.getMade());
            }
        }
        for(String as:has1){
            view1.getComboMaDe().addItem(as.toString());
        }
    }
    
    public void taoPTGV(){
        view1.getBtnTaoPT().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(GiaoVien as:gv){
                    if(as.getMatk().equalsIgnoreCase(maTK())==true){
                        s1=as.getMonday();
                    }
                }
                try {
                    if(view1.getTxtMaPhong().getText().isEmpty()){
                        tb("Mã phòng");
                    }
                    else if(ktraNS(view1.getTxtThoiGianThi().getText()).equals("1")==true){
                        JOptionPane.showMessageDialog(null, "Ngày phải có định dạng yyyy-MM-dd");
                    }
                    else if(Integer.parseInt(view1.getTxtThoiLuongThi().getText())<=0){
                        try {
                            throw new Exception("Thời lượng thi phải lớn 0");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else if(view1.getTxtGioBatDau().getText().isEmpty()){
                        tb("Giờ bắt đầu");
                    }
                    else{
                        PhongThi a=new PhongThi(view1.getTxtMaPhong().getText(), s1,
                                view1.getComboLop().getSelectedItem().toString(), view1.getTxtThoiGianThi().getText(),
                        Integer.parseInt(view1.getTxtThoiLuongThi().getText()), view1.getTxtGioBatDau().getText(),
                                view1.getComboMaDe().getSelectedItem().toString());
                        a.themPhongThi();
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Không được nhập chuỗi vào ô thời lượng thi");
                }
            }
        });
    }
    
    public void loadLichThi(){
        String s1="";
        Vector a=new Vector();
        Vector b=new Vector();
        a.add("Mã phòng");
        a.add("Môn");
        a.add("Thời gian thi");
        a.add("Thời lượng thi");
        a.add("Giờ bắt đầu");
        a.add("Mã đề");
        dm=(DefaultTableModel)view2.getTbLichThi().getModel();
        dm.setDataVector(b, a);
        for(HocSinh as:hs){
            if(as.getMatk().equalsIgnoreCase(maTK())==true){
                s1=as.getLop();
            }
        }
        for(PhongThi as:pt){
            if(as.getLop().equalsIgnoreCase(s1)==true){
                Vector c=new Vector();
                c.add(as.getMaphong());
                c.add(as.getMon());
                c.add(as.getThoigianthi());
                c.add(as.getThoiluongthi());
                c.add(as.getGiobatdau());
                c.add(as.getMade());
                b.add(c);
            }
        }
        view2.getTbLichThi().updateUI();
    }
    
    private String maTK(){
        String s1 = null, s2,s3;
        try {
            File f=new File("user.txt");
            Scanner sc=new Scanner(f);
            while(sc.hasNext()){
                s1=sc.nextLine();
                s2=sc.nextLine();
                s3=sc.nextLine();
            }
        } catch (Exception e) {
        }
        return s1;
    }
}
