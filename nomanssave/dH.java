package nomanssave;

class dH extends ValidatedTextField {
   // $FF: synthetic field
   final SettlementsPanel hE;

   dH(SettlementsPanel var1) {
      this.hE = var1;
   }

   protected String g(String var1) {
      SettlementState var2 = (SettlementState)SettlementsPanel.AboutDialog(this.hE).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         try {
            var1 = hg.aB(var1).toString();
            if (!var1.equals(var2.cK())) {
               var2.aa(var1);
            }

            return var1;
         } catch (RuntimeException var4) {
            return var2.cK();
         }
      }
   }
}
