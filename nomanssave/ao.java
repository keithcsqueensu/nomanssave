package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ao implements ActionListener {
   // $FF: synthetic field
   final aj ItemDetailsDialog;

   ao(aj var1) {
      this.ItemDetailsDialog = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.ItemDetailsDialog.setVisible(false);
   }
}
