/*Create an interface Shape */
interface Shape {
   void draw();
}

/*Create concrete classes implementing the same interface*/

class Rectangle implements Shape {

   @Override
   public void draw() {
      System.out.println("Rectangle::draw()");
   }
}

class Square implements Shape {

   @Override
   public void draw() {
      System.out.println("Square::draw()");
   }
}

class Circle implements Shape {

   @Override
   public void draw() {
      System.out.println("Circle::draw()");
   }
}

/* Create a facade class */

class ShapeMaker {
   private Shape circle;
   private Shape rectangle;
   private Shape square;

   public ShapeMaker() {
      circle = new Circle();
      rectangle = new Rectangle();
      square = new Square();
   }

   public void drawCircle(){
      circle.draw();
   }
   public void drawRectangle(){
      rectangle.draw();
   }
   public void drawSquare(){
      square.draw();
   }
}

/* Use the facade to draw various types of shapes.*/
public class FacadePattern {
   public static void main(String[] args) {
   
      ShapeMaker shapeMaker = new ShapeMaker();

      shapeMaker.drawCircle();
      shapeMaker.drawRectangle();
      shapeMaker.drawSquare();		
   }
}
