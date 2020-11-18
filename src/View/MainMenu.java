/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;


public class MainMenu extends JFrame implements ActionListener{
    JFrame frame_main;
    JButton b_insertJurusanBaru,b_lihatSemuaJurusan,b_insertMaba,b_lihatDataPerJurusan;
    JLabel label_atas;
    public MainMenu(){
        frame_main = new JFrame();
        frame_main.setSize(400, 300);
        frame_main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame_main.setLocationRelativeTo(null);
        
        label_atas = new JLabel("MyITHB");
        label_atas.setBounds(170, 20, 100, 30);
        
        b_insertJurusanBaru = new JButton("Insert Jurusan Baru");
        b_insertJurusanBaru.setBounds(45, 60, 300, 30);
        b_insertJurusanBaru.addActionListener(this);
        b_lihatSemuaJurusan = new JButton("Lihat Semua Jurusan");
        b_lihatSemuaJurusan.setBounds(45, 100, 300, 30);
        b_lihatSemuaJurusan.addActionListener(this);
        b_insertMaba = new JButton("Insert Mahasiswa Baru");
        b_insertMaba.setBounds(45, 140, 300, 30);
        b_insertMaba.addActionListener(this);
        b_lihatDataPerJurusan = new JButton("Lihat Data Per Jurusan");
        b_lihatDataPerJurusan.setBounds(45, 180, 300, 30);
        b_lihatDataPerJurusan.addActionListener(this);
        
        frame_main.add(label_atas);
        frame_main.add(b_lihatDataPerJurusan);
        frame_main.add(b_insertMaba);
        frame_main.add(b_lihatSemuaJurusan);
        frame_main.add(b_insertJurusanBaru);
        frame_main.setLayout(null);
        frame_main.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command){
            case "Insert Jurusan Baru":
                frame_main.setVisible(false);
                new InsertJurusan();
                break;
            case "Lihat Semua Jurusan":
                frame_main.setVisible(false);
                new AllJurusan();
                break;
            case "Insert Mahasiswa Baru":
                frame_main.setVisible(false);
                new InsertMaba();
                break;
            case "Lihat Data Per Jurusan":
                break;
            default:
                break;
        }
    }
}
