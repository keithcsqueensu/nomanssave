package nomanssave;

class ef extends ValidatedTextField {
   // $FF: synthetic field
   final ec ik;
   // $FF: synthetic field
   private final int il;

   ef(ec var1, int var2) {
      this.ik = var1;
      this.il = var2;
   }

   protected String g(String var1) {
      try {
         var1 = hg.aB(var1).toString();
         if (!var1.equals(SquadronPanel.AboutDialog(ec.h(this.ik))[this.il].ee())) {
            SquadronPanel.AboutDialog(ec.h(this.ik))[this.il].ax(var1);
         }

         return var1;
      } catch (RuntimeException var3) {
         return SquadronPanel.AboutDialog(ec.h(this.ik))[this.il].ee();
      }
   }
}
