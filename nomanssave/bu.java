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
      FrigatesPanel.AboutDialog(bt.access$getFrigatesPanel(this.es), FrigatesPanel.e(bt.access$getFrigatesPanel(this.es)).getSelectedRow());
      int var1;
      if (FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es)) < 0) {
         FrigatesPanel.AboutDialog(bt.access$getFrigatesPanel(this.es), new er[0]);
         FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es), new er[0]);
         FrigatesPanel.h(bt.access$getFrigatesPanel(this.es)).setVisible(false);
         FrigatesPanel.i(bt.access$getFrigatesPanel(this.es)).setVisible(false);
         FrigatesPanel.j(bt.access$getFrigatesPanel(this.es)).setText("");
         FrigatesPanel.k(bt.access$getFrigatesPanel(this.es)).setSelectedIndex(-1);
         FrigatesPanel.l(bt.access$getFrigatesPanel(this.es)).setText("");
         FrigatesPanel.m(bt.access$getFrigatesPanel(this.es)).setSelectedIndex(-1);
         FrigatesPanel.n(bt.access$getFrigatesPanel(this.es)).setText("");
         FrigatesPanel.o(bt.access$getFrigatesPanel(this.es)).setText("");

         for(var1 = 0; var1 < FrigatesPanel.d(bt.access$getFrigatesPanel(this.es)).length; ++var1) {
            FrigatesPanel.d(bt.access$getFrigatesPanel(this.es))[var1].setText("");
         }

         FrigatesPanel.p(bt.access$getFrigatesPanel(this.es)).setSelectedIndex(-1);
         FrigatesPanel.q(bt.access$getFrigatesPanel(this.es)).setSelectedIndex(-1);
         FrigatesPanel.r(bt.access$getFrigatesPanel(this.es)).setSelectedIndex(-1);
         FrigatesPanel.s(bt.access$getFrigatesPanel(this.es)).setSelectedIndex(-1);
         FrigatesPanel.t(bt.access$getFrigatesPanel(this.es)).setSelectedIndex(-1);
         FrigatesPanel.u(bt.access$getFrigatesPanel(this.es)).setText("");
         FrigatesPanel.RefreshRunnable(bt.access$getFrigatesPanel(this.es)).setText("");
         FrigatesPanel.AppStartupRunnable(bt.access$getFrigatesPanel(this.es)).setText("");
         FrigatesPanel.UpdateCheckThread(bt.access$getFrigatesPanel(this.es)).setText("");
         FrigatesPanel.h(bt.access$getFrigatesPanel(this.es)).updateUI();
         FrigatesPanel.i(bt.access$getFrigatesPanel(this.es)).updateUI();
         FrigatesPanel.UpdateDownloadRunnable(bt.access$getFrigatesPanel(this.es)).setText("");
         FrigatesPanel.ShowErrorRunnable(bt.access$getFrigatesPanel(this.es)).setVisible(false);
         FrigatesPanel.ShowWarningRunnable(bt.access$getFrigatesPanel(this.es)).setEnabled(false);
         FrigatesPanel.g(bt.access$getFrigatesPanel(this.es)).setEnabled(false);
      } else {
         FrigatesPanel.AboutDialog(bt.access$getFrigatesPanel(this.es), er.AboutDialog(FrigatesPanel.AccountPanel(bt.access$getFrigatesPanel(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es))].da()));
         FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es), er.AboutDialogCloseListener(FrigatesPanel.AccountPanel(bt.access$getFrigatesPanel(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es))].da()));
         FrigatesPanel.h(bt.access$getFrigatesPanel(this.es)).setVisible(true);
         FrigatesPanel.i(bt.access$getFrigatesPanel(this.es)).setVisible(true);
         FrigatesPanel.j(bt.access$getFrigatesPanel(this.es)).setText(FrigatesPanel.AccountPanel(bt.access$getFrigatesPanel(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es))].getName());
         FrigatesPanel.k(bt.access$getFrigatesPanel(this.es)).setSelectedItem(FrigatesPanel.AccountPanel(bt.access$getFrigatesPanel(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es))].da());
         FrigatesPanel.l(bt.access$getFrigatesPanel(this.es)).setText(FrigatesPanel.AccountPanel(bt.access$getFrigatesPanel(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es))].LineNumberPanel().toString());
         FrigatesPanel.m(bt.access$getFrigatesPanel(this.es)).m(FrigatesPanel.AccountPanel(bt.access$getFrigatesPanel(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es))].db());
         FrigatesPanel.n(bt.access$getFrigatesPanel(this.es)).setText(FrigatesPanel.AccountPanel(bt.access$getFrigatesPanel(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es))].cU());
         FrigatesPanel.o(bt.access$getFrigatesPanel(this.es)).setText(FrigatesPanel.AccountPanel(bt.access$getFrigatesPanel(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es))].cV());

         for(var1 = 0; var1 < FrigatesPanel.d(bt.access$getFrigatesPanel(this.es)).length; ++var1) {
            FrigatesPanel.d(bt.access$getFrigatesPanel(this.es))[var1].setText(Integer.toString(FrigatesPanel.AccountPanel(bt.access$getFrigatesPanel(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es))].aq(var1)));
         }

         FrigatesPanel.p(bt.access$getFrigatesPanel(this.es)).setSelectedItem(FrigatesPanel.AccountPanel(bt.access$getFrigatesPanel(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es))].ar(0));
         FrigatesPanel.q(bt.access$getFrigatesPanel(this.es)).setSelectedItem(FrigatesPanel.AccountPanel(bt.access$getFrigatesPanel(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es))].ar(1));
         FrigatesPanel.r(bt.access$getFrigatesPanel(this.es)).setSelectedItem(FrigatesPanel.AccountPanel(bt.access$getFrigatesPanel(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es))].ar(2));
         FrigatesPanel.s(bt.access$getFrigatesPanel(this.es)).setSelectedItem(FrigatesPanel.AccountPanel(bt.access$getFrigatesPanel(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es))].ar(3));
         FrigatesPanel.t(bt.access$getFrigatesPanel(this.es)).setSelectedItem(FrigatesPanel.AccountPanel(bt.access$getFrigatesPanel(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es))].ar(4));
         FrigatesPanel.u(bt.access$getFrigatesPanel(this.es)).setText(Integer.toString(FrigatesPanel.AccountPanel(bt.access$getFrigatesPanel(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es))].dc()));
         FrigatesPanel.RefreshRunnable(bt.access$getFrigatesPanel(this.es)).setText(Integer.toString(FrigatesPanel.AccountPanel(bt.access$getFrigatesPanel(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es))].dd()));
         FrigatesPanel.AppStartupRunnable(bt.access$getFrigatesPanel(this.es)).setText(Integer.toString(FrigatesPanel.AccountPanel(bt.access$getFrigatesPanel(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es))].de()));
         FrigatesPanel.UpdateCheckThread(bt.access$getFrigatesPanel(this.es)).setText(Integer.toString(FrigatesPanel.AccountPanel(bt.access$getFrigatesPanel(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es))].df()));
         if (this.bv.j(FrigatesPanel.AccountPanel(bt.access$getFrigatesPanel(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es))].getIndex())) {
            FrigatesPanel.UpdateDownloadRunnable(bt.access$getFrigatesPanel(this.es)).setText("Status: On Mission");
            FrigatesPanel.UpdateDownloadRunnable(bt.access$getFrigatesPanel(this.es)).setForeground(Color.BLUE);
            FrigatesPanel.ShowErrorRunnable(bt.access$getFrigatesPanel(this.es)).setVisible(false);
         } else if (FrigatesPanel.AccountPanel(bt.access$getFrigatesPanel(this.es))[FrigatesPanel.AboutDialogCloseListener(bt.access$getFrigatesPanel(this.es))].dh() > 0) {
            FrigatesPanel.UpdateDownloadRunnable(bt.access$getFrigatesPanel(this.es)).setText("Status: Damaged!");
            FrigatesPanel.UpdateDownloadRunnable(bt.access$getFrigatesPanel(this.es)).setForeground(Color.RED);
            FrigatesPanel.ShowErrorRunnable(bt.access$getFrigatesPanel(this.es)).setVisible(true);
         } else {
            FrigatesPanel.UpdateDownloadRunnable(bt.access$getFrigatesPanel(this.es)).setText("");
            FrigatesPanel.ShowErrorRunnable(bt.access$getFrigatesPanel(this.es)).setVisible(false);
         }

         FrigatesPanel.h(bt.access$getFrigatesPanel(this.es)).updateUI();
         FrigatesPanel.i(bt.access$getFrigatesPanel(this.es)).updateUI();
         FrigatesPanel.p(bt.access$getFrigatesPanel(this.es)).updateUI();
         FrigatesPanel.q(bt.access$getFrigatesPanel(this.es)).updateUI();
         FrigatesPanel.r(bt.access$getFrigatesPanel(this.es)).updateUI();
         FrigatesPanel.s(bt.access$getFrigatesPanel(this.es)).updateUI();
         FrigatesPanel.t(bt.access$getFrigatesPanel(this.es)).updateUI();
         FrigatesPanel.ShowWarningRunnable(bt.access$getFrigatesPanel(this.es)).setEnabled(FrigatesPanel.AccountPanel(bt.access$getFrigatesPanel(this.es)).length > 1);
         FrigatesPanel.g(bt.access$getFrigatesPanel(this.es)).setEnabled(FrigatesPanel.AccountPanel(bt.access$getFrigatesPanel(this.es)).length < 30 || en.aS());
      }
   }
}
