import socket
import os

i = 1
while(i <= 255) :
    id = socket.gethostbyaddr("192.168.1.{}".format(i))

    if id[0] == "espressif":
        os.system('ngrok http http://192.168.1.{} -host-header="http:192.168.1.{}"'.format(i, i))
        break
    i += 1