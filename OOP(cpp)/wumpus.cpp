#include <iostream>
#include <cmath>
#include <sstream>
#include<ctime>
#include<cstdlib>

using namespace std;

#define GRIDSIZE 4
#define UP      0
#define RIGHT   1
#define DOWN    2
#define LEFT    3

#define MAX_SHOTS 3


string to_strings(int x)
{
    std::string out_string;
    std::stringstream ss;
    ss << x;
    return ss.str();
}


class Position
{
    int x, y;

public:

    Position (int x, int y)
    {        
       this->x = x;
       this->y = y;              
    }

    Position(){
    }

    // Modify the following four so that the resulting position does not leave the grid
    void moveRight()
    {
        if(x< GRIDSIZE-1)
            x++;    
        else
            cout << "\nOut of bounds\n";    
    }

    void moveLeft()
    {
       if(x >0 )
            x--;
        else
            cout << "\nOut of bounds\n";
    }

    void moveUp()
    {
        if(y< GRIDSIZE-1)
            y++;
        else
            cout << "\nOut of bounds\n";
    }

    void moveDown()
    {
        if(y >0 )
            y--;
        else
            cout << "\nOut of bounds\n";
    }

    bool isAdjacent(Position p)
    {
        //implement the function
        if( ( abs(p.x - this->x)==1 && abs(p.y - this->y) == 0 ) || ( abs(p.x - this->x)==0 && abs(p.y - this->y) == 1) )
        {
            //cout << p.x <<' ' <<  p.y<<' '<<this->x <<' ' << this->y <<endl;
            return true;
        }   
        return false;     
    }

    bool isSamePoint(Position p)
    {
        //implement the function
        if(this->x == p.x && this->y == p.y)
            return true;
        return false;        
    }

    int getX()
    {
        return x;
    }

    int getY()
    {
        return y;
    }

};


class Wumpus
{

    bool killed;
    Position p;

public:

    Wumpus(int x, int y)
    {
        p = Position(x, y);
        killed = false;
        //int temp= p.x;
    }

    Wumpus()
    {
        //implement this default constructor of Wumpus class so that it initialized 
        //the position randomly within the grid, and sets it to alive
        srand(time(NULL));
        
        int a = rand() % (3 + 1 - 0) + 0;
        int b = rand() % (3 + 1 - 0) + 0;           //what is both remain zero !!!!
        p = Position(a,b);
        killed= false;
    }    

    
    void set_pos(int x, int y)
    {
        p=Position(x,y);
    }

    int getx()
    {
        int n= p.getX();
        return n;
    }
    int gety()
    {
        int n= p.getY();
        return n;
    }
    Position getPosition()
    {
        return p;
    }
};


class Player
{
    int direction;
    int total_shots;
    bool killed;
    Position p;

public:    

    Player()
    {
        //.implement this default constructor of Player class.  
        p = Position(0,0);
        total_shots=3;
        killed= false;
        direction = 0;
    }

    void turnLeft()
    {       
        direction++;
        direction = (direction%4+2)%4;
    }

    void turnRight()
    {       
        direction++;
        direction = direction%4;
    }

    void moveForward()
    {
        //player moves to the next cell 
        int x = p.getX();
        int y = p.getY();
        if(direction == 0)
         {
            //p = Position(x,y+1);
            p.moveUp();
         }
        else if(direction==1)
        {
            //p = Position(x+1,y);
            p.moveRight();
        }
        else if(direction== 2)
        {
            //p = Position(x,y-1);
            p.moveDown();
        }
        else if(direction==  3)
        {
            //p = Position(x-1,y);
            p.moveLeft();
        }


    }

    bool isAdjacent(Position pos)
    {
        return p.isAdjacent(pos);
    }

    bool isSamePoint(Position pos)
    {
        return p.isSamePoint(pos);
    }

    void kill()
    {
        killed = true;
    }

    string getPositionInfo()
    {
        cout << endl;       //optional
        return "Player is now at " + to_strings(p.getX()) + ", " + to_strings(p.getY());
    }

    int getx()
    {
        int n= p.getX();
        return n;
    }
    int gety()
    {
        int n= p.getY();
        return n;
    }
    int direction_inf()
    {
        return direction;
    }

    string getDirectionInfo()
    {
        string s;
        if (direction == UP) s = "up";
        if (direction == DOWN) s = "down";
        if (direction == LEFT) s = "left";
        if (direction == RIGHT) s = "right";
        return "Player is moving at direction: " + s;
    }
    void update_shots(int n)
    {
        total_shots = n;
    }
    int shots()
    {
        return total_shots;
    }

};

class Pit
{ 
    Position p;
    bool killed; 

