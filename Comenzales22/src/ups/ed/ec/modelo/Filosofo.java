/* 
 * To change this template, choose Tools | Templates 
 * and open the template in the editor. 
 */  
  
package ups.ed.ec.modelo;  
import java.awt.Color;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
/** 
 * 
 * @author 
 */  
public class Filosofo implements Runnable{  
int id,res;  
Thread t;  
JButton filosofo;
JLabel derecho;
JLabel izquierdo;
JLabel resultado;
String proceso;
JTextArea textArea;
public Filosofo(int id,JLabel izquierdo, JLabel derecho,JButton filosofo,JLabel resultado, JTextArea textArea){  
    this.id = id;  
    this.derecho = derecho;  
    this.izquierdo = izquierdo;  
    this.filosofo=filosofo;
    this.resultado=resultado;
    this.textArea=textArea;
    t = new Thread(this);
    t.start();  
    
}  
public void  run(){ 
    for(int i =0;i<25;i++){  
        synchronized(this.izquierdo){  
           synchronized(this.derecho){  
             comer();     
            } 
        }
        pensar();  
    } 
   
}  
void comer () {  
    
    derecho.setText("cubierto Ocupado");
    derecho.setForeground(Color.red);
  
    izquierdo.setText("cubierto Ocupado");
    izquierdo.setForeground(Color.red);
    
    filosofo.setText("Comiendo");
    filosofo.setBackground(Color.GREEN);

    res=Integer.parseInt(resultado.getText());
    res+=1;
    resultado.setText(String.valueOf(res));
    proceso= "Filosofo.= "+(id+1)+ " Comiendo, utilizandocubiertos\n";
    textArea.append(proceso);
    try{  
        Thread.sleep(4000);  
    }catch(InterruptedException e){  
    }
    derecho.setText("cubierto Libre");
    derecho.setForeground(Color.black);
    
    izquierdo.setText("cubierto Libre");
    izquierdo.setForeground(Color.black);
    
    filosofo.setText("Pensando");   
    filosofo.setBackground(Color.DARK_GRAY);
    proceso="Filosofo.= "+(id+1)+ " Termina de comer y comienza a pensar, libera cubiertos\n";  
    textArea.append(proceso);
}  
void pensar(){  
    derecho.setText("cubierto Libre");
    derecho.setForeground(Color.black);
    
    izquierdo.setText("cubierto Libre");
    izquierdo.setForeground(Color.black);
    
    filosofo.setText("Pensando");   
    filosofo.setBackground(Color.DARK_GRAY);

    try{  
//int valor =  (int) (Math.random()*4000+1000);

        Thread.sleep(4000);  
      //  System.out.println("sleep: "+valor);
    }catch(InterruptedException e){  
    }          
}  

}  