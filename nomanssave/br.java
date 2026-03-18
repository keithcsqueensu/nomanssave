package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class br implements ActionListener {
   // $FF: synthetic field
   final FrigatesPanel er;
   // $FF: synthetic field
   private final Application bv;

   br(FrigatesPanel var1, Application var2) {
      this.er = var1;
      this.bv = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      if (FrigatesPanel.AboutDialogCloseListener(this.er) >= 0) {
         String var2 = hg.eo().toString();
         FrigatesPanel.AboutDialog(this.er, this.bv.AboutDialog(FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].getIndex(), var2));
         FrigatesPanel.g(this.er).setEnabled(FrigatesPanel.AccountPanel(this.er).length < 30 || en.aS());
         FrigatesPanel.e(this.er).updateUI();
      }
   }
}
