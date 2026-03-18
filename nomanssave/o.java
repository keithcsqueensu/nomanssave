package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class o implements ActionListener {
   // $FF: synthetic field
   final h ShowErrorRunnable;

   o(h var1) {
      this.ShowErrorRunnable = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.ShowErrorRunnable.setVisible(false);
   }
}
