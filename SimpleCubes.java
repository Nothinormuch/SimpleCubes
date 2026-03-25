class Main {

}
class InvalidUnitVectorException extends RuntimeException{
  InvalidUnitVectorException(){
    super("Unit vector magnitude is not 1!");
  }
}
class InvalidCardinalUnitVectorException extends RuntimeException{
  InvalidCardinalUnitVectorException(){
    super("Unit vector not cardinal!");
  }
}
class UnitVector {
  int i,j,k;
  UnitVector(int i, int j, int k){
    if(Math.pow((Math.pow(i,2)+Math.pow(j,2)+Math.pow(k,2)),1/2)==1){
      this.i = i;
      this.j = j;
      this.k = k;
    }
    else{
      throw new InvalidUnitVectorException();
    }
  }
  boolean equals(UnitVector v){
    return(this.i == v.i && this.j == v.j && this.k == v.k);
  }
}

class Position {
  int x,y;
  Position(int x, int y){
    this.x = x;
    this.y = y;
  }
}

class Face {
  UnitVector direction;
  Facelet[][] faceletList;
  
  Face(String faceColor){
    faceletList = new Facelet[3][];
    for(int i = 0; i < 3; i ++){
      faceletList[i] = new Facelet[3];
      for(int j = 0; j < 3; j++){
        faceletList[i][j] = new Facelet(faceColor,new Position(j, i));
      }
    }
  }
  static String defaultDirectionColor(UnitVector direction){
    if(direction.equals(new UnitVector(0,0,1))){return "Yellow";}
    else if(direction.equals(new UnitVector(0,0,-1))){return "White";}
    else if(direction.equals(new UnitVector(0,1,0))){return "Blue";}
    else if(direction.equals(new UnitVector(0,-1,0))){return "Green";}
    else if(direction.equals(new UnitVector(0,0,-1))){return "white";}
    else if(direction.equals(new UnitVector(1,0,0))){return "Red";}
    else if(direction.equals(new UnitVector(-1,0,0))){return "Orange";}
    else {throw new InvalidCardinalUnitVectorException();}
  }
}

class Facelet {
  String color;
  Position pos;
  Facelet(String color,Position pos){
    this.color = color;
    this.pos = pos;
  }
}