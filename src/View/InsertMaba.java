/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import Controller.Controller;
import Model.Jurusan;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class InsertMaba extends JFrame implements ActionListener{
    JFrame maba;
    JLabel label_nim,label_nama,label_angkatan, label_jurusan,label_atas;
    JTextField field_nim,field_nama,field_angkatan;
    JButton button_submit,button_back,button_reset;
    JComboBox CBJurusan;
    String[] jurusan;
    public InsertMaba(){
        maba = new JFrame("Insert Maba");
        maba.setSize(400, 500);
        maba.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        maba.setLocationRelativeTo(null);
        
        label_atas = new JLabel("Silahkan Insert Data Dibawah ");
        label_atas.setBounds(100, 10, 200, 30);
        
        label_nim = new JLabel("NIM ");
        label_nim.setBounds(45, 50, 100, 30);
        
        field_nim = new JTextField();
        field_nim.setBounds(150, 50, 200, 30);
        
        label_nama = new JLabel("Nama ");
        label_nama.setBounds(45, 100, 100, 30);
        
        field_nama = new JTextField();
        field_nama.setBounds(150, 100, 200, 30);
        
        label_angkatan = new JLabel("Angkatan ");
        label_angkatan.setBounds(45, 150, 100, 30);
        
        field_angkatan = new JTextField();
        field_angkatan.setBounds(150, 150, 200, 30);
        
        ArrayList<Jurusan> listJur = Controller.getAllJurusan();
        int panjang = listJur.size();
        jurusan = new String[panjang];
        for(int i = 0; i < listJur.size() ; i++){
            jurusan[i] = listJur.get(i).getKode();
        }
        
        label_jurusan = new JLabel("Jurusan ");
        label_jurusan.setBounds(45, 200, 100, 30);
        
        CBJurusan = new JComboBox(jurusan);
        CBJurusan.setBounds(150, 200, 200, 30);
        
        button_submit = new JButton("Submit");
        button_submit.setBounds(45,250,300,30);
        button_submit.addActionListener(this);
        
        button_back = new JButton("Back");
        button_back.setBounds(50,300,100,30);
        button_back.addActionListener(this);
        
        button_reset = new JButton("Reset");
        button_reset.setBounds(250,300,100,30);
        button_reset.addActionListener(this);
          
        maba.add(CBJurusan);
        maba.add(label_atas);
        maba.add(button_reset);
        maba.add(button_back);
        maba.add(button_submit);
        maba.add(field_nim);
        maba.add(label_nama);
        maba.add(label_nim);
        maba.add(field_nama);
        maba.add(label_angkatan);
        maba.add(field_angkatan);
        maba.add(label_jurusan);
        maba.setLayout(null);
        maba.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command){
            case"Submit":
                String nama = field_nama.getText();
                String nim = field_nim.getText();
                int angkatan = Integer.parseInt(field_angkatan.getText());
                int cek_nim = Controller.cekDuplikatNIM(nim);
                if(nama.equals("") && nim.equals("")){
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                } else if(cek_nim > 0){
                    JOptionPane.showMessageDialog(null, "NIM sudah terdaftar!", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                } else {
                    String jurusan = CBJurusan.getItemAt(CBJurusan.getSelectedIndex()).toString();
                    if(Controller.insertMABA(nim, nama, angkatan, jurusan)){
                        JOptionPane.showMessageDialog(null, "Insert Berhasil!!");
                        maba.setVisible(false);
                        new MainMenu();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Insert gagal!!");
                        break;
                    }
                }
            case"Back":
                maba.setVisible(false);
                new MainMenu();
                break;
            case"Reset":
                maba.setVisible(false);
                new InsertMaba();
                break;
            default:
                break;
        }
    }
}
