import java.applet.*;

import java.awt.*;

import java.awt.event.*;

import java.util.Stack;

import java.util.Queue;

import java.util.HashSet;

import java.util.LinkedList;

import java.util.Iterator;

 

/*

<applet code="MiniProject1" width=500 height=800>

</applet>

*/

 

 

class GameDatabase

{

int gridType[][][]=new int[10][10][3];

int i,j;

GameDatabase()

{

for(i=0;i<10;i++)

{

for(j=0;j<10;j++)

{

gridType[i][j][0]=1;
//gridType[i][j][0]=(int)(Math.random()*100)%2;

}

}

gridType[5][0][0]=0;

gridType[5][1][0]=0;

gridType[5][2][0]=0;

gridType[5][3][0]=0;

gridType[5][4][0]=0;

gridType[5][5][0]=0;

gridType[5][6][0]=0;

gridType[5][7][0]=0;

gridType[5][8][0]=0;

gridType[5][9][0]=0;

gridType[4][0][0]=0;

gridType[4][1][0]=0;

gridType[4][2][0]=0;

gridType[4][3][0]=0;

gridType[4][4][0]=0;

gridType[4][5][0]=0;

gridType[4][6][0]=0;

gridType[4][7][0]=0;

gridType[4][8][0]=0;

gridType[4][9][0]=0;


}

public int[][][] getGrid()

{

return gridType;

}

 

}

 

 

 

 

 

 

 

class GridReturn

{

int OldGrid[][][],NewGrid[][][];

long score;

Stack <Integer> stack;

Queue <Integer> queue;

GridReturn(int OldGrid[][][],int NewGrid[][][])

{

this.OldGrid=OldGrid;

this.NewGrid=NewGrid;

}

 

GridReturn(int OldGrid[][][], int NewGrid[][][], Queue <Integer> queue)

{

this.OldGrid=OldGrid;

this.NewGrid=NewGrid;

this.queue=queue;

}

 

GridReturn(int OldGrid[][][], int NewGrid[][][], Queue <Integer> queue, Stack<Integer> stack)

{

this.OldGrid=OldGrid;

this.NewGrid=NewGrid;

this.queue=queue;

this.stack=stack;

}

 

GridReturn(int OldGrid[][][], int NewGrid[][][], Queue <Integer> queue, Stack<Integer> stack,long score)

{

this.OldGrid=OldGrid;

this.NewGrid=NewGrid;

this.queue=queue;

this.stack=stack;

this.score=score;

}

 

GridReturn(int OldGrid[][][],int NewGrid[][][], Stack <Integer> stack)

{

this.OldGrid=OldGrid;

this.NewGrid=NewGrid;

this.stack=stack;

}

 

public int[][][] getOldGrid()

{

return OldGrid;

}

 

public int[][][] getNewGrid()

{

return NewGrid;

}

 

public boolean gridsDifferent()

{

int i,j;

for(i=0;i<10;i++)

{

for(j=0;j<10;j++)

{

if(OldGrid[i][j][1]!=NewGrid[i][j][1])

{

return true;

}

}

}

return false;

}

 

 

public Queue<Integer> getSpecialCandies()

{

return queue;

}

 

public Stack<Integer> crushedCandiesLocation()

{

return stack;

}

 

public long getScore()

{

return score;

}

 

}

 

 

 

 

 

 

 

class CandyCrusher

