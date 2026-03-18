package nomanssave;

import java.util.Collections;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class dk implements ComboBoxModel {
   private Multitool hk;
   // $FF: synthetic field
   final MultitoolPanel GalacticAddress;

   dk(MultitoolPanel var1) {
      this.GalacticAddress = var1;
      this.hk = null;
   }

   public int getSize() {
      return MultitoolPanel.AboutDialog(this.GalacticAddress) == null ? 0 : MultitoolPanel.AboutDialog(this.GalacticAddress).length;
   }

   public Multitool SlotComboBoxModel(int var1) {
      return MultitoolPanel.AboutDialog(this.GalacticAddress)[var1];
   }

   public void addListDataListener(ListDataListener var1) {
   }

   public void removeListDataListener(ListDataListener var1) {
   }

   public void setSelectedItem(Object var1) {
      this.hk = (Multitool)var1;
      if (this.hk == null) {
         MultitoolPanel.AboutDialogCloseListener(this.GalacticAddress).setText("");
         MultitoolPanel.AccountPanel(this.GalacticAddress).setSelectedIndex(-1);
         MultitoolPanel.d(this.GalacticAddress).setSelectedIndex(-1);
         MultitoolPanel.e(this.GalacticAddress).setText("");
         MultitoolPanel.f(this.GalacticAddress).setText("");
         MultitoolPanel.g(this.GalacticAddress).setText("");
         MultitoolPanel.h(this.GalacticAddress).setText("");
         MultitoolPanel.i(this.GalacticAddress).AboutDialog(Collections.emptyList());
      } else {
         MultitoolPanel.AboutDialogCloseListener(this.GalacticAddress).setText(this.hk.getName());
         MultitoolPanel.AccountPanel(this.GalacticAddress).m(this.hk.cT());
         MultitoolPanel.d(this.GalacticAddress).m(this.hk.LineNumberPanel());
         MultitoolPanel.e(this.GalacticAddress).setText(this.hk.cK());
         MultitoolPanel.f(this.GalacticAddress).setText(Double.toString(this.hk.dF()));
         MultitoolPanel.g(this.GalacticAddress).setText(Double.toString(this.hk.dG()));
         MultitoolPanel.h(this.GalacticAddress).setText(Double.toString(this.hk.dH()));
         MultitoolPanel.i(this.GalacticAddress).AboutDialog(Collections.singletonList(this.hk.SettlementsPanel()));
      }
   }

   public Object getSelectedItem() {
      return this.hk;
   }

   // $FF: synthetic method
   public Object getElementAt(int var1) {
      return this.SlotComboBoxModel(var1);
   }
}
