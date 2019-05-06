import numpy as np
import matplotlib.pyplot as plt
# def mandelbrot( h,w, maxit=20 ):
#     y, x = np.ogrid[-1.4:1.4:h * 1j, -2:0.8:w * 1j]
#     c = x + y * 1j
#     z = c
#     divtime = maxit + np.zeros(z.shape, dtype=int)
#     for i in range(maxit):
#         z = z ** 2 + c
#         diverge = z * np.conj(z) > 2 ** 2
#         div_now = diverge & (divtime == maxit)
#         divtime[div_now] = i
#         z[diverge] = 2
#     return divtime
# plt.imshow(mandelbrot(400,400))
# plt.show()


# palette = np.array([[0,0,0],[255,0,0],[0,255,0],[0,0,255],[255,255,255]])
# image = np.array([[0,1,2,0],[0,3,4,0]])
# print(palette[image])

# a= np.arange(12).reshape(3,4)
# b1 = np.array([False,True,True])
# b2 = np.array([True,False,False,False])
# print(a)
# print("------------")
# print(a[b1,b2])

# mu, sigma = 2, 1
# v = np.random.normal(mu,sigma,10000)
# plt.hist(v, bins=50, normed=1)
# plt.show()

x= np.float32(10)
print(x)