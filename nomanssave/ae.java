package nomanssave;

class ae extends ValidatedTextField {
   // $FF: synthetic field
   final CompanionsPanel bV;

   ae(CompanionsPanel var1) {
      this.bV = var1;
   }

   protected String g(String var1) {
      Companion var2 = (Companion)CompanionsPanel.k(this.bV).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         var1 = var1.trim();
         if (!var1.equals(var2.cN())) {
            var2.ab(var1);
            CompanionsPanel.e(this.bV).setText(var1);
         }

         return var1;
      }
   }
}
