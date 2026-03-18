package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cj implements ActionListener {
   // $FF: synthetic field
   final ItemDetailsDialog fF;

   cj(ItemDetailsDialog var1) {
      this.fF = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      ItemDetailsDialog.fE.setVisible(false);
   }
}