{

 

public void drawCandies(Graphics g,int i,int j, int k)

{

if(k==1)

{

Color c1=new Color(80,80,80);

Color c3=new Color(0,230,0);

g.setColor(c3);

g.drawRoundRect(8+50*i,8+50*j+100,35,35,20,20);

g.fillRoundRect(8+50*i,8+50*j+100,35,35,20,20);

g.setColor(Color.black);

g.drawRoundRect(8+50*i,8+50*j+100,35,35,20,20);

}

else if(k==2)

{

Color c1=new Color(80,80,80);

Color c3=new Color(0,0,210);

g.setColor(c3);

g.drawOval(7+50*i,7+50*j+100,35,35);

g.fillOval(7+50*i,7+50*j+100,35,35);

g.setColor(Color.black);

g.drawOval(7+50*i,7+50*j+100,35,35);

}

else if(k==3)

{

Color c1=new Color(80,80,80);

g.setColor(Color.red);

g.drawOval(12+50*i,7+50*j+100,25,35);

g.fillOval(12+50*i,7+50*j+100,25,35);

g.setColor(Color.black);

g.drawOval(12+50*i,7+50*j+100,25,35);

}

else if(k==4)

{

int xPoints[]= {25+50*i,42+50*i,25+50*i,8+50*i};

int yPoints[]= {8+50*j+100,27+50*j+100,42+50*j+100,27+50*j+100};

int n=4;

Color c1=new Color(80,80,80);

Color c3=new Color(0,191,255);

g.setColor(c3);

g.drawPolygon(xPoints, yPoints, n);

g.fillPolygon(xPoints, yPoints, n);

g.setColor(Color.black);

g.drawPolygon(xPoints, yPoints, n);

}

else if(k==5)

{

int xPoints[]= {25+50*i,39+50*i,11+50*i};

int yPoints[]= {10+50*j+100,40+50*j+100,40+50*j+100};

int n=3;

Color c1=new Color(80,80,80);

Color c3=new Color(250,250,0);

g.setColor(c3);

g.drawPolygon(xPoints, yPoints, n);

g.fillPolygon(xPoints, yPoints, n);

g.setColor(Color.black);

g.drawPolygon(xPoints, yPoints, n);

}

else if(k==6)

{

int xPoints[]= {7+50*i,26+50*i,43+50*i,43+50*i,26+50*i,7+50*i,7+50*i};

int yPoints[]= {17+50*j+100,10+50*j+100,17+50*j+100,30+50*j+100,37+50*j+100,30+50*j+100,17+50*j+100};

int n=7;

Color c1=new Color(80,80,80);

Color c3=new Color(255,0,255);

g.setColor(c3);

g.drawPolygon(xPoints, yPoints, n);

g.fillPolygon(xPoints, yPoints, n);

g.setColor(Color.black);

g.drawPolygon(xPoints, yPoints, n);

}

else if(k==11)

{

Color c1=new Color(80,80,80);

Color c3=new Color(0,230,0);

g.setColor(c3);

g.drawRoundRect(8+50*i,8+50*j+100,35,35,20,20);

g.fillRoundRect(8+50*i,8+50*j+100,35,35,20,20);

g.setColor(Color.black);

g.drawRoundRect(8+50*i,8+50*j+100,35,35,20,20);

g.setColor(Color.white);

g.drawLine(22+50*i,9+50*j+100,22+50*i,42+50*j+100);

g.drawLine(27+50*i,9+50*j+100,27+50*i,42+50*j+100);

g.drawLine(9+50*i,23+50*j+100,42+50*i,23+50*j+100);

g.drawLine(9+50*i,29+50*j+100,42+50*i,29+50*j+100);

}

else if(k==12)

{

Color c1=new Color(80,80,80);

Color c3=new Color(0,0,210);

g.setColor(c3);

g.drawOval(7+50*i,7+50*j+100,35,35);

g.fillOval(7+50*i,7+50*j+100,35,35);

g.setColor(Color.black);

g.drawOval(7+50*i,7+50*j+100,35,35);

g.setColor(Color.white);

g.drawLine(22+50*i,8+50*j+100,22+50*i,40+50*j+100);

g.drawLine(27+50*i,8+50*j+100,27+50*i,40+50*j+100);

g.drawLine(9+50*i,21+50*j+100,41+50*i,21+50*j+100);

g.drawLine(9+50*i,27+50*j+100,41+50*i,27+50*j+100);

}

else if(k==13)

{

Color c1=new Color(80,80,80);

g.setColor(Color.red);

g.drawOval(12+50*i,7+50*j+100,25,35);

g.fillOval(12+50*i,7+50*j+100,25,35);

g.setColor(Color.black);

g.drawOval(12+50*i,7+50*j+100,25,35);

g.setColor(Color.white);

g.drawLine(22+50*i,9+50*j+100,22+50*i,39+50*j+100);

g.drawLine(27+50*i,9+50*j+100,27+50*i,39+50*j+100);

g.drawLine(13+50*i,22+50*j+100,35+50*i,23+50*j+100);

g.drawLine(13+50*i,27+50*j+100,35+50*i,28+50*j+100);

}

else if(k==14)

{

int xPoints[]= {25+50*i,42+50*i,25+50*i,8+50*i};

int yPoints[]= {8+50*j+100,27+50*j+100,42+50*j+100,27+50*j+100};

int n=4;

Color c1=new Color(80,80,80);

Color c3=new Color(0,191,255);

g.setColor(c3);

g.drawPolygon(xPoints, yPoints, n);

g.fillPolygon(xPoints, yPoints, n);

g.setColor(Color.black);

g.drawPolygon(xPoints, yPoints, n);

g.setColor(Color.white);

g.drawLine(22+50*i,12+50*j+100,22+50*i,38+50*j+100);

g.drawLine(28+50*i,12+50*j+100,28+50*i,38+50*j+100);

g.drawLine(12+50*i,24+50*j+100,38+50*i,24+50*j+100);

g.drawLine(12+50*i,30+50*j+100,38+50*i,30+50*j+100);

}

else if(k==15)

{

int xPoints[]= {25+50*i,39+50*i,11+50*i};

int yPoints[]= {10+50*j+100,40+50*j+100,40+50*j+100};

int n=3;

Color c1=new Color(80,80,80);

Color c3=new Color(255,223,0);

g.setColor(c3);

g.drawPolygon(xPoints, yPoints, n);

g.fillPolygon(xPoints, yPoints, n);

g.setColor(Color.black);

g.drawPolygon(xPoints, yPoints, n);

g.setColor(Color.white);

g.drawLine(22+50*i,17+50*j+100,22+50*i,39+50*j+100);

g.drawLine(27+50*i,17+50*j+100,27+50*i,39+50*j+100);

g.drawLine(17+50*i,29+50*j+100,33+50*i,29+50*j+100);

g.drawLine(14+50*i,34+50*j+100,35+50*i,34+50*j+100);

}

else if(k==16)

{

Color c1=new Color(80,80,80);

g.setColor(Color.red);

g.drawOval(12+50*i,7+50*j+100,25,35);

g.fillOval(12+50*i,7+50*j+100,25,35);

g.setColor(Color.black);

g.drawOval(12+50*i,7+50*j+100,25,35);

g.setColor(Color.white);

g.drawLine(21+50*i,9+50*j+100,21+50*i,39+50*j+100);

g.drawLine(26+50*i,9+50*j+100,26+50*i,39+50*j+100);

g.drawLine(13+50*i,22+50*j+100,35+50*i,22+50*j+100);

g.drawLine(13+50*i,27+50*j+100,35+50*i,27+50*j+100);

}

else if(k==21)

{

Color c1=new Color(80,80,80);

Color c3=new Color(0,230,0);

g.setColor(c3);

g.drawRoundRect(8+50*i,8+50*j+100,35,35,20,20);

g.fillRoundRect(8+50*i,8+50*j+100,35,35,20,20);

g.setColor(Color.black);

g.drawRoundRect(8+50*i,8+50*j+100,35,35,20,20);

g.setColor(Color.white);

g.drawLine(22+50*i,9+50*j+100,22+50*i,42+50*j+100);

g.drawLine(27+50*i,9+50*j+100,27+50*i,42+50*j+100);

g.drawLine(9+50*i,23+50*j+100,42+50*i,23+50*j+100);

g.drawLine(9+50*i,29+50*j+100,42+50*i,29+50*j+100);

}

else if(k==22)

{

Color c1=new Color(80,80,80);

Color c3=new Color(0,0,210);

g.setColor(c3);

g.drawOval(7+50*i,7+50*j+100,35,35);

g.fillOval(7+50*i,7+50*j+100,35,35);

g.setColor(Color.black);

g.drawOval(7+50*i,7+50*j+100,35,35);

g.setColor(Color.white);

g.drawLine(22+50*i,8+50*j+100,22+50*i,40+50*j+100);

g.drawLine(27+50*i,8+50*j+100,27+50*i,40+50*j+100);

g.drawLine(9+50*i,21+50*j+100,41+50*i,21+50*j+100);

g.drawLine(9+50*i,27+50*j+100,41+50*i,27+50*j+100);

}

else if(k==23)

{

Color c1=new Color(80,80,80);

g.setColor(Color.red);

g.drawOval(12+50*i,7+50*j+100,25,35);

g.fillOval(12+50*i,7+50*j+100,25,35);

g.setColor(Color.black);

g.drawOval(12+50*i,7+50*j+100,25,35);

g.setColor(Color.white);

g.drawLine(22+50*i,9+50*j+100,22+50*i,39+50*j+100);

g.drawLine(27+50*i,9+50*j+100,27+50*i,39+50*j+100);

g.drawLine(13+50*i,22+50*j+100,35+50*i,23+50*j+100);

g.drawLine(13+50*i,27+50*j+100,35+50*i,28+50*j+100);

}

else if(k==24)

{

int xPoints[]= {25+50*i,42+50*i,25+50*i,8+50*i};

int yPoints[]= {8+50*j+100,27+50*j+100,42+50*j+100,27+50*j+100};

int n=4;

Color c1=new Color(80,80,80);

Color c3=new Color(0,191,255);

g.setColor(c3);

g.drawPolygon(xPoints, yPoints, n);

g.fillPolygon(xPoints, yPoints, n);

g.setColor(Color.black);

g.drawPolygon(xPoints, yPoints, n);

g.setColor(Color.white);

g.drawLine(22+50*i,12+50*j+100,22+50*i,38+50*j+100);

g.drawLine(28+50*i,12+50*j+100,28+50*i,38+50*j+100);

g.drawLine(12+50*i,24+50*j+100,38+50*i,24+50*j+100);

g.drawLine(12+50*i,30+50*j+100,38+50*i,30+50*j+100);

}

else if(k==25)

{

int xPoints[]= {25+50*i,39+50*i,11+50*i};

int yPoints[]= {10+50*j+100,40+50*j+100,40+50*j+100};

int n=3;

Color c1=new Color(80,80,80);

Color c3=new Color(255,223,0);

g.setColor(c3);

g.drawPolygon(xPoints, yPoints, n);

g.fillPolygon(xPoints, yPoints, n);

g.setColor(Color.black);

g.drawPolygon(xPoints, yPoints, n);

g.setColor(Color.white);

g.drawLine(22+50*i,17+50*j+100,22+50*i,39+50*j+100);

g.drawLine(27+50*i,17+50*j+100,27+50*i,39+50*j+100);

g.drawLine(17+50*i,29+50*j+100,33+50*i,29+50*j+100);

g.drawLine(14+50*i,34+50*j+100,35+50*i,34+50*j+100);

}

else if(k==26)

{

Color c1=new Color(80,80,80);

g.setColor(Color.red);

g.drawOval(12+50*i,7+50*j+100,25,35);

g.fillOval(12+50*i,7+50*j+100,25,35);

g.setColor(Color.black);

g.drawOval(12+50*i,7+50*j+100,25,35);

g.setColor(Color.white);

g.drawLine(21+50*i,9+50*j+100,21+50*i,39+50*j+100);

g.drawLine(26+50*i,9+50*j+100,26+50*i,39+50*j+100);

g.drawLine(13+50*i,22+50*j+100,35+50*i,22+50*j+100);

g.drawLine(13+50*i,27+50*j+100,35+50*i,27+50*j+100);

}

else if(k==31)

{

int xPoints[]= {12+50*i,20+50*i,30+50*i,38+50*i,38+50*i,30+50*i,20+50*i,12+50*i,12+50*i};

int yPoints[]= {12+50*j+100,21+50*j+100,21+50*j+100,12+50*j+100,38+50*j+100,31+50*j+100,31+50*j+100,38+50*j+100,12+50*j+100};

int n=9;

Color c1=new Color(80,80,80);

Color c2=new Color(0,100,0);

Color c3=new Color(0,230,0);

g.setColor(c2);

g.drawRect(8+50*i, 8+50*j+100, 34, 35);

g.fillRect(8+50*i, 8+50*j+100, 34, 35);

g.setColor(Color.black);

g.drawRect(8+50*i, 8+50*j+100, 34, 35);

g.setColor(c3);

g.drawPolygon(xPoints, yPoints, n);

g.fillPolygon(xPoints, yPoints, n);

g.setColor(Color.black);

g.drawPolygon(xPoints, yPoints, n);

}

else if(k==32)

{

int xPoints[]= {12+50*i,20+50*i,30+50*i,38+50*i,38+50*i,30+50*i,20+50*i,12+50*i,12+50*i};

int yPoints[]= {12+50*j+100,21+50*j+100,21+50*j+100,12+50*j+100,38+50*j+100,31+50*j+100,31+50*j+100,38+50*j+100,12+50*j+100};

int n=9;

Color c1=new Color(80,80,80);

Color c2=new Color(0,0,130);

Color c3=new Color(0,0,210);

g.setColor(c2);

g.drawRect(8+50*i, 8+50*j+100, 34, 35);

g.fillRect(8+50*i, 8+50*j+100, 34, 35);

g.setColor(Color.black);

g.drawRect(8+50*i, 8+50*j+100, 34, 35);

g.setColor(c3);

g.drawPolygon(xPoints, yPoints, n);

g.fillPolygon(xPoints, yPoints, n);

g.setColor(Color.black);

g.drawPolygon(xPoints, yPoints, n);

}

else if(k==33)

{

int xPoints[]= {12+50*i,20+50*i,30+50*i,38+50*i,38+50*i,30+50*i,20+50*i,12+50*i,12+50*i};

int yPoints[]= {12+50*j+100,21+50*j+100,21+50*j+100,12+50*j+100,38+50*j+100,31+50*j+100,31+50*j+100,38+50*j+100,12+50*j+100};

int n=9;

Color c1=new Color(80,80,80);

Color c2=new Color(150,0,0);

g.setColor(c2);

g.drawRect(8+50*i, 8+50*j+100, 34, 35);

g.fillRect(8+50*i, 8+50*j+100, 34, 35);

g.setColor(Color.black);

g.drawRect(8+50*i, 8+50*j+100, 34, 35);

g.setColor(Color.red);

g.drawPolygon(xPoints, yPoints, n);

g.fillPolygon(xPoints, yPoints, n);

g.setColor(Color.black);

g.drawPolygon(xPoints, yPoints, n);

}

else if(k==34)

{

int xPoints[]= {12+50*i,20+50*i,30+50*i,38+50*i,38+50*i,30+50*i,20+50*i,12+50*i,12+50*i};

int yPoints[]= {12+50*j+100,21+50*j+100,21+50*j+100,12+50*j+100,38+50*j+100,31+50*j+100,31+50*j+100,38+50*j+100,12+50*j+100};

int n=9;

Color c1=new Color(80,80,80);

Color c2=new Color(0,0,255);

Color c3=new Color(0,191,255);

g.setColor(c2);

g.drawRect(8+50*i, 8+50*j+100, 34, 35);

g.fillRect(8+50*i, 8+50*j+100, 34, 35);

g.setColor(Color.black);

g.drawRect(8+50*i, 8+50*j+100, 34, 35);

g.setColor(c3);

g.drawPolygon(xPoints, yPoints, n);

g.fillPolygon(xPoints, yPoints, n);

g.setColor(Color.black);

g.drawPolygon(xPoints, yPoints, n);

}

else if(k==35)

{

int xPoints[]= {12+50*i,20+50*i,30+50*i,38+50*i,38+50*i,30+50*i,20+50*i,12+50*i,12+50*i};

int yPoints[]= {12+50*j+100,21+50*j+100,21+50*j+100,12+50*j+100,38+50*j+100,31+50*j+100,31+50*j+100,38+50*j+100,12+50*j+100};

int n=9;

Color c1=new Color(80,80,80);

Color c2=new Color(255,100,0);

Color c3=new Color(250,250,0);

g.setColor(c2);

g.drawRect(8+50*i, 8+50*j+100, 34, 35);

g.fillRect(8+50*i, 8+50*j+100, 34, 35);

g.setColor(Color.black);

g.drawRect(8+50*i, 8+50*j+100, 34, 35);

g.setColor(c3);

g.drawPolygon(xPoints, yPoints, n);

g.fillPolygon(xPoints, yPoints, n);

g.setColor(Color.black);

g.drawPolygon(xPoints, yPoints, n);

}

else if(k==36)

{

int xPoints[]= {12+50*i,20+50*i,30+50*i,38+50*i,38+50*i,30+50*i,20+50*i,12+50*i,12+50*i};

int yPoints[]= {12+50*j+100,21+50*j+100,21+50*j+100,12+50*j+100,38+50*j+100,31+50*j+100,31+50*j+100,38+50*j+100,12+50*j+100};

int n=9;

Color c1=new Color(80,80,80);

Color c2=new Color(128,0,128);

Color c3=new Color(255,0,255);

g.setColor(c2);

g.drawRect(8+50*i, 8+50*j+100, 34, 35);

g.fillRect(8+50*i, 8+50*j+100, 34, 35);

g.setColor(Color.black);

g.drawRect(8+50*i, 8+50*j+100, 34, 35);

g.setColor(c3);

g.drawPolygon(xPoints, yPoints, n);

g.fillPolygon(xPoints, yPoints, n);

g.setColor(Color.black);

g.drawPolygon(xPoints, yPoints, n);

}

else if(k==40)

{

Color c1=new Color(80,80,80);

Color c2=new Color(139,69,19);

Color c3=new Color(0,0,210);

Color c4=new Color(50,205,50);

Color c5=new Color(255,223,0);

Color c6=new Color(240,0,0);

g.setColor(c2);

g.drawOval(7+50*i,7+50*j+100,35,35);

g.fillOval(7+50*i,7+50*j+100,35,35);

g.setColor(Color.black);

g.drawOval(7+50*i,7+50*j+100,35,35);

g.setColor(c3);

g.drawOval(20+50*i,11+50*j+100,5,5);

g.fillOval(20+50*i,11+50*j+100,5,5);

g.setColor(c4);

g.drawOval(29+50*i,16+50*j+100,5,5);

g.fillOval(29+50*i,16+50*j+100,5,5);

g.setColor(c6);

g.drawOval(13+50*i,18+50*j+100,5,5);

g.fillOval(13+50*i,18+50*j+100,5,5);

g.setColor(c5);

g.drawOval(21+50*i,22+50*j+100,5,5);

g.fillOval(21+50*i,22+50*j+100,5,5);

g.setColor(c4);

g.drawOval(14+50*i,28+50*j+100,5,5);

g.fillOval(14+50*i,28+50*j+100,5,5);

g.setColor(c3);

g.drawOval(31+50*i,26+50*j+100,5,5);

g.fillOval(31+50*i,26+50*j+100,5,5);

g.setColor(c6);

g.drawOval(24+50*i,31+50*j+100,5,5);

g.fillOval(24+50*i,31+50*j+100,5,5);

}

 

}

 

public void displayGrid(Graphics g,int Grid1[][][],int Grid[][][],int updateType)

{

int i,j;

Color c1 = new Color(80,80,80);

 

 

 

for(i=0;i<10;i++)

{

for(j=0;j<10;j++)

{

if(Grid[i][j][0]==1 && (Grid[i][j][1]!=Grid1[i][j][1] || Grid[i][j][0]!=Grid1[i][j][0] || updateType==0))

{

g.setColor(c1);

g.fillRect(50*i,50*j+100,50,50);

}

}

}

 

for(i=0;i<10;i++)

{

for(j=0;j<10;j++)

{

if(Grid[i][j][0]>0 && (Grid[i][j][1]!=Grid1[i][j][1] || Grid[i][j][0]!=Grid1[i][j][0] || updateType==0))

{

g.setColor(Color.black);

g.drawLine(50*i,50*j+100,50*i+50,50*j+100);

g.drawLine(50*i,50*j+100,50*i,50*j+150);

g.drawLine(50*i,50*j+150,50*i+50,50*j+150);

g.drawLine(50*i+50,50*j+100,50*i+50,50*j+150);

}

if(Grid[i][j][1]!=Grid1[i][j][1] || Grid[i][j][0]!=Grid1[i][j][0] || updateType==0)

{

drawCandies(g,i,j,Grid[i][j][1]);

}

}

 

}

 

}

 

 

public void displayGrid(Graphics g,int Grid[][][],Stack<Integer> stack)

{

int i,j;

Color c1 = new Color(80,80,80);

while(!stack.empty())

{

i=(int)(stack.peek()/10);

j=(stack.peek()%10);

g.fillRect(50*i,50*j+100,50,50);

g.setColor(Color.black);

g.drawLine(50*i,50*j+100,50*i+50,50*j+100);

g.drawLine(50*i,50*j+100,50*i,50*j+150);

g.drawLine(50*i,50*j+150,50*i+50,50*j+150);

g.drawLine(50*i+50,50*j+100,50*i+50,50*j+150);

drawCandies(g,i,j,Grid[i][j][1]);

stack.pop();

}

 

}

 

 

 

 

 

 

 

 

 

 

 

public GridReturn fillEmptySpaces(Graphics g,int Grid[][][],int typeOfCandiestoConstruct[],int totalCandies)

{

int Grid1[][][]=Grid;

GridReturn gridReturn;

Stack<Integer> stack=new Stack<Integer>();

int i,j,k,temp,shiftingDone=0;

CandyCrusher candyCrusher=new CandyCrusher();

for(i=0;i<10;i++)

{

for(j=0;j<10;j++)

{

if(Grid[j][i][1]==0 && Grid[j][i][0]!=0)

{

k=i;

while(k>=1 && Grid[j][k-1][0]!=0)

{

Grid[j][k][1]=Grid[j][k-1][1];

if(!stack.contains(10*i+j))

{

stack.push(10*i+j);

}

k--;

}

Grid[j][k][1]=typeOfCandiestoConstruct[((int)(Math.random()*1000))%totalCandies];

if(!stack.contains(10*i+j))

{

stack.push(10*i+j);

}

g.setColor(Color.black);

shiftingDone=1;

}

}

if(shiftingDone==1)

{

gridReturn = new GridReturn(Grid1,Grid,stack);

return gridReturn;

}

}

gridReturn = new GridReturn(Grid1,Grid,stack);

return gridReturn;

}

 

 

 

public int[][][] exchangeCandies(Graphics g,int Grid[][][],int xpos,int ypos,int xpos1,int ypos1)

{

int location,location1,temp,i,j;

location=((int)(xpos/50))*10+((int)((ypos-100)/50));

location1=((int)(xpos1/50))*10+((int)((ypos1-100)/50));

Color c1 = new Color(80,80,80);

if(((int)(location/10))<10 && ((int)(location/10))>=0 && location%10<10 && location%10>=0 && ((int)(location1/10))<10 && ((int)(location1/10))>=0 && location1%10<10 && location1%10>=0)

{

if((location-location1 == -10 || location-location1 == -1 || location-location1 == 1 || location-location1 == 10) && Grid[(int)(location/10)][location%10][0]!=0 && Grid[(int)(location1/10)][location1%10][0]!=0)

{

temp=Grid[(int)(location/10)][location%10][1];

Grid[(int)(location/10)][location%10][1]=Grid[(int)(location1/10)][location1%10][1];

Grid[(int)(location1/10)][location1%10][1]=temp;

i=(int)(location/10);

j=location%10;

g.setColor(c1);

g.fillRect(50*(int)(location/10),50*(location%10)+100,50,50);

g.setColor(Color.black);

g.drawLine(50*i,50*j+100,50*i+50,50*j+100);

g.drawLine(50*i,50*j+100,50*i,50*j+150);

g.drawLine(50*i,50*j+150,50*i+50,50*j+150);

g.drawLine(50*i+50,50*j+100,50*i+50,50*j+150);

g.drawString(String.valueOf(Grid[i][j][1]),i*50+20,j*50+130);

 

i=(int)(location1/10);

j=location1%10;

g.setColor(c1);

g.fillRect(50*(int)(location1/10),50*(location1%10)+100,50,50);

g.setColor(Color.black);

g.drawLine(50*i,50*j+100,50*i+50,50*j+100);

g.drawLine(50*i,50*j+100,50*i,50*j+150);

g.drawLine(50*i,50*j+150,50*i+50,50*j+150);

g.drawLine(50*i+50,50*j+100,50*i+50,50*j+150);

g.drawString(String.valueOf(Grid[i][j][1]),i*50+20,j*50+130);

}

}

return Grid;

}

 

 

 

 

 

public Stack<Integer> checkHorizontal(int Grid[][][],int i,int j)

{

int i1,j1,count=1;

Stack<Integer> stack=new Stack<Integer>();

Stack<Integer> stack1=new Stack<Integer>();

stack.push(10*i+j);

if(Grid[i][j][1]!=0)

{

j1=j+1;

while(j1<10 && (Grid[i][j][1])%10==(Grid[i][j1][1])%10)

{

stack.push(10*i+j1);

count++;

j1++;

}

 

j1=j-1;

while(j1>=0 && (Grid[i][j][1])%10==(Grid[i][j1][1])%10)

{

stack.push(10*i+j1);

count++;

j1--;

}

}

if(count>=3)

{

return stack;

}

else

{

return stack1;

}

}

 

public Stack<Integer> checkVertical(int Grid[][][],int i,int j)

{

int i1,j1,count=1;

Stack<Integer> stack=new Stack<Integer>();

Stack<Integer> stack1=new Stack<Integer>();

stack.push(10*i+j);

if(Grid[i][j][1]!=-1)

{

i1=i+1;

while(i1<10 && (Grid[i][j][1])%10==(Grid[i1][j][1])%10)

{

stack.push(10*i1+j);

count++;

i1++;

}

 

i1=i-1;

while(i1>=0 && (Grid[i][j][1])%10==(Grid[i1][j][1])%10)

{

stack.push(10*i1+j);

count++;

i1--;

}

}

if(count>=3)

{

return stack;

}

else

{

return stack1;

}

}

 

 

public GridReturn performCandyCrush(Graphics g, int Grid[][][])

{

int i,j,i1,j1,h,v,h1,v1,t;

int Grid1[][][]=Grid;

long score=0;

Stack<Integer> stack=new Stack<Integer>();

Stack<Integer> stack_h=new Stack<Integer>();

Stack<Integer> stack_v=new Stack<Integer>();

Stack<Integer> stack_temp=new Stack<Integer>();

 

for(i=0;i<10;i++)

{

for(j=0;j<10;j++)

{

 

stack_h=checkHorizontal(Grid,i,j);

if(!stack_h.empty())

{

while(!stack_h.empty())

{

stack.push(stack_h.pop());

stack_temp=checkVertical(Grid,(int)((stack.peek())/10),j);

if(!stack_temp.empty())

{

while(!stack_temp.empty())

{

stack.push(stack_temp.pop());

}

}

}

 

}

 

 

stack_v=checkVertical(Grid,i,j);

if(!stack_v.empty())

{

while(!stack_v.empty())

{

stack.push(stack_v.pop());

stack_temp=checkHorizontal(Grid,i,(stack.peek())%10);

if(!stack_temp.empty())

{

while(!stack_temp.empty())

{

stack.push(stack_temp.pop());

}

}

}

 

}

 

 

if(!(stack_h.empty() || stack_v.empty()))

{

break;

}

 

 

 

}

 

 

 

}

 

 

 

HashSet <Integer> hash_Set = new HashSet <Integer>();

Queue <Integer> queue = new LinkedList<Integer>();

Stack<Integer> crushedCandies=new Stack<Integer>();

 

while(!stack.empty())

{

if(Grid1[(int)(stack.peek()/10)][stack.peek()%10][1]>10)

{

hash_Set.add(stack.pop());

}

else

{

score+=60;

crushedCandies.push((int)(stack.peek()/10)*10+stack.peek()%10);

Grid[(int)(stack.peek()/10)][stack.pop()%10][1]=0;

}

}

 

Iterator<Integer> it = hash_Set.iterator();

 

while(it.hasNext())

{

queue.add(it.next());

}

GridReturn gg = new GridReturn(Grid1,Grid,queue,crushedCandies,score);

return gg;

 

}

 

 

 

public GridReturn burstSpecialCandies(int Grid[][][],Queue <Integer> queue)

{

int Grid1[][][]=Grid;

int number=0;

long score=0;

Stack<Integer>crushedCandies = new Stack<Integer>();

//Horizontal burst

if(Grid1[(int)(queue.peek()/10)][queue.peek()%10][1]>10 && Grid1[(int)(queue.peek()/10)][queue.peek()%10][1]<20)

{

score+=1000;

for(int i=0;i<10;i++)

{

if(Grid1[i][queue.peek()%10][1]>10 && i!=(int)(queue.peek()/10) && !queue.contains(10*i+(queue.peek())%10))

{

queue.add(10*i+queue.peek()%10);

}

else

{

score+=60;

crushedCandies.push(i*10+queue.peek()%10);

Grid[i][queue.peek()%10][1]=0;

}

}

}

//Vertical burst

else if(Grid1[(int)(queue.peek()/10)][queue.peek()%10][1]>20 && Grid1[(int)(queue.peek()/10)][queue.peek()%10][1]<30)

{

score+=1000;

for(int j=0;j<10;j++)

{

if(Grid1[(int)(queue.peek()/10)][j][1]>10 && j!=queue.peek()%10 && !queue.contains((int)(queue.peek()/10)+j))

{

queue.add((int)(queue.peek()/10)*10+j);

}

else

{

score+=60;

crushedCandies.push((int)(queue.peek()/10)*10+j);

Grid[(int)(queue.peek()/10)][j][1]=0;

}

}

}

 

//Wrapped Candy burst

else if(Grid1[(int)(queue.peek()/10)][queue.peek()%10][1]>30 && Grid1[(int)(queue.peek()/10)][queue.peek()%10][1]<40)

{

score+=1500;

Grid1[(int)(queue.peek()/10)][queue.peek()%10][1]=0;   //Centre

 

if((int)(queue.peek()%10)>0)           

{

if(Grid1[(int)(queue.peek()/10)][queue.peek()%10-1][1]>10 && !queue.contains((int)(queue.peek()/10)*10+queue.peek()%10-1))

{

queue.add((int)(queue.peek()/10)*10+queue.peek()%10-1);

}

else

{

score+=60;

Grid1[(int)(queue.peek()/10)][queue.peek()%10-1][1]=0;      //Left

}

}

 

if((int)(queue.peek()%10)<9)          

{

if(Grid1[(int)(queue.peek()/10)][queue.peek()%10+1][1]>10 && !queue.contains((int)(queue.peek()/10)*10+queue.peek()%10+1))

{

queue.add((int)(queue.peek()/10)*10+queue.peek()%10+1);

}

else

{

score+=60;

Grid1[(int)(queue.peek()/10)][queue.peek()%10+1][1]=0;      //Right

}

}

 

if((int)(queue.peek()/10)>0)

{

if(Grid1[(int)(queue.peek()/10-1)][queue.peek()%10][1]>10 && !queue.contains((int)(queue.peek()/10-1)*10+queue.peek()%10))           

{

queue.add((int)(queue.peek()/10-1)*10+queue.peek()%10);

}

else

{

score+=60;

Grid1[(int)(queue.peek()/10)-1][queue.peek()%10][1]=0;      //Top

}

if((int)(queue.peek()%10)>0)

{

if(Grid1[(int)(queue.peek()/10)-1][queue.peek()%10-1][1]>10 && !queue.contains((int)(queue.peek()/10-1)*10+queue.peek()%10-1))

{

queue.add((int)(queue.peek()/10-1)*10+queue.peek()%10-1);

}

else

{

score+=60;

Grid1[(int)(queue.peek()/10-1)][queue.peek()%10-1][1]=0;      //Top Left

}

}

if((int)(queue.peek()%10)<9)

{

if(Grid1[(int)(queue.peek()/10)-1][queue.peek()%10+1][1]>10 && !queue.contains((int)(queue.peek()/10-1)*10+queue.peek()%10+1))

{

queue.add((int)(queue.peek()/10-1)*10+queue.peek()%10+1);

}

else

{

score+=60;

Grid1[(int)(queue.peek()/10-1)][queue.peek()%10+1][1]=0;      //Top Right 

}

}

}

if((int)(queue.peek()/10)<9)

{

if(Grid1[(int)(queue.peek()/10+1)][queue.peek()%10][1]>10 && !queue.contains((int)(queue.peek()/10+1)*10+queue.peek()%10))

{

queue.add((int)(queue.peek()/10+1)*10+queue.peek()%10);

}

else

{

score+=60;

Grid1[(int)(queue.peek()/10+1)][queue.peek()%10][1]=0;      //Bottom

}

if((int)(queue.peek()%10)>0)

{

if(Grid1[(int)(queue.peek()/10)+1][queue.peek()%10-1][1]>10 && !queue.contains((int)(queue.peek()/10+1)*10+queue.peek()%10-1))

{

queue.add((int)(queue.peek()/10+1)*10+queue.peek()%10-1);

}

else

{

score+=60;

Grid1[(int)(queue.peek()/10)+1][queue.peek()%10-1][1]=0;      //Bottom Left

}

}

if((int)(queue.peek()%10)<9)

{

if(Grid1[(int)(queue.peek()/10)+1][queue.peek()%10+1][1]>10 && !queue.contains((int)(queue.peek()/10+1)*10+queue.peek()%10+1))

{

queue.add((int)(queue.peek()/10+1)*10+queue.peek()%10+1);

}

else

{

score+=60;

Grid1[(int)(queue.peek()/10)+1][queue.peek()%10+1][1]=0;     //Bottom Right

}

}

}

}

 

//Color bomb burst

else if(Grid1[(int)(queue.peek()/10)][queue.peek()%10][1]==40)

{

int count,maxx=0;

score+=3000;

Grid1[(int)(queue.peek()/10)][queue.peek()%10][1]=0;

for(int k=1;k<=6;k++)

{

count=0;

for(int i=0;i<10;i++)

{

for(int j=0;j<10;j++)

{

if(Grid1[i][j][1]%10==k)

{

count++;

}

}

}

if(count>maxx)

{

maxx=count;

number=k;

}

 

}

 

if(maxx!=0)

{

int a=number;

for(int i=0;i<10;i++)

{

for(int j=0;j<10;j++)

{

if(Grid1[i][j][1]%10==a)

{

if(Grid1[i][j][1]>10)

{

queue.add(10*i+j);

}

else

{

score+=60;

crushedCandies.push(i*10+j);

Grid1[i][j][1]=0;

}

}

}

}

}

else

{

int a=(int)(Math.random()*1150)%6+1;

for(int i=0;i<10;i++)

{

for(int j=0;j<10;j++)

{

if(Grid1[i][j][1]%10==a)

{

if(Grid1[i][j][1]>10)

{

queue.add(10*i+j);

}

else

{

score+=60;

crushedCandies.push(i*10+j);

Grid1[i][j][1]=0;

}

}

}

}

}

}

 

 

queue.remove();

 

GridReturn gg = new GridReturn(Grid1,Grid,queue,crushedCandies,score);

return gg;

}

 

public boolean checkUsefullness(int Grid[][][])

{

int i,j;

for(i=0;i<10;i++)

{

for(j=0;j<10;j++)

{

if(i<8 && Grid[i][j][0]!=0 && Grid[i+1][j][0]!=0 && Grid[i+2][j][0]!=0  && Grid[i][j][1]!=40 && Grid[i][j][1]%10==Grid[i+1][j][1]%10 && Grid[i][j][1]%10==Grid[i+2][j][1]%10)

{

return true;

}

if(j<8 && Grid[i][j][0]!=0 && Grid[i][j+1][0]!=0 && Grid[i][j+2][0]!=0 && Grid[i][j][1]!=40 && Grid[i][j][1]%10==Grid[i][j+1][1]%10 && Grid[i][j][1]%10==Grid[i][j+2][1]%10)

{

return true;

}

}

}

return false;

}

 

}

 

 

