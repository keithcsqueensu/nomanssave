package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class t implements ActionListener {
   // $FF: synthetic field
   final p BasesStoragePanel;

   t(p var1) {
      this.BasesStoragePanel = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.BasesStoragePanel.setVisible(false);
   }
}
