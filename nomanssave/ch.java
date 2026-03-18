package nomanssave;

class ch extends ValidatedTextField {
   // $FF: synthetic field
   final ItemDetailsDialog fF;

   ch(ItemDetailsDialog var1) {
      this.fF = var1;
   }

   protected String g(String var1) {
      if (ItemDetailsDialog.AboutDialog(this.fF) == null) {
         return "";
      } else {
         try {
            int var2 = hf.AboutDialogCloseListener(var1, 0, 99999);
            if (ItemDetailsDialog.AboutDialog(this.fF) != var2) {
               ItemDetailsDialog.AboutDialogCloseListener(this.fF).m(ItemDetailsDialog.AccountPanel(this.fF).M(var2));
               ItemDetailsDialog.AboutDialog(this.fF, new Integer(var2));
            }
         } catch (RuntimeException var3) {
         }

         return ItemDetailsDialog.AboutDialog(this.fF).toString();
      }
   }
}
