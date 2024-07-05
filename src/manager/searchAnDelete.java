/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class searchAnDelete extends javax.swing.JFrame {

    /**
     * Creates new form searchAnDelete
     */
    private static EmpModel e;
    public ArrayList<EmpModel> emp= new ArrayList<>();
    public searchAnDelete() {
        initComponents();
        btnDelete.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtKey = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        emp_searchTable = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        emp_searchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        emp_searchTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emp_searchTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(emp_searchTable);

        btnDelete.setText("Delete");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnBack.setText("Return");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(49, 49, 49))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                .addComponent(btnSearch)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnBack))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emp_searchTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emp_searchTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_searchTableMouseClicked
private void loadData(){
    String key=txtKey.getText().trim();
        try{ 
        Connection con = ConnectDB.getConnection();
        Statement smt = con.createStatement();
        ResultSet rs = smt.executeQuery("SELECT * FROM emp WHERE name LIKE '%"+key+"%'");
        emp= new ArrayList<>();
        while(rs.next()){
    //        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // Định dạng ngày tháng của cột trong cơ sở dữ liệu
    //        String dateAsString = dateFormat.format(rs.getDate(2)); // Chuyển đổi kiểu dữ liệu Date thành String theo định dạng

            EmpModel em=new EmpModel(rs.getInt(1),rs.getString(2), rs.getDate(3), rs.getString(4),rs.getString(5));
            emp.add(em);
            
        }
            if(emp.size() == 0){
            JOptionPane.showMessageDialog(this, "Không tìm thấy!");
        }
                String[][] data= new String[emp.size()][5];
                for (int i = 0; i < emp.size(); i++) {
                    var a=emp.get(i);
                    data[i][0]=a.getId()+"";
                    data[i][1]=a.getName();
                    data[i][2]=a.getBirthday().toString();
                    data[i][3]=a.getPhone();
                    data[i][4]=a.getMajor();
            }
            String[] columnNames= {"ID","name","birthday","phone","major"};
            DefaultTableModel dtm =new DefaultTableModel(data, columnNames);
            emp_searchTable.removeAll();
            emp_searchTable.setModel(dtm);
        }catch(Exception ex){
            ex.printStackTrace();
    }
}
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int id= Integer.parseInt(emp_searchTable.getValueAt(emp_searchTable.getSelectedRow(), 0).toString());

        try {

            // Kết nối cơ sở dữ liệu bằng lớp DatabaseConnection
            Connection con = ConnectDB.getConnection();

             // Thực hiện truy vấn SQL
            Statement smt = con.createStatement();

                
            int r=JOptionPane.showConfirmDialog(this, "Bạn chắc chứ?");
            if(r==0){

                int rs =smt.executeUpdate("delete from emp  where id ="+id) ;

                if(rs>0){
                    JOptionPane.showMessageDialog(this,"xóa thành công");
                    txtKey.setText("");
                    loadData();
                    
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Thử lại!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        btnDelete.setVisible(true);
        loadData();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       ManageEmp mp=new ManageEmp();
       mp.setLocation(450, 190);
               mp.setVisible(true);
               dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(searchAnDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(searchAnDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(searchAnDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(searchAnDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new searchAnDelete().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JTable emp_searchTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtKey;
    // End of variables declaration//GEN-END:variables
}
