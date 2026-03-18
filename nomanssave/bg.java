package nomanssave;

class bg extends ValidatedTextField {
   // $FF: synthetic field
   final FreighterPanel dP;

   bg(FreighterPanel var1) {
      this.dP = var1;
   }

   protected String g(String var1) {
      if (FreighterPanel.AboutDialog(this.dP) == null) {
         return "";
      } else {
         try {
            var1 = hg.aB(var1).toString();
            if (!var1.equals(FreighterPanel.AboutDialog(this.dP).cV())) {
               FreighterPanel.AboutDialog(this.dP).ai(var1);
            }

            return var1;
         } catch (RuntimeException var3) {
            return FreighterPanel.AboutDialog(this.dP).cV();
         }
      }
   }
}
