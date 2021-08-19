/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DeThi;
import View.GiaoVien;
import View.QLDTGV;
import View.QLDeThi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author khoi
 */
public class ctlDeThi {
    private QLDeThi view;
    private QLDTGV view1;
    DefaultListModel dl=new DefaultListModel();
    private ArrayList<DeThi> dt=new DeThi().loadDt();
    private ArrayList<Model.GiaoVien> gv=new Model.GiaoVien().loadGV();
    private String s1="";
    private String s2="";
    private String s3="";
    public ctlDeThi() {
    }

    public ctlDeThi(QLDeThi view) {
        this.view = view;
    }
    
    public ctlDeThi(QLDTGV view1) {
        this.view1 = view1;
    }
    
    public void themDeThi(){
        ArrayList<DeThi> dt=new ArrayList<DeThi>();
        view.getBtnNF().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser jf=new JFileChooser();
                if(jf.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                    File f=jf.getSelectedFile();
                    view.getTxtFile().setText(f.getName());
                    try {
                        Scanner sc=new Scanner(f);
                        while (sc.hasNext()) {
                            DeThi a=new DeThi(sc.nextLine(), sc.nextLine(), sc.nextLine(),
                                    sc.nextLine(), sc.nextLine(), sc.nextLine());
                            dt.add(a);
                        }
                        
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        });
        view.getBtnThemDeThi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DeThi b=new DeThi(view.getComboMon().getSelectedItem().toString(), view.getTxtLoaiBai().getText());
                b.themDeThi(dt);
            }
        });
    }
    
    public void themDeThiGV(){
        ArrayList<DeThi> dtt=new ArrayList<>();
        view1.getTxtFileDe().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                JFileChooser jf=new JFileChooser();
                if(jf.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                    try {
                        File f=jf.getSelectedFile();
                        Scanner sc=new Scanner(f);
                        view1.getTxtFileDe().setText(f.getName());
                        while(sc.hasNext()){
                            DeThi a=new DeThi(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
                            dtt.add(a);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
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
        view1.getBtnThemDeThi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(Model.GiaoVien as:gv){
                    if(as.getMatk().equalsIgnoreCase(maTK())==true){
                        s1=as.getMonday();
                    }
                }
                DeThi b=new DeThi(s1, view1.getComboLoaiBai().getSelectedItem().toString());
                b.themDeThi(dtt);
            }
        });
    }
    
    public void deleteDeThi(){
        view.getBtnXoaDT().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DeThi a=new DeThi(view.getTxtMaDe().getText());
                a.xoaDeThi();
            }
        });
    }
    
    public void loadDeThi(){
        HashSet<String> hs=new HashSet<String>();
        for(DeThi as:dt){
            hs.add(as.getMade());
        }
        for(String as:hs){
            dl.addElement(as.toString());
        }
        view.getListDT().setModel(dl);
    }
    
    public void loadDeThiGV(){
        String s2="";
        HashSet<String> hs=new HashSet<String>();
        for(Model.GiaoVien as:gv){
            if(as.getMatk().equalsIgnoreCase(maTK())==true){
                s2=as.getMonday();
            }
        }
        for(DeThi as:dt){
            if(as.getMon().equalsIgnoreCase(s2)==true && as.getLoaibai().equalsIgnoreCase("Cuối kì")==false){
                hs.add(as.getMade());
            }
        }
        for(String as:hs){
            dl.addElement(as.toString());
        }
        view1.getListDT().setModel(dl);
    }
    
    public void clickList(){
        view.getListDT().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                for(DeThi as:dt){
                    if(as.getMade().equalsIgnoreCase(view.getListDT().getSelectedValue().toString())==true){
                        view.getTxtMon().setText(as.getMon());
                        view.getTxtLB().setText(as.getLoaibai());
                        view.getTxtMaDe().setText(as.getMade());
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
    
    public void clickListDTGV(){
        view1.getListDT().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
               view1.getTxtDeChon().setText(view1.getListDT().getSelectedValue().toString());
            }
            @Override
            public void mousePressed(MouseEvent me) {}
            @Override
            public void mouseReleased(MouseEvent me){}
            @Override
            public void mouseEntered(MouseEvent me) {}
            @Override
            public void mouseExited(MouseEvent me) {}

        });
    }
    
    public void btnTaiXuong(){
        view1.getBtnDownload().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ArrayList<DeThi> dtt=new DeThi(view1.getTxtDeChon().getText()).upLoadDT();
                try {
                    JFileChooser jf=new JFileChooser();
                    if(jf.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
                        File f=jf.getSelectedFile();
                        PrintWriter pr=new PrintWriter(f);
                        for(DeThi as:dtt){
                           pr.println(as.toString());
                        }
                        pr.close();
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
    
    public void deleteDeThiGV(){
        view1.getBtnXoaDT().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DeThi a=new DeThi(view1.getTxtDeChon().getText());
                a.xoaDeThi();
            }
            }
        );
    }
    
    public void updateDTGV(){
        
        ArrayList<DeThi> dtt=new ArrayList<>();
        view1.getTxtFileDe2().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                JFileChooser jf=new JFileChooser();
                if(jf.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                    try {
                        File f=jf.getSelectedFile();
                        Scanner sc=new Scanner(f);
                        view1.getTxtFileDe2().setText(f.getName());
                        while(sc.hasNext()){
                            DeThi a=new DeThi(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
                            dtt.add(a);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
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
        view1.getBtnSuaDT().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(Model.GiaoVien as:gv){
                    if(as.getMatk().equalsIgnoreCase(maTK())==true){
                        s2=as.getMonday();
                    }
                }
                for(DeThi as:dt){
                    if(as.getMade().equalsIgnoreCase(view1.getTxtDeChon().getText())==true){
                        s3=as.getLoaibai();
                    }
                }
                DeThi a=new DeThi(s2, s3);
                a.updateDeThi(dtt, view1.getTxtDeChon().getText());
                
            }
        });
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
