package nomanssave;

class dU extends ValidatedTextField {
   // $FF: synthetic field
   final ShipsPanel ia;

   dU(ShipsPanel var1) {
      this.ia = var1;
   }

   protected String g(String var1) {
      Starship var2 = (Starship)ShipsPanel.p(this.ia).getSelectedItem();
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
