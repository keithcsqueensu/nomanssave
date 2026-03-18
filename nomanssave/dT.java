package nomanssave;

class dT extends ValidatedTextField {
   // $FF: synthetic field
   final ShipsPanel ia;

   dT(ShipsPanel var1) {
      this.ia = var1;
   }

   protected String g(String var1) {
      Starship var2 = (Starship)ShipsPanel.p(this.ia).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         var1 = var1.trim();
         if (!var1.equals(var2.getName())) {
            var2.setName(var1);
            ShipsPanel.AboutDialogCloseListener(this.ia).setText(var1);
         }

         return var1;
      }
   }
}
