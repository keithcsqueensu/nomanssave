package nomanssave;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bR implements ActionListener {
   // $FF: synthetic field
   final InventoryPanel JsonParseException;

   bR(InventoryPanel var1) {
      this.JsonParseException = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if (InventoryPanel.AboutDialog(this.JsonParseException) != null) {
         Dimension var2 = aQ.AboutDialog(this.JsonParseException, InventoryPanel.AboutDialog(this.JsonParseException).getSize(), InventoryPanel.AboutDialog(this.JsonParseException).dm(), InventoryPanel.AboutDialog(this.JsonParseException).dn());
         if (var2 != null && InventoryPanel.AboutDialog(this.JsonParseException).AboutDialog(var2)) {
            InventoryPanel.AccountPanel(this.JsonParseException);
         }

      }
   }
}
