package nomanssave;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class cN extends JComboBox {
   private final boolean Freighter;
   private final Enum[] FreighterBase;
   private final List FreighterType;
   private cR Frigate;
   private Object gq;
   private static final Color FrigateClass;
   private static final Color gs;

   static {
      FrigateClass = Color.RED;
      gs = new Color(255, 100, 100);
   }

   public cN(Class var1) {
      this.Freighter = gD.class.isAssignableFrom(var1);
      this.FreighterBase = (Enum[])var1.getEnumConstants();
      this.FreighterType = new ArrayList();
      this.setModel(new cO(this, var1));
      this.setRenderer(new cP(this));
   }

   public void m(String var1) {
      Object var2 = null;
      if (var1 != null) {
         Enum[] var6;
         int var5 = (var6 = this.FreighterBase).length;

         for(int var4 = 0; var4 < var5; ++var4) {
            Enum var3 = var6[var4];
            if (this.Freighter) {
               if (((gD)var3).K().equals(var1)) {
                  var2 = var3;
                  break;
               }
            } else if (var3.name().equals(var1)) {
               var2 = var3;
               break;
            }
         }

         if (var2 == null) {
            int var7 = this.FreighterType.indexOf(new cQ(this, var1));
            if (var7 >= 0) {
               var2 = this.FreighterType.get(var7);
            } else {
               var2 = this.Freighter ? new cS(this, var1) : var1;
               this.FreighterType.add(var2);
            }
         }
      }

      this.gq = var2;
      this.selectedItemChanged();
      this.updateUI();
   }

   public void setSelected(cR var1) {
      this.Frigate = var1;
   }

   // $FF: synthetic method
   static List access$getItems(cN var0) {
      return var0.FreighterType;
   }

   // $FF: synthetic method
   static Object access$getSelectedItem(cN var0) {
      return var0.gq;
   }

   // $FF: synthetic method
   static void access$setSelectedItem(cN var0, Object var1) {
      var0.gq = var1;
   }

   // $FF: synthetic method
   static cR access$getChangeListener(cN var0) {
      return var0.Frigate;
   }

   // $FF: synthetic method
   static boolean d(cN var0) {
      return var0.Freighter;
   }

   // $FF: synthetic method
   static Enum[] e(cN var0) {
      return var0.FreighterBase;
   }

   // $FF: synthetic method
   static Color ag() {
      return gs;
   }

   // $FF: synthetic method
   static Color aB() {
      return FrigateClass;
   }
}
