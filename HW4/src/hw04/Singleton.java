package hw04;

public class Singleton {
    
    
   /* A private Constructor prevents any other
    * class from instantiating.
    */
    private Singleton(){}
    private static Singleton instance = null;
    public static Singleton getInstance(){ 
        if(instance==null)
            instance = new Singleton();
        return instance;

  } 
  
}