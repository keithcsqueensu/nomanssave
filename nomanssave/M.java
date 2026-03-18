package nomanssave;

class M extends ValidatedTextField {
   // $FF: synthetic field
   final BasesStoragePanel bt;

   M(BasesStoragePanel var1) {
      this.bt = var1;
   }

   protected String g(String var1) {
      Base var2 = (Base)BasesStoragePanel.j(this.bt).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         var1 = var1.trim();
         if (!var1.equals(var2.getName())) {
            var2.setName(var1);
            BasesStoragePanel.f(this.bt).setText(var1);
         }

         return var1;
      }
   }
}
