package nomanssave;

class aP extends ValidatedTextField {
   // $FF: synthetic field
   final ExosuitPanel MultitoolPanel;

   aP(ExosuitPanel var1) {
      this.MultitoolPanel = var1;
   }

   protected String g(String var1) {
      if (ExosuitPanel.AboutDialog(this.MultitoolPanel) == null) {
         return "";
      } else {
         long var2 = ExosuitPanel.AboutDialog(this.MultitoolPanel).dL();

         try {
            long var4 = hf.AboutDialog(var1, 0L, 4294967295L);
            if (var4 != var2) {
               ExosuitPanel.AboutDialog(this.MultitoolPanel).g(var4);
            }

            return Long.toString(var4);
         } catch (RuntimeException var6) {
            return Long.toString(var2);
         }
      }
   }
}
