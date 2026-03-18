package nomanssave;

class by extends ValidatedTextField {
   // $FF: synthetic field
   final FrigatesPanel er;

   by(FrigatesPanel var1) {
      this.er = var1;
   }

   protected String g(String var1) {
      if (FrigatesPanel.AboutDialogCloseListener(this.er) < 0) {
         return "";
      } else {
         try {
            var1 = hg.aB(var1).toString();
            if (!var1.equals(FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].cV())) {
               FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].ai(var1);
            }

            return var1;
         } catch (RuntimeException var3) {
            return FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].cV();
         }
      }
   }
}
