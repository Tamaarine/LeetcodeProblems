Trial 1
I think for this one you can map each of the nodes into say an array/list
and because k can be an arbitrary number, we only rotate k % mod len(list) times.

because if we have 3 elements, rotating it 2 times is the same as rotating it 5 times. 

Scratch that, this method is inefficient, better way to do it is using two pointers.

One pointer that points to the start of the list
The other point to the start of the gathering point
And then just increment the gathering point one until you have gotten all the elements 