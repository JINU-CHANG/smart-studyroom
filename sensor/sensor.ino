#include <WiFi.h>
#include <WiFiClient.h>
#include <WebServer.h>
#include <HTTPClient.h>
#include <ESPmDNS.h>

const char *ssid = "worksalonopen";
const char *password = "025344050";

WebServer server(80);

const int FORCE_SENSOR_PIN = 36;

void handleRoot() {
  String html = "<!DOCTYPE html><html><head><meta charset='UTF-8'><title>ESP32 Control</title></head><body>";
  html += "<h1>ESP32 Practice</h1>";
  html += "<button onclick=\"sendPing()\">Ping 서버</button>";
  html += "<p id='response'></p>";
  html += "<script>";
  html += "function sendPing() {";
  html += "  fetch('/pingtest').then(response => response.text()).then(data => {";
  html += "    document.getElementById('response').innerText = '서버 응답: ' + data;";
  html += "  }).catch(error => {";
  html += "    document.getElementById('response').innerText = '오류 발생: ' + error;";
  html += "  });";
  html += "}";
  html += "</script></body></html>";
  server.send(200, "text/html", html);
}

void handlePingTest() {
  HTTPClient http;

  const char* actualURL = "http://192.168.0.236:8080/ping";

  http.begin(actualURL);
  int httpCode = http.GET();
  if (httpCode == 200) {
    String payload = http.getString();
    server.send(200, "text/plain", payload);
  } else {
    String errorMsg = http.errorToString(httpCode).c_str();
    Serial.println(errorMsg);
    Serial.println("Failed");
  }
  http.end();
}

void setup() {
  Serial.begin(115200);

  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, password);
  Serial.print("Connecting to WiFi..");

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("\nConnected! IP address: ");
  Serial.println(WiFi.localIP());

  if (MDNS.begin("esp32")) {
    Serial.println("MDNS responder started");
  }

  server.on("/", handleRoot);
  server.on("/pingtest", handlePingTest);
  server.begin();
  Serial.println("HTTP server started");
}

void loop() {
  server.handleClient();
  sensorValue = analogRead(FORCE_SENSOR_PIN);

  delay(1000);
}
