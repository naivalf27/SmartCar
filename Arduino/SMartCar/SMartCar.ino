// include the library code:
#include <Servo.h>
 
Servo myservo;  // create servo object to control a servo 
                // a maximum of eight servo objects can be created 
 
int pos = 65;    // variable to store the servo position
int delta = 1;

//int PINSW = 10;
int PINDIR = 5;

int BPWM = 11;
int BDIR = 13;

int APWM = 3;
int ADIR = 12;

int vitesse = 100;
int nbCycle = 0;
int distance;
int filterDist[5];
int indxDist = 6;
int moyDist;
int minDist;
int prevGo = 0;

int extremLeft = 60;
int extremRight = 105;

char recd_dat;

void setup() {
  Serial.begin(9600);
  	
  //pinMode(APWM,OUTPUT);
  //pinMode(BPWM,OUTPUT);
  //pinMode(ADIR,OUTPUT);
  //pinMode(BDIR,OUTPUT);
  
  //pinMode(PINSW,INPUT);
  
  //myservo.attach(5);  // attaches the servo on pin 5 to the servo object 
  //Stop();
  //nbCycle = 0;
  
}

void loop() {
  if( Serial.available() ) {
    recd_dat = Serial.read();
    Serial.println(recd_dat);
  }
  delay(150);
  
//int go = 0;

//  minDistance();
  //go = digitalRead(PINSW);
  
//  goBackward(vitesse);
//  turn(50);
  
//  //oscillateDir();
//  if (prevGo == HIGH && nbCycle > 25)
//  {
//	
//	
//	Serial.print("-------------");
//    Serial.println(minDist);
//    if (minDist < 29)
//    {
//      //myservo.write(75);
//      goBackward(vitesse);
//    }
//    else
//    {
//      goForward(vitesse + 10);
//    }
//    nbCycle = 0;
//    minDist = 200;
//	  
//  }
//  nbCycle++;


//  delay(20);
}

/////////////////////////////////////////////////////////

int meanDistance()
{
  distance = analogRead(A1);
  
  if (indxDist <=4)
  {
    filterDist[indxDist] = distance;
    indxDist++;
  }
  else
  {
    filterDist[0] = distance;
    indxDist = 1;
  }
  
  moyDist = 0;
  for (int i=0; i<5; i++)
  {
     moyDist += filterDist[i];
  }
  moyDist = moyDist/5;
}

// -------------------------------------------------
int minDistance()
{
  distance = analogRead(A1);
  
  if (distance < minDist)
  {
    minDist = distance;
  }
}

// ---------------------------------------------------
void turn(int angle){
  int prctMax = extremRight - extremLeft;
  int res = (prctMax * angle / 100) + extremLeft;
   Serial.println(res);
   myservo.write(res); 
}
// ---------------------------------------------------
void oscillateDir()
{
  myservo.write(pos);              // tell servo to go to position in variable 'pos' 
  pos += delta;
  if ( pos > 105)  // goes from 0 degrees to 180 degrees 
  {                                  // in steps of 1 degree 
    delta = -1;
  } 
  if (pos < 65)     // goes from 180 degrees to 0 degrees 
  {                                
    delta = 1;
  }
}

// ---------------------------------------------------
void Stop()
{
  analogWrite(APWM, 0);
  analogWrite(BPWM, 0);
}

// ---------------------------------------------------
void goForward(int speed)
{
  digitalWrite(ADIR, 1);
  analogWrite(APWM, speed);
  digitalWrite(BDIR, 0);
  analogWrite(BPWM, speed); 
}

// ---------------------------------------------------
void goBackward(int speed)
{
  digitalWrite(ADIR, 0);
  analogWrite(APWM, speed);
  digitalWrite(BDIR, 1);
  analogWrite(BPWM, speed); 
}

