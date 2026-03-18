package nomanssave;

class dW extends ValidatedTextField {
   // $FF: synthetic field
   final ShipsPanel ia;

   dW(ShipsPanel var1) {
      this.ia = var1;
   }

   protected String g(String var1) {
      if (ShipsPanel.o(this.ia) == null) {
         return "";
      } else {
         int var2 = ShipsPanel.o(this.ia).dM();

         try {
            int var3 = hf.AboutDialogCloseListener(var1, 1, 500);
            if (var3 != var2) {
               ShipsPanel.o(this.ia).aB(var3);
            }

            return Integer.toString(var3);
         } catch (RuntimeException var4) {
            return Integer.toString(var2);
         }
      }
   }
}
