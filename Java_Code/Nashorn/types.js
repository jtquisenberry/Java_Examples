var query = "contains-text:1"
//var items = currentCase.search(query)

// Declare types.
// http://winterbe.com/posts/2014/04/05/java8-nashorn-tutorial/
var ByteArrayOutputStream = Java.type("java.io.ByteArrayOutputStream");
var ObjectOutputStream = Java.type("java.io.ObjectOutputStream")
var ByteArray = Java.type("byte[]");

var bos = new ByteArrayOutputStream();
var out = new ObjectOutputStream(bos);
out.writeObject(query);
out.flush()
var myBytes = bos.toByteArray();
print(myBytes.length);
