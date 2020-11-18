/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Jurusan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import Controller.Controller;
import javax.swing.JOptionPane;


public class InsertJurusan extends JFrame implements ActionListener{
    JFrame jurusan;
    JLabel label_kode,label_nama,label_atas;
    JTextField TF_kode,TF_nama;
    JButton button_submit,button_back,button_reset;
    public InsertJurusan(){
        jurusan = new JFrame("Insert Jurusan");
        jurusan.setSize(400, 300);
        jurusan.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jurusan.setLocationRelativeTo(null);
        
        label_atas = new JLabel("Silahkan Insert Data Dibawah ");
        label_atas.setBounds(100, 10, 200, 30);
        
        label_kode = new JLabel("Kode ");
        label_kode.setBounds(45, 50, 100, 30);
        
        TF_kode = new JTextField();
        TF_kode.setBounds(150, 50, 200, 30);
        
        label_nama = new JLabel("Nama ");
        label_nama.setBounds(45, 100, 100, 30);
        
        TF_nama = new JTextField();
        TF_nama.setBounds(150, 100, 200, 30);
        
        button_submit = new JButton("Submit");
        button_submit.setBounds(45,150,300,30);
        button_submit.addActionListener(this);
        
        button_back = new JButton("Back");
        button_back.setBounds(50,200,100,30);
        button_back.addActionListener(this);
        
        button_reset = new JButton("Reset");
        button_reset.setBounds(250,200,100,30);
        button_reset.addActionListener(this);
           
        jurusan.add(label_atas);
        jurusan.add(button_reset);
        jurusan.add(button_back);
        jurusan.add(button_submit);
        jurusan.add(TF_kode);
        jurusan.add(label_nama);
        jurusan.add(label_kode);
        jurusan.add(TF_nama);
        jurusan.setLayout(null);
        jurusan.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command){
            case"Submit":
                String kode_jur = TF_kode.getText();
                String nama_jur = TF_nama.getText();
                ArrayList<Jurusan> listJur = Controller.getAllJurusan();
                int cek_kode = Controller.cekDuplikatKode(kode_jur);
                if(kode_jur.equals("") && nama_jur.equals("")){
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                } else if(cek_kode > 0){
                    JOptionPane.showMessageDialog(null, "Kode Sudah Terpakai!!", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                } else {
                    if(Controller.insertJurusan(kode_jur, nama_jur)){
                        JOptionPane.showMessageDialog(null, "Insert Berhasil!!");
                        jurusan.setVisible(false);
                        new MainMenu();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Insert gagal!!");
                        break;
                    }
                }
            case"Back":
                jurusan.setVisible(false);
                new MainMenu();
                break;
            case"Reset":
                jurusan.setVisible(false);
                new InsertJurusan();
                break;
            default:
                break;
        }
    }
    
}
