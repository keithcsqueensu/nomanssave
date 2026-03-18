package nomanssave;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

class bQ extends DefaultListCellRenderer {
   // $FF: synthetic field
   final InventoryPanel JsonParseException;

   bQ(InventoryPanel var1) {
      this.JsonParseException = var1;
   }

   public Component getListCellRendererComponent(JList var1, Object var2, int var3, boolean var4, boolean var5) {
      if (var2 instanceof Inventory) {
         var2 = ((Inventory)var2).getSimpleName();
      }

      return super.getListCellRendererComponent(var1, var2, var3, var4, var5);
   }
}
