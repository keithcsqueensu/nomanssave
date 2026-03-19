package nomanssave;

class aM extends ValidatedTextField {
   // $FF: synthetic field
   final ExosuitPanel MultitoolPanel;

   aM(ExosuitPanel var1) {
      this.MultitoolPanel = var1;
   }

   protected String g(String var1) {
      if (ExosuitPanel.AboutDialog(this.MultitoolPanel) == null) {
         return "";
      } else {
         int var2 = ExosuitPanel.AboutDialog(this.MultitoolPanel).dO();

         try {
            int var3 = hf.parseIntClamped(var1, 0, 100);
            if (var3 != var2) {
               ExosuitPanel.AboutDialog(this.MultitoolPanel).aD(var3);
            }

            return Integer.toString(var3);
         } catch (RuntimeException var4) {
            return Integer.toString(var2);
         }
      }
   }
}
