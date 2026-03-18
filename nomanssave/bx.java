package nomanssave;

class bx extends ValidatedTextField {
   // $FF: synthetic field
   final FrigatesPanel er;

   bx(FrigatesPanel var1) {
      this.er = var1;
   }

   protected String g(String var1) {
      if (FrigatesPanel.AboutDialogCloseListener(this.er) < 0) {
         return "";
      } else {
         try {
            var1 = var1.trim();
            if (!var1.equals(FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].cU())) {
               FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].ah(var1);
               FrigatesPanel.n(this.er).setText(var1);
            }

            return var1;
         } catch (RuntimeException var3) {
            return FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].cU();
         }
      }
   }
}
