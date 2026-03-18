package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bk implements ActionListener {
   // $FF: synthetic field
   final FreighterPanel dP;
   // $FF: synthetic field
   private final Application bv;

   bk(FreighterPanel var1, Application var2) {
      this.dP = var1;
      this.bv = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      if (FreighterPanel.AboutDialog(this.dP) != null) {
         this.bv.AboutDialogCloseListener(FreighterPanel.AboutDialog(this.dP));
      }
   }
}
