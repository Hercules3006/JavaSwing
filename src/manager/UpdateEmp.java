/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class UpdateEmp extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form UpdateEmp
     */
        public static Boolean isDate(String date){
        Pattern patternDate = Pattern.compile("\\d{1,2}-\\d{1,2}-\\d{4}");
        if(patternDate.matcher(date).matches()){
            int d = Integer.parseInt(date.split("-")[1]);
            int m = Integer.parseInt(date.split("-")[0]);
            int y = Integer.parseInt(date.split("-")[2]);
            if(m<=0 || m>12) return false;
            if(m == 1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12){
                if(d<=0 || d>31) return false;    
            }
            if(m==4 || m==6 || m==9 || m==11){
                if(d<=0 || d>30)return false;
            }
            if(m==2){
                if((y%4==0 && y%100 ==0)||(y%400==0)){
                    if(d<=0 || d>29)return false;
                }
                else{
                    if(d<=0 || d>28)return false;
                }
            }
            return true;
        }
        return false;
    }
    private EmpModel e;
    public int id;
    public UpdateEmp(EmpModel e) {
        initComponents();
        this.e=e;
        id = e.getId();
        setTitle("Sửa thông tin");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        String birthdayString = dateFormat.format(e.getBirthday()); 
        txtBirthday.setText(birthdayString);
        txtName.setText(e.getName());
        txtPhone.setText(e.getPhone());

        jComboBoxMajor.removeAllItems();
        jComboBoxMajor.addItem("Lễ tân");
        jComboBoxMajor.addItem("Phục vụ");
        jComboBoxMajor.addItem("Đầu bếp");
        jComboBoxMajor.setSelectedItem(e.getMajor());
        
        btnOk.addActionListener(this);
        btnCancel.addActionListener(ex->{
           searchAnUpdate sau=new searchAnUpdate(null);
           sau.setLocation(450, 190);
           sau.setVisible(true);
           dispose();
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtBirthday = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jComboBoxMajor = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnOk.setText("Xác nhận");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancel.setText("Hủy");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel2.setText("Họ tên");

        jLabel3.setText("Ngày sinh");

        jLabel4.setText("Số điện thoại");

        jLabel5.setText("Chức vụ");

        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        jComboBoxMajor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(btnOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addComponent(btnCancel)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName)
                    .addComponent(txtBirthday)
                    .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBoxMajor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private javax.swing.JComboBox<String> jComboBoxMajor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtBirthday;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        String name= txtName.getText();
        String Dob=txtBirthday.getText();
        String phoneNum= txtPhone.getText();
        String major = (String) jComboBoxMajor.getSelectedItem();
        
        if(name.equals("")||Dob.equals("")||phoneNum.equals("")){
            JOptionPane.showMessageDialog(this,"Không được bỏ trống");
            return;
        }
                String phonePattern = "^[0-9]+$";

        String namePattern = "^[^0-9]+$";


    if (!name.matches(namePattern)) {
        JOptionPane.showMessageDialog(this, "Name chỉ được chứa chữ cái từ a-z hoặc A-Z");
        return;
    }

    if (!phoneNum.matches(phonePattern)) {
    JOptionPane.showMessageDialog(this, "Phone chỉ được chứa số từ 0-9");
    return;
    }
        if(!isDate(Dob)){
            JOptionPane.showMessageDialog(this,"Dob is notvalid");
            return;
        }
           
        try {
            // Kết nối cơ sở dữ liệu bằng lớp DatabaseConnection
            Connection con = ConnectDB.getConnection();
            String query = "SELECT 1 FROM emp where phone=" + phoneNum + "and id <>" + id;
            Statement smt = con.createStatement();
            ResultSet tmp = smt.executeQuery(query);
            boolean phoneExists = false;
            if(tmp.next()) {
                phoneExists = true;
            }

            if (phoneExists) {
                JOptionPane.showMessageDialog(null, "Số điện thoại của người khác");
            } 
            else{
                            int rs = smt.executeUpdate("Update emp Set name=N'"+name+"',birthday='"+Dob+"',phone='"+phoneNum+"',major=N'"+major+"' where id = "+id);
            if(rs>0){
                JOptionPane.showMessageDialog(this,"Cập nhật nhân viên mới thành công");
                searchAnUpdate sau =new searchAnUpdate(null);
                sau.setLocation(450, 190);
                sau.setVisible(true);
                this.dispose();
            }
            }
            


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
       
}
