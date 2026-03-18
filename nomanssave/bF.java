package nomanssave;

class bF implements bK {
   // $FF: synthetic field
   final MilestonesPanel ItemDefinition;

   bF(MilestonesPanel var1) {
      this.ItemDefinition = var1;
   }

   public String getID() {
      return "ExtremeSurvival";
   }

   public boolean isSpecial() {
      return false;
   }

   public String ab() {
      return Double.toString(MilestonesPanel.AboutDialog(this.ItemDefinition).dT());
   }

   public void l(String var1) {
      double var2 = Double.parseDouble(var1);
      MilestonesPanel.AboutDialog(this.ItemDefinition).g(var2);
   }
}