    public:    
    Pit()
    {        
        srand(time(NULL));
        
        int a = rand() % (3 + 1 - 0) + 0;
        int b = rand() % (3 + 1 - 0) + 0;           //what is both remain zero !!!!
        p = Position(a,b);
        killed= false;
    }
    Pit (int a, int b)
    {
        p = Position(a,b);
        killed= false;
    }
    Position getPosition()
    {
        return p;
    }

};

class WumpusWorld
{

private:

    Player player;
    Wumpus wumpus;
    Position gold_position;
    bool ended;
    Pit pit;

public:

    WumpusWorld(){
    }

    WumpusWorld(int wumpus_x, int wumpus_y)
    {
        wumpus = Wumpus(wumpus_x,wumpus_y);
    }

    WumpusWorld(int wumpus_x, int wumpus_y, int gold_x, int gold_y)
    {
       wumpus = Wumpus(wumpus_x,wumpus_y);
       gold_position = Position(gold_x,gold_y);
    }

    WumpusWorld(int wumpus_x, int wumpus_y, int gold_x, int gold_y, int pit_x, int pit_y)
    {
        wumpus = Wumpus(wumpus_x,wumpus_y);
        pit = Pit(pit_x,pit_y);
        gold_position = Position(gold_x,gold_y);
    }

    void moveForward()
    {
        player.moveForward();
        return showGameState();
    }

    void turnLeft()
    {
        player.turnLeft();
        return showGameState();
    }

    void turnRight()
    {
        player.turnRight();
        return showGameState();
    }

    void shoot()
    {
        int count = player.shots();
        if(count<=0)
        {
            cout << "No more shots left" << endl;
        }
        
        else
        {
            int px = player.getx();
            int py= player.gety();
            int d = player.direction_inf();            
            int wx= wumpus.getx();
            int wy= wumpus.gety();
            //cout << wx << wy << endl;
            
            if(d==0 && wy>py && wx==px)
            {                                  
                       cout << "Wumpus killed!" << endl;
                       wumpus.set_pos(10,10);
                
            }
            else if(d==1 && wx>px && wy==py)
            {
                    cout << "Wumpus killed!" << endl;
                    wumpus.set_pos(10,10);
                
            }
            else if(d==2 && py>wy && wx==px)
            {                                 
                    cout << "Wumpus killed!" << endl;
                    wumpus.set_pos(10,10);
                
            }
            else if(d==3 && wx<px && wy==py)
            {                                   
                    cout << "Wumpus killed!" << endl;
                    wumpus.set_pos(10,10);
                
            }            
            count--;
            player.update_shots(count);
            
        }
              
       return showGameState();
    }

    void showGameState()
    {
        cout << player.getPositionInfo() << endl;
        cout << player.getDirectionInfo() << endl;
        if (player.isSamePoint(gold_position))
        {
            cout << "Got the gold!" << endl;
            cout << "Game ended, you won!" << endl;
            ended = true;
        }

        if (player.isAdjacent(wumpus.getPosition()))
        {
            cout << "stench!" << endl;
        }
        if (player.isAdjacent(pit.getPosition()))
        {
            cout << "breeze!" << endl;
        }

        if (player.isSamePoint(wumpus.getPosition()))
        {
            cout << "Player is killed!" << endl;
            player.kill();
            cout << "Game over!" << endl;
            ended = true;
        }
        if (player.isSamePoint(pit.getPosition()))
        {
            cout << "Player fell into pit !" << endl;
            player.kill();
            cout << "Game over!" << endl;
            ended = true;
        }
        
    }

    bool isOver()
    {
        return ended;
    }

};

void file()
{
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
}
int main()
{   
    
    int c, wumpus_x, wumpus_y, gold_x, gold_y, pit_x, pit_y;
    cin >>wumpus_x >>wumpus_y >>gold_x >>gold_y>> pit_x>> pit_y;    
    WumpusWorld w(wumpus_x, wumpus_y, gold_x, gold_y, pit_x, pit_y);
    //WumpusWorld( wumpus_x,  wumpus_y);
    //WumpusWorld( wumpus_x,  wumpus_y,  gold_x,  gold_y);

    w.showGameState();
    while (!w.isOver())
    {
        cout << "1: move forward" << endl;
        cout << "2: Turn left" << endl;
        cout << "3: Turn right" << endl;
        cout << "4: Shoot" << endl;
        cin >> c;
        if (c == 1)
        {
            w.moveForward();
        }
        else if (c == 2)
        {
            w.turnLeft();
        }
        else if (c == 3)
        {
            w.turnRight();
        }
        else if (c == 4)
        {
            w.shoot();
        }
       
    }
    return 0;
}
