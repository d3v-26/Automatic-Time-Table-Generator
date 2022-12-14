/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import BackEnd.Day;
import BackEnd.Lecture;
import BackEnd.TimeTable;
import UserInterface.components.SubjectComponent;
import java.awt.Graphics;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author meet
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        this.setSize(1366,768);
        this.setLocationRelativeTo(null);
        this.setShape(new RoundRectangle2D.Double(0,0,this.getWidth(),this.getHeight(),18,18));
        jpSubject = new AddSubjects();
        jpSubject.setBounds(0,0,1216,660);
        jpSubject.setVisible(true);
        jpDemo.add(jpSubject);
        jpDemo.setVisible(true);
        jspTimetable.setVisible(false);
        initTimetable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpDemo = new javax.swing.JPanel();
        jspTimetable = new javax.swing.JScrollPane();
        jpTimetable = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(this.getBackground());
                g.fillRoundRect(0,0,this.getWidth(),this.getHeight(),18,18);
            }
        };
        jlMonday = new javax.swing.JLabel();
        jlThursday = new javax.swing.JLabel();
        jlTuesday = new javax.swing.JLabel();
        jlWednesday = new javax.swing.JLabel();
        jlSaturday = new javax.swing.JLabel();
        jlFriday = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlProfile = new javax.swing.JLabel();
        jlAdd = new javax.swing.JLabel();
        jlTimetable = new javax.swing.JLabel();
        jlLogout = new javax.swing.JLabel();
        jlTimtable = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1366, 768));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setSize(new java.awt.Dimension(1366, 768));
        jPanel1.setLayout(null);

        jpDemo.setLayout(null);
        jPanel1.add(jpDemo);
        jpDemo.setBounds(130, 90, 1216, 660);

        jspTimetable.setBorder(null);

        jpTimetable.setBackground(new java.awt.Color(241, 245, 246));
        jpTimetable.setPreferredSize(new java.awt.Dimension(2322, 1058));
        jpTimetable.setSize(new java.awt.Dimension(2322, 1058));
        jpTimetable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlMonday.setFont(new java.awt.Font("Fira Sans", 1, 18)); // NOI18N
        jlMonday.setText("MONDAY");
        jpTimetable.add(jlMonday, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jlThursday.setFont(new java.awt.Font("Fira Sans", 1, 18)); // NOI18N
        jlThursday.setText("THURSDAY");
        jpTimetable.add(jlThursday, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 20, -1, -1));

        jlTuesday.setFont(new java.awt.Font("Fira Sans", 1, 18)); // NOI18N
        jlTuesday.setText("TUESDAY");
        jpTimetable.add(jlTuesday, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        jlWednesday.setFont(new java.awt.Font("Fira Sans", 1, 18)); // NOI18N
        jlWednesday.setText("WEDNESDAY");
        jpTimetable.add(jlWednesday, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, -1, -1));

        jlSaturday.setFont(new java.awt.Font("Fira Sans", 1, 18)); // NOI18N
        jlSaturday.setText("SATURDAY");
        jpTimetable.add(jlSaturday, new org.netbeans.lib.awtextra.AbsoluteConstraints(2010, 20, -1, -1));

        jlFriday.setFont(new java.awt.Font("Fira Sans", 1, 18)); // NOI18N
        jlFriday.setText("FRIDAY");
        jpTimetable.add(jlFriday, new org.netbeans.lib.awtextra.AbsoluteConstraints(1620, 20, -1, -1));

        jLabel8.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("10:00");
        jpTimetable.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel9.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("09:00");
        jpTimetable.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel10.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("11:00");
        jpTimetable.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        jLabel11.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("10:00");
        jpTimetable.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel12.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("11:15");
        jpTimetable.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        jLabel13.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("12:15");
        jpTimetable.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, -1, -1));

        jLabel14.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText("12:15");
        jpTimetable.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, -1, -1));

        jLabel15.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setText("01:15");
        jpTimetable.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 690, -1, -1));

        jLabel16.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setText("01:45");
        jpTimetable.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 760, -1, -1));

        jLabel17.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 153, 153));
        jLabel17.setText("02:45");
        jpTimetable.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 880, -1, -1));

        jLabel18.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 153, 153));
        jLabel18.setText("02:25");
        jpTimetable.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 920, -1, -1));

        jLabel19.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 153, 153));
        jLabel19.setText("03:45");
        jpTimetable.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1040, -1, -1));

        jspTimetable.setViewportView(jpTimetable);

        jPanel1.add(jspTimetable);
        jspTimetable.setBounds(130, 90, 1216, 660);

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setPreferredSize(new java.awt.Dimension(80, 1366));
        jPanel2.setLayout(null);

        jlProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/profile.png"))); // NOI18N
        jPanel2.add(jlProfile);
        jlProfile.setBounds(20, 20, 40, 40);

        jlAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/add.png"))); // NOI18N
        jlAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlAddMouseClicked(evt);
            }
        });
        jPanel2.add(jlAdd);
        jlAdd.setBounds(20, 180, 32, 32);

        jlTimetable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/calendar.png"))); // NOI18N
        jlTimetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlTimetableMouseClicked(evt);
            }
        });
        jPanel2.add(jlTimetable);
        jlTimetable.setBounds(20, 100, 32, 32);

        jlLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/logout.png"))); // NOI18N
        jPanel2.add(jlLogout);
        jlLogout.setBounds(20, 710, 32, 32);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 80, 770);

        jlTimtable.setFont(new java.awt.Font("Raleway", 0, 36)); // NOI18N
        jlTimtable.setText("Timetable");
        jPanel1.add(jlTimtable);
        jlTimtable.setBounds(130, 30, 190, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/close.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(1310, 20, 32, 32);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAddMouseClicked
        this.jpDemo.setVisible(true);
        this.jpSubject.setVisible(true);
        this.jspTimetable.setVisible(false);
    }//GEN-LAST:event_jlAddMouseClicked

    private void jlTimetableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlTimetableMouseClicked
        this.jpDemo.setVisible(false);
        this.jspTimetable.setVisible(true);
    }//GEN-LAST:event_jlTimetableMouseClicked
    private void initTimetable() {
        try {
        new TimeTable().generateTimetable(new File("/Users/gauravpunjabi/Desktop/Timetable.xml"));
        }catch(Exception e){}
        XmlParser parser = new XmlParser(new File("/Users/gauravpunjabi/Desktop/Timetable.xml"));
        ArrayList<Day> timeTable = parser.parseTimetable();
        System.out.println("Day : " + timeTable);
        int x = 90;
        System.out.println("Day " + timeTable.size());
        for(int i=0;i<timeTable.size();i++) {
            for(int j=0,y=60;j<6;j++,y+=160) {
                Lecture lecture = timeTable.get(i).getLecture(j);
                System.out.println("Lecture : " + " " + timeTable.get(i).getLecture(j).getName());
                SubjectComponent component = new SubjectComponent(lecture.getName(), "SHUBHAM VIRA", lecture.isTheory(), 407);
                jpTimetable.add(component, new org.netbeans.lib.awtextra.AbsoluteConstraints(x,y,377,120));
            }
            x+=387;
        }
    }
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
                if ("Macintosh".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlAdd;
    private javax.swing.JLabel jlFriday;
    private javax.swing.JLabel jlLogout;
    private javax.swing.JLabel jlMonday;
    private javax.swing.JLabel jlProfile;
    private javax.swing.JLabel jlSaturday;
    private javax.swing.JLabel jlThursday;
    private javax.swing.JLabel jlTimetable;
    private javax.swing.JLabel jlTimtable;
    private javax.swing.JLabel jlTuesday;
    private javax.swing.JLabel jlWednesday;
    private javax.swing.JPanel jpDemo;
    private javax.swing.JPanel jpTimetable;
    private javax.swing.JScrollPane jspTimetable;
    // End of variables declaration//GEN-END:variables
    private AddSubjects jpSubject;
}
