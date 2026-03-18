package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bY implements ActionListener {
   // $FF: synthetic field
   final InventorySlotPanel fk;

   bY(InventorySlotPanel var1) {
      this.fk = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if (InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk)).dp() || en.aS()) {
         if (InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk)).dv()) {
            InventoryPanel.AccountPanel(InventorySlotPanel.j(this.fk));
         }

      }
   }
}
