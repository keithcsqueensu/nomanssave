package nomanssave;

class ea extends ValidatedTextField {
   // $FF: synthetic field
   final ShipsPanel ia;

   ea(ShipsPanel var1) {
      this.ia = var1;
   }

   protected String g(String var1) {
      Starship var2 = (Starship)ShipsPanel.p(this.ia).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         double var3 = var2.cX();

         try {
            double var5 = hf.AboutDialog(var1, 0.0D, 1000.0D);
            if (var5 != var3) {
               var2.AboutDialog(var5);
            }

            return Double.toString(var5);
         } catch (RuntimeException var7) {
            return Double.toString(var3);
         }
      }
   }
}
