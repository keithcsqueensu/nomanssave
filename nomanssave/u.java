package nomanssave;

class u implements SaveChangeListener {
   // $FF: synthetic field
   final Application aZ;

   u(Application var1) {
      this.aZ = var1;
   }

   public void AboutDialog(SaveLocation var1) {
      if (Application.loadIcon(this.aZ) && Application.AboutDialogCloseListener(this.aZ) == var1) {
         Application.AboutDialog(this.aZ, true);
      }
   }

   public void AboutDialog(SaveLocation var1, int var2, String var3) {
      if (Application.loadIcon(this.aZ) && Application.AboutDialogCloseListener(this.aZ) == var1) {
         Application.AboutDialogCloseListener(this.aZ, true);
         if (Application.AccountPanel(this.aZ) >= 0 && Application.d(this.aZ)[Application.AccountPanel(this.aZ)].getIndex() == var2) {
            Application.AccountPanel(this.aZ, true);
            if (Application.e(this.aZ) >= 0 && Application.f(this.aZ)[Application.e(this.aZ)].K().equals(var3)) {
               Application.d(this.aZ, true);
            }
         }

      }
   }
}