class Timer extends Thread

{

int time=59;

boolean play=false;

public void run()

{

while(true)

{

try

{

Thread.sleep(1000);

}

catch(InterruptedException e)

{

e.printStackTrace();

}

if(play)

{
if(time>0)
{
time--;
}
}

}

}

public void haltTime()

{

play=false;

}

public void resumeTime()

{

play=true;

}

public int getTime()

{

return time;

}

}

 

public class CandyCrush extends Applet implements Runnable,MouseListener,MouseMotionListener,ActionListener

{

int ll=0;
int Grid[][][],Grid1[][][];

int gamePhase=0;

int gameStatus=0;

int gameStage=0;

int score=0;

int step=0,temp=0,counter=0;

int screenWidth=500,screenHeight=800;

int xpos,ypos,xpos1,ypos1;

int candyCrushState=0;

boolean mouseRelease=false;

boolean crushCandies=false;

GameDatabase gameDatabase=new GameDatabase();

CandyCrusher candyCrusher=new CandyCrusher();

GridReturn gridreturn;

GridReturn gg;

Timer timer = new Timer();
Font myFont = new Font("Harlow Solid Italic", Font.BOLD | Font.ITALIC ,40);  
  AudioClip audio, audio2;
  Image pic;
  int p=0;
 

@Override

public void init()

{
audio=getAudioClip(getDocumentBase(),"Candy Crush Saga Theme - The Saga Begins.wav");
	audio2=getAudioClip(getDocumentBase(),"button click.wav");
    pic=getImage(getDocumentBase(),"theme.jpg");

addMouseListener(this);

addMouseMotionListener(this);

}

 

@Override

public void start()

{

Thread thread = new Thread(this);

thread.start();
audio.loop();
}

 

@Override

public void stop()

{

 

}

 

@Override

public void destroy()

{

 

}

 

 

 

 

 

 

@Override

public void paint(Graphics g)
{

int typeOfCandiestoConstruct[]={1,2,3,4,5,6};

g.setColor(Color.black);
g.setFont(myFont);
g.drawString(String.valueOf(timer.getTime()),500,700);

g.drawString("Kandy KKrush",100,40);


if(gameStatus<5)

{

Grid=gameDatabase.getGrid();

Color c1 = new Color(50,50,50);

setBackground(c1);

}

else if(gameStatus<16)

{

gridreturn=candyCrusher.fillEmptySpaces(g,Grid,typeOfCandiestoConstruct,6);

Grid=gridreturn.getNewGrid();

candyCrusher.displayGrid(g,gridreturn.getOldGrid(),Grid,0);

}

else if(mouseRelease)

{

g.setColor(Color.red);

g.fillRect(250,250,50,50);

Grid=candyCrusher.exchangeCandies(g,Grid,xpos,ypos,xpos1,ypos1);

candyCrusher.displayGrid(g,gridreturn.getOldGrid(),Grid,0);

mouseRelease=false;

}


}

 

public void update(Graphics g)

{

int typeOfCandiestoConstruct[]={1,2,3,4,5,6,1,12,13,14,15,16,1,22,23,24,25,6,26,1,32,33,34,35,36,40,1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6,40},totalCandies=115,tt=0;

Color c12=new Color(50,50,50);
Color c22 =new Color(50,50,50);
g.setColor(c22);
setBackground(c12);

g.fillRect(250,600,200,200);
g.setColor(Color.black);


g.setFont(myFont);
g.drawString("Time:- "+String.valueOf(timer.getTime()),280,750);





if(gameStage==0)

{

Grid=gameDatabase.getGrid();

Color c1 = new Color(50,50,50);

//setBackground(c1);




g.setColor(c22);



g.fillRect(250,600,200,200);
g.setColor(Color.black);


g.setFont(myFont);
g.drawString("Time:- "+String.valueOf(timer.getTime()),280,750);





}

if(gameStage==1)

{

timer.resumeTime();

gridreturn=candyCrusher.fillEmptySpaces(g,Grid,typeOfCandiestoConstruct,totalCandies);

Grid=gridreturn.getNewGrid();

candyCrusher.displayGrid(g,gridreturn.getOldGrid(),Grid,0);



g.fillRect(250,600,200,200);







g.setColor(c22);



g.fillRect(250,600,200,200);
g.setColor(Color.black);


g.setFont(myFont);
g.drawString("Time:- "+String.valueOf(timer.getTime()),280,750);


}

 

 

if(gameStage==2)

{

if(step==0)

{

timer.resumeTime();

g.setColor(c22);



g.fillRect(250,600,200,200);
g.setColor(Color.black);


g.setFont(myFont);
g.drawString("Time:- "+String.valueOf(timer.getTime()),280,750);


if(mouseRelease)

{

mouseRelease=false;

step=1;

}

else

{

step=0;

}

g.setColor(c12);



g.setColor(c22);



g.fillRect(250,600,200,200);
g.setColor(Color.black);


g.setFont(myFont);
g.drawString("Time:- "+String.valueOf(timer.getTime()),280,750);





}

else if(step==1)

{

timer.resumeTime();

Grid1=candyCrusher.exchangeCandies(g,Grid,xpos,ypos,xpos1,ypos1);

candyCrusher.displayGrid(g,Grid,Grid1,0);

Grid=Grid1;

g.setColor(c22);



g.fillRect(250,600,200,200);
g.setColor(Color.black);


g.setFont(myFont);
g.drawString("Time:- "+String.valueOf(timer.getTime()),280,750);




if(temp==0)

{

step=2;

}

else

{

temp=0;

step=0;

}


}

else if(step==2)

{

timer.resumeTime();

if(candyCrusher.checkUsefullness(Grid))

{

step=3;

}

else

{

temp=1;

step=1;

}

g.setColor(c22);


g.fillRect(250,600,200,200);
g.setColor(Color.black);


g.setFont(myFont);
g.drawString("Time:- "+String.valueOf(timer.getTime()),280,750);




}

 

 

else if(step==3)

{

timer.haltTime();

gridreturn = candyCrusher.performCandyCrush(g, Grid);

candyCrusher.displayGrid(g, gridreturn.getNewGrid(),Grid,0);

Grid=gridreturn.getNewGrid();

score+=gridreturn.getScore();

g.setColor(c12);

g.fillRect(0,600,900,200);

g.setColor(Color.black);
g.drawString("Score:- ",0,650);

g.drawString(String.valueOf(score),0,700);

step=4;




g.setColor(c22);



g.fillRect(150,600,200,200);
g.setColor(Color.black);


g.setFont(myFont);
g.drawString("Time:- "+String.valueOf(timer.getTime()),280,750);




}

 

else if(step==4)

{

timer.haltTime();

if(gridreturn.getSpecialCandies().size()!=0)

{

gridreturn=candyCrusher.burstSpecialCandies(gridreturn.getNewGrid(),gridreturn.getSpecialCandies());

candyCrusher.displayGrid(g, gridreturn.getNewGrid(), Grid,0);

Grid=gridreturn.getNewGrid();

score+=gridreturn.getScore();

g.setColor(c12);

g.fillRect(0,600,900,200);

g.setColor(Color.black);
g.drawString("Score:- ",0,650);

g.drawString(String.valueOf(score),0,700);

step=4;

g.setColor(c22);



g.fillRect(250,600,200,200);
g.setColor(Color.black);


g.setFont(myFont);
g.drawString("Time:- "+String.valueOf(timer.getTime()),280,750);



}

else

{

step=5;

}



}

 

else if(step==5)

{

counter++;

timer.haltTime();

if(counter<=15)

{

gridreturn=candyCrusher.fillEmptySpaces(g,gridreturn.getNewGrid(),typeOfCandiestoConstruct,totalCandies);

candyCrusher.displayGrid(g, gridreturn.getNewGrid(), Grid,0);

Grid=gridreturn.getNewGrid();

step=5;

}

else

{

counter=0;

step=6;

}


g.setColor(c22);



g.fillRect(250,600,200,200);
g.setColor(Color.black);


g.setFont(myFont);
g.drawString("Time:- "+String.valueOf(timer.getTime()),280,750);




}

 

else if(step==6)

{

timer.haltTime();



g.setColor(c22);



g.fillRect(250,600,200,200);
g.setColor(Color.black);


g.setFont(myFont);
g.drawString("Time:- "+String.valueOf(timer.getTime()),280,750);



if(candyCrusher.checkUsefullness(Grid))

{

step=3;

}

else

{

step=0;

mouseRelease=false;

}

}

}

 

 

 



 

 

 
if(gameStage==100)
{
String a;
if(score>=1000000)
{
a="You Won";
}
else
{
a="You Lost";
}
Font myFont1 = new Font("Harlow Solid Italic", Font.BOLD | Font.ITALIC ,80);  
g.setColor(Color.black);
g.setFont(myFont1);
g.drawString("Game Over ",80,400);
g.drawString(a,80,500);
audio.stop();
}
 

 

 

 

}

 

 

 

@Override

public void run()

{



gamePhase=0;
while(true)
{





timer.start();

repaint();

 

for(int i=0;i<15;i++)

{

gameStage=1;

repaint();

try

{

Thread.sleep(100);

}

catch(InterruptedException e)

{

e.printStackTrace();

}


}

gameStage=2;

step=3;

while(true)

{

 

 

repaint();
if(timer.getTime()==0)
{
break;
}

try

{

Thread.sleep(50);

}

catch(InterruptedException e)

{

e.printStackTrace();

}

 

}
if(timer.getTime()==0)
{
gameStage=100;
repaint();

break;
}


}

}

 



 

 

 

 

 

 

@Override

public void mouseDragged(MouseEvent e)

{

 

 

 

}

 

@Override

public void mouseMoved(MouseEvent e)

{

 

}

 

 

 

@Override

public void mouseClicked(MouseEvent e) {



      

}

 

@Override

public void mousePressed(MouseEvent e) {



    xpos1=e.getX();

    ypos1=e.getY();

    mouseRelease=false;

 

      

}

 

@Override

public void mouseReleased(MouseEvent e) {

    xpos=e.getX();

    ypos=e.getY();

    mouseRelease=true;

}

 

@Override

public void mouseEntered(MouseEvent e) {

      

}

 

@Override

public void mouseExited(MouseEvent e) {
   

}

  
public void actionPerformed(ActionEvent e)
{



}
 

}

