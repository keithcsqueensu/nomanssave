package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

class dQ implements ActionListener {
   // $FF: synthetic field
   final ShipsPanel ia;
   // $FF: synthetic field
   private final Application bv;

   dQ(ShipsPanel var1, Application var2) {
      this.ia = var1;
      this.bv = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      int var2 = ShipsPanel.p(this.ia).getSelectedIndex();
      if (var2 >= 0 && var2 < ShipsPanel.AboutDialog(this.ia).length) {
         if (ShipsPanel.AboutDialog(this.ia).length == 1) {
            this.bv.AccountPanel("You cannot delete the only ship you have!");
         } else if (JOptionPane.showConfirmDialog(this.ia, "Are you sure you want to delete this ship?\nAll items and technology in the ship inventory will be lost!", "Delete", 2) == 0) {
            this.bv.i(ShipsPanel.AboutDialog(this.ia)[var2].getIndex());
         }
      }
   }
}
