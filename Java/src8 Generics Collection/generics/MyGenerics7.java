package generics;

class TwoD {
    int x, y;

    TwoD(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class ThreeD extends TwoD {
    int z;

    ThreeD(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}

class FourD extends ThreeD {
    int t;

    FourD(int x, int y, int z, int t) {
        super(x, y, z);
        this.t = t;
    }
}

class Coords<T extends TwoD> // hence T must be a subclass of TwoD ie threeD or fourD o eshe porbe auto
{
    T[] coords;

    Coords(T[] coords) {
        this.coords = coords;
       // System.out.println(coords[0].z); // error
        
    }
    
}

class BoundedWildcard {
    static void showXY(Coords<?> c) 
    
    // ? means can extend twoD or threeD or fourD
    //cant print z or t because lower bound  ta ke eta always...here is TwoD ..so eta kei nibe .extend only one class
     {
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + ", " + c.coords[i].y);
            //System.out.println(c.coords[i].z); // error
        }
        System.out.println();
    }

    static void showXYZ(Coords<? extends ThreeD> c)
    // here lower bound is ThreeD so it can print z also 
    {
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + ", " + c.coords[i].y + ", " + c.coords[i].z);
        }
        System.out.println();
    }

    static void showAll(Coords<? extends FourD> c) {
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + ", " + c.coords[i].y + ", " + c.coords[i].z + ", " + c.coords[i].t);
        }
        System.out.println();
    }
}

public class MyGenerics7 {
    public static void main(String[] args) {
        TwoD[] twoD = {
                new TwoD(1, 8),
                new TwoD(2, 7),
                new TwoD(3, 6),
                new TwoD(4, 5)
        };
        Coords<TwoD> twoDCoords = new Coords<>(twoD);
        BoundedWildcard.showXY(twoDCoords);
        //BoundedWildcard.showXYZ(twoDCoords);
        // generics.BoundedWildcard.showAll(twoDCoords);

        FourD[] fourD = {
                new FourD(1, 8, 9, 16),
                new FourD(2, 7, 10, 15),
                new FourD(3, 6, 11, 14),
                new FourD(4, 5, 12, 13)
        };
        Coords<FourD> fourDCoords = new Coords<>(fourD);
        BoundedWildcard.showXY(fourDCoords);
        BoundedWildcard.showXYZ(fourDCoords);
        BoundedWildcard.showAll(fourDCoords);
    }

}
