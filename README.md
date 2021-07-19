# Smart Garden base esp32-cam IoT
This tool can monitor air humidity, soil temperature and air and can maintain plant conditions through a camera that is already on the camera, access the camera using the "ngrok" proxy server. and can be accessed through an Android application that is connected to the Google Firebase real-time database.

# Hardware 
- Esp32-cam
- Relay Module 5VDC 2 Channel
- Soil Moisture Sensor
- DHT 22 Sensor
- Solenoid Valve 220 VAC
- FTDI FT232R USB Interface
- PSU 5VDC 3A

# Datasheet
- (Esp32-cam) ![image](https://user-images.githubusercontent.com/50385294/126102808-d04f5480-8159-482f-88ca-9c91f25d2d59.png)
- https://www.tme.eu/Document/24f3427a9c2722c53c198fcd61cc5df0/MR009-004-1.pdf (Relay Module)
- https://www.tme.eu/Document/24f3427a9c2722c53c198fcd61cc5df0/MR009-004-1.pdf (Soil Sensor)
- https://www.sparkfun.com/datasheets/Sensors/Temperature/DHT22.pdf (DHT 22)
- (Solenoid Valve) ![image](https://user-images.githubusercontent.com/50385294/126102182-be719eb5-ce52-4f20-b377-71edfbe1393a.png) 
- https://www.sparkfun.com/datasheets/IC/FT232R_v104.pdf (FTDI FT232R)

# Software
- Arduino IDE
- Python 3.7.0
- Android Studio 
- Ngrox

# Database
- Google Firebase

# Documentation
- Circuit Connection
![image](https://user-images.githubusercontent.com/50385294/126102587-d1cac956-ff2b-4852-b57f-b6931abe7771.png)

- Data Log Sensor Firebase
![image](https://user-images.githubusercontent.com/50385294/126102652-538be7f5-58b0-4f69-a063-22c63762c573.png)

- Testing Device
![image](https://user-images.githubusercontent.com/50385294/126102693-7ba58fb1-3bf1-4339-8ec8-e6e9eb155621.png)
![pengujian data sensor pada serial monitor arduino ide](https://user-images.githubusercontent.com/50385294/126103061-b9d321f5-3c9d-473a-9b2c-f1f2f9601017.png)

- Layout App's Smart Garden
![Screenshot_20200611-102843](https://user-images.githubusercontent.com/50385294/126103146-278d2ae8-b366-4abb-882b-517f7bea89d0.png)
![Screenshot_20200611-102848](https://user-images.githubusercontent.com/50385294/126103150-d1f33a18-a539-4a49-95a7-fdb8e0d7ea82.png)
![WhatsApp Image 2020-06-24 at 22 13 48](https://user-images.githubusercontent.com/50385294/126103153-672f11d8-1a5c-449f-bad3-31f26051feae.jpeg)

- MockUp
![IMG_20200703_171233](https://user-images.githubusercontent.com/50385294/126103022-0850ff0c-fdea-4dd7-b342-ce723a398483.jpg)
![image](https://user-images.githubusercontent.com/50385294/126102716-fb36cbef-47d6-43b0-a869-3af20107182a.png)




