package nomanssave;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

class ax implements TableModel {
   // $FF: synthetic field
   final DiscoveryPanel cu;

   ax(DiscoveryPanel var1) {
      this.cu = var1;
   }

   public int getRowCount() {
      return AlienWord.bx();
   }

   public int getColumnCount() {
      return 7;
   }

   public String getColumnName(int var1) {
      switch(var1) {
      case 0:
         return "Word";
      case 1:
         return "ID";
      case 2:
         return Race.kr.toString();
      case 3:
         return Race.ks.toString();
      case 4:
         return Race.kt.toString();
      case 5:
         return Race.kv.toString();
      case 6:
         return Race.kz.toString();
      default:
         return null;
      }
   }

   public Class getColumnClass(int var1) {
      switch(var1) {
      case 0:
      case 1:
         return String.class;
      default:
         return Boolean.class;
      }
   }

   public boolean isCellEditable(int var1, int var2) {
      if (var2 >= 2 && var2 < this.getColumnCount()) {
         AlienWord var3 = AlienWord.T(var1);
         if (var3 == null) {
            return false;
         } else {
            switch(var2) {
            case 2:
               return var3.isSpokenBy(Race.kr);
            case 3:
               return var3.isSpokenBy(Race.ks);
            case 4:
               return var3.isSpokenBy(Race.kt);
            case 5:
               return var3.isSpokenBy(Race.kv);
            case 6:
               return var3.isSpokenBy(Race.kz);
            default:
               return false;
            }
         }
      } else {
         return false;
      }
   }

   public Object getValueAt(int var1, int var2) {
      AlienWord var3 = AlienWord.T(var1);
      gA var4 = DiscoveryPanel.i(this.cu).getWordEntry(var3);
      switch(var2) {
      case 0:
         return var3 == null ? "" : var3.getText();
      case 1:
         return var4.getID();
      case 2:
         return var4.hasRecipeForRace(Race.kr);
      case 3:
         return var4.hasRecipeForRace(Race.ks);
      case 4:
         return var4.hasRecipeForRace(Race.kt);
      case 5:
         return var4.hasRecipeForRace(Race.kv);
      case 6:
         return var4.hasRecipeForRace(Race.kz);
      default:
         return null;
      }
   }

   public void setValueAt(Object var1, int var2, int var3) {
      AlienWord var4 = AlienWord.T(var2);
      gA var5 = DiscoveryPanel.i(this.cu).getWordEntry(var4);
      switch(var3) {
      case 2:
         var5.setRecipeEnabled(Race.kr, Boolean.TRUE.equals(var1));
         break;
      case 3:
         var5.setRecipeEnabled(Race.ks, Boolean.TRUE.equals(var1));
         break;
      case 4:
         var5.setRecipeEnabled(Race.kt, Boolean.TRUE.equals(var1));
         break;
      case 5:
         var5.setRecipeEnabled(Race.kv, Boolean.TRUE.equals(var1));
         break;
      case 6:
         var5.setRecipeEnabled(Race.kz, Boolean.TRUE.equals(var1));
      }

   }

   public void addTableModelListener(TableModelListener var1) {
   }

   public void removeTableModelListener(TableModelListener var1) {
   }
}
