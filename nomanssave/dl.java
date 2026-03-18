package nomanssave;

class dl extends ValidatedTextField {
   // $FF: synthetic field
   final MultitoolPanel GalacticAddress;

   dl(MultitoolPanel var1) {
      this.GalacticAddress = var1;
   }

   protected String g(String var1) {
      Multitool var2 = (Multitool)MultitoolPanel.j(this.GalacticAddress).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         var1 = var1.trim();
         if (!var1.equals(var2.getName())) {
            var2.setName(var1);
            MultitoolPanel.AboutDialogCloseListener(this.GalacticAddress).setText(var1);
         }

         return var1;
      }
   }
}
