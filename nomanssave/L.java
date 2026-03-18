package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class L implements ComboBoxModel {
   Base bu;
   // $FF: synthetic field
   final BasesStoragePanel bt;

   L(BasesStoragePanel var1) {
      this.bt = var1;
      this.bu = null;
   }

   public int getSize() {
      return BasesStoragePanel.AboutDialog(this.bt) == null ? 0 : BasesStoragePanel.AboutDialog(this.bt).cE().size();
   }

   public Base p(int var1) {
      return BasesStoragePanel.AboutDialog(this.bt) == null ? null : (Base)BasesStoragePanel.AboutDialog(this.bt).cE().get(var1);
   }

   public void addListDataListener(ListDataListener var1) {
   }

   public void removeListDataListener(ListDataListener var1) {
   }

   public void setSelectedItem(Object var1) {
      this.bu = (Base)var1;
      if (this.bu == null) {
         BasesStoragePanel.e(this.bt).setText("");
         BasesStoragePanel.f(this.bt).setText("");
         BasesStoragePanel.f(this.bt).setEnabled(false);
         BasesStoragePanel.g(this.bt).setEnabled(false);
         BasesStoragePanel.h(this.bt).setEnabled(false);
         BasesStoragePanel.i(this.bt).setEnabled(false);
      } else {
         BasesStoragePanel.e(this.bt).setText(Integer.toString(this.bu.cG()));
         BasesStoragePanel.f(this.bt).setText(this.bu.getName());
         BasesStoragePanel.f(this.bt).setEnabled(true);
         BasesStoragePanel.g(this.bt).setEnabled(true);
         BasesStoragePanel.h(this.bt).setEnabled(true);
         BasesStoragePanel.i(this.bt).setEnabled(true);
      }

   }

   public Object getSelectedItem() {
      return this.bu;
   }

   // $FF: synthetic method
   public Object getElementAt(int var1) {
      return this.p(var1);
   }
}
