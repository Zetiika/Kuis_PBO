
package kuis2;

import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class IntiView extends JFrame{
    JLabel ljudul, ltipe, lepisode, lstatus, lrating, lgenre;
    JTextField txjudul, txtipe, txepisode, txrating, txgenre, txcari;
    JButton refresh, create, delete, update, exit, search;
    JComboBox jcstatus;
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"#","ID","Judul","Tipe","Episode","Genre", "Status", "Rating"};
    
    public IntiView(){
        //tabel
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        //label
        ljudul = new JLabel("Judul");
        ltipe = new JLabel("Tipe");
        lepisode = new JLabel("Episode");
        lstatus = new JLabel("Status");
        lrating = new JLabel("Rating");
        lgenre = new JLabel("Genre");
        //textfield
        txjudul = new JTextField(""); 
        txtipe = new JTextField("");
        txepisode = new JTextField(""); 
        txrating = new JTextField("");
        txgenre = new JTextField(""); 
        txcari = new JTextField("");
        //combobox
        String pilih[] = {"Belum", "Selesai"};
        jcstatus = new JComboBox(pilih);
        //button
        refresh = new JButton("Refresh");
        create = new JButton("Create");
        delete = new JButton("Delete"); 
        update = new JButton("Update");
        exit = new JButton("Exit");
        search = new JButton("Search");
        
        setLayout(null);
        add(ljudul);
        add(ltipe);
        add(lepisode);
        add(lstatus);
        add(lrating);
        add(lgenre);
        add(txjudul);
        add(txtipe);
        add(txepisode);
        add(txrating);
        add(txgenre);
        add(txcari);
        add(jcstatus);
        add(refresh);
        add(create);
        add(delete);
        add(update);
        add(exit);
        add(search);
        add(scrollPane);
                
        scrollPane.setBounds(50, 50, 900, 250);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        ljudul.setBounds(50, 325, 50, 20);
        txjudul.setBounds(50, 350, 300, 20);
        txcari.setBounds(500, 350, 200, 20);
        search.setBounds(725, 348, 80, 25);
        ltipe.setBounds(50, 385, 50, 20);
        txtipe.setBounds(50, 410, 125, 20);
        lstatus.setBounds(225, 385, 50, 20);
        jcstatus.setBounds(225, 410, 100, 30);
        lepisode.setBounds(50, 460, 50, 20);
        txepisode.setBounds(50, 485, 125, 20);
        lrating.setBounds(225, 460, 50, 20);
        txrating.setBounds(225, 485, 120, 20);
        lgenre.setBounds(50, 525, 50, 20);
        txgenre.setBounds(50, 550, 300, 20);
        refresh.setBounds(450, 548, 80, 25);
        create.setBounds(550, 548, 80, 25);
        update.setBounds(650, 548, 80, 25);
        delete.setBounds(750, 548, 80, 25);
        exit.setBounds(850, 548, 80, 25);
        setSize(1000,650);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public String getEpsiode(){
        return txepisode.getText();
    }
    
    public String getJudul(){
        return txjudul.getText();
    }
    
    public String getTipe(){
        return txtipe.getText();
    }
    public String getRating(){
        return txrating.getText();
    }
    
    public String getGenre(){
        return txgenre.getText();
    }
    
    public String getCari(){
        return txcari.getText();
    }
    
    public String getStatus(){
        return jcstatus.getSelectedItem().toString();
    }
}
