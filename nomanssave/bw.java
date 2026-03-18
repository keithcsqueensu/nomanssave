package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class bw implements ComboBoxModel {
   FrigateClass et;
   // $FF: synthetic field
   final FrigatesPanel er;

   bw(FrigatesPanel var1) {
      this.er = var1;
   }

   public int getSize() {
      return FrigateClass.values().length;
   }

   public FrigateClass u(int var1) {
      return FrigateClass.values()[var1];
   }

   public void addListDataListener(ListDataListener var1) {
   }

   public void removeListDataListener(ListDataListener var1) {
   }

   public void setSelectedItem(Object var1) {
      this.et = (FrigateClass)var1;
      FrigatesPanel.AboutDialog(this.er, FrigatesPanel.AboutDialogCloseListener(this.er) < 0 ? null : nomanssave.er.AboutDialog(this.et));
      FrigatesPanel.AboutDialogCloseListener(this.er, FrigatesPanel.AboutDialogCloseListener(this.er) < 0 ? null : nomanssave.er.AboutDialogCloseListener(this.et));
      if (FrigatesPanel.AboutDialogCloseListener(this.er) >= 0 && this.et != null && !this.et.equals(FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].da())) {
         FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].AccountPanel(this.et);
         if (FrigatesPanel.AboutDialog(this.er) != null && FrigatesPanel.AboutDialog(this.er).length > 0) {
            FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].AboutDialog(0, FrigatesPanel.AboutDialog(this.er)[0]);
            FrigatesPanel.p(this.er).setSelectedItem(FrigatesPanel.AboutDialog(this.er)[0]);
         } else {
            FrigatesPanel.p(this.er).setSelectedItem((Object)null);
         }

         FrigatesPanel.q(this.er).setSelectedItem((Object)null);
         FrigatesPanel.r(this.er).setSelectedItem((Object)null);
         FrigatesPanel.s(this.er).setSelectedItem((Object)null);
         FrigatesPanel.t(this.er).setSelectedItem((Object)null);
      }

      FrigatesPanel.e(this.er).updateUI();
      FrigatesPanel.p(this.er).updateUI();
      FrigatesPanel.q(this.er).updateUI();
      FrigatesPanel.r(this.er).updateUI();
      FrigatesPanel.s(this.er).updateUI();
      FrigatesPanel.t(this.er).updateUI();
   }

   public Object getSelectedItem() {
      return this.et;
   }

   // $FF: synthetic method
   public Object getElementAt(int var1) {
      return this.u(var1);
   }
}
