package nomanssave;

class bi extends ValidatedTextField {
   // $FF: synthetic field
   final FreighterPanel dP;

   bi(FreighterPanel var1) {
      this.dP = var1;
   }

   protected String g(String var1) {
      if (FreighterPanel.AboutDialog(this.dP) == null) {
         return "";
      } else {
         double var2 = FreighterPanel.AboutDialog(this.dP).cY();

         try {
            double var4 = hf.AboutDialog(var1, 0.0D, 1000.0D);
            if (var4 != var2) {
               FreighterPanel.AboutDialog(this.dP).AboutDialogCloseListener(var4);
            }

            return Double.toString(var4);
         } catch (RuntimeException var6) {
            return Double.toString(var2);
         }
      }
   }
}
