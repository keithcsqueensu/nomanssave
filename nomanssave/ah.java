package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ah implements ActionListener {
   // $FF: synthetic field
   final CompanionsPanel bV;

   ah(CompanionsPanel var1) {
      this.bV = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      Companion var2 = (Companion)CompanionsPanel.k(this.bV).getSelectedItem();
      if (var2 != null) {
         if (CompanionsPanel.h(this.bV).isSelected() ^ var2.cQ()) {
            var2.d(CompanionsPanel.h(this.bV).isSelected());
         }

      }
   }
}
