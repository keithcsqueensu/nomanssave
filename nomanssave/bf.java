package nomanssave;

class bf extends ValidatedTextField {
   // $FF: synthetic field
   final FreighterPanel dP;

   bf(FreighterPanel var1) {
      this.dP = var1;
   }

   protected String g(String var1) {
      if (FreighterPanel.AboutDialog(this.dP) == null) {
         return "";
      } else {
         try {
            var1 = var1.trim();
            if (!var1.equals(FreighterPanel.AboutDialog(this.dP).cU())) {
               FreighterPanel.AboutDialog(this.dP).ah(var1);
               FreighterPanel.AccountPanel(this.dP).setText(var1);
            }

            return var1;
         } catch (RuntimeException var3) {
            return FreighterPanel.AboutDialog(this.dP).cU();
         }
      }
   }
}
