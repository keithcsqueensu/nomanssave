package nomanssave;

class bv extends ValidatedTextField {
   // $FF: synthetic field
   final FrigatesPanel er;

   bv(FrigatesPanel var1) {
      this.er = var1;
   }

   protected String g(String var1) {
      if (FrigatesPanel.AboutDialogCloseListener(this.er) < 0) {
         return "";
      } else {
         var1 = var1.trim();
         if (!var1.equals(FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].getName())) {
            FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].setName(var1);
            FrigatesPanel.j(this.er).setText(var1);
            FrigatesPanel.e(this.er).updateUI();
         }

         return var1;
      }
   }
}
