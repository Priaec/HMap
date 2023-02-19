import java.util.*;
public class Plane implements Comparable<Plane>{

public String brand;
public String model;
//public int weight;

public Plane(){
	brand = "Unknown Brand";
	model = "Unknown Model";
	//weight = 0;
}

public Plane(String brand){
	this.brand = brand;
	this.model = "Unknown Model";
	//this.weight = 0;
}

public Plane (String brand, String model){
	this.brand = brand;
	this.model = model;
	//this.weight = weight;
}

@Override
public boolean equals (Object o1){
	if (o1 == this){
       return true;
	}
     else if(o1 == null || o1.getClass() != this.getClass()){
        return false;
	 }
      else{
        Plane po = (Plane) o1;
        return(this.brand.equals(po.brand)&&this.model.equals(po.model));
	  }		
}

@Override
public int compareTo(Plane other){
	if (this.brand.equals(other.brand)){
		return this.brand.compareTo(other.brand);
	}
	else{
		return this.brand.compareTo(other.brand);
	}
  }
  
  @Override
  public String toString(){
	 // return brand + "model";
	  return "Plane is " + brand + " " + model;
  }
  
  @Override 
  public int hashCode(){
	  return Math.abs((brand.hashCode() * 3) + model.hashCode());
  }
}