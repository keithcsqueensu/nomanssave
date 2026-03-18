package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AboutDialogCloseListener implements ActionListener {
   // $FF: synthetic field
   final AboutDialog AboutDialogCloseListener;

   AboutDialogCloseListener(AboutDialog var1) {
      this.AboutDialogCloseListener = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.AboutDialogCloseListener.setVisible(false);
   }
}
