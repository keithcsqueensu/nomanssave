package nomanssave;

import java.awt.Color;

class bu implements Runnable {
   // $FF: synthetic field
   final bt es;
   // $FF: synthetic field
   private final Application bv;

   bu(bt var1, Application var2) {
      this.es = var1;
      this.bv = var2;
   }

   public void run() {
      FrigatesPanel.AboutDialog(bt.AboutDialog(this.es), FrigatesPanel.e(bt.AboutDialog(this.es)).getSelectedRow());
      int var1;
      if (FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es)) < 0) {
         FrigatesPanel.AboutDialog(bt.AboutDialog(this.es), new er[0]);
         FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es), new er[0]);
         FrigatesPanel.h(bt.AboutDialog(this.es)).setVisible(false);
         FrigatesPanel.i(bt.AboutDialog(this.es)).setVisible(false);
         FrigatesPanel.j(bt.AboutDialog(this.es)).setText("");
         FrigatesPanel.k(bt.AboutDialog(this.es)).setSelectedIndex(-1);
         FrigatesPanel.l(bt.AboutDialog(this.es)).setText("");
         FrigatesPanel.m(bt.AboutDialog(this.es)).setSelectedIndex(-1);
         FrigatesPanel.n(bt.AboutDialog(this.es)).setText("");
         FrigatesPanel.o(bt.AboutDialog(this.es)).setText("");

         for(var1 = 0; var1 < FrigatesPanel.d(bt.AboutDialog(this.es)).length; ++var1) {
            FrigatesPanel.d(bt.AboutDialog(this.es))[var1].setText("");
         }

         FrigatesPanel.p(bt.AboutDialog(this.es)).setSelectedIndex(-1);
         FrigatesPanel.q(bt.AboutDialog(this.es)).setSelectedIndex(-1);
         FrigatesPanel.r(bt.AboutDialog(this.es)).setSelectedIndex(-1);
         FrigatesPanel.s(bt.AboutDialog(this.es)).setSelectedIndex(-1);
         FrigatesPanel.t(bt.AboutDialog(this.es)).setSelectedIndex(-1);
         FrigatesPanel.u(bt.AboutDialog(this.es)).setText("");
         FrigatesPanel.RefreshRunnable(bt.AboutDialog(this.es)).setText("");
         FrigatesPanel.AppStartupRunnable(bt.AboutDialog(this.es)).setText("");
         FrigatesPanel.UpdateCheckThread(bt.AboutDialog(this.es)).setText("");
         FrigatesPanel.h(bt.AboutDialog(this.es)).updateUI();
         FrigatesPanel.i(bt.AboutDialog(this.es)).updateUI();
         FrigatesPanel.UpdateDownloadRunnable(bt.AboutDialog(this.es)).setText("");
         FrigatesPanel.ShowErrorRunnable(bt.AboutDialog(this.es)).setVisible(false);
         FrigatesPanel.ShowWarningRunnable(bt.AboutDialog(this.es)).setEnabled(false);
         FrigatesPanel.g(bt.AboutDialog(this.es)).setEnabled(false);
      } else {
         FrigatesPanel.AboutDialog(bt.AboutDialog(this.es), er.AboutDialog(FrigatesPanel.AccountPanel(bt.AboutDialog(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es))].da()));
         FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es), er.AboutDialogCloseListener(FrigatesPanel.AccountPanel(bt.AboutDialog(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es))].da()));
         FrigatesPanel.h(bt.AboutDialog(this.es)).setVisible(true);
         FrigatesPanel.i(bt.AboutDialog(this.es)).setVisible(true);
         FrigatesPanel.j(bt.AboutDialog(this.es)).setText(FrigatesPanel.AccountPanel(bt.AboutDialog(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es))].getName());
         FrigatesPanel.k(bt.AboutDialog(this.es)).setSelectedItem(FrigatesPanel.AccountPanel(bt.AboutDialog(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es))].da());
         FrigatesPanel.l(bt.AboutDialog(this.es)).setText(FrigatesPanel.AccountPanel(bt.AboutDialog(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es))].LineNumberPanel().toString());
         FrigatesPanel.m(bt.AboutDialog(this.es)).m(FrigatesPanel.AccountPanel(bt.AboutDialog(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es))].db());
         FrigatesPanel.n(bt.AboutDialog(this.es)).setText(FrigatesPanel.AccountPanel(bt.AboutDialog(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es))].cU());
         FrigatesPanel.o(bt.AboutDialog(this.es)).setText(FrigatesPanel.AccountPanel(bt.AboutDialog(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es))].cV());

         for(var1 = 0; var1 < FrigatesPanel.d(bt.AboutDialog(this.es)).length; ++var1) {
            FrigatesPanel.d(bt.AboutDialog(this.es))[var1].setText(Integer.toString(FrigatesPanel.AccountPanel(bt.AboutDialog(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es))].aq(var1)));
         }

         FrigatesPanel.p(bt.AboutDialog(this.es)).setSelectedItem(FrigatesPanel.AccountPanel(bt.AboutDialog(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es))].ar(0));
         FrigatesPanel.q(bt.AboutDialog(this.es)).setSelectedItem(FrigatesPanel.AccountPanel(bt.AboutDialog(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es))].ar(1));
         FrigatesPanel.r(bt.AboutDialog(this.es)).setSelectedItem(FrigatesPanel.AccountPanel(bt.AboutDialog(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es))].ar(2));
         FrigatesPanel.s(bt.AboutDialog(this.es)).setSelectedItem(FrigatesPanel.AccountPanel(bt.AboutDialog(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es))].ar(3));
         FrigatesPanel.t(bt.AboutDialog(this.es)).setSelectedItem(FrigatesPanel.AccountPanel(bt.AboutDialog(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es))].ar(4));
         FrigatesPanel.u(bt.AboutDialog(this.es)).setText(Integer.toString(FrigatesPanel.AccountPanel(bt.AboutDialog(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es))].dc()));
         FrigatesPanel.RefreshRunnable(bt.AboutDialog(this.es)).setText(Integer.toString(FrigatesPanel.AccountPanel(bt.AboutDialog(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es))].dd()));
         FrigatesPanel.AppStartupRunnable(bt.AboutDialog(this.es)).setText(Integer.toString(FrigatesPanel.AccountPanel(bt.AboutDialog(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es))].de()));
         FrigatesPanel.UpdateCheckThread(bt.AboutDialog(this.es)).setText(Integer.toString(FrigatesPanel.AccountPanel(bt.AboutDialog(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es))].df()));
         if (this.bv.j(FrigatesPanel.AccountPanel(bt.AboutDialog(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es))].getIndex())) {
            FrigatesPanel.UpdateDownloadRunnable(bt.AboutDialog(this.es)).setText("Status: On Mission");
            FrigatesPanel.UpdateDownloadRunnable(bt.AboutDialog(this.es)).setForeground(Color.BLUE);
            FrigatesPanel.ShowErrorRunnable(bt.AboutDialog(this.es)).setVisible(false);
         } else if (FrigatesPanel.AccountPanel(bt.AboutDialog(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.AboutDialog(this.es))].dh() > 0) {
            FrigatesPanel.UpdateDownloadRunnable(bt.AboutDialog(this.es)).setText("Status: Damaged!");
            FrigatesPanel.UpdateDownloadRunnable(bt.AboutDialog(this.es)).setForeground(Color.RED);
            FrigatesPanel.ShowErrorRunnable(bt.AboutDialog(this.es)).setVisible(true);
         } else {
            FrigatesPanel.UpdateDownloadRunnable(bt.AboutDialog(this.es)).setText("");
            FrigatesPanel.ShowErrorRunnable(bt.AboutDialog(this.es)).setVisible(false);
         }

         FrigatesPanel.h(bt.AboutDialog(this.es)).updateUI();
         FrigatesPanel.i(bt.AboutDialog(this.es)).updateUI();
         FrigatesPanel.p(bt.AboutDialog(this.es)).updateUI();
         FrigatesPanel.q(bt.AboutDialog(this.es)).updateUI();
         FrigatesPanel.r(bt.AboutDialog(this.es)).updateUI();
         FrigatesPanel.s(bt.AboutDialog(this.es)).updateUI();
         FrigatesPanel.t(bt.AboutDialog(this.es)).updateUI();
         FrigatesPanel.ShowWarningRunnable(bt.AboutDialog(this.es)).setEnabled(FrigatesPanel.AccountPanel(bt.AboutDialog(this.es)).length > 1);
         FrigatesPanel.g(bt.AboutDialog(this.es)).setEnabled(FrigatesPanel.AccountPanel(bt.AboutDialog(this.es)).length < 30 || en.aS());
      }
   }
}
