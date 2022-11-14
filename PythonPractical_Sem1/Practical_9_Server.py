import time, socket

print("\nWelcome to Chat Room\n")
print("Initialising...\n")
time.sleep(1)

s = socket.socket()
ip = '127.0.0.1'
port = 1234
s.bind((ip,port))
print("(",ip,")\n")
name = input(str("Enter Your Name: "))

s.listen(1)
print("\nWaiting for Incoming Connections...\n")
conn, addr = s.accept()
print("Received Connection from ", addr[0], "(", addr[1], ")\n")

s_name = conn.recv(1024)
s_name = s_name.decode()
print(s_name, "has connected to the chat room\nEnter [e] to exit chat room\n")
conn.send(name.encode())

while True:
    message = input(str("Me : "))
    if message == "[e]":
        message = "Left chat room!"
        conn.send(message.encode())
        print("\n")
        break
    conn.send(message.encode())
    message = conn.recv(1024)
    message = message.decode()
    print(s_name, ":", message)