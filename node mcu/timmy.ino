#include <ESP8266WiFi.h>
#include <ESP8266mDNS.h>
#include <ESP8266WebServer.h>

//wifi name and password
const char* ssid = "grace";
const char* password = "gracious";

//access name and password
const char* www_username = "admin";
const char* www_password = "esp8266";

//led
uint8_t pin_led = BUILTIN_LED;
String webPage = "";


//initiate server
ESP8266WebServer server(80);
void setup() {
  //html page
  webPage += "<html>";
  webPage += "  <body>";
  webPage += "    <h1>Smart Switching<h1> &nbsp; <a href=\"led_on\"><button>ON</button></a>&nbsp";
  webPage += "    <a href=\"led_off\"><button>OFF</button></a>";
  webPage += "    <p>by team LABT</p>";
  webPage += "  <style>";
  webPage += "    body {text-align : center; font-family: arial; background-color: white;}";
  webPage += "    h1 { font-size : 50; font-weight : bold; color : #1B5E20} p{ font-size : 10px; color : black}";
  webPage += "    button {background-color: #4CAF50; color: white; border : none; padding :15px 32px; text-align: center; text-decoration : none; display : inline-block; font-size: 20px; margin: 4px 2px; cursor:pointer;}";  
  webPage += "  </style>";
  webPage += "</body>";
  webPage += "</html>";

  //set pin
  pinMode(pin_led, OUTPUT);
  //serial communication
  Serial.begin(9600);

  //Station mode
  WiFi.mode(WIFI_STA);
  //Initial WiFi
  WiFi.begin(ssid, password);
  if(WiFi.waitForConnectResult() != WL_CONNECTED) {
    Serial.println("WiFi Connect Failed! Rebooting...");
    delay(1000);
    ESP.restart();
  }

  //server coding (node js inspired)
  server.on("/", [](){
    //restricting access
    if(!server.authenticate(www_username, www_password))
      return server.requestAuthentication();
    server.send(200, "text/html", webPage);
  });
  //turn led on
  server.on("/led_on", [](){
    server.send(200, "text/html", webPage);
    digitalWrite(pin_led, LOW);
    delay(100);
  });
  //turn led off
  server.on("/led_off", [](){
    server.send(200, "text/html", webPage);
    digitalWrite(pin_led, HIGH);
    delay(100);
  });
  //Initiate Server
  server.begin();

  //IP Address
  Serial.print("Open http://");
  Serial.print(WiFi.localIP());
  Serial.println("/ in your browser");
}

void loop() {
  server.handleClient();
}
