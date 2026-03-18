package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class bC implements ComboBoxModel {
   final int ev;
   er eu;
   // $FF: synthetic field
   final FrigatesPanel er;

   bC(FrigatesPanel var1, int var2) {
      this.er = var1;
      this.ev = var2;
   }

   public int getSize() {
      return 1 + (FrigatesPanel.f(this.er) == null ? 0 : FrigatesPanel.f(this.er).length);
   }

   public er RefreshRunnable(int var1) {
      if (var1 == 0) {
         return null;
      } else {
         return FrigatesPanel.f(this.er) == null ? null : FrigatesPanel.f(this.er)[var1 - 1];
      }
   }

   public void addListDataListener(ListDataListener var1) {
   }

   public void removeListDataListener(ListDataListener var1) {
   }

   public void setSelectedItem(Object var1) {
      this.eu = (er)var1;
      if (FrigatesPanel.AboutDialogCloseListener(this.er) >= 0) {
         er var2 = FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].ar(this.ev);
         if (this.eu != var2) {
            int var3;
            int var4;
            if (var2 != null) {
               var3 = var2.aU().ordinal();
               var4 = FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].aq(var3) - var2.aV();
               if (var4 < 0) {
                  var4 = 0;
               }

               FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].e(var3, var4);
               FrigatesPanel.d(this.er)[var3].setText(Integer.toString(var4));
            }

            if (this.eu == null) {
               FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].AboutDialog(this.ev, (er)null);
            } else {
               FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].AboutDialog(this.ev, this.eu);
               var3 = this.eu.aU().ordinal();
               var4 = FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].aq(var3) + this.eu.aV();
               if (var4 < 0) {
                  var4 = 0;
               }

               FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].e(var3, var4);
               FrigatesPanel.d(this.er)[var3].setText(Integer.toString(var4));
            }

            FrigatesPanel.e(this.er).updateUI();
         }
      }

   }

   public Object getSelectedItem() {
      return this.eu;
   }

   // $FF: synthetic method
   public Object getElementAt(int var1) {
      return this.RefreshRunnable(var1);
   }
}
