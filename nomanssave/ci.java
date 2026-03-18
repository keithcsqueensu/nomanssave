package nomanssave;

class ci extends ValidatedTextField {
   // $FF: synthetic field
   final ItemDetailsDialog fF;

   ci(ItemDetailsDialog var1) {
      this.fF = var1;
   }

   protected String g(String var1) {
      if (ItemDetailsDialog.d(this.fF) == null) {
         return "";
      } else {
         try {
            int var2 = hf.AboutDialogCloseListener(var1, 1, ItemDetailsDialog.AboutDialogCloseListener(this.fF).dB());
            if (ItemDetailsDialog.d(this.fF) != var2) {
               ItemDetailsDialog.AboutDialogCloseListener(this.fF).aA(var2);
               ItemDetailsDialog.AboutDialogCloseListener(this.fF, new Integer(var2));
            }
         } catch (RuntimeException var3) {
         }

         return ItemDetailsDialog.d(this.fF).toString();
      }
   }
}
