
/**
 * This data type/class helps you work with fractions
 * Rational a = new Rational(3,4);
 *
 *  Rational objects stay in lowest terms
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rational{
    // instance variables - replace the example below with your own
    //private int x;
    private int numerator;
    private int denominator;
    
    /*
     * copy constructor
     */
    public Rational (Rational that){
        this.numerator = that.numerator;
        this.denominator = that.denominator;
    }
    
    public Rational(int numerator, int denominator){ 
        this.numerator = numerator;
        this.denominator = denominator;
        this.reduce(); 
        // n and d have local scope
        
    }
    
    public Rational(){
       numerator = 1;
       denominator = 1;
    }
    
    /*
     * stringify your object: provide a String 
     * representation of your object
     */
    
    /*
     * Override the toString that was inherited
     * from the Object class: the superclass of all
     * classes in Java
     * 
     * Override means change the implementation
     * of an inherited method
     */
    @Override
    public String toString(){
        //new Rational(3,4); 
        return numerator + "/" + denominator;     
    }
    
    
    /*
     *  Rational x = new Rational(1,4);
     *  Rational y = new Rational(1,2);
     *  Rational z = x.plus(y);
     */
    
    public Rational plus(Rational that){
        // a/b  + c/d =  (a*d+ b*c)/(b*d)
        int num = this.numerator*that.denominator + 
                  that.numerator*this.denominator;
        int denom = denominator * that.denominator;
        return new Rational(num, denom); //anonymous object
    }
    
    /*
     * mutator/setter method
     * alters the state of "this" object
     */
    public void add(Rational that){
         // a/b  + c/d =  (a*d+ b*c)/(b*d)
        this.numerator = this.numerator*that.denominator + 
                  that.numerator*this.denominator;
        this.denominator = denominator * that.denominator;
        this.reduce();
        //return new Rational(num, denom); //anonymous objec 
        
    }

    public Rational divide(Rational r){
      return new Rational(this.numerator*r.denominator, this.denominator*r.numerator);
    }
    /**
     * static method ~ class method (classes do not have a state)
     * non-static method ~ object method (objects have state)
     */
    public static Rational add(Rational a, Rational b){
          // a/b  + c/d =  (a*d+ b*c)/(b*d)
        //this.numerator = 42; // allowed? does this make sense?
        // will the Java marshalls come after you?
        int num = a.numerator*b.denominator + 
                  b.numerator*a.denominator;
        int denom = a.denominator * b.denominator;
        return new Rational(num, denom); 
        
        
    }
    /*
     * pre-condition: a and b are positive integers
     */
    private int gcd(int a, int b){
        for (int factor = a; factor > 1; factor--){
            if (a % factor == 0 && b % factor == 0)
                return factor;
        }
        return 1;
    }

    /**
     * reduces this Rational to lowest terms
     * (mutator/setter method)
     */
    private void reduce(){
        int gcd = gcd(this.numerator, this.denominator);
        this.numerator = this.numerator / gcd;
        this.denominator = this.denominator / gcd;
    }
    
    /**
     * attempt to override the equals method 
     * that was inherited from Object
     */
    public boolean equals(Rational that){
        return this.numerator == that.numerator &&
               this.denominator == that.denominator;
        
        
    }
   
}
