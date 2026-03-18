package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class dF implements ComboBoxModel {
   private SettlementState hD;
   // $FF: synthetic field
   final SettlementsPanel hE;

   dF(SettlementsPanel var1) {
      this.hE = var1;
      this.hD = null;
   }

   public int getSize() {
      return SettlementsPanel.AboutDialogCloseListener(this.hE) == null ? 0 : SettlementsPanel.AboutDialogCloseListener(this.hE).length;
   }

   public SettlementState FileComboBoxModel(int var1) {
      return SettlementsPanel.AboutDialogCloseListener(this.hE)[var1];
   }

   public void addListDataListener(ListDataListener var1) {
   }

   public void removeListDataListener(ListDataListener var1) {
   }

   public void setSelectedItem(Object var1) {
      this.hD = (SettlementState)var1;
      int var2;
      if (this.hD == null) {
         SettlementsPanel.AccountPanel(this.hE).setText("");
         SettlementsPanel.d(this.hE).setText("");

         for(var2 = 0; var2 < SettlementsPanel.e(this.hE).length; ++var2) {
            SettlementsPanel.e(this.hE)[var2].setText("");
         }

         SettlementsPanel.f(this.hE).AboutDialog(new gF[0]);
      } else {
         SettlementsPanel.AccountPanel(this.hE).setText(this.hD.getName());
         SettlementsPanel.d(this.hE).setText(this.hD.cK());

         for(var2 = 0; var2 < SettlementsPanel.e(this.hE).length; ++var2) {
            SettlementsPanel.e(this.hE)[var2].setText(Integer.toString(this.hD.aq(var2)));
         }

         SettlementsPanel.f(this.hE).AboutDialog(this.hD.dX());
      }

      SettlementsPanel.g(this.hE).revalidate();
   }

   public Object getSelectedItem() {
      return this.hD;
   }

   // $FF: synthetic method
   public Object getElementAt(int var1) {
      return this.FileComboBoxModel(var1);
   }
}
