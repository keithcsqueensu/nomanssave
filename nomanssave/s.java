package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class s implements ActionListener {
   // $FF: synthetic field
   final p BasesStoragePanel;

   s(p var1) {
      this.BasesStoragePanel = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.BasesStoragePanel.setVisible(false);
   }
}
