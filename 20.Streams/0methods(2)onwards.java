java.io.BufferedInputStream
BufferedInputStream(InputStream in):
	Creates a BufferedInputStream and saves its argument, the input stream in, for later use.
read():
	Reads the next byte of data from this input stream.

java.io.ByteArrayInputStream
ByteArrayInputStream(byte[] buf):
	Creates a ByteArrayInputStream so that it uses buf as its buffer array.
read():
	Reads the next byte of data from this input stream.

java.io.ByteArrayOutputStream
ByteArrayOutputStream():
	Creates a new byte array output stream.
write(int b):
	Writes the specified byte to this byte array output stream.
writeTo(OutputStream out):
	Writes the complete contents of this byte array output stream to the specified output stream argument.
toByteArray():
	Creates a newly allocated byte array. Its size is the current size of this output stream and the valid contents of the buffer have been copied into it.
toString():
	Converts the buffer's contents into a string decoding bytes using the platform's default character set.

java.io.DataInputStream
DataInputStream(InputStream in):
	Creates a DataInputStream that uses the specified underlying InputStream.
readLine():
	(Deprecated) Reads the next line of text from the input stream.
close():
	Closes this input stream and releases any system resources associated with the stream.

java.io.DataOutputStream
DataOutputStream(OutputStream out):
	Creates a new data output stream to write data to the specified underlying output stream.
writeInt(int v):
	Writes an int to the underlying output stream as four bytes, high byte first.
writeLong(long v):
	Writes a long to the underlying output stream as eight bytes, high byte first.
writeDouble(double v):
	Converts the double argument to a long using the doubleToLongBits method in class Double, and then writes that long value to the underlying output stream as an 8-byte quantity, high byte first.
writeBoolean(boolean v):
	Writes a boolean to the underlying output stream as a 1-byte value.
writeBytes(String s):
	Writes out the string to the underlying output stream as a sequence of bytes.
writeChars(String s):
	Writes a string to the underlying output stream as a sequence of characters.
writeUTF(String str):
	Writes a string to the underlying output stream using modified UTF-8 encoding.
flush():
	Flushes this data output stream.
close():
	Closes this output stream and releases any system resources associated with this stream.

java.io.File
File(String pathname):
	Creates a new File instance by converting the given pathname string into an abstract pathname.

java.io.FileInputStream
FileInputStream(String name):
	Creates a FileInputStream by opening a connection to an actual file, the file named by the path name name in the file system.
read():
	Reads a byte of data from this input stream.
read(byte[] b):
	Reads up to b.length bytes of data from this input stream into an array of bytes.
available():
	Returns an estimate of the number of remaining bytes that can be read from this input stream without blocking.
close():
	Closes this file input stream and releases any system resources associated with the stream.

java.io.FileOutputStream
FileOutputStream(String name):
	Creates a file output stream to write to the file with the specified name.
FileOutputStream(String name, boolean append):
	Creates a file output stream to write to the file with the specified name, with a boolean to indicate whether to append to the file.
FileOutputStream(File file):
	Creates a file output stream to write to the file represented by the specified File object.
write(byte[] b):
	Writes b.length bytes from the specified byte array to this file output stream.
close():
	Closes this file output stream and releases any system resources associated with this stream.

java.io.PipedInputStream
PipedInputStream():
	Creates a PipedInputStream so that it is not yet connected.
read():
	Reads the next byte of data from this piped input stream.

java.io.PipedOutputStream
PipedOutputStream():
	Creates a piped output stream that is not yet connected to a piped input stream.
PipedOutputStream(PipedInputStream snk):
	Creates a piped output stream connected to the specified piped input stream.
connect(PipedInputStream snk):
	Connects this piped output stream to a receiver.
write(int b):
	Writes the specified byte to the piped output stream.

java.io.PrintStream
PrintStream(OutputStream out):
	Creates a new print stream.
println(String x):
	Prints a String and then terminates the line.
println(int x):
	Prints an integer and then terminates the line.

java.io.SequenceInputStream
SequenceInputStream(InputStream s1, InputStream s2):
	Initializes a newly created SequenceInputStream by remembering the two arguments, which will be read in order, first s1 and then s2.
SequenceInputStream(Enumeration<? extends InputStream> e):
	Initializes a newly created SequenceInputStream by remembering the argument, which must be an Enumeration that produces objects whose type is InputStream.

java.lang.Class
.class:
	A literal that creates a Class object for the given type.

java.lang.Exception
printStackTrace():
	Prints this throwable and its backtrace to the standard error stream. (Note: The code in 3BufferedStream.java uses printStackTree(), which is not a standard Java method and is likely a typo for printStackTrace()).

java.lang.String
getBytes():
	Encodes this String into a sequence of bytes using the platform's default charset, storing the result into a new byte array.
equals(Object anObject):
	Compares this string to the specified object.
length():
	Returns the length of this string.
String(byte[] bytes):
	Constructs a new String by decoding the specified array of bytes using the platform's default charset.

java.lang.System
static void setOut(PrintStream out):
	Reassigns the "standard" output stream.
static void setErr(PrintStream err):
	Reassigns the "standard" error output stream.
out:
	The "standard" output stream.
err:
	The "standard" error output stream.

java.lang.Thread
Thread(Runnable target):
	Allocates a new Thread object.
start():
	Causes this thread to begin execution.
static void sleep(long millis):
	Causes the currently executing thread to sleep for the specified number of milliseconds.

java.util.Enumeration
hasMoreElements():
	Tests if this enumeration contains more elements.
nextElement():
	Returns the next element of this enumeration if this enumeration object has at least one more element to provide.








  /* Note -> flush method is advised to be applied on the outermost outputStream (the one your program directly interacts with) */
	dos.flush(); // Ensure all data is written
  dos.close(); // Also flushes and closes all underlying streams