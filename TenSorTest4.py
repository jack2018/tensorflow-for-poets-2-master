import tensorflow as tf
state=tf.Variable(10)
one=tf.constant(1)
new_value=tf.add(state,one)
updata=tf.assign(state,new_value)
init=tf.global_variables_initializer()
with tf.Session() as sess:
  sess.run(init)
  for o in range(4):
    print("new_value:"+str(sess.run(state))+"--"+str(sess.run(new_value)))
    print(sess.run(updata))
