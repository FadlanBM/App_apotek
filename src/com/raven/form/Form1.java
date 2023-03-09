/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import com.raven.transitions.TransitionsForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RAVEN
 */
public class Form1 extends TransitionsForm {

    /**
     * Creates new form Form
     */
         Connection con;

    public Form1() {
        initComponents();
        TampilData();
        TampilDataTransaksi();
    }
    
     public void bersih(){
        txt_pesan_nama_obat.setText("");
        txt_pesan_kategori.setText("");
        txt_pesan_produsen.setText("");
        txt_pesan_harga.setText("");
    }
    
    private void TampilData(){
        try {
            DefaultTableModel model= new DefaultTableModel();
            model.addColumn("NO");
            model.addColumn("Nama Obat");
            model.addColumn("Kategori");
            model.addColumn("Produsen");
            model.addColumn("Harga");
            model.addColumn("Tgl_exp");
            model.addColumn("Stok");
            tb_list_obat.setModel(model);

             model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            Class.forName("com.mysql.cj.jdbc.Driver");
           java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbapotek","root","");
           String sql ="SELECT * FROM tb_obat";
           java.sql.Statement st=con.createStatement();
            java.sql.ResultSet rs=st.executeQuery(sql);
           
            while (rs.next()) {
                Object[] data={
                    rs.getString("id"),
                    rs.getString("nama_obat"),
                    rs.getString("kategori_obat"),
                    rs.getString("produsen"),
                    rs.getString("harga"),
                    rs.getString("tgl_exp"),
                    rs.getString("stok")
                };
                model.addRow(data);
                tb_list_obat.setModel(model);
            }
        } catch (Exception e) {
        }
    }
    
