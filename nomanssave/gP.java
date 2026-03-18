package nomanssave;

import java.util.function.Function;

class gP extends Inventory {
   // $FF: synthetic field
   final Vehicle rP;
   // $FF: synthetic field
   private final boolean rr;
   // $FF: synthetic field
   private final int rQ;

   gP(Vehicle var1, Function var2, JsonObject var3, int var4, int var5, int var6, boolean var7, boolean var8, boolean var9, boolean var10, boolean var11, int var12) {
      super(var2, var3, var4, var5, var6, var7, var8, var9, var10);
      this.rP = var1;
      this.rr = var11;
      this.rQ = var12;
   }

   public int MultitoolPanel() {
      return this.rr ? 3584 : 3584 | this.rQ;
   }
}
