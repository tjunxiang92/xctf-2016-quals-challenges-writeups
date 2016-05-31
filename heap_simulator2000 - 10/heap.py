import socket, sys, time
sa = ('128.199.75.22', 4243)
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
sock.connect(sa)
sleep_time = 1
def recv():
	global sock
	time.sleep(sleep_time)
	data = sock.recv(200000000)
	print data
	return data

def send(text):
	global sock
	time.sleep(sleep_time)
	sock.send(str(text.strip()) + '\n')

def process(text):
	send(text)
	print text
	return recv()

recv()
for i in range(2):
	send('1\n1\n' * 100)
	recv()

send('1\n1\n' * 17)
recv()
while True:
	a = raw_input()
	send(a)
	recv()

sock.close()
exit()
for i in range (50):
	send('1\n1\n')
	recv()

sock.close()
exit()
for i in range (5):
	process(3)
	process(4 - i)
	process("x" * 100)	

for i in range(5):
	process(2)
	process(4 - i)

exit()

process(1)
process(32)

#for i in range(10000, 16000, 1000):
process(3)
a = process(0)
process("x" * 1000)

process(2)
process(1)
process(2)
process(0)
sock.close()


