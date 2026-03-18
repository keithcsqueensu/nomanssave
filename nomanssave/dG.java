package nomanssave;

class dG extends ValidatedTextField {
   // $FF: synthetic field
   final SettlementsPanel hE;

   dG(SettlementsPanel var1) {
      this.hE = var1;
   }

   protected String g(String var1) {
      SettlementState var2 = (SettlementState)SettlementsPanel.AboutDialog(this.hE).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         var1 = var1.trim();
         if (!var1.equals(var2.getName())) {
            var2.setName(var1);
            SettlementsPanel.AccountPanel(this.hE).setText(var1);
         }

         return var1;
      }
   }
}
