package nomanssave;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class dy extends MouseAdapter {
   // $FF: synthetic field
   final du hp;
   // $FF: synthetic field
   private final gF hq;

   dy(du var1, gF var2) {
      this.hp = var1;
      this.hq = var2;
   }

   public void mouseClicked(MouseEvent var1) {
      if (var1.getClickCount() == 2 && this.hq != null) {
         ItemDetailsDialog.AboutDialog((Container)du.d(this.hp), (ItemData)this.hq);
         du.AccountPanel(this.hp);
      }

   }
}
