import java.util.Iterator;
import java.util.Scanner;

public class MDriver{

   public static void main(String[] args){

      Plane p1 = new Plane(); p1.brand = "Boeing";   p1.model = "707";
      Plane p2 = new Plane(); p2.brand = "Boeing";   p2.model = "727";
	  Plane p3 = new Plane(); p3.brand = "Boeing";   p3.model = "737";
	  Plane p4 = new Plane(); p4.brand = "Boeing";   p4.model = "767";

      Scanner s1 = new Scanner(System.in);
 	  System.out.println("enter an integer. 1: Map(Empty) 2: Map(4)");
	  int i1 = s1.nextInt();
	  HMap<Plane, String> planes = ScanMAP(i1);
   if(planes.isEmpty()){
			System.out.println("the MAP is empty");
		}
		else if(!(planes.isEmpty())){
		  System.out.println("The MAP is not empty");
		  System.out.println("Size of MAP: " + planes.size());
		  }
	 if(planes.isFull()){
		  System.out.println("The MAP is full");
	    }
 
      Iterator<MapEntry<Plane, String>> it = planes.iterator();	 
	while(it.hasNext()){
	   MapEntry<Plane, String> tempp1;
	   tempp1 = it.next();
	   System.out.print(tempp1.toString());
     }
   }
public static HMap<Plane, String> ScanMAP(int selection){
	 
	  Plane p1 = new Plane(); p1.brand = "Boeing";   p1.model = "707";
      Plane p2 = new Plane(); p2.brand = "Boeing";   p2.model = "727";
	  Plane p3 = new Plane(); p3.brand = "Boeing";   p3.model = "737";
	  Plane p4 = new Plane(); p4.brand = "Boeing";   p4.model = "767";
		
		HMap<Plane, String>builda = new HMap<Plane, String>();
		 
     if (selection == 1){
			HMap<Plane, String>build1 = new HMap<Plane, String>();
		    return build1;
		}
		else if(selection == 2){ 
		    HMap<Plane, String>build2 = new HMap<Plane, String>(4, 0.75);
			build2.put(p1, p1.model);
			build2.put(p2, p2.model);
			build2.put(p3, p3.model);
			build2.put(p4, p4.model);
		    return build2;
		 }
		
     return builda;
 }
}