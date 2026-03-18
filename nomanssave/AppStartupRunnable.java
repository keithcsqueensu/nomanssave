package nomanssave;

class AppStartupRunnable implements Runnable {
   // $FF: synthetic field
   private final boolean FormPanel;

   AppStartupRunnable(boolean var1) {
      this.FormPanel = var1;
   }

   public void run() {
      try {
         Application.g(new Application(this.FormPanel, (Application)null));
         Application.h(Application.H()).setVisible(true);
      } catch (Exception var2) {
         var2.printStackTrace();
         System.exit(1);
      }

   }
}
