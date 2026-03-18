package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dR implements ActionListener {
   // $FF: synthetic field
   final ShipsPanel ia;
   // $FF: synthetic field
   private final Application bv;

   dR(ShipsPanel var1, Application var2) {
      this.ia = var1;
      this.bv = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      int var2 = ShipsPanel.p(this.ia).getSelectedIndex();
      if (var2 >= 0 && var2 < ShipsPanel.AboutDialog(this.ia).length) {
         this.bv.AboutDialog(ShipsPanel.AboutDialog(this.ia)[var2]);
      }
   }
}
