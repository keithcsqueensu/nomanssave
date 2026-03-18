package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cc implements ActionListener {
   // $FF: synthetic field
   final InventorySlotPanel fk;

   cc(InventorySlotPanel var1) {
      this.fk = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if (InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk)).dr()) {
         InventoryPanel.AccountPanel(InventorySlotPanel.j(this.fk));
      }

   }
}
