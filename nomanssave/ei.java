package nomanssave;

class ei extends ValidatedTextField {
   // $FF: synthetic field
   final ec ik;
   // $FF: synthetic field
   private final int il;

   ei(ec var1, int var2) {
      this.ik = var1;
      this.il = var2;
   }

   protected String g(String var1) {
      try {
         int var2 = Integer.parseInt(var1);
         if (var2 != SquadronPanel.AboutDialog(ec.h(this.ik))[this.il].eh()) {
            SquadronPanel.AboutDialog(ec.h(this.ik))[this.il].aI(var2);
         }

         return var1;
      } catch (RuntimeException var3) {
         return Integer.toString(SquadronPanel.AboutDialog(ec.h(this.ik))[this.il].eh());
      }
   }
}
