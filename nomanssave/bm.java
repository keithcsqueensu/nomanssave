package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

class bm implements ActionListener {
   // $FF: synthetic field
   final FrigatesPanel er;
   // $FF: synthetic field
   private final Application bv;

   bm(FrigatesPanel var1, Application var2) {
      this.er = var1;
      this.bv = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      if (FrigatesPanel.AboutDialogCloseListener(this.er) >= 0) {
         if (JOptionPane.showConfirmDialog(this.er, "Are you sure you want to delete this frigate?", "Delete", 2) == 0) {
            FrigatesPanel.AboutDialog(this.er, this.bv.k(FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].getIndex()));
            if (FrigatesPanel.AccountPanel(this.er).length > 0) {
               FrigatesPanel.e(this.er).setRowSelectionInterval(0, 0);
            } else {
               FrigatesPanel.e(this.er).clearSelection();
            }

            FrigatesPanel.e(this.er).updateUI();
         }
      }
   }
}
