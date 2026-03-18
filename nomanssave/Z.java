package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Z implements ActionListener {
   // $FF: synthetic field
   final CompanionsPanel bV;
   // $FF: synthetic field
   private final Application bv;

   Z(CompanionsPanel var1, Application var2) {
      this.bV = var1;
      this.bv = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      Companion var2 = (Companion)CompanionsPanel.k(this.bV).getSelectedItem();
      if (var2 != null) {
         this.bv.AboutDialog(var2);
      }

   }
}
