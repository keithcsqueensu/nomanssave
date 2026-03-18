package nomanssave;

class af extends ValidatedTextField {
   // $FF: synthetic field
   final CompanionsPanel bV;

   af(CompanionsPanel var1) {
      this.bV = var1;
   }

   protected String g(String var1) {
      Companion var2 = (Companion)CompanionsPanel.k(this.bV).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         var1 = var1.trim();
         if (!var1.equals(var2.cO())) {
            var2.ac(var1);
            CompanionsPanel.f(this.bV).setText(var1);
         }

         return var1;
      }
   }
}