     private void TampilDataTransaksi(){
        try {
            DefaultTableModel model= new DefaultTableModel();
            model.addColumn("Nama Obat");
            model.addColumn("Nama Obat");
            model.addColumn("Kategori");
            model.addColumn("Produsen");
            model.addColumn("Harga");
            tb_tampil_transaksi.setModel(model);

             model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            Class.forName("com.mysql.cj.jdbc.Driver");
           java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbapotek","root","");
           String sql ="SELECT * FROM tb_pemesanan";
           java.sql.Statement st=con.createStatement();
            java.sql.ResultSet rs=st.executeQuery(sql);
           
            while (rs.next()) {
                Object[] data={
                    rs.getString("id"),
                    rs.getString("nama_obat"),
                    rs.getString("kategori"),
                    rs.getString("produsen"),
                    rs.getString("harga"),
                };
                model.addRow(data);
                tb_tampil_transaksi.setModel(model);
            }
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_pesan_nama_obat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_pesan_kategori = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_pesan_produsen = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_pesan_harga = new javax.swing.JTextField();
        btn_batal = new javax.swing.JButton();
        txt_hidden_pesan = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_list_obat = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btn_pesan = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_tampil_transaksi = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jPanel3.setBackground(new java.awt.Color(0, 0, 153));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/logo.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pharma GI");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/logout.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 729, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel3.setText("List Pesanan");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        jLabel5.setText("Nama Obat");

        txt_pesan_nama_obat.setFocusable(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Kategori Obat");

        txt_pesan_kategori.setRequestFocusEnabled(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Produsen");

        txt_pesan_produsen.setRequestFocusEnabled(false);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Harga");

        txt_pesan_harga.setRequestFocusEnabled(false);

        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(186, 186, 186))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_pesan_nama_obat, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                            .addComponent(txt_pesan_harga, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_pesan_produsen, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_pesan_kategori, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(btn_batal)))))
                .addContainerGap(96, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_hidden_pesan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addComponent(txt_hidden_pesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_pesan_nama_obat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_pesan_kategori, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_pesan_produsen, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_pesan_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        tb_list_obat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_list_obat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_list_obatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_list_obat);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel2.setText("List Obat Pharma GI");

        btn_pesan.setText("Pesan");
        btn_pesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_pesan)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btn_pesan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1))
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        tb_tampil_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_tampil_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_tampil_transaksiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_tampil_transaksi);

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tabel Pemesanan");

        jButton2.setText("Hapus");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int dialogbtn =JOptionPane.YES_NO_OPTION;
        int dialogresult=JOptionPane.showConfirmDialog(this,"Apakah Anda Yakin Akan Keluar?","Peringatan",dialogbtn);
        this.setVisible(false);
        if(dialogresult==0){
            //kondisi
            System.exit(0);
            this.setVisible(false);
        }else{

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tb_list_obatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_list_obatMouseClicked
        int row=tb_list_obat.rowAtPoint(evt.getPoint());
//         String id=tb_list_obat.getValueAt(row,0).toString();
//          txt_hidden_pesan.setText(id);
        
          String nama_obat=tb_list_obat.getValueAt(row,1).toString();
          txt_pesan_nama_obat.setText(nama_obat);
          
          String kategori=tb_list_obat.getValueAt(row,2).toString();
          txt_pesan_kategori.setText(kategori);
          
           String produsen=tb_list_obat.getValueAt(row,3).toString();
          txt_pesan_produsen.setText(produsen);
          
          
           String harga=tb_list_obat.getValueAt(row,4).toString();
          txt_pesan_harga.setText(harga);
    }//GEN-LAST:event_tb_list_obatMouseClicked

    private void btn_pesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesanActionPerformed
       try {
            if (txt_pesan_nama_obat.getText().equals("")||txt_pesan_kategori.getText().equals("")||txt_pesan_produsen.getText().equals("")||txt_pesan_harga.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Data tidak boleh kosong","pesan",JOptionPane.ERROR_MESSAGE);
                bersih();
            }else{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbapotek","root","");
               java.sql.Statement st=con.createStatement();
                String simpan ="INSERT INTO tb_pemesanan(nama_obat,produsen,kategori,harga)VALUES('"+txt_pesan_nama_obat.getText()+"','"+txt_pesan_produsen.getText()+"','"
                +txt_pesan_kategori.getText()+"',"+txt_pesan_harga.getText()+")";
                st=con.createStatement();
                st.executeUpdate(simpan);
                JOptionPane.showMessageDialog(this,"Pemesanan Berhasil");
                bersih();
                TampilDataTransaksi();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"data sudah ada","pesan",JOptionPane.ERROR_MESSAGE);
            bersih();
        }
    }//GEN-LAST:event_btn_pesanActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         try {
            int dialogButton=JOptionPane.YES_NO_OPTION;
            int dialogResult=JOptionPane.showConfirmDialog(null,"Apakah Anda yakin untuk menghapus data dari List Pembelian ini","Warning",dialogButton);
            if (dialogResult  == JOptionPane.YES_OPTION) {
                String sql="DELETE FROM tb_pemesanan where id='"+txt_hidden_pesan.getText()+"'";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbapotek","root","");
            java.sql.PreparedStatement ptsm=con.prepareStatement(sql);
            ptsm.execute();
            JOptionPane.showMessageDialog(null,"Berhasil menghapus data");
            TampilDataTransaksi();
            bersih();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tb_tampil_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_tampil_transaksiMouseClicked
               int row=tb_tampil_transaksi.rowAtPoint(evt.getPoint());
          
           String id=tb_tampil_transaksi.getValueAt(row,0).toString();
          txt_hidden_pesan.setText(id);
          
          String nama_obat=tb_tampil_transaksi.getValueAt(row,1).toString();
         txt_pesan_nama_obat.setText(nama_obat);
          
           String produsen=tb_tampil_transaksi.getValueAt(row,2).toString();
           txt_pesan_produsen.setText(produsen);
          
           String kategori=tb_tampil_transaksi.getValueAt(row,3).toString();
          txt_pesan_kategori.setText(kategori);
          
           String harga=tb_tampil_transaksi.getValueAt(row,4).toString();
          txt_pesan_harga.setText(harga);
                                             
    }//GEN-LAST:event_tb_tampil_transaksiMouseClicked

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        bersih();
    }//GEN-LAST:event_btn_batalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_pesan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb_list_obat;
    private javax.swing.JTable tb_tampil_transaksi;
    private javax.swing.JTextField txt_hidden_pesan;
    private javax.swing.JTextField txt_pesan_harga;
    private javax.swing.JTextField txt_pesan_kategori;
    private javax.swing.JTextField txt_pesan_nama_obat;
    private javax.swing.JTextField txt_pesan_produsen;
    // End of variables declaration//GEN-END:variables
}