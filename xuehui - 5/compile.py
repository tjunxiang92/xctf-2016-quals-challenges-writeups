import os

list = [4, 6, 15, 1, 5, 18, 13, 3, 8, 10, 14, 12, 16, 2, 17, 0, 19, 9, 11, 7]
print os.listdir('.')

for i in list:
	filename = "php[%d].zip" % (i)
	f = open(filename, 'rb')
	fa = open('sum.zip', 'ab')
	fa.write(f.read())
	f.close()
	fa.close()