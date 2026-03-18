package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class n implements ActionListener {
   // $FF: synthetic field
   final h ShowErrorRunnable;

   n(h var1) {
      this.ShowErrorRunnable = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.ShowErrorRunnable.setVisible(false);
   }
}
