import tensorflow as tf

a= tf.constant(3.0,dtype=tf.float32,name="data1")
b= tf.constant(4.0,name="data2")
total = tf.add(a,b,name="total")
multiply = tf.multiply(total,a,name="multiply")
print(a)
print(b)
print(total)
sess = tf.Session()
wright = tf.summary.FileWriter('cc/',sess.graph)
print(sess.run(multiply))
wright.close()


