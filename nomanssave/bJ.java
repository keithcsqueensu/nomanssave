package nomanssave;

class bJ extends ValidatedTextField {
   final gs ez;
   final int type;
   // $FF: synthetic field
   final MilestonesPanel ItemDefinition;
   // $FF: synthetic field
   private static int[] eA;

   bJ(MilestonesPanel var1, gs var2, boolean var3) {
      this.ItemDefinition = var1;
      this.ez = var2;
      switch(ad()[var2.ordinal()]) {
      case 24:
         this.type = 1;
         break;
      default:
         this.type = 0;
      }

      this.setEnabled(var3);
   }

   protected String g(String var1) {
      if (MilestonesPanel.AboutDialog(this.ItemDefinition) == null) {
         return "";
      } else {
         String var2;
         switch(this.type) {
         case 0:
            var2 = Integer.toString(MilestonesPanel.AboutDialog(this.ItemDefinition).AboutDialog(this.ez));
            break;
         case 1:
            var2 = Double.toString(MilestonesPanel.AboutDialog(this.ItemDefinition).AboutDialogCloseListener(this.ez));
            break;
         default:
            return "";
         }

         if (var1.equals(var2)) {
            return var1;
         } else {
            try {
               int var3;
               switch(this.type) {
               case 0:
                  var3 = hf.AboutDialogCloseListener(var1, 0, Integer.MAX_VALUE);
                  MilestonesPanel.AboutDialog(this.ItemDefinition).AboutDialog(this.ez, var3);
                  var1 = Integer.toString(var3);
                  break;
               case 1:
                  double var4 = Double.parseDouble(var1);
                  MilestonesPanel.AboutDialog(this.ItemDefinition).AboutDialog(this.ez, var4);
                  var1 = Double.toString(var4);
               }

               MilestonesPanel.AboutDialog(this.ItemDefinition, this.ez, var1);
               if (this.ez == gs.pL || this.ez == gs.pM) {
                  var3 = MilestonesPanel.AboutDialog(this.ItemDefinition).AboutDialog(gs.pL) + MilestonesPanel.AboutDialog(this.ItemDefinition).AboutDialog(gs.pM);
                  MilestonesPanel.AboutDialog(this.ItemDefinition).AboutDialog(gs.pR, var3);
                  MilestonesPanel.AboutDialog(this.ItemDefinition, gs.pR, Integer.toString(var3));
               }

               if (this.ez == gs.pI || this.ez == gs.pK || this.ez == gs.pJ) {
                  var3 = MilestonesPanel.AboutDialog(this.ItemDefinition).AboutDialog(gs.pI) + MilestonesPanel.AboutDialog(this.ItemDefinition).AboutDialog(gs.pK) + MilestonesPanel.AboutDialog(this.ItemDefinition).AboutDialog(gs.pJ);
                  MilestonesPanel.AboutDialog(this.ItemDefinition).AboutDialog(gs.pS, var3);
                  MilestonesPanel.AboutDialog(this.ItemDefinition, gs.pS, Integer.toString(var3));
               }

               return var1;
            } catch (RuntimeException var6) {
               return var2;
            }
         }
      }
   }

   void ac() {
      String var1;
      if (MilestonesPanel.AboutDialog(this.ItemDefinition) == null) {
         var1 = "";
      } else {
         switch(this.type) {
         case 0:
            var1 = Integer.toString(MilestonesPanel.AboutDialog(this.ItemDefinition).AboutDialog(this.ez));
            break;
         case 1:
            var1 = Double.toString(MilestonesPanel.AboutDialog(this.ItemDefinition).AboutDialogCloseListener(this.ez));
            break;
         default:
            var1 = "";
         }
      }

      this.setText(var1);
   }

   // $FF: synthetic method
   static int[] ad() {
      int[] var10000 = eA;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[gs.values().length];

         try {
            var0[gs.pO.ordinal()] = 25;
         } catch (NoSuchFieldError var31) {
         }

         try {
            var0[gs.pU.ordinal()] = 31;
         } catch (NoSuchFieldError var30) {
         }

         try {
            var0[gs.pN.ordinal()] = 24;
         } catch (NoSuchFieldError var29) {
         }

         try {
            var0[gs.pT.ordinal()] = 30;
         } catch (NoSuchFieldError var28) {
         }

         try {
            var0[gs.pI.ordinal()] = 19;
         } catch (NoSuchFieldError var27) {
         }

         try {
            var0[gs.pC.ordinal()] = 13;
         } catch (NoSuchFieldError var26) {
         }

         try {
            var0[gs.pF.ordinal()] = 16;
         } catch (NoSuchFieldError var25) {
         }

         try {
            var0[gs.pE.ordinal()] = 15;
         } catch (NoSuchFieldError var24) {
         }

         try {
            var0[gs.pR.ordinal()] = 28;
         } catch (NoSuchFieldError var23) {
         }

         try {
            var0[gs.pD.ordinal()] = 14;
         } catch (NoSuchFieldError var22) {
         }

         try {
            var0[gs.pB.ordinal()] = 12;
         } catch (NoSuchFieldError var21) {
         }

         try {
            var0[gs.pQ.ordinal()] = 27;
         } catch (NoSuchFieldError var20) {
         }

         try {
            var0[gs.pL.ordinal()] = 22;
         } catch (NoSuchFieldError var19) {
         }

         try {
            var0[gs.pv.ordinal()] = 6;
         } catch (NoSuchFieldError var18) {
         }

         try {
            var0[gs.pM.ordinal()] = 23;
         } catch (NoSuchFieldError var17) {
         }

         try {
            var0[gs.pH.ordinal()] = 18;
         } catch (NoSuchFieldError var16) {
         }

         try {
            var0[gs.pK.ordinal()] = 21;
         } catch (NoSuchFieldError var15) {
         }

         try {
            var0[gs.pG.ordinal()] = 17;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[gs.pS.ordinal()] = 29;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[gs.pr.ordinal()] = 2;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[gs.pu.ordinal()] = 5;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[gs.pt.ordinal()] = 4;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[gs.pq.ordinal()] = 1;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[gs.ps.ordinal()] = 3;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[gs.pJ.ordinal()] = 20;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[gs.pw.ordinal()] = 7;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[gs.px.ordinal()] = 8;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[gs.pA.ordinal()] = 11;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[gs.pz.ordinal()] = 10;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[gs.pP.ordinal()] = 26;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[gs.py.ordinal()] = 9;
         } catch (NoSuchFieldError var1) {
         }

         eA = var0;
         return var0;
      }
   }
}
