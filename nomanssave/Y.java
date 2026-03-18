package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class Y implements ComboBoxModel {
   private Companion bU;
   // $FF: synthetic field
   final CompanionsPanel bV;

   Y(CompanionsPanel var1) {
      this.bV = var1;
      this.bU = null;
   }

   public int getSize() {
      return CompanionsPanel.AboutDialog(this.bV) == null ? 0 : CompanionsPanel.AboutDialog(this.bV).length;
   }

   public Companion q(int var1) {
      return CompanionsPanel.AboutDialog(this.bV)[var1];
   }

   public void addListDataListener(ListDataListener var1) {
   }

   public void removeListDataListener(ListDataListener var1) {
   }

   public void setSelectedItem(Object var1) {
      this.bU = (Companion)var1;
      if (this.bU == null) {
         CompanionsPanel.AboutDialogCloseListener(this.bV).setSelectedIndex(-1);
         CompanionsPanel.AccountPanel(this.bV).setText("");
         CompanionsPanel.AccountPanel(this.bV).setEnabled(false);
         CompanionsPanel.d(this.bV).setText("");
         CompanionsPanel.d(this.bV).setEnabled(false);
         CompanionsPanel.e(this.bV).setText("");
         CompanionsPanel.e(this.bV).setEnabled(false);
         CompanionsPanel.f(this.bV).setText("");
         CompanionsPanel.f(this.bV).setEnabled(false);
         CompanionsPanel.g(this.bV).setText("");
         CompanionsPanel.g(this.bV).setEnabled(false);
         CompanionsPanel.h(this.bV).setSelected(false);
         CompanionsPanel.h(this.bV).setEnabled(false);
         CompanionsPanel.i(this.bV).setSelectedIndex(-1);
         CompanionsPanel.i(this.bV).setEnabled(false);
         CompanionsPanel.j(this.bV).setSelectedIndex(-1);
         CompanionsPanel.j(this.bV).setEnabled(false);
      } else {
         CompanionsPanel.AboutDialogCloseListener(this.bV).setSelectedIndex(this.bU.cL().ordinal());
         CompanionsPanel.AccountPanel(this.bV).setText(this.bU.getName());
         CompanionsPanel.AccountPanel(this.bV).setEnabled(true);
         CompanionsPanel.d(this.bV).setText(this.bU.cK());
         CompanionsPanel.d(this.bV).setEnabled(true);
         CompanionsPanel.e(this.bV).setText(this.bU.cN());
         CompanionsPanel.e(this.bV).setEnabled(true);
         CompanionsPanel.f(this.bV).setText(this.bU.cO());
         CompanionsPanel.f(this.bV).setEnabled(true);
         CompanionsPanel.g(this.bV).setText(this.bU.cP());
         CompanionsPanel.g(this.bV).setEnabled(true);
         CompanionsPanel.h(this.bV).setSelected(this.bU.cQ());
         CompanionsPanel.h(this.bV).setEnabled(true);
         CompanionsPanel.i(this.bV).m(this.bU.cR());
         CompanionsPanel.i(this.bV).setEnabled(true);
         CompanionsPanel.j(this.bV).m(this.bU.cS());
         CompanionsPanel.j(this.bV).setEnabled(true);
      }

   }

   public Object getSelectedItem() {
      return this.bU;
   }

   // $FF: synthetic method
   public Object getElementAt(int var1) {
      return this.q(var1);
   }
}
