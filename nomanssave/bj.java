package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bj implements ActionListener {
   // $FF: synthetic field
   final FreighterPanel dP;
   // $FF: synthetic field
   private final Application bv;

   bj(FreighterPanel var1, Application var2) {
      this.dP = var1;
      this.bv = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      if (FreighterPanel.AboutDialog(this.dP) != null) {
         this.bv.AboutDialog(FreighterPanel.AboutDialog(this.dP));
      }
   }
}
