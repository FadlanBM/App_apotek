package login;

import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.*;


public class Register extends PanelCustom {

     Connection con=null;
    Statement st=null;
    
   public void hapuslayar(){
        t_username.setText("");
        t_password.setText("");
        t_repassword.setText("");
        t_name .setText("");
    }
    public Register() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        t_name = new swing.TextField();
        t_username = new swing.TextField();
        t_password = new swing.Password();
        button1 = new swing.Button();
        t_repassword = new swing.Password();

        setBackground(new java.awt.Color(58, 58, 58));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SIGN UP");

        t_name.setForeground(new java.awt.Color(242, 242, 242));
        t_name.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        t_name.setHint("NAME");

        t_username.setForeground(new java.awt.Color(242, 242, 242));
        t_username.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        t_username.setHint("Username");

        t_password.setForeground(new java.awt.Color(242, 242, 242));
        t_password.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        t_password.setHint("PASSWORD");

        button1.setBackground(new java.awt.Color(86, 142, 255));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Sign Up");
        button1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        t_repassword.setForeground(new java.awt.Color(242, 242, 242));
        t_repassword.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        t_repassword.setHint("Re Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(t_username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_repassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(t_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(t_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(t_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(t_repassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        try {
            if (t_username.getText().equals("")||t_password.getPassword().equals("")||t_name.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Data tidak boleh kosong","pesan",JOptionPane.ERROR_MESSAGE);
                hapuslayar();
            }else{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbapotek","root","");
                st=con.createStatement();
                String simpan ="insert into tblogin values('"+t_username.getText()+"','"
                +String.valueOf(t_password.getPassword())+"','"+t_name.getText()+"')";
                st=con.createStatement();
                int SA=st.executeUpdate(simpan);
                JOptionPane.showMessageDialog(this,"Register Berhasil");
                hapuslayar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Akun sudah ada","pesan",JOptionPane.ERROR_MESSAGE);
            hapuslayar();
        }
    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button button1;
    private javax.swing.JLabel jLabel1;
    private swing.TextField t_name;
    private swing.Password t_password;
    private swing.Password t_repassword;
    private swing.TextField t_username;
    // End of variables declaration//GEN-END:variables
}
