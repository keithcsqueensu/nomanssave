package nomanssave;

class bA extends ValidatedTextField {
   private final int index;
   // $FF: synthetic field
   final FrigatesPanel er;

   private bA(FrigatesPanel var1, int var2) {
      this.er = var1;
      this.index = var2;
   }

   protected String g(String var1) {
      if (FrigatesPanel.AboutDialogCloseListener(this.er) < 0) {
         return "";
      } else {
         int var2 = FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].aq(this.index);

         try {
            int var3 = hf.AboutDialogCloseListener(var1, 0, 50);
            if (var3 != var2) {
               FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].e(this.index, var3);
            }

            return Integer.toString(var3);
         } catch (RuntimeException var4) {
            return Integer.toString(var2);
         }
      }
   }

   // $FF: synthetic method
   bA(FrigatesPanel var1, int var2, bA var3) {
      this(var1, var2);
   }
}
