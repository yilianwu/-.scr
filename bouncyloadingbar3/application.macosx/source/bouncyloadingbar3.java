import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class bouncyloadingbar3 extends PApplet {

float x=0;
float xpos;
float ypos;

int rwidth=600;
int rheight=40;

float xspeed=3;
float yspeed=2.5f;

int [] dir={-1,1};
int xdir;
int ydir;

float disx;
float disy;
float tx;
float ty;

float disrx=xpos+rwidth-2;
float trx;
float vrx=disrx/trx;

float percentage=0;

float moving;

float r;
float g;
float b;
int c;

public void setup(){
  background(0);
  
  //size(1280,750);
  frameRate(10);
  xpos=random(0,600);
  ypos=random(0,600);
    r=random(0,225);
    g=random(0,225);
    b=random(0,225);
    int xindex=PApplet.parseInt (random(dir.length));
    xdir=dir[xindex];
    int yindex=PApplet.parseInt (random(dir.length));
    ydir=dir[yindex];
    noCursor();
}
public void draw(){
  background(0);
  
  if (xpos >= width-rwidth||xpos <= 0) {
    xdir *= -1;
    x=0;
    percentage=0.0f;
    r=random(0,225);
    g=random(0,225);
    b=random(0,225);
    c=color (r,g,b);
    
  }
  if (ypos >= height-rheight||ypos <= 0) {
    ydir *= -1;
    x=0;
    percentage=0.0f;
    r=random(0,225);
    g=random(0,225);
    b=random(0,225);  
  }
 
  xpos+=xspeed*xdir;
  ypos+=yspeed*ydir;
  noFill();
  stroke(r,g,b);
  strokeWeight(2);
  rect(xpos,ypos,rwidth,rheight);
  
  //\u7b2c\u56db\u8c61\u9650\u65b9\u5411
  if(xdir>0&&ydir>0){
    disx=width-xpos-rwidth;
    disy=height-ypos-rheight;
    tx=disx/xspeed;
    ty=disy/yspeed;
    if(tx<ty){
      vrx=xspeed*0.7f;     
    }
    else{
      vrx=yspeed*0.7f;      
    }
    if(x<rwidth){
      x+=vrx;
    }
    if(percentage>=100.0f){
      percentage=100;
    }
    else{
      percentage=100*(x/rwidth);
    }
    fill(r,g,b);
    strokeWeight(2);
    rect(xpos,ypos,x,rheight);
  }
  //\u7b2c\u4e00\u8c61\u9650\u65b9\u5411
  if(xdir>0&&ydir<0){
    disx=width-xpos-rwidth;
    disy=ypos;
    tx=disx/xspeed;
    ty=disy/yspeed;
    if(tx<ty){
      vrx=xspeed*0.7f;      
    }
    else{
      vrx=yspeed*0.7f;      
    }
    if(x<rwidth){
      x+=vrx;
    }
    if(percentage>=100.0f){
      percentage=100;
    }
    else{
      percentage=100*(x/rwidth);
    }
    fill(r,g,b);
    strokeWeight(2);
    rect(xpos,ypos,x,rheight);
  }
  //\u7b2c\u4e09\u8c61\u9650\u65b9\u5411  
  if(xdir<0&&ydir>0){
    disx=xpos;
    disy=height-ypos-rheight;
    tx=disx/xspeed;
    ty=disy/yspeed;
    if(tx<ty){
      vrx=xspeed*0.7f;      
    }
    else{
      vrx=yspeed*0.7f;      
    }
    if(x<rwidth){
      x+=vrx;
    }
    if(percentage>=100.0f){
      percentage=100;
    }
    else{
      percentage=100*(x/rwidth);
    }
    fill(r,g,b);
    strokeWeight(2);
    rect(xpos+rwidth,ypos,-x,rheight);
  }
  //\u7b2c\u4e8c\u8c61\u9650\u65b9\u5411
  if(xdir<0&&ydir<0){
    disx=xpos;
    disy=ypos;
    tx=disx/xspeed;
    ty=disy/yspeed;
    if(tx<ty){
      vrx=xspeed*0.7f;     
    }
    else{
      vrx=yspeed*0.7f;     
    }
    if(x<rwidth){
      x+=vrx;
    }
    if(percentage>=100.0f){
      percentage=100;
    }
    else{
      percentage=100*(x/rwidth);
    }
    fill(r,g,b);
    strokeWeight(2);
    rect(xpos+rwidth,ypos,-x,rheight);
  }
  
  textAlign(CENTER);
    textSize(121);
    fill(0);
    text(str(percentage)+"%",width/2,height/2);
    textSize(120);
    fill(r,g,b);
    text(str(percentage)+"%",width/2,height/2);
  
  if(moving>1){
    exit();
  }
  else{
    moving=0;
  }
  
}
public void mouseMoved(){
  moving++;
}
  public void settings() {  fullScreen(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#080808", "--stop-color=#cccccc", "bouncyloadingbar3" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
