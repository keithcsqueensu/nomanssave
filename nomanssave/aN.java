package nomanssave;

class aN extends ValidatedTextField {
   // $FF: synthetic field
   final ExosuitPanel MultitoolPanel;
   // $FF: synthetic field
   private final Application bv;

   aN(ExosuitPanel var1, Application var2) {
      this.MultitoolPanel = var1;
      this.bv = var2;
   }

   protected String g(String var1) {
      if (ExosuitPanel.AboutDialog(this.MultitoolPanel) == null) {
         return "";
      } else {
         long var2 = ExosuitPanel.AboutDialog(this.MultitoolPanel).dJ();

         try {
            long var4 = hf.AboutDialog(var1, 0L, 4294967295L);
            if (var4 != var2) {
               ExosuitPanel.AboutDialog(this.MultitoolPanel).e(var4);
               this.bv.C();
            }

            return Long.toString(var4);
         } catch (RuntimeException var6) {
            return Long.toString(var2);
         }
      }
   }
}
