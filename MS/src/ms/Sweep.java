
package ms;
import javax.swing.JToggleButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Sweep extends javax.swing.JFrame {
   final int wid=9, hei=9, noOfBomba=10;
   JToggleButton[][] blocks=new JToggleButton[hei][wid];
   int[][] blox=new int[hei][wid];
   boolean first=false,canPlay;
   
   
   ActionListener listen = new ActionListener(){
   public void actionPerformed(ActionEvent e){
         int i = 0, j = 0;
            boolean found = false;
            for(i = 0; i < hei; i++){
                for(j = 0; j < wid; j++){
                    if(e.getSource() == blocks[i][j]){
                        found = true;
                        break;
   }}
                if(found) break; 
            }
            if(canPlay){
                blocks[i][j].setSelected(true);
             if(!first){
                spawm(i, j);
                first = true;
   }
             if(blox[i][j]!= -1 ){
                    open(i,j);
                    reval();
             } else lose();
             checkWin();
            } else reval();
            
   };
   private void checkWin(){
      boolean won = true;
        for(int i = 0; i < hei; i++){
            for(int j = 0; j < wid; j++){
                if(blox[i][j] == 0) {
                    won = false;
                    break;
                } }
              if(!won) break;
   }
         if(won){
            javax.swing.JOptionPane.showMessageDialog(null, "You win!!!");
            canPlay=false;
         }}
   private void lose() {
       canPlay = false;
        for(int i = 0; i < hei; i++){
            for(int j = 0; j < wid; j++){
                if(blox[i][j] == -1) {
                    blocks[i][j].setText("BOOM");
                    blocks[i][j].setSelected(true);

   }}}}
   
   
   private void open(int y, int x){
        if(y < 0 || x < 0 || x > wid - 1 || y > hei - 1 || blox[y][x] != 0) return;
        int bomba = 0;
        for(int i = y - 1; i <= y + 1;i++){
            for(int j = x - 1; j <= x + 1;j++){
                if(!(j < 0 || i < 0 || j > wid - 1 || i > hei - 1) && blox[i][j] == -1)
                    bomba++;
   }
        }
        if(bomba == 0){
            blox[y][x] = -2;
            for(int i = y - 1; i <= y + 1;i++){
                for(int j = x - 1; j <= x + 1;j++){
                    if(!(j < 0 || i < 0 || j > wid - 1 || i > hei - 1))
                    if(i != y || j != x) open(i,j);
   }
            }
        }else blox[y][x] = bomba;
   }
                
    
    

                
    private void spawm (int y, int x){
         for(int k = 1; k <= noOfBomba;k++){
            int i, j;
            do{
                i = (int)(Math.random()*(wid-.01));
                j = (int)(Math.random()*(hei-.01));
            }
            while(blox[i][j] == -1 || (i == y && j == x));
            blox[i][j] = -1;
            
    }}
    }
    ;
                                        
    public Sweep() {
        initComponents();
        for(int i=0;i<hei;i++){
            for(int j=0;j<wid;j++){
                blocks[i][j]=new JToggleButton();
                blocks[i][j].setSize(jPanel1.getWidth()/wid, jPanel1.getHeight()/hei);
                jPanel1.add(blocks[i][j]);
                blocks[i][j].setLocation(j*jPanel1.getWidth()/wid, i*jPanel1.getHeight()/hei);
                blocks[i][j].addActionListener(listen);
                
            }
        }
        first = false;
        canPlay = true;
    }
    private void resiz(){
      for(int i = 0; i < hei; i++){
            for(int j = 0; j < wid; j++){
                blocks[i][j].setSize(jPanel1.getWidth()/wid, jPanel1.getHeight()/hei);
                jPanel1.add(blocks[i][j]);
                blocks[i][j].setLocation(j*jPanel1.getWidth()/wid, i*jPanel1.getHeight()/hei);
            }}}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(0, 102, 255));
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 491, Short.MAX_VALUE)
        );

        jButton1.setText(":)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(445, 445, 445)
                .addComponent(jButton1)
                .addGap(0, 456, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
      resiz();
    }//GEN-LAST:event_jPanel1ComponentResized

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        blox= new int[hei][wid];
        reval();
        canPlay=true;
        first=false;
    }//GEN-LAST:event_jButton1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(Sweep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sweep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sweep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sweep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sweep().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables

    private void reval() {     
        for(int i = 0; i < hei; i++){
            for(int j = 0; j < wid; j++){
                if(blox[i][j] == 0){
                    blocks[i][j].setText("");
                    blocks[i][j].setSelected(false);

                }
                if(blox[i][j] == -2){
                    blocks[i][j].setText("");
                    blocks[i][j].setSelected(true);
                }
                if(blox[i][j] > 0){
                    blocks[i][j].setText(""+blox[i][j]);
                    blocks[i][j].setSelected(true);
                }
                if(!canPlay && blox[i][j] == -1) blocks[i][j].setSelected(true);
            }
        }
        jPanel1.repaint();
    }
    }

   

