package nomanssave;

class be extends ValidatedTextField {
   // $FF: synthetic field
   final FreighterPanel dP;

   be(FreighterPanel var1) {
      this.dP = var1;
   }

   protected String g(String var1) {
      if (FreighterPanel.AboutDialog(this.dP) == null) {
         return "";
      } else {
         var1 = var1.trim();
         if (!var1.equals(FreighterPanel.AboutDialog(this.dP).getName())) {
            FreighterPanel.AboutDialog(this.dP).setName(var1);
            FreighterPanel.AboutDialogCloseListener(this.dP).setText(var1);
         }

         return var1;
      }
   }
}
