package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ca implements ActionListener {
   // $FF: synthetic field
   final InventorySlotPanel fk;

   ca(InventorySlotPanel var1) {
      this.fk = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if (InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk)).dq()) {
         if (InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk)).ds()) {
            InventoryPanel.AccountPanel(InventorySlotPanel.j(this.fk));
         }

      }
   }
}
