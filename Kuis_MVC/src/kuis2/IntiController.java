
package kuis2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class IntiController {
    IntiView intiview;
    IntiModel intimodel;
    IntiDAO intidao;
    
    public IntiController(IntiView intiview, IntiModel intimodel, IntiDAO intidao){
        this.intiview = intiview;
        this.intimodel = intimodel;
        this.intidao = intidao;
        
        if(intidao.getJmldata() != 0){
            String dataInti[][] = intidao.readData();
            intiview.tabel.setModel((new JTable(dataInti, intiview.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        intiview.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                super.mousePressed(e);
                int baris = intiview.tabel.getSelectedRow();
                int kolom = intiview.tabel.getSelectedColumn();
                
                String judul = intiview.tabel.getValueAt(baris, 2).toString();
                intiview.txjudul.setText(judul);
                String tipe = intiview.tabel.getValueAt(baris, 3).toString();
                intiview.txtipe.setText(tipe);
                String episode = intiview.tabel.getValueAt(baris, 4).toString();
                intiview.txepisode.setText(episode);
                String genre = intiview.tabel.getValueAt(baris, 5).toString();
                intiview.txgenre.setText(genre);
                String rating = intiview.tabel.getValueAt(baris, 7).toString();
                intiview.txrating.setText(rating);
           }
        });
        
        intiview.refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dataInti[][] = intidao.readData();
                intiview.tabel.setModel((new JTable(dataInti, intiview.namaKolom)).getModel());
            }
        });
        
        intiview.create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judul = intiview.getJudul();
                String tipe = intiview.getTipe();
                String episode = intiview.getEpsiode();
                String genre = intiview.getGenre();
                String status = intiview.getStatus();
                String rating = intiview.getRating();
                String cari = intiview.getCari();
                if(judul.isEmpty() || tipe.isEmpty() || episode.isEmpty() || genre.isEmpty() || status.isEmpty() || rating.isEmpty()){
                   JOptionPane.showMessageDialog(null, "Harap Isi Semua Field");
               }else{
                    intimodel.setIntiModel(judul, tipe, status, episode, rating, genre, cari);
                    intidao.Create(intimodel);
                    
                    String dataInti[][] = intidao.readData();
                    intiview.tabel.setModel((new JTable(dataInti,intiview.namaKolom)).getModel());
                }
            }
        });
        
        intiview.update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judul = intiview.getJudul();
                String tipe = intiview.getTipe();
                String episode = intiview.getEpsiode();
                String genre = intiview.getGenre();
                String status = intiview.getStatus();
                String rating = intiview.getRating();
                String cari = intiview.getCari();
                if(judul.isEmpty() || tipe.isEmpty() || episode.isEmpty() || genre.isEmpty() || status.isEmpty() || rating.isEmpty()){
                   JOptionPane.showMessageDialog(null, "Harap Isi Semua Field");
               }else{
                    intimodel.setIntiModel(judul, tipe, status, episode, rating, genre, cari);
                    intidao.Update(intimodel);
                    
                    String dataInti[][] = intidao.readData();
                    intiview.tabel.setModel((new JTable(dataInti,intiview.namaKolom)).getModel());
                }
            }
        });
        
        intiview.delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judul = intiview.getJudul();
                String tipe = intiview.getTipe();
                String episode = intiview.getEpsiode();
                String genre = intiview.getGenre();
                String status = intiview.getStatus();
                String rating = intiview.getRating();
                String cari = intiview.getCari();
                if(judul.isEmpty() || tipe.isEmpty() || episode.isEmpty() || genre.isEmpty() || status.isEmpty() || rating.isEmpty()){
                   JOptionPane.showMessageDialog(null, "Harap Isi Semua Field");
               }else{
                    intimodel.setIntiModel(judul, tipe, status, episode, rating, genre, cari);
                    intidao.Delete(intimodel);
                    
                    String dataInti[][] = intidao.readData();
                    intiview.tabel.setModel((new JTable(dataInti,intiview.namaKolom)).getModel());
                }
            }
        });
        
        intiview.exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Terima Kasih");
                System.exit(0);
            }
        });
        
        intiview.search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judul = intiview.getJudul();
                String tipe = intiview.getTipe();
                String episode = intiview.getEpsiode();
                String genre = intiview.getGenre();
                String status = intiview.getStatus();
                String rating = intiview.getRating();
                String cari = intiview.getCari();
                if(cari.isEmpty()){
                   JOptionPane.showMessageDialog(null, "Harap Isi Data yang Ingin Dicari");
               }else{
                    intimodel.setIntiModel(judul, tipe, status, episode, rating, genre, cari);
                    intidao.searchData(intimodel);
                }
            }
        });
    }
}
