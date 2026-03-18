package nomanssave;

class bq extends ValidatedTextField {
   // $FF: synthetic field
   final FrigatesPanel er;

   bq(FrigatesPanel var1) {
      this.er = var1;
   }

   protected String g(String var1) {
      if (FrigatesPanel.AboutDialogCloseListener(this.er) < 0) {
         return "";
      } else {
         int var2 = FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].df();

         try {
            int var3 = hf.AboutDialogCloseListener(var1, 0, Integer.MAX_VALUE);
            if (var3 != var2) {
               FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].av(var3);
            }

            return Integer.toString(var3);
         } catch (RuntimeException var4) {
            return Integer.toString(var2);
         }
      }
   }
}
