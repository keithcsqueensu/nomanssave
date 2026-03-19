package nomanssave;

class aO extends ValidatedTextField {
   // $FF: synthetic field
   final ExosuitPanel MultitoolPanel;

   aO(ExosuitPanel var1) {
      this.MultitoolPanel = var1;
   }

   protected String g(String var1) {
      if (ExosuitPanel.AboutDialog(this.MultitoolPanel) == null) {
         return "";
      } else {
         long var2 = ExosuitPanel.AboutDialog(this.MultitoolPanel).dK();

         try {
            long var4 = hf.parseLongClamped(var1, 0L, 4294967295L);
            if (var4 != var2) {
               ExosuitPanel.AboutDialog(this.MultitoolPanel).f(var4);
            }

            return Long.toString(var4);
         } catch (RuntimeException var6) {
            return Long.toString(var2);
         }
      }
   }
}
