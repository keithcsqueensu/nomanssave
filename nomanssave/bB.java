package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class bB implements ComboBoxModel {
   er eu;
   // $FF: synthetic field
   final FrigatesPanel er;

   private bB(FrigatesPanel var1) {
      this.er = var1;
   }

   public int getSize() {
      return FrigatesPanel.AboutDialog(this.er) == null ? 0 : FrigatesPanel.AboutDialog(this.er).length;
   }

   public er RefreshRunnable(int var1) {
      return FrigatesPanel.AboutDialog(this.er) == null ? null : FrigatesPanel.AboutDialog(this.er)[var1];
   }

   public void addListDataListener(ListDataListener var1) {
   }

   public void removeListDataListener(ListDataListener var1) {
   }

   public void setSelectedItem(Object var1) {
      this.eu = (er)var1;
      if (FrigatesPanel.AboutDialogCloseListener(this.er) >= 0) {
         er var2 = FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].ar(0);
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
               FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].AboutDialog(0, (er)null);
            } else {
               FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].AboutDialog(0, this.eu);
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

   // $FF: synthetic method
   bB(FrigatesPanel var1, bB var2) {
      this(var1);
   }
}
