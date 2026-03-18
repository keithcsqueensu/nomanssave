package nomanssave;

import java.util.Iterator;

public class gA {
   private final AlienWord rd;
   // $FF: synthetic field
   final Exosuit re;

   private gA(Exosuit var1, AlienWord var2) {
      this.re = var1;
      this.rd = var2;
   }

   public String getID() {
      return this.rd.getID();
   }

   public boolean AccountPanel(Race var1) {
      Iterator var3 = this.rd.bw().iterator();

      while(var3.hasNext()) {
         String var2 = (String)var3.next();
         if (this.rd.ShowErrorRunnable(var2) == var1) {
            return Exosuit.AboutDialog(this.re, var2, var1.ordinal());
         }
      }

      return false;
   }

   public void AboutDialog(Race var1, boolean var2) {
      Iterator var4 = this.rd.bw().iterator();

      while(var4.hasNext()) {
         String var3 = (String)var4.next();
         if (this.rd.ShowErrorRunnable(var3) == var1) {
            Exosuit.AboutDialog(this.re, var3, var1.ordinal(), var2);
         }
      }

   }

   // $FF: synthetic method
   gA(Exosuit var1, AlienWord var2, gA var3) {
      this(var1, var2);
   }
}
