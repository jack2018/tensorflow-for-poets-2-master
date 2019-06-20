import tensorflow as tf
# 线性函数
x = tf.constant([[1], [2], [3], [4]], dtype=tf.float32)
y_true = tf.constant([[3], [6], [9], [12]], dtype=tf.float32)
linear_nodel = tf.layers.Dense(units=1)
y_pred = linear_nodel(x)

loss = tf.losses.mean_squared_error(labels=y_true,predictions=y_pred)
optimizer = tf.train.GradientDescentOptimizer(0.01)
train = optimizer.minimize(loss)
init = tf.global_variables_initializer()
sess = tf.Session()
sess.run(init)
for i in range(1000):
    _,loss_value = sess.run((train,loss))
    print(loss_value)

print(sess.run(y_pred,feed_dict={x:[[5],[6],[7],[8]]}))



