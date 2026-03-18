package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class J implements ComboBoxModel {
   gh bs;
   // $FF: synthetic field
   final BasesStoragePanel bt;

   J(BasesStoragePanel var1) {
      this.bt = var1;
      this.bs = null;
   }

   public int getSize() {
      return BasesStoragePanel.AboutDialog(this.bt) == null ? 0 : BasesStoragePanel.AboutDialog(this.bt).cD().size();
   }

   public gh o(int var1) {
      return BasesStoragePanel.AboutDialog(this.bt) == null ? null : (gh)BasesStoragePanel.AboutDialog(this.bt).cD().get(var1);
   }

   public void addListDataListener(ListDataListener var1) {
   }

   public void removeListDataListener(ListDataListener var1) {
   }

   public void setSelectedItem(Object var1) {
      this.bs = (gh)var1;
      if (this.bs == null) {
         BasesStoragePanel.AboutDialogCloseListener(this.bt).setText("");
         BasesStoragePanel.AccountPanel(this.bt).setText("");
         BasesStoragePanel.AccountPanel(this.bt).setEnabled(false);
      } else {
         NpcType var2 = this.bs.cJ();
         BasesStoragePanel.AboutDialogCloseListener(this.bt).setText(var2 == null ? "" : var2.toString());
         BasesStoragePanel.AccountPanel(this.bt).setText(this.bs.cK());
         BasesStoragePanel.AccountPanel(this.bt).setEnabled(true);
      }

   }

   public Object getSelectedItem() {
      return this.bs;
   }

   // $FF: synthetic method
   public Object getElementAt(int var1) {
      return this.o(var1);
   }
}
