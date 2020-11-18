/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import Controller.Controller;
import Model.Jurusan;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class AllJurusan extends JFrame implements ActionListener{
    JFrame Jur;
    String[][] data;
    String[] kolom = {"Kode","Nama"};
    JLabel label_kode,label_jurusan;
    JTable tabelJur;
    String kode_jurusan = "";
    String nama_jurusan = "";
    public AllJurusan(){
        Jur = new JFrame("Jurusan");
        Jur.setSize(500, 500);
        Jur.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Jur.setLocationRelativeTo(null);
        
        ArrayList<Jurusan> listJur = Controller.getAllJurusan();
     
        for(int i = 0; i < listJur.size(); i++){
            kode_jurusan += listJur.get(i).getKode() + " ";
            nama_jurusan += listJur.get(i).getNama() + " ";
        }
        label_kode = new JLabel(kode_jurusan);
        label_kode.setBounds(20, 20, 200, 30);
        label_jurusan = new JLabel(nama_jurusan);
        label_jurusan.setBounds(20, 50, 500, 30);
        
        Jur.add(label_jurusan);
        Jur.add(label_kode);
        
        Jur.setLayout(null);
        Jur.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
