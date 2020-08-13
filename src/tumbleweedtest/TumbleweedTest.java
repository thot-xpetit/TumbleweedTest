/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tumbleweedtest;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.ginko.core.models.PrefixBase36Entity;
import org.ginko.core.util.Base36Converter;
import org.tumbleweed.resource.ResourceManager;

/**
 *
 * @author Xavier PETIT
 */
public class TumbleweedTest {
    
    static  void displayMessage(Locale currentLocale) {
 
      System.out.println("currentLocale = " + currentLocale.toString());
      System.out.println();
      Locale.setDefault(currentLocale);
 
       System.out.println(ResourceManager.getLanguage());
 
      Object[] messageArguments = {
          ResourceManager.getPlanet(),
         new Integer(7),
         new Date()
      };
 
      MessageFormat formatter = new MessageFormat("");
      formatter.setLocale(currentLocale);
 
      formatter.applyPattern(ResourceManager.getTemplate());
      String output = formatter.format(messageArguments);
 
      System.out.println(output);
 
   }
    

    public static void showPicture() {
        JFrame frame = new JFrame();
        ImageIcon icon = ResourceManager.getLogoApplication();
        JLabel label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void checkBase36Converter() {
        int[] decimalvalue = new int[36];
        String[] b36value = new String[36];
        for (int i = 0; i < 36; i++) {
            decimalvalue[i] = i;
            b36value[i] = Base36Converter.DecimalToBase36(i);
            System.out.println(Integer.toString(decimalvalue[i]) + "***" + b36value[i]);
        }
    }
    
    public static void showPrefexBase36() {
        PrefixBase36Entity entity = new PrefixBase36Entity("CUS", "CUS000000000000");
        System.out.println(entity.toString());
        entity.CalculateNextIdentity();
        System.out.println(entity.toString());
    }
 
   static public void main(String[] args) {
       /*
      displayMessage(Locale.getDefault());
      System.out.println();
      displayMessage(new Locale("en", "US"));
      System.out.println();
      displayMessage(new Locale("en", "EN"));
      System.out.println();
      displayMessage(new Locale("fr", "FR"));
      
      showPicture();
        */
       //checkBase36Converter();
       showPrefexBase36();
   }

    
}
 