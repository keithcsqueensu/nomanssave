package nomanssave;

class aL extends ValidatedTextField {
   // $FF: synthetic field
   final ExosuitPanel MultitoolPanel;

   aL(ExosuitPanel var1) {
      this.MultitoolPanel = var1;
   }

   protected String g(String var1) {
      if (ExosuitPanel.AboutDialog(this.MultitoolPanel) == null) {
         return "";
      } else {
         int var2 = ExosuitPanel.AboutDialog(this.MultitoolPanel).ShipsPanel();

         try {
            int var3 = hf.AboutDialogCloseListener(var1, 0, 100);
            if (var3 != var2) {
               ExosuitPanel.AboutDialog(this.MultitoolPanel).aC(var3);
            }

            return Integer.toString(var3);
         } catch (RuntimeException var4) {
            return Integer.toString(var2);
         }
      }
   }
}
