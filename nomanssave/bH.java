package nomanssave;

class bH implements bK {
   // $FF: synthetic field
   final MilestonesPanel ItemDefinition;

   bH(MilestonesPanel var1) {
      this.ItemDefinition = var1;
   }

   public String getID() {
      return "TWordsLearnt";
   }

   public boolean isSpecial() {
      return true;
   }

   public String ab() {
      return Integer.toString(MilestonesPanel.AboutDialog(this.ItemDefinition).AboutDialogCloseListener(Race.ks));
   }

   public void l(String var1) {
      throw new RuntimeException("Cannot set words learnt");
   }
}
