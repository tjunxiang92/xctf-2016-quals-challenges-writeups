from PIL import Image
import zlib, struct


image_old = Image.open("hello.png")
pix_old = image_old.load()

i=0
str = ""
for x in range(image_old.size[0]):
	for y in range(image_old.size[1]):
		if x == 0:
			str = str + chr(pix_old[x,y][2] ^ 36)

print str