package nomanssave;

import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

class ec extends FormPanel {
   private final int index;
   private JCheckBox if;
   private JComboBox ig;
   private ValidatedTextField bj;
   private JComboBox ih;
   private ValidatedTextField hO;
   private ValidatedTextField ii;
   // $FF: synthetic field
   final SquadronPanel ij;

   ec(SquadronPanel var1, int var2) {
      super(AppSettings.cH, AppSettings.cH * 2);
      this.ij = var1;
      this.index = var2;
      this.k("Wingman " + (var2 + 1));
      this.if = new JCheckBox("Enabled");
      this.if.addActionListener(new ed(this, var2));
      this.AboutDialog((String)null, this.if);
      this.setBorder(new LineBorder(Color.DARK_GRAY));
      this.ig = new JComboBox();
      this.ig.setModel(new ee(this, var2));
      this.AboutDialog("NPC Race", this.ig);
      this.bj = new ef(this, var2);
      this.AboutDialog("NPC Seed", this.bj);
      this.ih = new JComboBox();
      this.ih.setModel(new eg(this, var2));
      this.AboutDialog("Ship Type", this.ih);
      this.hO = new eh(this, var2);
      this.AboutDialog("Ship Seed", this.hO);
      this.ii = new ei(this, var2);
      this.AboutDialog("Pilot Rank", this.ii);
   }

   private void aQ() {
      this.if.setSelected(SquadronPanel.AboutDialog(this.ij)[this.index].isEnabled());
      this.ig.setEnabled(SquadronPanel.AboutDialog(this.ij)[this.index].isEnabled());
      this.ig.setSelectedItem(SquadronPanel.AboutDialog(this.ij)[this.index].ed());
      this.bj.setEnabled(SquadronPanel.AboutDialog(this.ij)[this.index].isEnabled());
      this.bj.setText(SquadronPanel.AboutDialog(this.ij)[this.index].ee());
      this.ih.setEnabled(SquadronPanel.AboutDialog(this.ij)[this.index].isEnabled());
      this.ih.setSelectedItem(SquadronPanel.AboutDialog(this.ij)[this.index].ef());
      this.hO.setEnabled(SquadronPanel.AboutDialog(this.ij)[this.index].isEnabled());
      this.hO.setText(SquadronPanel.AboutDialog(this.ij)[this.index].eg());
      this.ii.setEnabled(SquadronPanel.AboutDialog(this.ij)[this.index].isEnabled());
      this.ii.setText(Integer.toString(SquadronPanel.AboutDialog(this.ij)[this.index].eh()));
   }

   // $FF: synthetic method
   static JCheckBox access$getCheckBox(ec var0) {
      return var0.if;
   }

   // $FF: synthetic method
   static JComboBox access$getComboBox(ec var0) {
      return var0.ig;
   }

   // $FF: synthetic method
   static ValidatedTextField AccountPanel(ec var0) {
      return var0.bj;
   }

   // $FF: synthetic method
   static JComboBox d(ec var0) {
      return var0.ih;
   }

   // $FF: synthetic method
   static ValidatedTextField e(ec var0) {
      return var0.hO;
   }

   // $FF: synthetic method
   static ValidatedTextField f(ec var0) {
      return var0.ii;
   }

   // $FF: synthetic method
   static void g(ec var0) {
      var0.aQ();
   }

   // $FF: synthetic method
   static SquadronPanel h(ec var0) {
      return var0.ij;
   }
}
