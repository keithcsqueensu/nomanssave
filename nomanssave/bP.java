package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class bP implements ComboBoxModel {
   // $FF: synthetic field
   final InventoryPanel JsonParseException;

   bP(InventoryPanel var1) {
      this.JsonParseException = var1;
   }

   public int getSize() {
      return InventoryPanel.d(this.JsonParseException).size();
   }

   public Inventory AppStartupRunnable(int var1) {
      return (Inventory)InventoryPanel.d(this.JsonParseException).get(var1);
   }

   public void addListDataListener(ListDataListener var1) {
   }

   public void removeListDataListener(ListDataListener var1) {
   }

   public void setSelectedItem(Object var1) {
      InventoryPanel.AboutDialog(this.JsonParseException, (Inventory)var1);
      InventoryPanel.e(this.JsonParseException).setVisible(InventoryPanel.AboutDialog(this.JsonParseException) == null ? false : en.aS() || InventoryPanel.AboutDialog(this.JsonParseException).dk());
      InventoryPanel.AccountPanel(this.JsonParseException);
   }

   public Object getSelectedItem() {
      return InventoryPanel.AboutDialog(this.JsonParseException);
   }

   // $FF: synthetic method
   public Object getElementAt(int var1) {
      return this.AppStartupRunnable(var1);
   }
}
