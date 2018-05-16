float x=0;
float xpos;
float ypos;

int rwidth=600;
int rheight=40;

float xspeed=3;
float yspeed=2.5;

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
color c;

void setup(){
  background(0);
  fullScreen();
  //size(1280,750);
  frameRate(10);
  xpos=random(0,600);
  ypos=random(0,600);
    r=random(0,225);
    g=random(0,225);
    b=random(0,225);
    int xindex=int (random(dir.length));
    xdir=dir[xindex];
    int yindex=int (random(dir.length));
    ydir=dir[yindex];
    noCursor();
}
void draw(){
  background(0);
  
  if (xpos >= width-rwidth||xpos <= 0) {
    xdir *= -1;
    x=0;
    percentage=0.0;
    r=random(0,225);
    g=random(0,225);
    b=random(0,225);
    c=color (r,g,b);
    
  }
  if (ypos >= height-rheight||ypos <= 0) {
    ydir *= -1;
    x=0;
    percentage=0.0;
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
  
  //第四象限方向
  if(xdir>0&&ydir>0){
    disx=width-xpos-rwidth;
    disy=height-ypos-rheight;
    tx=disx/xspeed;
    ty=disy/yspeed;
    if(tx<ty){
      vrx=xspeed*0.7;     
    }
    else{
      vrx=yspeed*0.7;      
    }
    if(x<rwidth){
      x+=vrx;
    }
    if(percentage>=100.0){
      percentage=100;
    }
    else{
      percentage=100*(x/rwidth);
    }
    fill(r,g,b);
    strokeWeight(2);
    rect(xpos,ypos,x,rheight);
  }
  //第一象限方向
  if(xdir>0&&ydir<0){
    disx=width-xpos-rwidth;
    disy=ypos;
    tx=disx/xspeed;
    ty=disy/yspeed;
    if(tx<ty){
      vrx=xspeed*0.7;      
    }
    else{
      vrx=yspeed*0.7;      
    }
    if(x<rwidth){
      x+=vrx;
    }
    if(percentage>=100.0){
      percentage=100;
    }
    else{
      percentage=100*(x/rwidth);
    }
    fill(r,g,b);
    strokeWeight(2);
    rect(xpos,ypos,x,rheight);
  }
  //第三象限方向  
  if(xdir<0&&ydir>0){
    disx=xpos;
    disy=height-ypos-rheight;
    tx=disx/xspeed;
    ty=disy/yspeed;
    if(tx<ty){
      vrx=xspeed*0.7;      
    }
    else{
      vrx=yspeed*0.7;      
    }
    if(x<rwidth){
      x+=vrx;
    }
    if(percentage>=100.0){
      percentage=100;
    }
    else{
      percentage=100*(x/rwidth);
    }
    fill(r,g,b);
    strokeWeight(2);
    rect(xpos+rwidth,ypos,-x,rheight);
  }
  //第二象限方向
  if(xdir<0&&ydir<0){
    disx=xpos;
    disy=ypos;
    tx=disx/xspeed;
    ty=disy/yspeed;
    if(tx<ty){
      vrx=xspeed*0.7;     
    }
    else{
      vrx=yspeed*0.7;     
    }
    if(x<rwidth){
      x+=vrx;
    }
    if(percentage>=100.0){
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
void mouseMoved(){
  moving++;
}