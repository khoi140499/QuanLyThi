/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DiemThi;
import Model.GiaoVien;
import View.DiemMon;
import View.QLDiemHS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khoi
 */
public class ctlDiemThi {
    private QLDiemHS view;
    private DiemMon view1;
    private View.DiemThi view2;
    private ArrayList<DiemThi> dt=new DiemThi().loadDT();
    private ArrayList<GiaoVien> gv=new GiaoVien().loadGV();
    DefaultTableModel dm=new DefaultTableModel();
    private String s1="";
    public ctlDiemThi() {
    }

    public ctlDiemThi(QLDiemHS view) {
        this.view = view;
    }

    public ctlDiemThi(DiemMon view1) {
        this.view1 = view1;
    }

    public ctlDiemThi(View.DiemThi view2) {
        this.view2 = view2;
    }
    
    public void loadDS(){
        Vector a=new Vector();
        Vector b=new Vector();
        a.add("Tên");
        a.add("Môn");
        a.add("Điểm 15p");
        a.add("Điểm 45p");
        a.add("Điểm cuối kì");
        dm=(DefaultTableModel)view.getTbDiemHS().getModel();
        dm.setDataVector(b, a);
        view.getBtnHienDS().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ArrayList<DiemThi> dt1=new DiemThi().hienDT(view.getTxtLop().getText());
                for(DiemThi as:dt1){
                    Vector c=new Vector();
                    c.add(as.getMatk());
                    c.add(as.getMon());
                    c.add(as.getDiem15());
                    c.add(as.getDiem45());
                    c.add(as.getDiemck());
                    b.add(c);
                }
                view.getTbDiemHS().updateUI();
            }
        });
    }
    
    public void loadDTGV(){
        Vector a=new Vector();
        Vector b=new Vector();
        a.add("Tên");
        a.add("Điểm 15p");
        a.add("Điểm 45p");
        a.add("Điểm cuối kì");
        dm=(DefaultTableModel)view1.getTbDiemHS().getModel();
        dm.setDataVector(b, a);
        view1.getBtnHienDS().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ArrayList<DiemThi> dt1=new DiemThi().hienDT(view1.getTxtLop().getText());
                for(GiaoVien as:gv){
                    if(as.getMatk().equalsIgnoreCase(maTK())==true){
                        s1=as.getMonday();
                    }
                }
                for(DiemThi as:dt1){
                    if(as.getMon().equalsIgnoreCase(s1)==true){
                        Vector c=new Vector();
                        c.add(as.getMatk());
                        c.add(as.getDiem15());
                        c.add(as.getDiem45());
                        c.add(as.getDiemck());
                        b.add(c);
                    }
                }
                view1.getTbDiemHS().updateUI();
            }
        });
    }
    
    public void xemDiemThi(){
        Vector a=new Vector();
        Vector b=new Vector();
        a.add("Môn");
        a.add("Điểm 15p");
        a.add("Điểm 45p");
        a.add("Điểm cuối kì");
        dm=(DefaultTableModel)view2.getTbXemDS().getModel();
        dm.setDataVector(b, a);
        for(DiemThi as:dt){
            if(as.getMatk().equalsIgnoreCase(maTK())==true){
                Vector c=new Vector();
                c.add(as.getMon());
                c.add(as.getDiem15());
                c.add(as.getDiem45());
                c.add(as.getDiemck());
                b.add(c);
            }
        }
        view2.getTbXemDS().updateUI();
    }
    
    public void addDT(){
        
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
