/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DeThi;
import Model.DiemThi;
import Model.HocSinh;
import Model.PhongThi;
import View.VaoThi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author khoi
 */
public class ctlVaoThi {
    private VaoThi view;
    private ArrayList<Model.HocSinh> hs=new Model.HocSinh().loadHS();
    private ArrayList<PhongThi> pt=new PhongThi().loadPt();
    private ArrayList<DeThi> dt=new DeThi().loadDt();
    private ArrayList<String> ar=new ArrayList<>();
    private int m;
    private int f=0;
    private String g="";
    private String ch="";
    private String ctl="";
    private int n=0;
    public ctlVaoThi() {
    }

    public ctlVaoThi(VaoThi view) {
        this.view = view;
    }
    
    public void ktraMaPhong(){
        view.getBtnVaoPhong().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(PhongThi as:pt){
                    if(as.getMaphong().equalsIgnoreCase(view.getTxtNhapMaPhong().getText())==true){
                        view.getTxtLop().setText(as.getLop());
                        view.getTxtMonThi().setText(as.getMon());
                        view.getTxtMaDe().setText(as.getMade());
                        m=as.getThoiluongthi();
                        g=as.getMade();
                    }
                }
                for(HocSinh as:hs){
                    if(as.getMatk().equalsIgnoreCase(maTK())==true){
                        view.getTxtTenHS().setText(as.getTen());
                    }
                }
                Thread th=new Thread(){
                  @Override
                  public void run(){
                        int n=0;
                        for(int i=0;i<m*60;i++){
                            if(i<10){
                                view.getTxtThoiGian().setText(n+":0"+i);
                                } 
                            else{
                                view.getTxtThoiGian().setText(n+":"+i+"");
                                if(i>59){
                                    n=n+1;
                                    i=0;
                                    view.getTxtThoiGian().setText(n+":"+i);
                                    if(n<10){
                                        view.getTxtThoiGian().setText("0"+n+":0"+i);
                                        }
                                    }
                                }
                            if(n*60+i==m*60){
                                nopBai();
                                view.getBtnNext().setEnabled(false);
                                break;
                                }
                            try {
                                sleep(1000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(VaoThi.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }  
                };
                th.start();
                
                for(DeThi as:dt){
                    if(as.getMade().equalsIgnoreCase(g)==true){
                        ar.add(as.getCauhoi());
                        view.getTxtLoaiBai().setText(as.getLoaibai());
                    }
                }
        
                for(int i=0;i<ar.size();i++){
                    view.getTxtCauHoi().setText(ar.get(0));
                    ch=ar.get(0);
                    f=0;
                }
        
                for(DeThi as:dt){
                    if(as.getCauhoi().equalsIgnoreCase(ch)==true){
                        view.getCkA().setText(as.getDaA());
                        view.getCkB().setText(as.getDaB());
                        view.getCkC().setText(as.getDaC());
                        view.getCkD().setText(as.getDaD());
                    }
                }
            }
        });
    }
    
    public void nextKT(){
        view.getBtnNext().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(DeThi as:dt){
            if(as.getMade().equalsIgnoreCase(g)==true){
                if(as.getCauhoi().equalsIgnoreCase(ch)==true){
                    if(view.getCkA().isSelected()==true){
                        ctl=view.getCkA().getText();
                        }
                    if(view.getCkB().isSelected()==true){
                        ctl=view.getCkB().getText();
                        }
                    if(view.getCkC().isSelected()==true){
                        ctl=view.getCkC().getText();
                        }
                    if(view.getCkD().isSelected()==true){
                        ctl=view.getCkD().getText();
                        }
                    
                    }
                }
            }
            for(DeThi as:dt){
                if(as.getMade().equalsIgnoreCase(g)==true){
                    if(as.getCauhoi().equalsIgnoreCase(ch)==true){
                        if(as.getDaDung().equalsIgnoreCase(ctl)==true){
                            n+=1;
                        }   
                    }
                }
            }
            ArrayList<String> a=new ArrayList<>();
            for(DeThi as:dt){
                if(as.getMade().equals(g)==true){
                    a.add(as.getCauhoi());
                }
            }
            if(f==a.size()-2){
                view.getBtnNext().setEnabled(false);
            }
            for(int i=0;i<ar.size();i++){
                f=f+1;
                view.getTxtCauHoi().setText(ar.get(f));
                ch=ar.get(f);
                break;
            }
            for(DeThi as:dt){
                if(as.getCauhoi().equalsIgnoreCase(ch)==true){
                    view.getCkA().setText(as.getDaA());
                    view.getCkB().setText(as.getDaB());
                    view.getCkC().setText(as.getDaC());
                    view.getCkD().setText(as.getDaD());
                    }
                }
            }
        });
    }
    
    public void nopBai(){
        view.getBtnNopBai().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.getBtnNopBai().setEnabled(false);
                String s2="";
                String s3="";
                String s4="";
                for(DeThi as:dt){
                    if(as.getMade().equalsIgnoreCase(g)==true){
                        if(as.getCauhoi().equalsIgnoreCase(ch)==true){
                            if(view.getCkA().isSelected()==true){
                                ctl=view.getCkA().getText();
                            }
                            if(view.getCkB().isSelected()==true){
                                ctl=view.getCkB().getText();
                            }   
                            if(view.getCkC().isSelected()==true){
                                ctl=view.getCkC().getText();
                            }
                            if(view.getCkD().isSelected()==true){
                                ctl=view.getCkD().getText();
                            }
                    
                        }
                    }
                }
                for(DeThi as:dt){
                    if(as.getMade().equalsIgnoreCase(g)==true){
                        if(as.getCauhoi().equalsIgnoreCase(ch)==true){
                            if(as.getDaDung().equalsIgnoreCase(ctl)==true){
                                n+=1;
                            }
                        }
                    }
                }
                ArrayList<String> a=new ArrayList<>();
                for(DeThi as:dt){
                    if(as.getMade().equals(g)==true){
                        a.add(as.getCauhoi());
                        }
                }
                int d=a.size();
                float x=(float)n/d*10;
                for(DeThi as:dt){
                    if(as.getMade().equalsIgnoreCase(g)==true){
                        s2=as.getLoaibai();
                        s4=as.getLoaibai();
                    }
                }
                for(Model.HocSinh as:hs){
                    if(as.getTen().equalsIgnoreCase(view.getTxtTenHS().getText())==true){
                        s3=as.getMatk();
                        }
                    }
                DiemThi aw=new DiemThi();
                aw.themDiemThi(s3, view.getTxtMonThi().getText(), x, s4);
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
