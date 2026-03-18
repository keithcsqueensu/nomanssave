package nomanssave;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class df extends MouseAdapter {
   // $FF: synthetic field
   final dd gW;

   df(dd var1) {
      this.gW = var1;
   }

   public void mouseClicked(MouseEvent var1) {
      if (var1.getClickCount() == 2) {
         dd.AboutDialog(this.gW, dd.AboutDialogCloseListener(this.gW).getSelectedIndex());
         this.gW.setVisible(false);
      }

   }
}
