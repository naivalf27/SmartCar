// include the library code:
#include <Servo.h>
#include <SoftwareSerial.h>

SoftwareSerial btSerial(5, 10); // RX/TX pins
Servo myservo;  // create servo object to control a servo 
// a maximum of eight servo objects can be created 

int pinSensorLeft = 9;
int pinSensorRight = 6;

int pinSensorFace = A1;// ancien A1
int distanceRange = 60;


int pinServo = 5;
int extremLeft = 60;
int extremRight = 105;

int pinMotorLeftPower = 3;
int pinMotorLeftDirection = 12;
int pinMotorRightPower = 11;
int pinMotorRightDirection = 13;


void setup() {
  Serial.begin(9600);
  btSerial.begin(9600);

  initCapteurLateraux();
  initSensorDistance();
  initServo();
  initMotor();
  
}
void loop() {
  loopBluetooth();
  //loopCapteurLateraux();
  loopServo();
  //loopMotor();

  float prct = getSensorDistance();

  String s = "% = ";
  s += String(prct);

  Serial.println(s);

//  if (cm < 5) {
//    turn(100);
//    goBackward(70);
//  } else {
//    goForward(100);
//  }
  
}


// ---------------------MOTOR--------------------- \\

void initMotor(){
  pinMode(pinMotorLeftPower, OUTPUT);
  pinMode(pinMotorRightPower, OUTPUT);
  pinMode(pinMotorLeftDirection, OUTPUT);
  pinMode(pinMotorRightDirection, OUTPUT);

  stopMotor();
}

void loopMotor(){
  goForward(100);
}

void goForward(int speed)
{
  digitalWrite(pinMotorLeftDirection, 1);
  analogWrite(pinMotorLeftPower, speed);
  digitalWrite(pinMotorRightDirection, 0);
  analogWrite(pinMotorRightPower, speed); 
}

void stopMotor()
{
  analogWrite(pinMotorLeftPower, 0);
  analogWrite(pinMotorRightPower, 0);
}

void goBackward(int speed)
{
  digitalWrite(pinMotorLeftDirection, 0);
  analogWrite(pinMotorLeftPower, speed);
  digitalWrite(pinMotorRightDirection, 1);
  analogWrite(pinMotorRightPower, speed); 
}
// ------------------MOTOR SERVO------------------ \\
void loopServo(){
  turn(50);
}

void initServo(){
  myservo.attach(5);
}

void turn(int prct){ // 0% == left, 50% == face, 100% == right
  if (prct > 100){
    prct = 100;
  } else if (prct < 0) {
    prct = 0;
  }
  
  int valueMax = extremRight - extremLeft;
  int res = (prct * valueMax / 100) + extremLeft;
  myservo.write(res); 
}


// ---------------SENSOR DISTANCE--------------- \\
void initSensorDistance(){
  pinMode(A1, INPUT);
}

float getSensorDistance(){
  float sum = 0;
  for (int i = 0; i < distanceRange ; i++){
    float anVolt = analogRead(pinSensorFace);
    sum += anVolt;
    delay(10);
  }

  float min = 27.9;
  float max = 34.3;

  float inches = sum / distanceRange;

  float range = max - min;
  float prc = inches - min;

  prc = ((prc * 100) / range);
  sendMessage("front:"+String(prc));
  return prc;
}


// ----------------SENSOR LATERAUX---------------- \\
void loopCapteurLateraux(){
  int detectLeft = digitalRead(pinSensorLeft);
  int detectRight = digitalRead(pinSensorRight);

  if (detectLeft == LOW){
    Serial.println("LEFT :: OBSTACLE!!");
    sendMessage("left:1");
  }

  if (detectRight == LOW){
    Serial.println("RIGHT :: OBSTACLE!!");
    sendMessage("right:1");
  }
}

void initCapteurLateraux(){
  pinMode(pinSensorLeft, INPUT);
  pinMode(pinSensorRight, INPUT);
}


// --------------------BLUETOOTH-------------------- \\
void loopBluetooth(){
  String msg = getMessage();
    if(msg!=""){
      Serial.println(msg);
    }
 
    // Send the text you entered in the input field of the Serial Monitor to the HC-06
    if(Serial.available()){
      btSerial.write(Serial.read());
    }
}

void sendMessage(String msg){
  btSerial.println(msg);
}

String getMessage(){
  String msg = "";
  char a;
  
  while(btSerial.available()) {
    Serial.println("test");
      a = btSerial.read();
      btSerial.println(String(a));
      msg+=String(a);
  }
  return msg;
}

