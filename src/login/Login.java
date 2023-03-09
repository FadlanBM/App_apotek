package login;

import com.raven.main.Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import swing.EventLogin;

public class Login extends PanelCustom {
 Connection conn=null;
    Statement st=null;
    
    private EventLogin event;
    
    public void hapuslayar(){
        t_username.setText("");
        t_password.setText("");
    }

    public Login() {
        initComponents();
        setAlpha(1);
         try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost/dbapotek","root","");
        st=conn.createStatement();
        JOptionPane.showMessageDialog(null, "Selamat Datang di Pharma GI");
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Gagal terkoneksiKarena " + ex);
    }
    }
    

    public void setEventLogin(EventLogin event) {
        this.event = event;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        t_username = new swing.TextField();
        t_password = new swing.Password();
        button1 = new swing.Button();

        setBackground(new java.awt.Color(247, 247, 247));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(76, 76, 76));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN");

        t_username.setForeground(new java.awt.Color(76, 76, 76));
        t_username.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        t_username.setHint("Username");

        t_password.setForeground(new java.awt.Color(76, 76, 76));
        t_password.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        t_password.setHint("Password");

        button1.setBackground(new java.awt.Color(86, 142, 255));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Sign In");
        button1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(t_password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(button1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(t_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(t_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        try{
        if(t_username.getText().equals("") ||t_password.getText().equals("")){
                JOptionPane.showMessageDialog(this, "DataTidak Boleh Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);
                t_username.requestFocus();
                hapuslayar();
                }else{
                    st = conn.createStatement();
                    String sql = ("SELECT * FROM tblogin WHERE username ='"+t_username.getText()+"' AND Password ='"+String.valueOf(t_password.getPassword())+"'");
                    ResultSet rs = st.executeQuery(sql);
                if(rs.next()){
                        event.loginDone();
                   }else{
                        JOptionPane.showMessageDialog(this, "UserName dan Password Salah\nAtau Akun Belum Terdaftar", "Pesan",JOptionPane.ERROR_MESSAGE);
                        hapuslayar();
                }
            }
            }catch(Exception e){
                e.printStackTrace();
            }
    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button button1;
    private javax.swing.JLabel jLabel1;
    private swing.Password t_password;
    private swing.TextField t_username;
    // End of variables declaration//GEN-END:variables
}
