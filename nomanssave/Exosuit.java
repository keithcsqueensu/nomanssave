package nomanssave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class Exosuit {
   private final JsonObject oI;
   private final JsonArray rb;
   private final JsonArray rc;
   private final List CoordinateTransform;

   public static Exosuit fromPlayerData(JsonObject var0) {
      JsonArray var1 = null;
      JsonArray var2 = var0.d("Stats");
      if (var2 != null) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            JsonObject var4 = var2.V(var3);
            if ("^GLOBAL_STATS".equals(var4.getValueAsString("GroupId"))) {
               var1 = var4.d("Stats");
               break;
            }
         }
      }

      return new Exosuit(var0, var1, var0.H("Inventory"), var0.H("Inventory_TechOnly"), var0.H("Inventory_Cargo"));
   }

   private static Function au(String var0) {
      return (var1) -> {
         return new String[]{"Exosuit", var0};
      };
   }

   private Exosuit(JsonObject var1, JsonArray var2, JsonObject var3, JsonObject var4, JsonObject var5) {
      this.oI = var1;
      this.rb = var2;
      JsonArray var6 = var1.d("KnownWords");
      JsonArray var7 = var1.d("KnownWordGroups");
      if (var7 == null) {
         var7 = new JsonArray();
         var1.setValueByPath("KnownWordGroups", (Object)var7);
      }

      if (var6.size() > 0) {
         int var8 = 0;

         label46:
         while(true) {
            while(true) {
               if (var8 >= var6.size()) {
                  break label46;
               }

               JsonObject var9 = var6.V(var8);
               AlienWord var10 = AlienWord.ShowWarningRunnable(var9.getValueAsString("id"));
               if (var10 == null) {
                  Logger.warn("Could not build word groups: " + var9.getValueAsString("id"));
                  ++var8;
               } else {
                  Iterator var12 = var10.bw().iterator();

                  while(var12.hasNext()) {
                     String var11 = (String)var12.next();
                     Race var13 = var10.ShowErrorRunnable(var11);
                     if (var13 != null) {
                        JsonObject var14 = new JsonObject();
                        var14.setValueByPath("Group", (Object)var11);
                        JsonArray var15 = new JsonArray(new Object[]{Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE});
                        var15.AboutDialog(var13.ordinal(), Boolean.TRUE);
                        var14.setValueByPath("Races", (Object)var15);
                        var7.f(var14);
                        Logger.debug("Creating word: " + var11 + "[" + var13.ordinal() + "] = true");
                     }
                  }

                  var6.ac(var8);
                  Logger.debug("Removed old word: " + var9.getValueAsString("id"));
               }
            }
         }
      }

      this.rc = var7;
      boolean var20 = false;
      boolean var22 = false;
      short var24 = 0;
      byte var25 = 8;
      byte var26 = 6;
      byte var27 = 7;
      byte var16 = 2;
      String var18;
      String var19;
      short var21;
      byte var23;
      if (Application.getInstance().SlotComboBoxModel()) {
         var21 = 3584;
         var23 = 1;
         var25 = 10;
         var26 = 12;
         var27 = 10;
         var16 = 6;
         var18 = "Cargo";
         var19 = "Unused";
         var5 = null;
      } else {
         var21 = 3585;
         var23 = 1;
         var24 = 3584;
         var18 = "General";
         var19 = "Cargo";
      }

      ArrayList var17 = new ArrayList();
      var17.add(new Inventory(au(var18), var3, var21, var25, var26, false, true));
      if (var4 != null) {
         var17.add(new Inventory(au("Technology"), var4, var23, var27, var16, true, true));
      }

      if (var5 != null) {
         var17.add(new Inventory(au(var19), var5, var24, 8, 6, false, true));
      }

      this.CoordinateTransform = Collections.unmodifiableList(var17);
   }

   public long dJ() {
      return this.oI.K("Units") & 4294967295L;
   }

   public void e(long var1) {
      this.oI.setValueByPath("Units", (Object)(new Integer((int)var1)));
   }

   public long dK() {
      return this.oI.K("Nanites") & 4294967295L;
   }

   public void f(long var1) {
      this.oI.setValueByPath("Nanites", (Object)(new Integer((int)var1)));
   }

   public long dL() {
      return this.oI.K("Specials") & 4294967295L;
   }

   public void g(long var1) {
      this.oI.setValueByPath("Specials", (Object)(new Integer((int)var1)));
   }

   public int dM() {
      return this.oI.J("Health");
   }

   public void aB(int var1) {
      this.oI.setValueByPath("Health", (Object)(new Integer(var1)));
   }

   public int ShipsPanel() {
      return this.oI.J("Shield");
   }

   public void aC(int var1) {
      this.oI.setValueByPath("Shield", (Object)(new Integer(var1)));
   }

   public int dO() {
      return this.oI.J("Energy");
   }

   public void aD(int var1) {
      this.oI.setValueByPath("Energy", (Object)(new Integer(var1)));
   }

   public List cC() {
      return this.CoordinateTransform;
   }

   public int dP() {
      return this.oI.J("KnownPortalRunes");
   }

   public void aE(int var1) {
      this.oI.setValueByPath("KnownPortalRunes", (Object)(new Integer(var1)));
   }

   public JsonArray dQ() {
      return this.oI.d("KnownTech");
   }

   public JsonArray dR() {
      return this.oI.d("KnownProducts");
   }

   public JsonArray dS() {
      return this.oI.d("KnownSpecials");
   }

   public int bx() {
      byte var1 = 0;
      ArrayList var3 = new ArrayList();

      for(int var4 = 0; var4 < this.rc.size(); ++var4) {
         JsonObject var2 = this.rc.V(var4);
         AlienWord var5 = AlienWord.WindowCloseListener(var2.getValueAsString("Group"));
         if (var5 != null && !var3.contains(var5.getID())) {
            var3.add(var5.getID());
         }
      }

      return var1;
   }

   public int countKnownWords(Race var1) {
      int var2 = 0;

      for(int var4 = 0; var4 < this.rc.size(); ++var4) {
         JsonObject var3 = this.rc.V(var4);
         if (var3.d("Races").ab(var1.ordinal())) {
            ++var2;
         }
      }

      return var2;
   }

   public gA getWordEntry(AlienWord var1) {
      return new gA(this, var1, (gA)null);
   }

   private boolean d(String var1, int var2) {
      for(int var3 = 0; var3 < this.rc.size(); ++var3) {
         JsonObject var4 = this.rc.V(var3);
         if (var1.equals(var4.getValueAsString("Group"))) {
            return var4.d("Races").ab(var2);
         }
      }

      return false;
   }

   private void setStatData(String var1, int var2, boolean var3) {
      JsonObject var4;
      for(int var5 = 0; var5 < this.rc.size(); ++var5) {
         var4 = this.rc.V(var5);
         if (var1.equals(var4.getValueAsString("Group"))) {
            Logger.debug("Updating word: " + var1 + "[" + var2 + "] = " + var3);
            JsonArray var6 = var4.d("Races");

            while(var6.size() < Race.values().length) {
               var6.add(Boolean.FALSE);
            }

            var6.AboutDialog(var2, new Boolean(var3));

            for(int var7 = 0; var7 < var6.size(); ++var7) {
               var3 |= var6.ab(var7);
            }

            if (!var3) {
               Logger.debug("Removing word: " + var1);
               this.rc.ac(var5);
            }

            return;
         }
      }

      if (var3) {
         Logger.debug("Creating word: " + var1 + "[" + var2 + "] = " + var3);
         var4 = new JsonObject();
         var4.setValueByPath("Group", (Object)var1);
         JsonArray var8 = new JsonArray();

         while(var8.size() < Race.values().length) {
            var8.add(Boolean.FALSE);
         }

         var8.AboutDialog(var2, new Boolean(var3));
         var4.setValueByPath("Races", (Object)var8);
         this.rc.f(var4);
      }

   }

   public double dT() {
      return new Double((double)Math.round((double)this.oI.J("HazardTimeAlive") / 90.0D) / 10.0D);
   }

   public void g(double var1) {
      long var3 = Math.round(var1 * 900.0D);
      if (var3 >= 0L && var3 <= 2147483647L) {
         this.oI.setValueByPath("HazardTimeAlive", (Object)(new Integer((int)var3)));
      } else {
         throw new RuntimeException("Stat value out of range");
      }
   }

   public int getStat(gs var1) {
      for(int var3 = 0; var3 < this.rb.size(); ++var3) {
         JsonObject var2 = this.rb.V(var3);
         if (var2.getValueAsString("Id").equals(var1.id)) {
            return var2.J("Value.IntValue");
         }
      }

      return 0;
   }

   public void setStat(gs var1, int var2) {
      if (var2 < 0) {
         throw new RuntimeException("Stat value out of range");
      } else {
         JsonObject var3;
         for(int var4 = 0; var4 < this.rb.size(); ++var4) {
            var3 = this.rb.V(var4);
            if (var3.getValueAsString("Id").equals(var1.id)) {
               var3.setValueByPath("Value.IntValue", (Object)(new Integer(var2)));
               return;
            }
         }

         var3 = new JsonObject();
         var3.setValueByPath("Id", (Object)var1.id);
         JsonObject var5 = new JsonObject();
         var5.setValueByPath("IntValue", (Object)(new Integer(var2)));
         var5.setValueByPath("FloatValue", (Object)(new Double(0.0D)));
         var5.setValueByPath("Denominator", (Object)(new Double(0.0D)));
         var3.setValueByPath("Value", (Object)var5);
         this.rb.f(var3);
      }
   }

   public double getStatDouble(gs var1) {
      for(int var3 = 0; var3 < this.rb.size(); ++var3) {
         JsonObject var2 = this.rb.V(var3);
         if (var2.getValueAsString("Id").equals(var1.id)) {
            return var2.L("Value.FloatValue");
         }
      }

      return 0.0D;
   }

   public void setStatDouble(gs var1, double var2) {
      if (var2 < 0.0D) {
         throw new RuntimeException("Stat value out of range");
      } else {
         JsonObject var4;
         for(int var5 = 0; var5 < this.rb.size(); ++var5) {
            var4 = this.rb.V(var5);
            if (var4.getValueAsString("Id").equals(var1.id)) {
               var4.setValueByPath("Value.FloatValue", (Object)(new Double(var2)));
               return;
            }
         }

         var4 = new JsonObject();
         var4.setValueByPath("Id", (Object)var1.id);
         JsonObject var6 = new JsonObject();
         var6.setValueByPath("IntValue", (Object)(new Integer(0)));
         var6.setValueByPath("FloatValue", (Object)(new Double(var2)));
         var6.setValueByPath("Denominator", (Object)(new Double(0.0D)));
         var4.setValueByPath("Value", (Object)var6);
         this.rb.f(var4);
      }
   }

   // $FF: synthetic method
   static boolean access$checkStatKey(Exosuit var0, String var1, int var2) {
      return var0.d(var1, var2);
   }

   // $FF: synthetic method
   static void access$setStatData(Exosuit var0, String var1, int var2, boolean var3) {
      var0.setStatData(var1, var2, var3);
   }
}
