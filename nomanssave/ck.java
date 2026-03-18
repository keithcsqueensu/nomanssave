package nomanssave;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class ck extends WindowAdapter {
   // $FF: synthetic field
   final ItemDetailsDialog fF;

   ck(ItemDetailsDialog var1) {
      this.fF = var1;
   }

   public void windowClosing(WindowEvent var1) {
      ItemDetailsDialog.e(this.fF).N();
      ItemDetailsDialog.f(this.fF).N();
   }
}
