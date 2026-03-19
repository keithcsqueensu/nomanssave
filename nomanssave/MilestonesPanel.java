package nomanssave;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MilestonesPanel extends JPanel {
   private static final int ew = 0;
   private static final int TYPE_DOUBLE = 1;
   private final bN[] ex = new bN[3];
   private Exosuit cp;

   MilestonesPanel(Application var1) {
      GridLayout var2 = new GridLayout(1, 3, 10, 0);
      this.setLayout(var2);
      this.ex[0] = new bN(this);
      this.add(this.ex[0]);
      this.ex[1] = new bN(this);
      this.add(this.ex[1]);
      this.ex[2] = new bN(this);
      this.add(this.ex[2]);
      this.ex[0].AboutDialog("Milestones", (ImageIcon)Application.loadScaledIcon("UI-MILESTONES.PNG", 32, 32));
      this.ex[0].AboutDialog("On Foot Exploration", gs.pN);
      this.ex[0].AboutDialog("Alien Colonist Encounters", gs.pO);
      this.ex[0].AboutDialog("Words Collected", gs.pP, false, "See Discovery tab for more details");
      this.ex[0].AboutDialog("Most Units Accrued", gs.pQ);
      this.ex[0].AboutDialog("Ships Destroyed", gs.pR, false, "See Kills section for more details");
      this.ex[0].AboutDialog("Sentinels Destroyed", gs.pS, false, "See Kills section for more details");
      this.ex[0].AboutDialog("Extreme Survival", (bK)(new bF(this)));
      this.ex[0].AboutDialog("Space Exploration (Warps)", gs.pT);
      this.ex[0].AboutDialog("Planet Zoology Scanned", gs.pU);
      this.ex[0].AboutDialog("Kills", (ImageIcon)Application.loadScaledIcon("UI-CREATURES.PNG", 32, 32));
      this.ex[0].AboutDialog("Predators", gs.pH);
      this.ex[0].AboutDialog("Sentinel Drones", gs.pI);
      this.ex[0].AboutDialog("Sentinel Quads", gs.pK);
      this.ex[0].AboutDialog("Sentinel Walkers", gs.pJ);
      this.ex[0].AboutDialog("Pirates", gs.pL);
      this.ex[0].AboutDialog("Police", gs.pM);
      this.ex[1].AboutDialog("Gek", (ImageIcon)Application.loadScaledIcon("UI-GEK.PNG", 32, 32));
      this.ex[1].AboutDialog("Standing", gs.pq);
      this.ex[1].AboutDialog("Missions Completed", gs.pr);
      this.ex[1].AboutDialog("Words Learned", (bK)(new bG(this)), false, "See Discovery tab for more details");
      this.ex[1].AboutDialog("Systems Visited", gs.ps);
      this.ex[1].AboutDialog("Vy'keen", (ImageIcon)Application.loadScaledIcon("UI-VYKEEN.PNG", 32, 32));
      this.ex[1].AboutDialog("Standing", gs.pw);
      this.ex[1].AboutDialog("Missions Completed", gs.px);
      this.ex[1].AboutDialog("Words Learned", (bK)(new bH(this)), false, "See Discovery tab for more details");
      this.ex[1].AboutDialog("Systems Visited", gs.py);
      this.ex[1].AboutDialog("Korvax", (ImageIcon)Application.loadScaledIcon("UI-KORVAX.PNG", 32, 32));
      this.ex[1].AboutDialog("Standing", gs.pB);
      this.ex[1].AboutDialog("Missions Completed", gs.pC);
      this.ex[1].AboutDialog("Words Learned", (bK)(new bI(this)), false, "See Discovery tab for more details");
      this.ex[1].AboutDialog("Systems Visited", gs.pD);
      this.ex[2].AboutDialog("Traders", (ImageIcon)Application.loadScaledIcon("UI-TRADERS.PNG", 32, 32));
      this.ex[2].AboutDialog("Standing", gs.pt);
      this.ex[2].AboutDialog("Missions Completed", gs.pu);
      this.ex[2].AboutDialog("Plants Farmed", gs.pv);
      this.ex[2].AboutDialog("Units Earned", gs.pQ, false, "See Milestones section for more details");
      this.ex[2].AboutDialog("Warriors", (ImageIcon)Application.loadScaledIcon("UI-WARRIORS.PNG", 32, 32));
      this.ex[2].AboutDialog("Standing", gs.pz);
      this.ex[2].AboutDialog("Missions Completed", gs.pA);
      this.ex[2].AboutDialog("Sentinels Destroyed", gs.pS, false, "See Kills section for more details");
      this.ex[2].AboutDialog("Pirates Killed", gs.pR, false, "See Kills section for more details");
      this.ex[2].AboutDialog("Explorers", (ImageIcon)Application.loadScaledIcon("UI-EXPLORERS.PNG", 32, 32));
      this.ex[2].AboutDialog("Standing", gs.pE);
      this.ex[2].AboutDialog("Missions Completed", gs.pF);
      this.ex[2].AboutDialog("Rare Creatures Scanned", gs.pG);
      this.ex[2].AboutDialog("Distance Warped", gs.pT, false, "See Milestones section for more details");
   }

   void WindowCloseListener() {
      int var1 = this.cp.bx();
      this.cp.AboutDialog(gs.pP, var1);
      this.AboutDialog(gs.pP, Integer.toString(var1));
   }

   void C() {
      long var1 = this.cp.dJ();
      int var3 = this.cp.AboutDialog(gs.pQ);
      if ((long)var3 < var1) {
         var3 = (int)Math.min(var1, 2147483647L);
         this.cp.AboutDialog(gs.pQ, var3);
         this.AboutDialog(gs.pQ, Integer.toString(var3));
      }

   }

   void aa() {
      for(int var2 = 0; var2 < this.ex.length; ++var2) {
         for(int var3 = 0; var3 < this.ex[var2].getComponentCount(); ++var3) {
            Component var1 = this.ex[var2].getComponent(var3);
            if (var1 instanceof bL && ((bL)var1).eB.isSpecial()) {
               ((bL)var1).ac();
            }
         }
      }

   }

   private void addMilestone(gs var1, String var2) {
      for(int var4 = 0; var4 < this.ex.length; ++var4) {
         for(int var5 = 0; var5 < this.ex[var4].getComponentCount(); ++var5) {
            Component var3 = this.ex[var4].getComponent(var5);
            if (var3 instanceof bJ && ((bJ)var3).ez == var1) {
               ((bJ)var3).setText(var2);
            }
         }
      }

   }

   void updateMilestones(Exosuit var1) {
      this.cp = var1;

      for(int var3 = 0; var3 < this.ex.length; ++var3) {
         for(int var4 = 0; var4 < this.ex[var3].getComponentCount(); ++var4) {
            Component var2 = this.ex[var3].getComponent(var4);
            if (var2 instanceof bJ) {
               ((bJ)var2).ac();
            } else if (var2 instanceof bL) {
               ((bL)var2).ac();
            }
         }
      }

   }

   // $FF: synthetic method
   static Exosuit access$getExosuit(MilestonesPanel var0) {
      return var0.cp;
   }

   // $FF: synthetic method
   static void access$addMilestone(MilestonesPanel var0, gs var1, String var2) {
      var0.addMilestone(var1, var2);
   }
}
