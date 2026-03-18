package nomanssave;

class ag extends ValidatedTextField {
   // $FF: synthetic field
   final CompanionsPanel bV;

   ag(CompanionsPanel var1) {
      this.bV = var1;
   }

   protected String g(String var1) {
      Companion var2 = (Companion)CompanionsPanel.k(this.bV).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         var1 = var1.trim();
         if (!var1.equals(var2.cP())) {
            var2.ad(var1);
            CompanionsPanel.g(this.bV).setText(var1);
         }

         return var1;
      }
   }
}
