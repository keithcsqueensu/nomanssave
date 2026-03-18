package nomanssave;

class bI implements bK {
   // $FF: synthetic field
   final MilestonesPanel ItemDefinition;

   bI(MilestonesPanel var1) {
      this.ItemDefinition = var1;
   }

   public String getID() {
      return "TWordsLearnt";
   }

   public boolean isSpecial() {
      return true;
   }

   public String ab() {
      return Integer.toString(MilestonesPanel.AboutDialog(this.ItemDefinition).AboutDialogCloseListener(Race.kt));
   }

   public void l(String var1) {
      throw new RuntimeException("Cannot set words learnt");
   }
}
