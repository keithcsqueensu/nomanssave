package nomanssave;

class dm extends ValidatedTextField {
   // $FF: synthetic field
   final MultitoolPanel GalacticAddress;

   dm(MultitoolPanel var1) {
      this.GalacticAddress = var1;
   }

   protected String g(String var1) {
      Multitool var2 = (Multitool)MultitoolPanel.j(this.GalacticAddress).getSelectedItem();
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
