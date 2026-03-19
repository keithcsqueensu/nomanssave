package nomanssave;

class do extends ValidatedTextField {
   // $FF: synthetic field
   final MultitoolPanel GalacticAddress;

   do(MultitoolPanel var1) {
      this.GalacticAddress = var1;
   }

   protected String g(String var1) {
      Multitool var2 = (Multitool)MultitoolPanel.j(this.GalacticAddress).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         double var3 = var2.dG();

         try {
            double var5 = hf.parseDoubleClamped(var1, 0.0D, 1000.0D);
            if (var5 != var3) {
               var2.e(var5);
            }

            return Double.toString(var5);
         } catch (RuntimeException var7) {
            return Double.toString(var3);
         }
      }
   }
}
